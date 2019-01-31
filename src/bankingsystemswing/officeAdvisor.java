package bankingsystemswing;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class officeAdvisor {

    JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    officeAdvisor window = new officeAdvisor();
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
    public officeAdvisor() {
	initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    public ClientInformationAdvisor cia = new ClientInformationAdvisor();

    Connection connection = null;
    private JButton btnView;

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
	frame.setBounds(100, 100, 556, 447);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblOfficeAdvisor = new JLabel("OFFICE ADVISOR");
	lblOfficeAdvisor.setBounds(219, 11, 112, 14);
	frame.getContentPane().add(lblOfficeAdvisor);

	JScrollPane scrollPane = new JScrollPane();

	scrollPane.setBounds(25, 43, 494, 312);
	frame.getContentPane().add(scrollPane);

	table = new JTable();

	/// Mouse clicked event
	table.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {

		boolean a = table.isEditing();
		int index = table.getSelectedRow();

		GlobalVariableOfficeAdvisorEmail.getInstance().setEmail((String) table.getValueAt(index, 2));

		OfficeAdvisorClientInformation oaci = new OfficeAdvisorClientInformation();
		oaci.frame.setVisible(true);

	    }
	});
	scrollPane.setViewportView(table);

	try {
	    String query = "Select firstName,LastName,email,dateOfBirth,gender from clienttable";
	    PreparedStatement pst = connection.prepareStatement(query);
	    ResultSet rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));

	    btnView = new JButton("view");
	    btnView.setBounds(35, 366, 89, 23);
	    frame.getContentPane().add(btnView);

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
