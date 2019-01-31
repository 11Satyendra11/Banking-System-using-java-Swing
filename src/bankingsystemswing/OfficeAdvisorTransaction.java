package bankingsystemswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class OfficeAdvisorTransaction {

    JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    OfficeAdvisorTransaction window = new OfficeAdvisorTransaction();
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
    public OfficeAdvisorTransaction() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    Connection connection = null;
    private JTable table;
    private JScrollPane scrollPane;

    private JButton btnBack;

    private void initialize() {

	try {
	    connection = DBConnector.getConnection();

	} catch (ClassNotFoundException e1) {

	    e1.printStackTrace();
	} catch (SQLException e1) {

	    e1.printStackTrace();
	}

	frame = new JFrame();
	frame.setBounds(100, 100, 1061, 601);
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 11, 1025, 506);
	frame.getContentPane().add(scrollPane);

	table = new JTable();
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(false);
	table.setEnabled(true);
	table.isEnabled();
	
	
	
	
	
	scrollPane.setViewportView(table);
	try {
	    String query = "Select * from transactiontable where email=?";
	    PreparedStatement pst = connection.prepareStatement(query);
	    pst.setString(1, GlobalVariableOfficeAdvisorEmail.getInstance().getEmail());
	    ResultSet rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));

	    btnBack = new JButton("Back");
	    btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

		    frame.dispose();
		    
		}
	    });
	    btnBack.setBounds(0, 528, 89, 23);
	    frame.getContentPane().add(btnBack);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
