package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.opencsv.CSVWriter;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;



public class Transaction {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction window = new Transaction();
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
	public Transaction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Connection connection = null;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnExport;
	private JButton btnBack;
	private void initialize()  {
		try {
			connection = DBConnector.getConnection();
			
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1061, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 1025, 506);
			frame.getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setEnabled(false);
			scrollPane.setViewportView(table);
			try {
				String query = "Select * from transactiontable where email = ?";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, GlobalVariable.getInstance().getLogin());
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				//Export transaction to csv
				btnExport = new JButton("Export");
				btnExport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					    
					    JFileChooser chooser = new JFileChooser();
					    chooser.showOpenDialog(null);
					    File f = chooser.getSelectedFile();
					    String filename = f.getAbsolutePath();
					    
					    try {
						//FileWriter fw = new FileWriter(filename);
						ResultSet rs2 = pst.executeQuery();
						
						CSVWriter writer = new CSVWriter(new FileWriter(filename));
						writer.writeAll(rs2, true,true);
						writer.close();
						/*fw.append("id_bankBalance");
						fw.append(",");
						fw.append("transaction");
						fw.append(",");
						fw.append("debit");
						fw.append(",");
						
						while(rs2.next())
						{
						    fw.append(rs2.getString(1));
						    fw.append(",");
						    fw.append(rs2.getString(2));
						    fw.append(",");
						    
						    fw.append(rs2.getString(3));
						    fw.append(",");
						    fw.append(rs2.getString(4));
						    fw.append(",");
						    fw.append(rs2.getString(5));
						    
						    fw.append("\n");
				
						}
					            fw.flush();
					            fw.close();*/
					         
					           JOptionPane.showMessageDialog(frame, "CSV File is created successfully");
					    } catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					    }
					    
					}
				});
				btnExport.setBounds(533, 528, 89, 23);
				frame.getContentPane().add(btnExport);
				
				btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						frame.dispose();
						ClientInformation clientinformation = new ClientInformation();
						clientinformation.main(null);
					}
				});
				btnBack.setBounds(0, 528, 89, 23);
				frame.getContentPane().add(btnBack);
			}
				catch(Exception e){
					e.printStackTrace();
				}
			
		}
		
	}

