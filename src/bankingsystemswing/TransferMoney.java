package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.poi.util.SystemOutLogger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TransferMoney {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_4;
    private JTextField textField_5;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TransferMoney window = new TransferMoney();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public TransferMoney() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    Connection connection = null;
    private JTextField textField_9;
    private JTextField textField_recipientEmailID;

    private void initialize() {

	try {
	    connection = DBConnector.getConnection();
	} catch (ClassNotFoundException e2) {

	    e2.printStackTrace();
	} catch (SQLException e2) {

	    e2.printStackTrace();
	}

	frame = new JFrame();
	frame.setBounds(100, 100, 576, 438);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblTransferMoney = new JLabel("Transfer Money");
	lblTransferMoney.setBounds(228, 21, 107, 30);
	frame.getContentPane().add(lblTransferMoney);

	textField = new JTextField();
	textField.setBounds(114, 113, 107, 20);
	frame.getContentPane().add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setBounds(350, 113, 86, 20);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);

	JLabel lblNewLabel = new JLabel("First Name");
	lblNewLabel.setBounds(30, 116, 77, 14);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("Last Name:");
	lblNewLabel_1.setBounds(265, 116, 86, 14);
	frame.getContentPane().add(lblNewLabel_1);

	JButton btnTransfer = new JButton("Transfer");
	btnTransfer.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		//Warning
		if(textField_4.getText().isEmpty() || textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_9.getText().isEmpty() || textField_5.getText().isEmpty())
		{
		    JOptionPane.showMessageDialog(frame, "Please Enter BIC Code & Name & IBAN & Amount ");
		}
		
		// Transfer Money

		String query2 = "select iban,accountNo,BIC from clienttable where email =? ";
		String query6 = "select balance from balancetable where email = ?";
		try {

		    PreparedStatement pst4 = connection.prepareStatement(query2);
		    pst4.setString(1, GlobalVariable.getInstance().getLogin());

		    ResultSet rs4 = pst4.executeQuery();
		    while (rs4.next()) {
			GlobalVariable.getInstance().setIban1(rs4.getString("iban"));
			GlobalVariable.getInstance().setAccountNumber(rs4.getString("accountNo"));
			GlobalVariable.getInstance().setBicNumber(rs4.getString("BIC"));

		    }

		    // balance Prepared Statement
		    pst4 = connection.prepareStatement(query6);
		    pst4.setString(1, GlobalVariable.getInstance().getLogin());

		    rs4 = pst4.executeQuery();
		    while (rs4.next()) {
			GlobalVariable.getInstance().setBalance(rs4.getFloat("balance"));
		    }

		} catch (SQLException e2) {

		    e2.printStackTrace();
		}

		// If IBAN equal transfer money
		if (textField_5.getText().toString().equals(GlobalVariable.getInstance().getIban1().toString())) {
		    Date date = new Date();
		    DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");
		    String dateFormated = dateformat.format(date);
		    String transactionName = textField.getText() + " " + textField_1.getText();
		    String credit = textField_9.getText();

		    // Transaction Table insert
		    String query3 = "insert into  transactiontable(transactionName,credit,dateOfTransaction,email,iban,accountNoRecipient,bicRecipient,bic,accountNo,emailIDRecipient)values(?,?,?,?,?,?,?,?,?,?)";

		    try {
			PreparedStatement pst1 = connection.prepareStatement(query3);
			pst1.setString(1, transactionName);
			pst1.setString(2, credit);
			pst1.setString(3, dateFormated);
			pst1.setString(4, GlobalVariable.getInstance().getLogin());
			pst1.setString(5, GlobalVariable.getInstance().getIban1());
			pst1.setString(6, GlobalVariable.getInstance().getAccountNumber());
			pst1.setString(7, GlobalVariable.getInstance().getBicNumber());
			pst1.setString(8, textField_4.getText());
			pst1.setString(9, GlobalVariable.getInstance().getAccountNumber());
			pst1.setString(10, GlobalVariable.getInstance().getLogin());
			pst1.execute();

		    } catch (Exception e1) {
			e1.printStackTrace();
		    }

		}

		// Transfer Money if IBAN not equal

		
		if (!(textField_5.getText().toString().equals(GlobalVariable.getInstance().getIban1().toString()))) {

		    Date date = new Date();
		    DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");
		    String dateFormated = dateformat.format(date);
		    String transactionName = textField.getText() + " " + textField_1.getText();
		    String debit = textField_9.getText();
		    String creditExternal = textField_9.getText();

		    // Balance update
		    Float updatedBalance = GlobalVariable.getInstance().getBalance() - Float.parseFloat(debit);

		    // Transaction Table insert
		    String query3 = "insert into  transactiontable(transactionName,debit,dateOfTransaction,email,iban,accountNoRecipient,bicRecipient,bic,accountNo,emailIDRecipient)values(?,?,?,?,?,?,?,?,?,?)";

		    String query5 = "update balancetable set balance = ? where email = ?";

		    // Update the transaction detail of the external account
		    String query8 = "select * from clienttable where email = ?";
		    String query9 = "insert into  transactiontable(transactionName,credit,dateOfTransaction,email,iban,accountNoRecipient,bicRecipient,bic,accountNo,emailIDRecipient)values(?,?,?,?,?,?,?,?,?,?)";
		    // Update query balance of external account
		    String query10 = "select balance from balancetable where email = ?";
		    String query11 = "update balancetable set balance = ? where email =?";

		    try {
			PreparedStatement pst1 = connection.prepareStatement(query3);
			pst1.setString(1, transactionName);
			pst1.setString(2, debit);
			pst1.setString(3, dateFormated);
			pst1.setString(4, GlobalVariable.getInstance().getLogin());
			pst1.setString(5, GlobalVariable.getInstance().getIban1());
			pst1.setString(6, textField_5.getText());
			pst1.setString(7, textField_4.getText());
			pst1.setString(8, GlobalVariable.getInstance().getBicNumber());
			pst1.setString(9, GlobalVariable.getInstance().getAccountNumber());
			pst1.setString(10, textField_recipientEmailID.getText());
			pst1.execute();

			// query4

			pst1 = connection.prepareStatement(query5);
			pst1.setFloat(1, updatedBalance);
			pst1.setString(2, GlobalVariable.getInstance().getLogin());
			pst1.executeUpdate();

			// query 8

			pst1 = connection.prepareStatement(query8);
			pst1.setString(1, textField_recipientEmailID.getText());
			ResultSet rs8 = pst1.executeQuery();
			while (rs8.next()) {
			    GlobalVariableExternalRecipient.getInstance().setLogin(rs8.getString("email"));
			    GlobalVariableExternalRecipient.getInstance().setBicNumber(rs8.getString("BIC"));
			    GlobalVariableExternalRecipient.getInstance().setIban1(rs8.getString("iban"));
			    GlobalVariableExternalRecipient.getInstance().setAccountNumber(rs8.getString("accountNo"));

			}

			// query 9

			pst1 = connection.prepareStatement(query9);
			pst1.setString(1, transactionName);
			pst1.setString(2, creditExternal);
			pst1.setString(3, dateFormated);
			pst1.setString(4, GlobalVariableExternalRecipient.getInstance().getLogin());
			pst1.setString(5, GlobalVariableExternalRecipient.getInstance().getIban1());
			pst1.setString(6, GlobalVariable.getInstance().getAccountNumber());
			pst1.setString(7, GlobalVariable.getInstance().getBicNumber());
			pst1.setString(8, textField_4.getText());
			pst1.setString(9, GlobalVariableExternalRecipient.getInstance().getAccountNumber());
			pst1.setString(10, GlobalVariable.getInstance().getLogin());
			pst1.execute();

			// query10
			pst1 = connection.prepareStatement(query10);
			pst1.setString(1, GlobalVariableExternalRecipient.getInstance().getLogin());
			rs8 = pst1.executeQuery();
			while (rs8.next()) {
			    GlobalVariableExternalRecipient.getInstance().setBalance(rs8.getFloat("balance"));
			}

			//query 11
			Float ExternalRecipientBalance =  GlobalVariableExternalRecipient.getInstance().getBalance() + Float.parseFloat(textField_9.getText());
			GlobalVariableExternalRecipient.getInstance().setBalance(ExternalRecipientBalance);
			pst1 = connection.prepareStatement(query11);
			pst1.setFloat(1, ExternalRecipientBalance);
			pst1.setString(2, GlobalVariableExternalRecipient.getInstance().getLogin());
			pst1.executeUpdate();
		    
		    } catch (Exception e1) {
			e1.printStackTrace();
		    }

		}

		// TransferMoney table
		String query = "insert into transfermoney (FirstName,LastName,bic,amount,iban) values(?,?,?,?,?)";
		try {

		    PreparedStatement pst3 = connection.prepareStatement(query);
		    pst3.setString(1, textField.getText());
		    pst3.setString(2, textField_1.getText());
		    pst3.setString(3, textField_4.getText());
		    pst3.setFloat(4, Float.parseFloat(textField_9.getText()));
		    pst3.setString(5, textField_5.getText());

		    pst3.executeUpdate();
		    
		    System.out.println("=========================================");
		    System.out.println(textField.getText());
		    System.out.println(textField_1.getText());
		    System.out.println(textField_4.getText());
		    System.out.println(textField_9.getText());
		    System.out.println( textField_5.getText());
		    
		    

		} catch (SQLException e1) {

		    e1.printStackTrace();
		}
		
		//Transfer Successful dialog box code
		Float amm = Float.parseFloat(textField_9.getText()); 
		if(textField_4.getText().isEmpty() || textField.getText().isEmpty() || textField_1.getText().isEmpty()  || textField_5.getText().isEmpty() )
		{
		    if(amm == 0)
		    {
			//JOptionPane.showMessageDialog(frame, "Transfer Sucessfully amount credited");
			JOptionPane.showMessageDialog(frame, "Please Enter BIC Code & Name & IBAN & Amount ");
			
		    }
		    JOptionPane.showMessageDialog(frame, "Please Enter BIC Code & Name & IBAN & Amount ");
		}else
		{
		  JOptionPane.showMessageDialog(frame, "Transfer Sucessfully amount credited");
			
		}
		
		
		
		
		
	    }
	});
	btnTransfer.setBounds(265, 330, 89, 23);
	frame.getContentPane().add(btnTransfer);

	JButton btnBack = new JButton("back");
	btnBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		frame.dispose();
		ClientInformation clientInformation = new ClientInformation();
		clientInformation.main(null);
	    }
	});
	btnBack.setBounds(0, 365, 89, 23);
	frame.getContentPane().add(btnBack);

	JLabel lblNewLabel_4 = new JLabel("BIC:");
	lblNewLabel_4.setBounds(289, 178, 46, 14);
	frame.getContentPane().add(lblNewLabel_4);

	textField_4 = new JTextField();
	textField_4.setBounds(350, 175, 86, 20);
	frame.getContentPane().add(textField_4);
	textField_4.setColumns(10);

	JLabel lblNewLabel_5 = new JLabel("IBAN:");
	lblNewLabel_5.setBounds(175, 302, 46, 14);
	frame.getContentPane().add(lblNewLabel_5);

	textField_5 = new JTextField();
	textField_5.setBounds(228, 299, 206, 20);
	frame.getContentPane().add(textField_5);
	textField_5.setColumns(10);

	JLabel lblAmount = new JLabel("AMOUNT");
	lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblAmount.setBounds(338, 203, 98, 30);
	frame.getContentPane().add(lblAmount);

	textField_9 = new JTextField();
	textField_9.setBounds(327, 238, 109, 30);
	frame.getContentPane().add(textField_9);
	textField_9.setColumns(10);

	JLabel lblNewLabel_3 = new JLabel("\u20AC");
	lblNewLabel_3.setBounds(289, 241, 28, 14);
	frame.getContentPane().add(lblNewLabel_3);

	// New Transfer resets textField
	JButton btnNewButton = new JButton("NEW TRANSFER");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		textField.setText("");
		textField_1.setText("");
		textField_4.setText("");
		textField_recipientEmailID.setText("");
		textField_9.setText("");
		textField_5.setText("");

	    }
	});
	btnNewButton.setBounds(400, 365, 130, 23);
	frame.getContentPane().add(btnNewButton);

	JLabel lblRecipientEmailId = new JLabel("Recipient Email ID:");
	lblRecipientEmailId.setBounds(30, 162, 130, 14);
	frame.getContentPane().add(lblRecipientEmailId);

	textField_recipientEmailID = new JTextField();
	textField_recipientEmailID.setBounds(30, 192, 191, 20);
	frame.getContentPane().add(textField_recipientEmailID);
	textField_recipientEmailID.setColumns(10);
    }
}
