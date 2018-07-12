
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Register extends JFrame {

	private JPanel contentPane;
	public static Register frame = new Register();
	
	/**
	 * @param frame: The frame for the register class that makes it accessible to other objects
	 * String arrays containing information for combobox fields
	 */
	
	String[] arrayuserType = new String[] 
	{"Student", "Lecturer", "Cleaner"};
	
	String[] arrayDepartment = new String[] 
	{"Engineering", "Biomedical Sciences", "Business/Accounting", "Communications/Media Studies", 
	 "Computer Science", "English", "Economics/Finance", "Education", "Games Design", "Law", 
	 "Mathematics", "Music", "Psyiotheraphy", "Sports/Health Science", "Arts/Theatre"};
	
	String[] arrayAccomodation = new String[] 
	{"Bishop Complex", "Faraday Hall", "Fleming Hall", "Gailbraith Hall", "Isambard Complex",
	 "Mill Hall", "Lancaster Complex", "Chepstow Hall", "Clifton Hall","Saltash Hall"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * JPanel componenets
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 208, 278);
		contentPane.add(panel);
		
		/*
		 *  JTextField componenets
		 */
		
		JTextField userPassword = new JTextField();
		userPassword.setBounds(302, 101, 130, 26);
		contentPane.add(userPassword);
		userPassword.setColumns(10);
		
		JTextField userID = new JTextField();
		userID.setBounds(302, 76, 130, 26);
		contentPane.add(userID);
		userID.setColumns(10);
		
		/*
		 * JComboBox components
		 */
		
		JComboBox<String> userDepartment = new JComboBox<>(arrayDepartment);
		String selectedDepartment = (String) userDepartment.getSelectedItem();
		userDepartment.setBounds(302, 180, 130, 27);
		contentPane.add(userDepartment);
		
		JComboBox<String> userAccomodation = new JComboBox<>(arrayAccomodation);
		String selectedAccomodation = (String) userAccomodation.getSelectedItem();
		userAccomodation.setBounds(302, 154, 130, 27);
		contentPane.add(userAccomodation);
		
		JComboBox <String> userType = new JComboBox<>(arrayuserType);
		String selectedType= (String) userType.getSelectedItem();
		userType.setBounds(302, 127, 130, 27);
		contentPane.add(userType);
		
		/*
		 * JLabel componenets
		 */
		
		JLabel lblUniversityId = new JLabel("University ID");
		lblUniversityId.setBounds(220, 81, 70, 16);
		lblUniversityId.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblUniversityId);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(220, 106, 75, 16);
		lblNewLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(220, 131, 61, 16);
		lblPosition.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblPosition);
		
		JLabel lblAccomodation = new JLabel("Accomodation");
		lblAccomodation.setBounds(220, 158, 89, 16);
		lblAccomodation.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblAccomodation);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(220, 184, 89, 16);
		lblDepartment.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblDepartment);
		
		/*
		 * JButton components
		 */
		
		JButton backButton = new JButton("Next");
		backButton.setBounds(371, 231, 61, 29);
		backButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//TODO: After the user clicks next check the database for the pre-existing IDs in the system
				//TODO: After checking there are no pre-existing IDs, store the information in the mySQL database
				Home.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton nextButton = new JButton("Back");
		nextButton.setBounds(229, 231, 61, 29);
		nextButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(nextButton);
		nextButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StartUp back = new StartUp();
				back.frame.setVisible(true);
				frame.dispose();
			}
		});
	}
}
