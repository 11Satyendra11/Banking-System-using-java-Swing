package bankingsystemswing;

import java.awt.Button;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Login {

    JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;
    private String emailID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Login window = new Login();
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
    public Login() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    Connection connection = null;
    private String accountType;
    private String accountNumber;

    private void initialize() {

	try {
	    connection = DBConnector.getConnection();
	} catch (ClassNotFoundException e1) {

	    e1.printStackTrace();
	} catch (SQLException e1) {

	    e1.printStackTrace();
	}

	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("Email");
	lblNewLabel.setBounds(63, 77, 89, 14);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("SWISS BANK SYSTEM");
	lblNewLabel_1.setForeground(Color.BLUE);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_1.setBounds(151, 11, 212, 27);
	frame.getContentPane().add(lblNewLabel_1);

	textField = new JTextField();
	textField.setBounds(173, 74, 155, 20);
	frame.getContentPane().add(textField);
	textField.setColumns(10);

	// Encrpyted password
	passwordField = new JPasswordField();
	passwordField.setBounds(173, 111, 155, 20);
	frame.getContentPane().add(passwordField);
	String encryptedPassword = DigestUtils.md5Hex(passwordField.getText());

	JLabel lblNewLabel_2 = new JLabel("password");
	lblNewLabel_2.setBounds(63, 114, 89, 14);
	frame.getContentPane().add(lblNewLabel_2);

	JButton btnNewButton = new JButton("Login");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		emailID = textField.getText();

		AddMoneyClient amc = new AddMoneyClient();
		amc.setEmailID(emailID);

		String query = "select email, password,account_type from accounts where email=? and password =? and account_type = ? ";

		try {
		    PreparedStatement pst = connection.prepareStatement(query);
		    pst.setString(1, textField.getText());
		    pst.setString(2, encryptedPassword );
		    pst.setString(3, accountType);
		    ResultSet rs = pst.executeQuery();

		    int count = 0;

		    while (rs.next()) {
			count++;
			accountType = rs.getString("account_type");

		    }

		    if (count == 1 && accountType.equals("C")) {

			GlobalVariable.getInstance().setLogin(textField.getText());
			frame.dispose();
			ClientInformation window = new ClientInformation();
			window.frmClientInformation.setVisible(true);

		    } else if (count == 1 && accountType.equals("M")) {
			frame.dispose();
			Manager1 window = new Manager1();
			window.frame.setVisible(true);
		    } else if (count == 1 && accountType.equals("A")) {
			frame.dispose();
			officeAdvisor window = new officeAdvisor();
			window.frame.setVisible(true);
		    } else if (count > 1 || count == 0) {
			JOptionPane.showMessageDialog(frame, "Enter Correct password");
		    }
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}

	    }
	});
	btnNewButton.setBounds(176, 178, 89, 23);
	frame.getContentPane().add(btnNewButton);

	JRadioButton rbClient = new JRadioButton("Client");
	rbClient.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		if (rbClient.isSelected())
		    accountType = "C";

	    }
	});
	rbClient.setBounds(94, 148, 89, 23);
	frame.getContentPane().add(rbClient);

	JRadioButton rbAdvisor = new JRadioButton("Advisor");
	rbAdvisor.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (rbAdvisor.isSelected())
		    accountType = "A";
	    }
	});
	rbAdvisor.setBounds(193, 148, 92, 23);
	frame.getContentPane().add(rbAdvisor);

	JRadioButton rbManager = new JRadioButton("Manager");
	rbManager.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (rbManager.isSelected())
		    accountType = "M";
	    }
	});
	rbManager.setBounds(295, 148, 109, 23);
	frame.getContentPane().add(rbManager);

	ButtonGroup bg = new ButtonGroup();
	bg.add(rbClient);
	bg.add(rbAdvisor);
	bg.add(rbManager);

	// CREATE ACCOUNT FRAME
	JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
	btnCreateAccount.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		frame.dispose();
		CreateAccount ca = new CreateAccount();
		ca.frame.setVisible(true);
	    }
	});
	btnCreateAccount.setBounds(282, 227, 142, 23);
	frame.getContentPane().add(btnCreateAccount);

	JLabel lblNewLabel_3 = new JLabel("Login");
	lblNewLabel_3.setBounds(203, 49, 46, 14);
	frame.getContentPane().add(lblNewLabel_3);

    }
}
