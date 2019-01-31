package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class democombo {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    democombo window = new democombo();
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
    public democombo() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel = new JLabel("Account Type");
	lblNewLabel.setBounds(45, 77, 77, 14);
	frame.getContentPane().add(lblNewLabel);

	JComboBox comboBox = new JComboBox();
	comboBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String accountType = comboBox.getSelectedItem().toString();
		System.out.println(accountType);
		if (accountType == "Client") {
		    accountType = "C";
		}

		else if (accountType == "Officer") {
		    accountType = "A";
		} else if (accountType == "Manager") {
		    accountType = "M";
		}

		System.out.println(accountType);
	    }
	});
	comboBox.setBounds(150, 74, 77, 20);
	frame.getContentPane().add(comboBox);
	comboBox.addItem("Client");
	comboBox.addItem("Officer");
	comboBox.addItem("Manager");

    }

}
