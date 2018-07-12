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

public class RemoveProfile extends JFrame {

	private JPanel contentPane;
	public static RemoveProfile frame = new RemoveProfile();
	
	/**
	 * @param frame: The frame for the RemoveProfile class that makes it accessible to other objects
	 * @param 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveProfile frame = new RemoveProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RemoveProfile() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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
		 * JLabel components
		 */
		
		JLabel lblRemoveProfile = new JLabel("Remove Profile");
		lblRemoveProfile.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblRemoveProfile); 
		lblRemoveProfile.setForeground(new Color(255, 255, 255));
		lblRemoveProfile.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		
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
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to remove this profile?");
		lblRemoveProfile.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		lblAreYouSure.setBounds(87, 116, 285, 16);
		contentPane.add(lblAreYouSure);
		
		JButton removeButton = new JButton("Yes, remove");
		removeButton.setBounds(167, 144, 117, 29);
		removeButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		contentPane.add(removeButton);
		
	}
}
