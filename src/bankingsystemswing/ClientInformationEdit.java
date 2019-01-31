package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class ClientInformationEdit {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_4;
    private JTextField textFieldhouse;
    private JTextField textFieldneighbourhood;
    private JTextField textFieldcity;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ClientInformationEdit window = new ClientInformationEdit();
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
    public ClientInformationEdit() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private String married;
    private String gender;
    Connection connection = null;

    private String accountType;
    private JTextField textFieldCountry;
    private JTextField textFieldZipcode;
    private JTextField textField_2;

    private void initialize() {
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
	frame.setBounds(100, 100, 604, 457);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblClientInformationEdit = new JLabel("CLIENT INFORMATION EDIT");
	lblClientInformationEdit.setForeground(Color.BLUE);
	lblClientInformationEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblClientInformationEdit.setBounds(107, 5, 283, 31);
	frame.getContentPane().add(lblClientInformationEdit);

	JLabel lblNewLabel = new JLabel("First Name");
	lblNewLabel.setBounds(25, 47, 65, 14);
	frame.getContentPane().add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("Last Name");
	lblNewLabel_1.setBounds(25, 75, 65, 14);
	frame.getContentPane().add(lblNewLabel_1);

	JLabel lblNewLabel_2 = new JLabel("DOB");
	lblNewLabel_2.setBounds(25, 126, 46, 14);
	frame.getContentPane().add(lblNewLabel_2);

	JLabel lblNewLabel_4 = new JLabel("Gender");
	lblNewLabel_4.setBounds(25, 185, 46, 14);
	frame.getContentPane().add(lblNewLabel_4);

	textField = new JTextField();
	textField.setBounds(135, 47, 117, 20);
	frame.getContentPane().add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setBounds(135, 75, 117, 20);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);

	JRadioButton rdbtnMale = new JRadioButton("Male");
	rdbtnMale.addActionListener(new ActionListener() {
	    // gender radiobutton selection
	    public void actionPerformed(ActionEvent e) {
		if (rdbtnMale.isSelected())
		    gender = "M";
	    }
	});
	rdbtnMale.setBounds(112, 181, 58, 23);
	frame.getContentPane().add(rdbtnMale);

	JRadioButton rdbtnfemale = new JRadioButton("Female");
	rdbtnfemale.addActionListener(new ActionListener() {
	    // gender radiobutton selection
	    public void actionPerformed(ActionEvent e) {

		if (rdbtnfemale.isSelected())
		    gender = "F";
	    }
	});
	rdbtnfemale.setBounds(172, 181, 59, 23);
	frame.getContentPane().add(rdbtnfemale);

	ButtonGroup bg1 = new ButtonGroup();
	bg1.add(rdbtnMale);
	bg1.add(rdbtnfemale);

	JLabel lblNewLabel_5 = new JLabel("Telephone");
	lblNewLabel_5.setBounds(25, 220, 65, 14);
	frame.getContentPane().add(lblNewLabel_5);

	textField_4 = new JTextField();
	textField_4.setBounds(135, 217, 117, 20);
	frame.getContentPane().add(textField_4);
	textField_4.setColumns(10);

	JLabel lblAddress = new JLabel("Address");
	lblAddress.setBounds(442, 11, 66, 14);
	frame.getContentPane().add(lblAddress);

	textFieldhouse = new JTextField();
	textFieldhouse.setBounds(412, 36, 138, 20);
	frame.getContentPane().add(textFieldhouse);
	textFieldhouse.setColumns(10);

	textFieldneighbourhood = new JTextField();
	textFieldneighbourhood.setBounds(412, 67, 138, 20);
	frame.getContentPane().add(textFieldneighbourhood);
	textFieldneighbourhood.setColumns(10);

	textFieldcity = new JTextField();
	textFieldcity.setBounds(412, 102, 138, 20);
	frame.getContentPane().add(textFieldcity);
	textFieldcity.setColumns(10);

	
	JLabel lblNewLabel_6 = new JLabel("Occupation");
	lblNewLabel_6.setBounds(324, 215, 78, 14);
	frame.getContentPane().add(lblNewLabel_6);

	textField_8 = new JTextField();
	textField_8.setBounds(421, 209, 116, 20);
	frame.getContentPane().add(textField_8);
	textField_8.setColumns(10);

	JLabel lblNewLabel_7 = new JLabel("Mobile");
	lblNewLabel_7.setBounds(344, 253, 46, 14);
	frame.getContentPane().add(lblNewLabel_7);

	textField_9 = new JTextField();
	textField_9.setBounds(421, 247, 116, 20);
	frame.getContentPane().add(textField_9);
	textField_9.setColumns(10);

	JLabel lblNewLabel_8 = new JLabel("Nationality");
	lblNewLabel_8.setBounds(324, 288, 78, 14);
	frame.getContentPane().add(lblNewLabel_8);

	textField_10 = new JTextField();
	textField_10.setBounds(421, 282, 116, 20);
	frame.getContentPane().add(textField_10);
	textField_10.setColumns(10);

	JLabel lblNewLabel_9 = new JLabel("Married");
	lblNewLabel_9.setBounds(25, 256, 46, 14);
	frame.getContentPane().add(lblNewLabel_9);

	JRadioButton rdbtnYes = new JRadioButton("Yes");
	rdbtnYes.addActionListener(new ActionListener() {
	    // Married radiobutton action
	    public void actionPerformed(ActionEvent e) {
		if (rdbtnYes.isSelected())
		    married = "yes";

	    }
	});
	rdbtnYes.setBounds(122, 252, 48, 23);
	frame.getContentPane().add(rdbtnYes);

	JRadioButton rdbtnNo = new JRadioButton("No");
	rdbtnNo.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (rdbtnNo.isSelected())
		    married = "no";
	    }
	});
	rdbtnNo.setBounds(170, 252, 46, 23);
	frame.getContentPane().add(rdbtnNo);

	ButtonGroup bg2 = new ButtonGroup();
	bg2.add(rdbtnYes);
	bg2.add(rdbtnNo);

	JLabel lblSpouceName = new JLabel("Spouce Name:");
	lblSpouceName.setBounds(25, 291, 97, 14);
	frame.getContentPane().add(lblSpouceName);

	textField_11 = new JTextField();
	textField_11.setBounds(132, 288, 120, 20);
	frame.getContentPane().add(textField_11);
	textField_11.setColumns(10);

	JLabel lblBirthPlace = new JLabel("Birth Place");
	lblBirthPlace.setBounds(324, 324, 78, 14);
	frame.getContentPane().add(lblBirthPlace);

	textField_12 = new JTextField();
	textField_12.setBounds(421, 318, 116, 20);
	frame.getContentPane().add(textField_12);
	textField_12.setColumns(10);

	JLabel lblChildren = new JLabel("Children");
	lblChildren.setBounds(324, 359, 66, 14);
	frame.getContentPane().add(lblChildren);

	textField_13 = new JTextField();
	textField_13.setBounds(421, 353, 116, 20);
	frame.getContentPane().add(textField_13);
	textField_13.setColumns(10);

	JLabel lblBankAgency = new JLabel("Bank Agency");
	lblBankAgency.setBounds(25, 316, 89, 14);
	frame.getContentPane().add(lblBankAgency);

	textField_14 = new JTextField();
	textField_14.setBounds(130, 313, 122, 20);
	frame.getContentPane().add(textField_14);
	textField_14.setColumns(10);
		

	JButton btnDone = new JButton("Done");
	btnDone.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		// inserting into the database
		
		 String query ="update clienttable set firstName = ?,lastName = ?,dateOfBirth = ?,gender = ?,telephone = ?,house = ?,neighbourhood = ?,city = ?,country = ?, zipcode = ?,occupation = ?,mobile = ?,nationality = ?,Married = ?,spouceName = ?,birthPlace = ?,children = ?,bankAgency = ? where email = ?";
	try { 
	    	PreparedStatement pst= connection.prepareStatement(query);
		 pst.setString(1,textField.getText()); 
		 pst.setString(2,textField_1.getText());
		 pst.setString(3,textField_2.getText()); 
		 pst.setString(4, gender);
		 pst.setString(5,textField_4.getText() ); 
		 pst.setString(6,textFieldhouse.getText() );
		 pst.setString(7,textFieldneighbourhood.getText() );
		 pst.setString(8,textFieldcity.getText() );
		 pst.setString(9,textFieldCountry.getText() );
		 pst.setString(10,textFieldZipcode.getText() );
		 pst.setString(11, textField_8.getText());
		 pst.setString(12, textField_9.getText());
		 pst.setString(13, textField_10.getText());
		 pst.setString(14, married); 
		 pst.setString(15, textField_11.getText() );
		 pst.setString(16, textField_12.getText()); 
		 pst.setString(17,textField_13.getText()); 
		 pst.setString(18, textField_14.getText());
		 pst.setString(19, GlobalVariable.getInstance().getLogin());
		pst.executeUpdate();
		
		 JOptionPane.showMessageDialog(null, "Data updated successfully");
		 
		 } catch (SQLException e1) {
		
		  e1.printStackTrace(); }
		
	    }
	});
	btnDone.setBounds(489, 384, 89, 23);
	frame.getContentPane().add(btnDone);

	// Back button takes to the login page
	JButton btnNewButton = new JButton("Back");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		frame.dispose();
		ClientInformation cif = new ClientInformation();
		cif.frmClientInformation.setVisible(true);

	    }
	});
	btnNewButton.setBounds(10, 384, 89, 23);
	frame.getContentPane().add(btnNewButton);

	JLabel lblNewLabel_3 = new JLabel("Password");
	lblNewLabel_3.setBounds(25, 151, 78, 14);
	frame.getContentPane().add(lblNewLabel_3);

	
	//Change password
	JButton btnNewButton_1 = new JButton("Change Password");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
		    ChangePassword cp = new ChangePassword();
		    cp.frame.setVisible(true);
		
		}
	});
	btnNewButton_1.setBounds(135, 147, 117, 23);
	frame.getContentPane().add(btnNewButton_1);
	
	textFieldCountry = new JTextField();
	textFieldCountry.setBounds(412, 133, 138, 20);
	frame.getContentPane().add(textFieldCountry);
	textFieldCountry.setColumns(10);
	
	textFieldZipcode = new JTextField();
	textFieldZipcode.setBounds(412, 164, 138, 20);
	frame.getContentPane().add(textFieldZipcode);
	textFieldZipcode.setColumns(10);
	
	JLabel lblNewLabel_10 = new JLabel("House");
	lblNewLabel_10.setBounds(326, 39, 76, 14);
	frame.getContentPane().add(lblNewLabel_10);
	
	JLabel lblNewLabel_11 = new JLabel("Neighbourhood");
	lblNewLabel_11.setBounds(283, 70, 119, 14);
	frame.getContentPane().add(lblNewLabel_11);
	
	JLabel lblNewLabel_12 = new JLabel("City");
	lblNewLabel_12.setBounds(293, 105, 97, 14);
	frame.getContentPane().add(lblNewLabel_12);
	
	JLabel lblNewLabel_13 = new JLabel("Country");
	lblNewLabel_13.setBounds(303, 136, 99, 14);
	frame.getContentPane().add(lblNewLabel_13);
	
	JLabel lblNewLabel_14 = new JLabel("Zip Code");
	lblNewLabel_14.setBounds(301, 167, 101, 14);
	frame.getContentPane().add(lblNewLabel_14);
	
	textField_2 = new JTextField();
	textField_2.setBounds(135, 116, 86, 20);
	frame.getContentPane().add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblNewLabel_15 = new JLabel("YYYY-MM-DD");
	lblNewLabel_15.setBounds(135, 102, 117, 14);
	frame.getContentPane().add(lblNewLabel_15);
	
	
	
	
	
	String query3 = "select firstName,lastName,dateOfBirth,telephone,house,neighbourhood,city,country,zipcode,occupation,mobile,nationality,spouceName,birthPlace,children,bankAgency,gender,Married from clienttable where email = ?";
	try {
	    PreparedStatement pst3 = connection.prepareStatement(query3);
	    pst3.setString(1, GlobalVariable.getInstance().getLogin());
	    ResultSet rs2 = pst3.executeQuery();
	    while (rs2.next()) {
		textField.setText(rs2.getString("firstName"));
		textField_1.setText(rs2.getString("lastName"));
		textField_2.setText(rs2.getString("dateOfBirth"));
		textField_4.setText(rs2.getString("telephone"));
		textFieldhouse.setText(rs2.getString("house"));
		textFieldneighbourhood.setText(rs2.getString("neighbourhood"));
		textFieldcity.setText(rs2.getString("city"));
		textFieldCountry.setText(rs2.getString("country"));
		textFieldZipcode.setText(rs2.getString("zipcode"));
		textField_8.setText(rs2.getString("occupation"));
		textField_9.setText(rs2.getString("mobile"));
		textField_10.setText(rs2.getString("nationality"));
		textField_11.setText(rs2.getString("spouceName"));
		textField_12.setText(rs2.getString("birthPlace"));
		textField_13.setText(rs2.getString("children"));
		textField_14.setText(rs2.getString("bankAgency"));
		if(rs2.getString("gender").equals("M"))
		{
		    rdbtnMale.setSelected(true);
		    rdbtnfemale.setSelected(false);
		    
		}else
		{
		    rdbtnMale.setSelected(false);
		    rdbtnfemale.setSelected(true);
		}
		
		if(rs2.getString("Married").equals("yes"))
		{
		    rdbtnYes.setSelected(true);
		    rdbtnNo.setSelected(false);
		}else
		{
		    rdbtnYes.setSelected(false);
		    rdbtnNo.setSelected(true);
		}
		
		    
	    }
	} catch (Exception e2 ) {
	    e2.printStackTrace();
	}

    }
}
