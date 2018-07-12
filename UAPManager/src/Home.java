
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;
	static Home frame = new Home();
	
	/**
	 * @param frame: The frame for the home class that makes it accessible to other objects
	 * @param 
	 */
	
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

	public Home() 
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
		
		JLabel homeLabel = 	new JLabel("UAPM Home");
		homeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(homeLabel); 
		homeLabel.setForeground(new Color(255, 255, 255));
		homeLabel.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		
		/**
		 * JButton components
		 */
		
		JButton btnAccessBuilding = new JButton("Access Building");
		btnAccessBuilding.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 12));
		btnAccessBuilding.setBounds(166, 92, 117, 29);
		contentPane.add(btnAccessBuilding);
		btnAccessBuilding.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AccessBuilding.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton btnUpdateDetails = new JButton("Update Profile");
		btnUpdateDetails.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 12));
		btnUpdateDetails.setBounds(166, 133, 117, 29);
		contentPane.add(btnUpdateDetails);
		btnUpdateDetails.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				UpdateProfile.frame.setVisible(true);
				frame.dispose();
			}
		});
		
		JButton btnRemoveProfile = new JButton("Remove Profile");
		btnRemoveProfile.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 12));
		btnRemoveProfile.setBounds(166, 174, 117, 29);
		contentPane.add(btnRemoveProfile);
		btnRemoveProfile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				RemoveProfile.frame.setVisible(true);
				frame.dispose();
			}
		});
	}
}
