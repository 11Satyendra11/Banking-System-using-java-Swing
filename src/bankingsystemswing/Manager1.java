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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Manager1 extends Thread {

    JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Manager1 window = new Manager1();
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
    public Manager1() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    Connection connection = null;

    JDateChooser dateChooser;
    JDateChooser dateChooser_1;

    private void initialize() {
	try {
	    connection = DBConnector.getConnection();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	frame = new JFrame();
	frame.setBounds(100, 100, 699, 506);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("MANAGER");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblNewLabel.setBounds(282, 22, 134, 31);
	frame.getContentPane().add(lblNewLabel);

	// Get the data for a defined period
	JButton btnNewButton = new JButton("SHOW");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		String date1 = dateChooser.getDate().toString();
		String date[] = date1.split(" ");

		if (date[1].equalsIgnoreCase("jan")) {
		    date[1] = "01";
		} else if (date[1].equalsIgnoreCase("feb")) {
		    date[1] = "02";
		} else if (date[1].equalsIgnoreCase("mar")) {
		    date[1] = "03";
		} else if (date[1].equalsIgnoreCase("apr")) {
		    date[1] = "04";
		} else if (date[1].equalsIgnoreCase("may")) {
		    date[1] = "05";
		} else if (date[1].equalsIgnoreCase("jun")) {
		    date[1] = "06";
		} else if (date[1].equalsIgnoreCase("jul")) {
		    date[1] = "07";
		} else if (date[1].equalsIgnoreCase("aug")) {
		    date[1] = "08";
		} else if (date[1].equalsIgnoreCase("sep")) {
		    date[1] = "09";
		} else if (date[1].equalsIgnoreCase("oct")) {
		    date[1] = "10";
		} else if (date[1].equalsIgnoreCase("nov")) {
		    date[1] = "11";
		} else if (date[1].equalsIgnoreCase("dec")) {
		    date[1] = "12";
		}
		String date2 = date[5] + "-" + date[1] + "-" + date[2];

		String date3 = dateChooser_1.getDate().toString();
		String date4[] = date3.split(" ");

		if (date4[1].equalsIgnoreCase("jan")) {
		    date4[1] = "01";
		} else if (date4[1].equalsIgnoreCase("feb")) {
		    date4[1] = "02";
		} else if (date4[1].equalsIgnoreCase("mar")) {
		    date4[1] = "03";
		} else if (date4[1].equalsIgnoreCase("apr")) {
		    date4[1] = "04";
		} else if (date4[1].equalsIgnoreCase("may")) {
		    date4[1] = "05";
		} else if (date4[1].equalsIgnoreCase("jun")) {
		    date4[1] = "06";
		} else if (date4[1].equalsIgnoreCase("jul")) {
		    date4[1] = "07";
		} else if (date4[1].equalsIgnoreCase("aug")) {
		    date4[1] = "08";
		} else if (date4[1].equalsIgnoreCase("sep")) {
		    date4[1] = "09";
		} else if (date4[1].equalsIgnoreCase("oct")) {
		    date4[1] = "10";
		} else if (date4[1].equalsIgnoreCase("nov")) {
		    date4[1] = "11";
		} else if (date4[1].equalsIgnoreCase("dec")) {
		    date4[1] = "12";
		}

		String date5 = date4[5] + "-" + date4[1] + "-" + date4[2];

		String query = "select clienttable.firstName,clienttable.lastName,clienttable.email, transactiontable.debit as deposit from clienttable join transactiontable on\r\n"
			+ "clienttable.email = transactiontable.email where transactiontable.dateOfTransaction between ? and ?";

		try {
		  

		    PreparedStatement pst = connection.prepareStatement(query);
		    pst.setString(1, date2);
		    pst.setString(2, date5);
		    ResultSet rs = pst.executeQuery();

		    table.setModel(DbUtils.resultSetToTableModel(rs));
		    GlobalVariable.getInstance().setResultSet(pst.executeQuery());
		   

		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    }
	});
	btnNewButton.setBounds(271, 102, 89, 23);
	frame.getContentPane().add(btnNewButton);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 146, 663, 280);
	frame.getContentPane().add(scrollPane);

	table = new JTable();
	scrollPane.setViewportView(table);

	// Generate Report using Apache POI
	JButton btnNewButton_1 = new JButton("GENERATE REPORT");
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		// TO DO
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		GlobalVariable.getInstance().setFileName(f.getAbsolutePath());
		System.out.println(GlobalVariable.getInstance().getFileName());

		JOptionPane.showMessageDialog(frame, "File Saved Sucessfully");

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("lawix10");
		HSSFRow rowhead = sheet.createRow(0);
		rowhead.createCell(0).setCellValue("First Name");
		rowhead.createCell(1).setCellValue("Last Name");
		rowhead.createCell(2).setCellValue("Email");
		rowhead.createCell(3).setCellValue("Deposit");

		ResultSet rs3 = GlobalVariable.getInstance().getResultSet();
		int i = 1;
		try {
		    while (rs3.next()) {
			HSSFRow row = sheet.createRow((short) i);
			row.createCell((short) 0).setCellValue(rs3.getString("clienttable.firstName"));
			row.createCell((short) 1).setCellValue(rs3.getString("clienttable.lastName"));
			row.createCell((short) 2).setCellValue(rs3.getString("clienttable.email"));
			row.createCell((short) 3).setCellValue(rs3.getString("deposit"));
			i++;

		    }

		    String yemi = GlobalVariable.getInstance().getFileName();
		    System.out.println("yemi " + yemi);
		    FileOutputStream fileOut = new FileOutputStream(yemi);
		    workbook.write(fileOut);
		    fileOut.close();

		} catch (SQLException | IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    }
	});
	btnNewButton_1.setBounds(487, 433, 134, 23);
	frame.getContentPane().add(btnNewButton_1);

	dateChooser = new JDateChooser();
	dateChooser.setBounds(77, 65, 134, 20);
	frame.getContentPane().add(dateChooser);

	JLabel lblNewLabel_1 = new JLabel("TO");
	lblNewLabel_1.setBounds(292, 64, 46, 14);
	frame.getContentPane().add(lblNewLabel_1);

	dateChooser_1 = new JDateChooser();
	dateChooser_1.setBounds(438, 65, 134, 20);
	frame.getContentPane().add(dateChooser_1);

    }
}
