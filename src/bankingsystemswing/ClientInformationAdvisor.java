package bankingsystemswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ClientInformationAdvisor {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ClientInformationAdvisor window = new ClientInformationAdvisor();
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
    public ClientInformationAdvisor() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 596, 453);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel label = new JLabel("First Name");
	label.setBounds(20, 51, 65, 14);
	frame.getContentPane().add(label);

	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(130, 48, 117, 20);
	frame.getContentPane().add(textField);

	JLabel label_1 = new JLabel("Last Name");
	label_1.setBounds(20, 87, 65, 14);
	frame.getContentPane().add(label_1);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(130, 87, 117, 20);
	frame.getContentPane().add(textField_1);

	JLabel label_2 = new JLabel("DOB");
	label_2.setBounds(20, 122, 46, 14);
	frame.getContentPane().add(label_2);

	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(130, 122, 117, 20);
	frame.getContentPane().add(textField_2);

	JLabel label_3 = new JLabel("Account Type");
	label_3.setBounds(20, 159, 89, 14);
	frame.getContentPane().add(label_3);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(130, 159, 117, 20);
	frame.getContentPane().add(textField_3);

	JLabel label_4 = new JLabel("Gender");
	label_4.setBounds(20, 197, 46, 14);
	frame.getContentPane().add(label_4);

	JRadioButton radioButton = new JRadioButton("Male");
	radioButton.setBounds(107, 193, 58, 23);
	frame.getContentPane().add(radioButton);

	JRadioButton radioButton_1 = new JRadioButton("Female");
	radioButton_1.setBounds(167, 193, 59, 23);
	frame.getContentPane().add(radioButton_1);

	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(130, 229, 117, 20);
	frame.getContentPane().add(textField_4);

	JLabel label_5 = new JLabel("Telephone");
	label_5.setBounds(20, 232, 65, 14);
	frame.getContentPane().add(label_5);

	JLabel label_6 = new JLabel("Married");
	label_6.setBounds(20, 268, 46, 14);
	frame.getContentPane().add(label_6);

	JRadioButton radioButton_2 = new JRadioButton("Yes");
	radioButton_2.setBounds(117, 264, 48, 23);
	frame.getContentPane().add(radioButton_2);

	JRadioButton radioButton_3 = new JRadioButton("No");
	radioButton_3.setBounds(165, 264, 46, 23);
	frame.getContentPane().add(radioButton_3);

	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(127, 300, 120, 20);
	frame.getContentPane().add(textField_5);

	JLabel label_7 = new JLabel("Spouce Name:");
	label_7.setBounds(20, 303, 97, 14);
	frame.getContentPane().add(label_7);

	JLabel label_8 = new JLabel("Bank Agency");
	label_8.setBounds(20, 328, 89, 14);
	frame.getContentPane().add(label_8);

	textField_6 = new JTextField();
	textField_6.setColumns(10);
	textField_6.setBounds(125, 325, 122, 20);
	frame.getContentPane().add(textField_6);

	textField_7 = new JTextField();
	textField_7.setColumns(10);
	textField_7.setBounds(407, 323, 116, 20);
	frame.getContentPane().add(textField_7);

	JLabel label_9 = new JLabel("Email");
	label_9.setBounds(351, 320, 46, 14);
	frame.getContentPane().add(label_9);

	textField_8 = new JTextField();
	textField_8.setColumns(10);
	textField_8.setBounds(407, 292, 116, 20);
	frame.getContentPane().add(textField_8);

	JLabel label_10 = new JLabel("Children");
	label_10.setBounds(331, 295, 66, 14);
	frame.getContentPane().add(label_10);

	textField_9 = new JTextField();
	textField_9.setColumns(10);
	textField_9.setBounds(407, 257, 116, 20);
	frame.getContentPane().add(textField_9);

	JLabel label_11 = new JLabel("Birth Place");
	label_11.setBounds(331, 260, 78, 14);
	frame.getContentPane().add(label_11);

	textField_10 = new JTextField();
	textField_10.setColumns(10);
	textField_10.setBounds(407, 221, 116, 20);
	frame.getContentPane().add(textField_10);

	JLabel label_12 = new JLabel("Nationality");
	label_12.setBounds(331, 224, 78, 14);
	frame.getContentPane().add(label_12);

	textField_11 = new JTextField();
	textField_11.setColumns(10);
	textField_11.setBounds(407, 186, 116, 20);
	frame.getContentPane().add(textField_11);

	JLabel label_13 = new JLabel("Mobile");
	label_13.setBounds(351, 189, 46, 14);
	frame.getContentPane().add(label_13);

	textField_12 = new JTextField();
	textField_12.setColumns(10);
	textField_12.setBounds(407, 148, 116, 20);
	frame.getContentPane().add(textField_12);

	JLabel label_14 = new JLabel("Occupation");
	label_14.setBounds(331, 151, 78, 14);
	frame.getContentPane().add(label_14);

	textField_13 = new JTextField();
	textField_13.setColumns(10);
	textField_13.setBounds(407, 114, 138, 20);
	frame.getContentPane().add(textField_13);

	textField_14 = new JTextField();
	textField_14.setColumns(10);
	textField_14.setBounds(407, 79, 138, 20);
	frame.getContentPane().add(textField_14);

	textField_15 = new JTextField();
	textField_15.setColumns(10);
	textField_15.setBounds(407, 48, 138, 20);
	frame.getContentPane().add(textField_15);

	JLabel label_15 = new JLabel("Address");
	label_15.setBounds(331, 51, 66, 14);
	frame.getContentPane().add(label_15);

	JLabel label_16 = new JLabel("CLIENT INFORMATION EDIT");
	label_16.setBounds(219, 11, 156, 14);
	frame.getContentPane().add(label_16);
    }

}
