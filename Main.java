package NodePath;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.ComponentOrientation;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField nameFromTextField;
	private JTextField xFromTextField;
	private JTextField yFromTextField;
	private JTextField floorFromTextField;
	private JTextField roomTypeFromTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JTextArea insertTextArea;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameFromTextField = new JTextField();
		nameFromTextField.setBounds(82, 66, 46, 20);
		contentPane.add(nameFromTextField);
		nameFromTextField.setColumns(10);
		
		xFromTextField = new JTextField();
		xFromTextField.setBounds(82, 97, 46, 20);
		contentPane.add(xFromTextField);
		xFromTextField.setColumns(10);
		
		yFromTextField = new JTextField();
		yFromTextField.setBounds(82, 128, 46, 20);
		contentPane.add(yFromTextField);
		yFromTextField.setColumns(10);
		
		floorFromTextField = new JTextField();
		floorFromTextField.setBounds(82, 159, 46, 20);
		contentPane.add(floorFromTextField);
		floorFromTextField.setColumns(10);
		
		roomTypeFromTextField = new JTextField();
		roomTypeFromTextField.setBounds(82, 190, 86, 20);
		contentPane.add(roomTypeFromTextField);
		roomTypeFromTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Room \u2116");
		lblNewLabel.setBounds(10, 66, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Co. X");
		lblNewLabel_1.setBounds(10, 97, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Floor");
		lblNewLabel_3.setBounds(10, 159, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Co. Y");
		lblNewLabel_2.setBounds(10, 128, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Room type");
		lblNewLabel_4.setBounds(10, 190, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(10, 24, 46, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(225, 24, 46, 14);
		contentPane.add(lblTo);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(250, 232, 61, 23);
		contentPane.add(btnGo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(225, 66, 46, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 97, 46, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 128, 46, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 159, 46, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(225, 190, 86, 20);
		contentPane.add(textField_4);
		
		JTextArea insertTextArea = new JTextArea();
		insertTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		insertTextArea.setDragEnabled(true);
		insertTextArea.setEditable(false);
		insertTextArea.setBounds(367, 24, 285, 230);
		contentPane.add(insertTextArea);
		
		
		JButton btnInsertFile = new JButton("Insert file");
		btnInsertFile.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				FileOpener myObj = new FileOpener();
				
				try {
					myObj.choose();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				insertTextArea.setText(myObj.sb.toString());
			}
		});
		btnInsertFile.setBounds(563, 276, 89, 23);
		contentPane.add(btnInsertFile);
		
		JTextArea resultTextArea = new JTextArea();
		resultTextArea.setBounds(25, 293, 286, 136);
		contentPane.add(resultTextArea);
	}
}
