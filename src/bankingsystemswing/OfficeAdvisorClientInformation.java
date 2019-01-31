package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OfficeAdvisorClientInformation {

    JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    OfficeAdvisorClientInformation window = new OfficeAdvisorClientInformation();
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
    public OfficeAdvisorClientInformation() {
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
	frame.setBounds(100, 100, 664, 561);
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblClientInformation = new JLabel("CLIENT INFORMATION");
	lblClientInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblClientInformation.setBounds(274, 11, 187, 31);
	frame.getContentPane().add(lblClientInformation);
	
	JLabel lblFirstName = new JLabel("First Name");
	lblFirstName.setBounds(24, 71, 82, 14);
	frame.getContentPane().add(lblFirstName);
	
	JLabel lblLastName = new JLabel("Last Name");
	lblLastName.setBounds(24, 96, 82, 14);
	frame.getContentPane().add(lblLastName);
	
	JLabel lblDob = new JLabel("DOB");
	lblDob.setBounds(23, 121, 46, 14);
	frame.getContentPane().add(lblDob);
	
	JLabel label = new JLabel("");
	label.setBounds(24, 146, 62, 14);
	frame.getContentPane().add(label);
	
	JLabel lblGender = new JLabel("Gender");
	lblGender.setBounds(24, 146, 46, 14);
	frame.getContentPane().add(lblGender);
	
	JLabel lblTelephone = new JLabel("Telephone");
	lblTelephone.setBounds(24, 184, 82, 14);
	frame.getContentPane().add(lblTelephone);
	
	JLabel lblMarried = new JLabel("Married");
	lblMarried.setBounds(24, 209, 62, 14);
	frame.getContentPane().add(lblMarried);
	
	JLabel lblSpouceName = new JLabel("Spouce Name");
	lblSpouceName.setBounds(24, 234, 94, 14);
	frame.getContentPane().add(lblSpouceName);
	
	JLabel lblBankAgency = new JLabel("Bank Agency");
	lblBankAgency.setBounds(23, 259, 83, 14);
	frame.getContentPane().add(lblBankAgency);
	
	JLabel lblAddress = new JLabel("Address");
	lblAddress.setBounds(24, 284, 69, 14);
	frame.getContentPane().add(lblAddress);
	
	JLabel lblhouse = new JLabel("New label");
	lblhouse.setBounds(124, 284, 202, 14);
	frame.getContentPane().add(lblhouse);
	
	JLabel lblneighbourhood = new JLabel("New label");
	lblneighbourhood.setBounds(124, 309, 202, 14);
	frame.getContentPane().add(lblneighbourhood);
	
	JLabel lblcity = new JLabel("New label");
	lblcity.setBounds(124, 334, 202, 14);
	frame.getContentPane().add(lblcity);
	
	JLabel lblcountry = new JLabel("New label");
	lblcountry.setBounds(124, 359, 202, 14);
	frame.getContentPane().add(lblcountry);
	
	JLabel lblzip = new JLabel("New label");
	lblzip.setBounds(124, 384, 202, 14);
	frame.getContentPane().add(lblzip);
	
	JLabel lblBankagency = new JLabel("New label");
	lblBankagency.setBounds(124, 259, 202, 14);
	frame.getContentPane().add(lblBankagency);
	
	JLabel lblSpouce = new JLabel("New label");
	lblSpouce.setBounds(124, 234, 202, 14);
	frame.getContentPane().add(lblSpouce);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setBounds(124, 209, 202, 14);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setBounds(124, 184, 202, 14);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setBounds(124, 146, 202, 14);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("New label");
	lblNewLabel_3.setBounds(124, 121, 202, 14);
	frame.getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setBounds(124, 96, 202, 14);
	frame.getContentPane().add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("New label");
	lblNewLabel_5.setBounds(124, 71, 202, 14);
	frame.getContentPane().add(lblNewLabel_5);
	
	JLabel lblOccupation = new JLabel("Occupation");
	lblOccupation.setBounds(370, 71, 82, 14);
	frame.getContentPane().add(lblOccupation);
	
	JLabel lblNationality = new JLabel("Nationality");
	lblNationality.setBounds(370, 96, 82, 14);
	frame.getContentPane().add(lblNationality);
	
	JLabel lblMobile = new JLabel("Mobile");
	lblMobile.setBounds(370, 121, 62, 14);
	frame.getContentPane().add(lblMobile);
	
	JLabel lblBirthPlace = new JLabel("Birth Place");
	lblBirthPlace.setBounds(370, 146, 82, 14);
	frame.getContentPane().add(lblBirthPlace);
	
	JLabel lblChildren = new JLabel("Children");
	lblChildren.setBounds(370, 171, 72, 14);
	frame.getContentPane().add(lblChildren);
	
	
	//Back button dispose frame
	JButton btnBack = new JButton("Back");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		
		}
	});
	btnBack.setBounds(10, 422, 89, 23);
	frame.getContentPane().add(btnBack);
	
	//Show Transaction of the client when clicked
	JButton btnShowTransaction = new JButton("Show Transaction ");
	btnShowTransaction.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
		   OfficeAdvisorTransaction oat = new OfficeAdvisorTransaction();
		   oat.frame.setVisible(true);
		    
		
		}
	});
	btnShowTransaction.setBounds(233, 422, 121, 23);
	frame.getContentPane().add(btnShowTransaction);
	
	JLabel lblBalance = new JLabel("BALANCE");
	lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblBalance.setBounds(387, 259, 94, 23);
	frame.getContentPane().add(lblBalance);
	
	JLabel lblNewLabel_6 = new JLabel("New label");
	lblNewLabel_6.setBounds(378, 309, 74, 14);
	frame.getContentPane().add(lblNewLabel_6);
	
	JLabel lblNewLabel_7 = new JLabel("\u20AC");
	lblNewLabel_7.setBounds(457, 309, 46, 14);
	frame.getContentPane().add(lblNewLabel_7);
	
	JLabel lbloccup = new JLabel("New label");
	lbloccup.setBounds(478, 71, 160, 14);
	frame.getContentPane().add(lbloccup);
	
	JLabel lblnation = new JLabel("New label");
	lblnation.setBounds(478, 96, 160, 14);
	frame.getContentPane().add(lblnation);
	
	JLabel lblmobile = new JLabel("New label");
	lblmobile.setBounds(478, 121, 160, 14);
	frame.getContentPane().add(lblmobile);
	
	JLabel lblbirthplc = new JLabel("New label");
	lblbirthplc.setBounds(478, 146, 160, 14);
	frame.getContentPane().add(lblbirthplc);
	
	JLabel lblchild = new JLabel("New label");
	lblchild.setBounds(478, 171, 160, 14);
	frame.getContentPane().add(lblchild);
	
	String query = "Select firstName,LastName,dateOfBirth,telephone,house,neighbourhood,city,country,zipcode,occupation,mobile,nationality,Married,spouceName,birthPlace,children,bankAgency from clienttable where email=?";
	
	try {
	    PreparedStatement pst = connection.prepareStatement(query);
	    officeAdvisor oa = new officeAdvisor();
	    
	    pst.setString(1,GlobalVariableOfficeAdvisorEmail.getInstance().getEmail() );
	    ResultSet rs = pst.executeQuery();
	    
	    while(rs.next())
	    {
		lblNewLabel_5.setText(rs.getString("firstName"));
		lblNewLabel_4.setText(rs.getString("lastName"));
		lblNewLabel_3.setText(rs.getString("dateOfBirth"));
		lblNewLabel_1.setText(rs.getString("telephone"));
		lblhouse.setText(rs.getString("house"));
		lblneighbourhood.setText(rs.getString("neighbourhood"));
		lblcity.setText(rs.getString("city"));
		lblcountry.setText(rs.getString("country"));
		lblzip.setText(rs.getString("zipcode"));
		lblNewLabel.setText(rs.getString("Married"));
		lblSpouce.setText(rs.getString("spouceName"));
		lblBankagency.setText(rs.getString("bankAgency"));
		lbloccup.setText(rs.getString("occupation"));
		lblnation.setText(rs.getString("nationality"));
		lblmobile.setText(rs.getString("mobile"));
		lblbirthplc.setText(rs.getString("birthPlace"));
		lblchild.setText(rs.getString("children"));
		
		
	    }
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
	//For Balance 
	
	String query2 = "select balance from balancetable where email=?";
	try {
	    PreparedStatement pst1 = connection.prepareStatement(query2);
	    pst1.setString(1, GlobalVariableOfficeAdvisorEmail.getInstance().getEmail());
	    
	    ResultSet rs2 = pst1.executeQuery();
	    
	    while(rs2.next()) {
	   
	    lblNewLabel_6.setText(rs2.getString("balance"));
	    
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    
    }
}
