import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StartUp {

	public JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * @param frame: the frame for the class
	 * @param usernameField: the username user input
	 * @param passwordFied: the password user input
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUp window = new StartUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartUp() 
	{
		initialize();
	}

	public void initialize() 
	{	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * JPanel componenets
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 208, 278);
		frame.getContentPane().add(panel);
		
		/**
		 * JLabel components
		 */
		
		JLabel UserIDText = new JLabel("UniversityID");
		UserIDText.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		UserIDText.setBounds(220, 126, 75, 16);
		frame.getContentPane().add(UserIDText);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		lblPassword.setBounds(234, 154, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblUniversityAccessPoint = new JLabel("University Access Point Manager");
		lblUniversityAccessPoint.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 14));
		lblUniversityAccessPoint.setBounds(224, 41, 206, 16);
		frame.getContentPane().add(lblUniversityAccessPoint);
		
		/**
		 * JTextField components
		 */
		
		usernameField = new JTextField();
		usernameField.setBounds(300, 120, 130, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(300, 148, 130, 26);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		/**
		 * JButton components
		 */
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 10));
		btnLogIn.setBounds(300, 186, 66, 29);
		frame.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//TODO: Check if there are no errors in the username and password they input from the dateabase
			}
		});
		
		JButton btnsignUp = new JButton("Sign Up");
		btnsignUp.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 10));
		btnsignUp.setBounds(364, 186, 66, 29);
		frame.getContentPane().add(btnsignUp);
		btnsignUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Register newUser = new Register(); //Open the register class frame.
				newUser.setVisible(true);
				frame.dispose(); 
			}
		});
	}
}
