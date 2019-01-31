package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTabbedPane;



import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ClientInformation {

	JFrame frmClientInformation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInformation window = new ClientInformation();
					window.frmClientInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientInformation() {
		initialize();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection = null;
	
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
		frmClientInformation = new JFrame();
		frmClientInformation.setTitle("Client Information");
		frmClientInformation.setResizable(false);
		frmClientInformation.setBounds(100, 100, 819, 499);
		frmClientInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientInformation.getContentPane().setLayout(null);
		
		JLabel lblSwissBank = new JLabel("SWISS BANK");
		lblSwissBank.setForeground(Color.BLUE);
		lblSwissBank.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSwissBank.setBounds(10, 11, 145, 40);
		frmClientInformation.getContentPane().add(lblSwissBank);
		
		JButton btnNewButton = new JButton("INFORMATION");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 54, 89, 23);
		frmClientInformation.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TRANSACTION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClientInformation.dispose();
				Transaction transaction = new Transaction();
				transaction.main(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_1.setBounds(10, 88, 89, 23);
		frmClientInformation.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TRANSFER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmClientInformation.dispose();
				TransferMoney transfermoney = new TransferMoney();
				transfermoney.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_2.setBounds(10, 122, 89, 23);
		frmClientInformation.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 54, 694, 331);
		frmClientInformation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACC No:");
		lblNewLabel.setBounds(10, 24, 71, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EmailID:");
		lblNewLabel_1.setBounds(10, 49, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telephone:");
		lblNewLabel_2.setBounds(10, 99, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lbltelephone = new JLabel("New label");
		lbltelephone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbltelephone.setBounds(123, 99, 204, 14);
		panel.add(lbltelephone);
		
		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setBounds(48, 124, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblAccno = new JLabel("New label");
		lblAccno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAccno.setBounds(125, 24, 202, 14);
		panel.add(lblAccno);
		
		JLabel lblemail = new JLabel("New label");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblemail.setBounds(123, 49, 204, 14);
		panel.add(lblemail);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 74, 71, 14);
		panel.add(lblGender);
		
		JLabel lblgender = new JLabel("New label");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblgender.setBounds(123, 74, 204, 14);
		panel.add(lblgender);
		
		JLabel lblNewLabel_4 = new JLabel("House No:");
		lblNewLabel_4.setBounds(10, 149, 73, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Neighbourhood:");
		lblNewLabel_6.setBounds(10, 174, 98, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("City:");
		lblNewLabel_8.setBounds(10, 199, 71, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Country:");
		lblNewLabel_9.setBounds(10, 226, 71, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Zip Code:");
		lblNewLabel_10.setBounds(10, 251, 71, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Occupation:");
		lblNewLabel_11.setBounds(10, 276, 84, 14);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Mobile:");
		lblNewLabel_12.setBounds(10, 301, 71, 14);
		panel.add(lblNewLabel_12);
		
		JLabel lblhouse = new JLabel("New label");
		lblhouse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblhouse.setBounds(123, 149, 204, 14);
		panel.add(lblhouse);
		
		JLabel lblneighbour = new JLabel("New label");
		lblneighbour.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblneighbour.setBounds(123, 174, 204, 14);
		panel.add(lblneighbour);
		
		JLabel lblcity = new JLabel("New label");
		lblcity.setBounds(123, 199, 204, 14);
		panel.add(lblcity);
		
		JLabel lblcountry = new JLabel("New label");
		lblcountry.setBounds(123, 226, 204, 14);
		panel.add(lblcountry);
		
		JLabel lblzip = new JLabel("New label");
		lblzip.setBounds(125, 251, 202, 14);
		panel.add(lblzip);
		
		JLabel lblOccupation = new JLabel("New label");
		lblOccupation.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOccupation.setBounds(123, 276, 204, 14);
		panel.add(lblOccupation);
		
		JLabel lblMobile = new JLabel("New label");
		lblMobile.setBounds(123, 301, 204, 14);
		panel.add(lblMobile);
		
		JLabel lblNewLabel_13 = new JLabel("Nationality:");
		lblNewLabel_13.setBounds(386, 24, 78, 14);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Married:");
		lblNewLabel_14.setBounds(386, 49, 78, 14);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Spouce Name:");
		lblNewLabel_15.setBounds(386, 74, 98, 14);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Birth Place:");
		lblNewLabel_16.setBounds(386, 99, 78, 14);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Children:");
		lblNewLabel_17.setBounds(386, 124, 78, 14);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Bank Agency:");
		lblNewLabel_18.setBounds(386, 149, 78, 14);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("DOB:");
		lblNewLabel_19.setBounds(386, 174, 78, 14);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("IBAN");
		lblNewLabel_20.setBounds(455, 276, 46, 14);
		panel.add(lblNewLabel_20);
		
		JLabel lbliban = new JLabel("New label");
		lbliban.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbliban.setBounds(337, 294, 347, 25);
		panel.add(lbliban);
		
		JLabel lblNewLabel_22 = new JLabel("BIC Code:");
		lblNewLabel_22.setBounds(386, 251, 78, 14);
		panel.add(lblNewLabel_22);
		
		JLabel lblnationality = new JLabel("New label");
		lblnationality.setBounds(497, 24, 187, 14);
		panel.add(lblnationality);
		
		JLabel lblmarried = new JLabel("New label");
		lblmarried.setBounds(497, 49, 187, 14);
		panel.add(lblmarried);
		
		JLabel lblSpouce = new JLabel("New label");
		lblSpouce.setBounds(497, 74, 187, 14);
		panel.add(lblSpouce);
		
		JLabel lblBirthPlace = new JLabel("New label");
		lblBirthPlace.setBounds(497, 99, 187, 14);
		panel.add(lblBirthPlace);
		
		JLabel lblChildren = new JLabel("New label");
		lblChildren.setBounds(497, 124, 187, 14);
		panel.add(lblChildren);
		
		JLabel lblAgency = new JLabel("New label");
		lblAgency.setBounds(497, 149, 187, 14);
		panel.add(lblAgency);
		
		JLabel lblDOB = new JLabel("New label");
		lblDOB.setBounds(497, 174, 187, 14);
		panel.add(lblDOB);
		
		JLabel lblBIC = new JLabel("New label");
		lblBIC.setBounds(497, 251, 187, 14);
		panel.add(lblBIC);
		
		JLabel lblFirstName = new JLabel("New label");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(266, 20, 238, 14);
		frmClientInformation.getContentPane().add(lblFirstName);
		
		JLabel lblNewLabel_7 = new JLabel("BALANCE");
		lblNewLabel_7.setBounds(227, 412, 83, 14);
		frmClientInformation.getContentPane().add(lblNewLabel_7);
		
		
		// Edit the information page
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frmClientInformation.dispose();
				ClientInformationEdit cfe = new ClientInformationEdit();
				cfe.frame.setVisible(true);
			}
		});
		btnEdit.setBounds(681, 408, 89, 23);
		frmClientInformation.getContentPane().add(btnEdit);
		
		JButton btnAddMoney = new JButton("ADD MONEY");
		btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmClientInformation.dispose();
				AddMoneyClient.main(null);
			}
		});
		btnAddMoney.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAddMoney.setBounds(10, 156, 89, 23);
		frmClientInformation.getContentPane().add(btnAddMoney);
		
		JLabel lblLastName = new JLabel("New label");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(514, 20, 221, 14);
		frmClientInformation.getContentPane().add(lblLastName);
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(354, 408, 221, 19);
		frmClientInformation.getContentPane().add(label);
		
		JLabel lblNewLabel_3 = new JLabel("\u20AC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(320, 408, 24, 19);
		frmClientInformation.getContentPane().add(lblNewLabel_3);
		
		
		
		
		// To get the data from the database
		//String email11 = ;
		//String query = "select firstName,lastName,dateOfBirth,gender,telephone,house,neighbourhood,city,country,zipcode,occupation,mobile,nationality,Married,spouceName,birthPlace,children,bankAgency,email,iban,BIC,accountNo from clienttable where email= ?";
		String query = "SELECT * FROM clienttable WHERE email = ?";
		String query2 = "select balance from balancetable where email =?";
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
		    pst = connection.prepareStatement(query);
		    System.out.println(GlobalVariable.getInstance().getLogin());
		    pst.setString(1, GlobalVariable.getInstance().getLogin());
		    
		    //System.out.println(email11);
		    pst.setString(1, GlobalVariable.getInstance().getLogin());
		    
		    rs = pst.executeQuery();
		    
		    while(rs.next())
		    {
			lblFirstName.setText(rs.getString("firstName"));
			lblLastName.setText(rs.getString("lastName"));
			lblAccno.setText(rs.getString("accountNo"));
			lblemail.setText(rs.getString("email"));
			lblgender.setText(rs.getString("gender"));
			lbltelephone.setText(rs.getString("telephone"));
			lblhouse.setText(rs.getString("house"));
			lblneighbour.setText(rs.getString("neighbourhood"));
			lblcity.setText(rs.getString("city"));
			lblcountry.setText(rs.getString("country"));
			lblzip.setText(rs.getString("zipcode"));
			lblOccupation.setText(rs.getString("occupation"));
			lblMobile.setText(rs.getString("mobile"));
			lblnationality.setText(rs.getString("nationality"));
			lblmarried.setText(rs.getString("Married"));
			lblSpouce.setText(rs.getString("spouceName"));
			lblBirthPlace.setText(rs.getString("birthPlace"));
			lblChildren.setText(rs.getString("children"));
			lblAgency.setText(rs.getString("bankAgency"));
			lblDOB.setText(rs.getString("dateOfBirth"));
			lblBIC.setText(rs.getString("BIC"));
			lbliban.setText(rs.getString("iban"));
		    }
		   
		    pst = connection.prepareStatement(query2);
		    
		    pst.setString(1, GlobalVariable.getInstance().getLogin());
		    
		    rs = pst.executeQuery();
		    while(rs.next())
		    {
			label.setText(rs.getString("balance"));
		    }
		    
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} finally {
		   // pst.close();
		    // rs.close();
		}
		
	}
}
