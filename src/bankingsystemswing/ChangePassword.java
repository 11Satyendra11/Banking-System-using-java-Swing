package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ChangePassword window = new ChangePassword();
		    window.frame.setVisible(true);
		    window.frame.setTitle("Password Change");
		    window.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public ChangePassword() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    Connection connection = null;

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
	frame.setBounds(100, 100, 479, 251);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("CHANGE PASSWORD");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel.setBounds(158, 11, 209, 34);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("Old Password");
	lblNewLabel_1.setBounds(75, 68, 108, 19);
	frame.getContentPane().add(lblNewLabel_1);

	//Password old encrypted
	textField = new JTextField();
	textField.setBounds(212, 67, 155, 20);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	String encryptedPassword = DigestUtils.md5Hex(textField.getText());
	
	
	JLabel lblNewLabel_2 = new JLabel("New Password");
	lblNewLabel_2.setBounds(75, 98, 108, 14);
	frame.getContentPane().add(lblNewLabel_2);

	// Password encrypted New
	textField_1 = new JTextField();
	textField_1.setBounds(212, 95, 155, 20);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	String encryptedPasswordNew = DigestUtils.md5Hex(textField_1.getText());

	JLabel lblNewLabel_3 = new JLabel("Confirm Password");
	lblNewLabel_3.setBounds(75, 123, 127, 14);
	frame.getContentPane().add(lblNewLabel_3);

	textField_2 = new JTextField();
	textField_2.setBounds(212, 120, 155, 20);
	frame.getContentPane().add(textField_2);
	textField_2.setColumns(10);

	// Change password
	JButton btnNewButton = new JButton("CHANGE");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		String query1 = "select password from accounts where email = ?";
		String query = "update accounts set password = ? where email = ?";
		try {
		    PreparedStatement pst = connection.prepareStatement(query1);
		    pst.setString(1, GlobalVariable.getInstance().getLogin());
		    ResultSet rs = pst.executeQuery();
		    System.out.println("inside change password : " + GlobalVariable.getInstance().getLogin());
		    while (rs.next()) {
			GlobalVariable.getInstance().setPassword(rs.getString("password"));
		    }
		    System.out
			    .println("inside change password password : " + GlobalVariable.getInstance().getPassword());

		    if (GlobalVariable.getInstance().getPassword().equals(encryptedPassword)) {
			pst = connection.prepareStatement(query);
			pst.setString(1, encryptedPasswordNew);
			pst.setString(2, GlobalVariable.getInstance().getLogin());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(frame, "Password Changed Sucessfully");
			frame.setVisible(false);
		    } else {
			JOptionPane.showMessageDialog(frame, "Please enter correct password");
		    }

		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    }
	});
	btnNewButton.setBounds(189, 166, 127, 23);
	frame.getContentPane().add(btnNewButton);

    }
}
