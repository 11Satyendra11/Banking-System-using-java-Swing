package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddMoneyClient {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AddMoneyClient window = new AddMoneyClient();
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
    public AddMoneyClient() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    private String emailID;

    public void setEmailID(String emailID) {
	this.emailID = emailID;
    }

    Connection connection = null;

    // Balance textField
    JLabel lblNewLabel_3;

    // main
    private void initialize() {

	System.out.println(emailID);

	try {
	    connection = DBConnector.getConnection();
	} catch (ClassNotFoundException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	} catch (SQLException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	frame = new JFrame();
	frame.setBounds(100, 100, 446, 321);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("ADD MONEY ");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel.setBounds(174, 11, 115, 14);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblMoneyToBe = new JLabel("Money to be added to the account:");
	lblMoneyToBe.setBounds(141, 36, 178, 14);
	frame.getContentPane().add(lblMoneyToBe);

	textField = new JTextField();
	textField.setBounds(130, 125, 218, 20);
	frame.getContentPane().add(textField);
	textField.setColumns(10);

	JLabel lblNewLabel_1 = new JLabel("Acc Number");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_1.setBounds(174, 61, 100, 20);
	frame.getContentPane().add(lblNewLabel_1);

	// Account Number Text Field
	String query3 = "select accountNo from clienttable where email = ?";

	try {
	    PreparedStatement pst1 = connection.prepareStatement(query3);
	    pst1.setString(1, GlobalVariable.getInstance().getLogin());
	    ResultSet rs1 = pst1.executeQuery();
	    while (rs1.next()) {
		lblNewLabel_1.setText(rs1.getString("accountNo"));
	    }
	} catch (SQLException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	JLabel lblNewLabel_2 = new JLabel("\u20AC");
	lblNewLabel_2.setBounds(107, 128, 13, 14);
	frame.getContentPane().add(lblNewLabel_2);

	// Get the balance

	JButton btnNewButton = new JButton("ADD");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		emailID = GlobalVariable.getInstance().getLogin();

		if (!textField.getText().isEmpty()) {

		    String query1 = "select balance from balancetable where email = ?";
		    String query2 = "update balancetable set balance = ? where email = ?";

		    try {

			PreparedStatement pst = connection.prepareStatement(query1);
			pst.setString(1, GlobalVariable.getInstance().getLogin());
			ResultSet rs = pst.executeQuery();
			float money = 0;
			while (rs.next()) {
			    money = rs.getFloat("balance");
			}
			pst = connection.prepareStatement(query2);
			money += Float.parseFloat(textField.getText());
			pst.setFloat(1, money);
			pst.setString(2, GlobalVariable.getInstance().getLogin());
			pst.execute();
			String MoneyString = String.valueOf(money);
			lblNewLabel_3.setText(MoneyString);

		    } catch (Exception e1) {
			e1.getStackTrace();
		    }
		    JOptionPane.showMessageDialog(frame, "Amount added Successfully to your account");
		} else {
		    JOptionPane.showMessageDialog(frame, "Please enter the money!!!");
		}
	    }
	});
	btnNewButton.setBounds(171, 156, 89, 23);
	frame.getContentPane().add(btnNewButton);

	JLabel lblYourTotalBalance = new JLabel("Your Total Balance is : \u20AC");
	lblYourTotalBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblYourTotalBalance.setBounds(49, 207, 188, 23);
	frame.getContentPane().add(lblYourTotalBalance);

	lblNewLabel_3 = new JLabel("Acc Balance");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel_3.setBounds(247, 209, 127, 28);
	frame.getContentPane().add(lblNewLabel_3);

	// BAlance Text Field
	String query4 = "select balance from balancetable where email = ?";

	try {
	    PreparedStatement pst2 = connection.prepareStatement(query4);
	    pst2.setString(1, GlobalVariable.getInstance().getLogin());
	    ResultSet rs2 = pst2.executeQuery();
	    while (rs2.next()) {
		lblNewLabel_3.setText(rs2.getString("balance"));
	    }
	} catch (SQLException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	// BACK to the main window
	JButton btnNewButton_1 = new JButton("BACK");
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		frame.dispose();
		ClientInformation ci = new ClientInformation();
		ci.frmClientInformation.setVisible(true);
	    }
	});
	btnNewButton_1.setBounds(10, 248, 89, 23);
	frame.getContentPane().add(btnNewButton_1);
    }

}
