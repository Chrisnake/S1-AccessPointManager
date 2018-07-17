import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class StartUp {

	public JFrame frame;
	public static String userID;
	protected driver sqlDriver = new driver();
	
	/**
	 * @author christianvillegas - student project 2018, rights reserved.
	 * @param frame: the frame for the class
	 * @param sqlDriver: driver class containing SQL back end logic
	 */
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{ 
					StartUp window = new StartUp();
					window.frame.setVisible(true);
				} catch (Exception e) { e.printStackTrace(); }
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
		 * JLabel components
		 */
		
		JLabel UserIDText = new JLabel("University ID");
		UserIDText.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		UserIDText.setBounds(220, 126, 75, 16);
		frame.getContentPane().add(UserIDText);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		lblPassword.setBounds(234, 154, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel errorLogIn = new JLabel("*Your log In details are incorrect, please try again.");
		errorLogIn.setVisible(false);
		errorLogIn.setForeground(Color.RED);
		errorLogIn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 9));
		errorLogIn.setBounds(240, 231, 200, 16);
		frame.getContentPane().add(errorLogIn);
		
		JLabel lblUniversityAccessPoint = new JLabel("University Access Point Manager");
		lblUniversityAccessPoint.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 14));
		lblUniversityAccessPoint.setBounds(224, 41, 206, 16);
		frame.getContentPane().add(lblUniversityAccessPoint);
		
		/**
		 * JTextField components
		 */
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(300, 120, 130, 26);
		usernameField.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(300, 148, 130, 26);
		password.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 8));
		frame.getContentPane().add(password);
		password.setColumns(10);
		
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
				String username = usernameField.getText();
				char[] charPassword = password.getPassword();
				String password = String.valueOf(charPassword);
				System.out.println(username + " " + password);
				if(sqlDriver.checkLogin(username, password)) //If true, then there is a login and password match
				{
					Home homepage = new Home();
					userID = username; //Save the username that is logged in, into a global variable to share around classes.
					homepage.setVisible(true);
					frame.dispose();
				}
				else //Thus if there is not a match, then display error JLabel
				{
					errorLogIn.setVisible(true);
				}
			}
		});
		
		JButton btnsignUp = new JButton("Sign Up");
		btnsignUp.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 10));
		btnsignUp.setBounds(364, 186, 66, 29);
		frame.getContentPane().add(btnsignUp);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setForeground(UIManager.getColor("Button.select"));
		panel.setBounds(0, 0, 208, 278);
		frame.getContentPane().add(panel);
		
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
