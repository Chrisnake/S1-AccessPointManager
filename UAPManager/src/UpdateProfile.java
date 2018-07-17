import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	public static UpdateProfile frame = new UpdateProfile();
	protected Home home = new Home();
	protected driver sqlDriver = new driver();

	/**
	 * @param frame: The frame for the UpdateProfile class that makes it accessible to other objects
	 * @param Home: Gain access to the home frame to change frame when user has successfully updated profile
	 */
	
	private String[] arrayDepartment = new String[] 
			{"Engineering", "Biomedical Sciences", "Business/Accounting", "Communications/Media Studies", 
			 "Computer Science", "English", "Economics/Finance", "Education", "Games Design", "Law", 
	   		 "Mathematics", "Music", "Psyiotheraphy", "Sports/Health Science", "Arts/Theatre"};
	
	private String[] arrayAccomodation = new String[] 
			{"Bishop Complex", "Faraday Hall", "Fleming Hall", "Gailbraith Hall", "Isambard Complex",
			 "Mill Hall", "Lancaster Complex", "Chepstow Hall", "Clifton Hall","Saltash Hall", "None"};
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {UpdateProfile frame = new UpdateProfile();frame.setVisible(true);} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}

	public UpdateProfile() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * JPanel and JLabel components
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 450, 38);
		contentPane.add(panel);

		JLabel lblUpdateProfile2 = new JLabel("Update the fields below for the Students current course and accomodation");
		lblUpdateProfile2.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		lblUpdateProfile2.setBounds(23, 90, 441, 16);
		contentPane.add(lblUpdateProfile2);
		
		JLabel lblAccomodation = new JLabel("Accomodation");
		lblAccomodation.setBounds(87, 128, 89, 16);
		lblAccomodation.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblAccomodation);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(87, 160, 89, 16);
		lblDepartment.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lblDepartment);
		
		JLabel lbluserID = new JLabel("Student ID");
		lbluserID.setBounds(87, 193, 89, 16);
		lbluserID.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		contentPane.add(lbluserID);
		
		JLabel lblerrorID = new JLabel("*You typed the Student ID incorrectly, please try again.");
		lblerrorID.setVisible(false);
		lblerrorID.setForeground(Color.RED);
		lblerrorID.setBounds(129, 224, 210, 16);
		lblerrorID.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 9));
		contentPane.add(lblerrorID);
		
		JLabel lblUpdateProfile = new JLabel("Update Profile");
		lblUpdateProfile.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblUpdateProfile); 
		lblUpdateProfile.setForeground(new Color(255, 255, 255));
		lblUpdateProfile.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		
		/**
		 * JComboBox and JTextField components
		 */
		
		JComboBox<String> userAccomodation = new JComboBox<>(arrayAccomodation);
		userAccomodation.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		userAccomodation.setBounds(169, 124, 198, 27);
		contentPane.add(userAccomodation);
		
		JComboBox<String> userDepartment = new JComboBox<>(arrayDepartment);
		userDepartment.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		userDepartment.setBounds(169, 156, 198, 27);
		contentPane.add(userDepartment);
		
		JTextField userIDText = new JTextField();
		userIDText.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		userIDText.setBounds(169, 188, 198, 26);
		contentPane.add(userIDText);
	
		/**
		 * JButton components
		 */
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(20, 232, 61, 29);
		backButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Home.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(371, 231, 61, 29);
		nextButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		contentPane.add(nextButton);
		nextButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String selectedDepartment = (String) userDepartment.getSelectedItem();
				String selectedAccomodation = (String) userAccomodation.getSelectedItem();
				String selectedUserID = userIDText.getText();
				
				if(sqlDriver.duplicateID(selectedUserID) && selectedUserID.equals(StartUp.userID)) //If it is true, then that means that the ID exists in the database, then checks if the ID written is theirs.
				{
					sqlDriver.updateProfile(selectedUserID, selectedAccomodation, selectedDepartment);
					Home.frame.setVisible(true);
					frame.dispose();
				}
				else 
				{
					lblerrorID.setVisible(true); Home.labelTimer(lblerrorID);
				}
			}
		});
		
	}

}
