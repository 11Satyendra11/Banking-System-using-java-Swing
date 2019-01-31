package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class CreateAccount {

    JFrame frame;
    private JTextField textField_2;
    private JTextField textField_3;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    CreateAccount window = new CreateAccount();
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
    public CreateAccount() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    Connection connection = null;
    private String person;

    private void initialize() {
	try {
	    connection = DBConnector.getConnection();
	} catch (ClassNotFoundException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	} catch (SQLException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	frame = new JFrame();
	frame.setBounds(100, 100, 634, 367);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("CREATE AN ACCOUNT");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel.setBounds(224, 21, 187, 41);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblNewLabel_3 = new JLabel("UserName");
	lblNewLabel_3.setBounds(39, 103, 79, 14);
	frame.getContentPane().add(lblNewLabel_3);

	textField_2 = new JTextField();
	textField_2.setBounds(129, 100, 122, 20);
	frame.getContentPane().add(textField_2);
	textField_2.setColumns(10);

	JLabel lblNewLabel_4 = new JLabel("Email");
	lblNewLabel_4.setBounds(311, 103, 46, 14);
	frame.getContentPane().add(lblNewLabel_4);

	textField_3 = new JTextField();
	textField_3.setBounds(367, 100, 151, 20);
	frame.getContentPane().add(textField_3);
	textField_3.setColumns(10);

	JLabel lblNewLabel_5 = new JLabel("Password");
	lblNewLabel_5.setBounds(39, 175, 65, 14);
	frame.getContentPane().add(lblNewLabel_5);

	//Password to md5
	passwordField = new JPasswordField();
	passwordField.setBounds(129, 172, 122, 20);
	frame.getContentPane().add(passwordField);
	String encrpytedPassword = DigestUtils.md5Hex(passwordField.getText());
	
	
	JLabel lblNewLabel_6 = new JLabel("Confirm Password");
	lblNewLabel_6.setBounds(263, 175, 117, 14);
	frame.getContentPane().add(lblNewLabel_6);

	passwordField_1 = new JPasswordField();
	passwordField_1.setBounds(390, 172, 122, 20);
	frame.getContentPane().add(passwordField_1);

	JLabel lblNewLabel_7 = new JLabel("Account Type");
	lblNewLabel_7.setBounds(112, 224, 79, 14);
	frame.getContentPane().add(lblNewLabel_7);

	JRadioButton rdbtnNewRadioButton = new JRadioButton("Client");
	rdbtnNewRadioButton.addActionListener(new ActionListener() {

	    // Selection of the radio button
	    public void actionPerformed(ActionEvent arg0) {
		if (rdbtnNewRadioButton.isSelected())
		    person = "C";
	    }
	});
	rdbtnNewRadioButton.setBounds(208, 220, 65, 23);
	frame.getContentPane().add(rdbtnNewRadioButton);

	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Office Advisor");
	rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

	    // Radio button selection Office Advisor
	    public void actionPerformed(ActionEvent e) {
		if (rdbtnNewRadioButton_1.isSelected())
		    person = "A";
	    }
	});
	rdbtnNewRadioButton_1.setBounds(275, 220, 105, 23);
	frame.getContentPane().add(rdbtnNewRadioButton_1);

	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Manager");
	rdbtnNewRadioButton_2.addActionListener(new ActionListener() {

	    // Radio button selection Manager
	    public void actionPerformed(ActionEvent e) {
		if (rdbtnNewRadioButton_2.isSelected())
		    person = "M";
	    }
	});
	rdbtnNewRadioButton_2.setBounds(381, 220, 109, 23);
	frame.getContentPane().add(rdbtnNewRadioButton_2);

	// Button Group
	ButtonGroup bg = new ButtonGroup();
	bg.add(rdbtnNewRadioButton);
	bg.add(rdbtnNewRadioButton_1);
	bg.add(rdbtnNewRadioButton_2);

	// Create Account button
	Random rand = new Random();
	JButton btnNewButton = new JButton("CREATE");
	btnNewButton.addActionListener(new ActionListener() {

	    // Create an account button action
	    public void actionPerformed(ActionEvent e) {

		// for creating an account number
		String accountNumber = null;
		String IBAN = null;
		String BIC = null;

		accountNumber = "SWISSFR" + rand.nextInt(9999) + 1;

		BIC = "" + rand.nextInt(9999) + 1;

		IBAN = "FR" + rand.nextInt(9999) + BIC + 1 + rand.nextInt(9999) + 1 + accountNumber;

		if (person.equals("C")) {
		    String query = "insert into accounts(email,password,account_type,username) values(?,?,?,?)";
		    String query2 = "insert into clienttable(accountNo,iban,BIC,accountType,email) values (?,?,?,?,?)";

		    try {
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1, textField_3.getText());
			pst.setString(2, encrpytedPassword);
			pst.setString(3, person);
			pst.setString(4, textField_2.getText());
			pst.execute();
			pst = connection.prepareStatement(query2);
			pst.setString(1, accountNumber);
			pst.setString(2, IBAN);
			pst.setString(3, BIC);
			pst.setString(4, person);
			pst.setString(5, textField_3.getText());
			pst.execute();

		    } catch (SQLException e1) {

			e1.printStackTrace();
		    }
		}
		
		if(person.equals("A") || person.equals("M"))
		{
		    String query = "insert into accounts(email,password,account_type,username) values(?,?,?,?)";
		    try {
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1, textField_3.getText());
			pst.setString(2, encrpytedPassword);
			pst.setString(3, person);
			pst.setString(4, textField_2.getText());
			pst.execute();
		    } catch (SQLException e1) {

			e1.printStackTrace();
		    }
		}

		JOptionPane.showMessageDialog(frame, "Account Created Successfully");

		frame.dispose();
		Login log = new Login();
		log.frame.setVisible(true);

	    }
	});
	btnNewButton.setBounds(268, 266, 89, 23);
	frame.getContentPane().add(btnNewButton);

	// BACK BUTTON TAKES TO the login screen
	JButton btnNewButton_1 = new JButton("BACK");
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		frame.dispose();
		Login login1 = new Login();
		login1.frame.setVisible(true);
	    }
	});
	btnNewButton_1.setBounds(10, 294, 89, 23);
	frame.getContentPane().add(btnNewButton_1);
    }
}
