import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccessBuilding extends JFrame {

	private JPanel contentPane;
	public static AccessBuilding frame = new AccessBuilding();
	/**
	 * @param frame: The frame for the AccessBuilding class that makes it accessible to other objects
	 * @param 
	 */
	
	String[] arrayBuildings = new String[] 
			{"Bishop Complex", "Faraday Hall", "Fleming Hall", "Gailbraith Hall", "Isambard Complex",
			 "Mill Hall", "Lancaster Complex", "Chepstow Hall", "Clifton Hall","Saltash Hall", "Library",
			 "Elliot Jaques", "Mary Seacole", "Eastern Gateway", "St Johns", "Halsbury", "The lecture centre",
			 "The Bannerman Center", "Heinz Wolff", "Tower A", "Tower B", "Tower C", "Tower D" , "Joseph Lowe", 
			 "Antonin Artuard", "Marie Jahoda", "Gaskell"};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessBuilding frame = new AccessBuilding();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AccessBuilding() 
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
		
		JLabel lblBuildingAccess = 	new JLabel("Building Access");
		lblBuildingAccess.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblBuildingAccess); 
		lblBuildingAccess.setForeground(new Color(255, 255, 255));
		lblBuildingAccess.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		
		JLabel lblSwipeYourCard = new JLabel("Swipe your card on the building reader to review access");
		lblSwipeYourCard.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 13));
		lblSwipeYourCard.setBounds(80, 99, 323, 16);
		contentPane.add(lblSwipeYourCard);
		
		/**
		 * JComboBox component
		 */
		
		JComboBox<String> Buildings = new JComboBox<>();
		for(String hey : arrayBuildings)
		{
			Buildings.addItem(hey);
		}
		Buildings.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		Buildings.setBounds(90, 127, 239, 18);
		contentPane.add(Buildings);
		
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
		
		JButton scanButton = new JButton("Scan");
		scanButton.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 8));
		scanButton.setBounds(325, 122, 61, 29);
		contentPane.add(scanButton);
		scanButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String selectedBuilding = (String) Buildings.getSelectedItem(); //Gets the selected building from the combobox
				getTime();
				System.out.println(selectedBuilding);
			}
		});
	}
	
	protected SimpleDateFormat getTime() //This method returns the current time to check whether or not the building is accessible.
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()) );
        return sdf;
	}

}
