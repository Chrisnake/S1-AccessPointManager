import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class RemoveProfile extends JFrame {

	public static RemoveProfile frame = new RemoveProfile();
	protected driver sqlDriver = new driver();

	/**
	 * @param frame: The frame for the RemoveProfile class that makes it accessible to other objects
	 * @param sqlDriver: driver class containing SQL back end logic
	 */

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try { RemoveProfile frame = new RemoveProfile(); frame.setVisible(true);} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}

	public RemoveProfile() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * JPanel components
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 450, 38);
		contentPane.add(panel);
		
		/**
		 * JLabel and JTextField components
		 */
		
		JLabel lblRemoveProfile = new JLabel("Remove Profile");
		lblRemoveProfile.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblRemoveProfile); 
		lblRemoveProfile.setForeground(new Color(255, 255, 255));
		lblRemoveProfile.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		
		JLabel lblAreYouSure = new JLabel("To confirm please type in your ID");
		lblAreYouSure.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 13));
		lblAreYouSure.setBounds(129, 93, 285, 16);
		contentPane.add(lblAreYouSure);
		
		JLabel lblNote = new JLabel("Note: Only remove the profile if you have officially left University.");
		lblNote.setForeground(Color.RED);
		lblNote.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 9));
		lblNote.setBounds(99, 121, 263, 16);
		contentPane.add(lblNote);
		
		JTextField removeField = new JTextField();
		removeField.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		removeField.setBounds(162, 149, 130, 26);
		contentPane.add(removeField);
		removeField.setColumns(10);
		
		JLabel lblerrorID = new JLabel("*You typed the Student ID incorrectly, please try again.");
		lblerrorID.setVisible(false);
		lblerrorID.setForeground(Color.RED);
		lblerrorID.setBounds(129, 224, 210, 16);
		lblerrorID.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 9));
		contentPane.add(lblerrorID);
		/**
		 * JButton components
		 */
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(183, 187, 86, 29);
		removeButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		contentPane.add(removeButton);
		removeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String removeProfile = removeField.getText();
				if(sqlDriver.duplicateID(removeProfile) && removeField.equals(StartUp.userID)) //If it is true, then that means that the ID exists in the database, then checks if the ID written is theirs.
				{
					sqlDriver.removeUser(removeProfile);
					System.out.println("The account has been officially removed from the database");
					Home.frame.setVisible(true);
					frame.dispose();
				}
				else //If the user has not typed in their ID, or incorrectly typed it.
				{
					lblerrorID.setVisible(true); Home.labelTimer(lblerrorID);
				}
			
			}
		});
		
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
	}
}
