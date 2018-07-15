import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

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
	protected driver sqlDriver = new driver();
	protected static HashMap<String, String[]> hashMap = new HashMap<>();
	
	/**
	 * @param frame: The frame for the AccessBuilding class that makes it accessible to other objects
	 * @param sqlDriver: driver class containing SQL back end logic
	 * @param hashMap: The hashmap that links the department keys with their respective string array of allocated department buildings
	 */
	
	String[] arrayBuildings = new String[] {"Bishop Complex", "Faraday Hall", "Fleming Hall", "Gailbraith Hall", "Isambard Complex",
			 								"Mill Hall", "Lancaster Complex", "Chepstow Hall", "Clifton Hall","Saltash Hall", "Library",
			 								"Elliot Jaques", "Mary Seacole", "Eastern Gateway", "St Johns", "Halsbury", "The Lecture Centre",
			 								"Heinz Wolff", "Tower A", "Tower B", "Tower C", "Tower D" , "Joseph Lowe", 
			 								"Antonin Artuard", "Marie Jahoda", "Gaskell", "Wilfred Brown", "Howell", "John Crank"};
	
	static String[] C1 = new String[] {"St Johns”, “Halsbury", "Wilfred Brown"}; //CATEGORY 1: Computer Science	
	static String[] C2 = new String[] {"Tower A", "Tower B", "Tower C", "Tower D", "Howell", "Joseph Lowe", "Gaskell"}; //CATEGORY 2: Engineering, Digital Design, Communications/Media Studies, Games Design	
	static String[] C3 = new String[] {"Heinz Wolff", "Howell", "Marie Jahoda"}; //CATEGORY 3: Biomedical Sciences			
	static String[] C4 = new String[] {"John Crank"}; //CATEGORY 4: Business/Accounting, Economics/Finance	
	static String[] C5 = new String[] {"Elliot Jaques", "Halsbury" }; //CATEGORY 5: Law 		
	static String[] C6 = new String[] {"Heinz Wolff"}; //CATEGORY 6: English, Education			
	static String[] C7 = new String[] {"John Crank", "Gaskell", "Halsbury"}; //CATEGORY 7: Maths
	static String[] C8 = new String[] {"Antonin Artuard"}; //CATEGORY 8: Music, Arts/Theatre			
	static String[] C9 = new String[] {"Marie Jahoda"};  //CATEGORY 9: Physiotherapy, Sports/Health Science:
	
	public static void main(String[] args) 
	{
		inithashMap();
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try { AccessBuilding frame = new AccessBuilding(); frame.setVisible(true);} 
				catch (Exception e) {e.printStackTrace();}
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
		
		JComboBox<String> Buildings = new JComboBox<>(arrayBuildings);
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
			
				if(sqlDriver.checkAccomodation("1605942", selectedBuilding)) //Check if the user is trying to access their accomodation
				{
					System.out.println("SUCCESS 1");
				}
				if(departmentglobalAccess(selectedBuilding)) //Check if the selected building is a 'global' building, thus allowed access to anyone in the University environment with an ID.
				{
					getTime();
					System.out.println("SUCCESS 2");
				}
				if(departmentlocalAccess("1605942", selectedBuilding)) //Check the users current department and see if their selected building has a link in the hashmap with that department.
				{
					getTime();
					System.out.println("SUCCESS 3");
				}
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
	
	protected boolean departmentglobalAccess(String selectedBuilding) //Global access means the whole university environment has access to the building.
	{
		boolean check = false;
		if(selectedBuilding.equals("Library") || selectedBuilding.equals("The Lecture Centre") || selectedBuilding.equals("Eastern Gateway"))
		{
			check = true;
		}
		
		return check;
	}
	
	protected boolean departmentlocalAccess(String userID, String selectedBuilding) //Uses a HashMap to return the values where the key is the department
	{
		boolean check = false;
		//1) GET THE USERS DEPARTMENT FROM THE DATABASE
		//2) RETURNS THE BUILDINGS THAT THE USER IS AVAILABLE TO DEPENDING ON THEIR DEPARTMENT
		//3) SEARCH THROUGH THE STRING ARRAY TO FIND THE BUILDING THAT THE USER REQUESTED TO ACCESS
		//4) RETURNS TRUE IF THERE IS A MATCH IN STRINGS, FALSE IF THERE IS NOT.
		
		String userDepartment = sqlDriver.getDepartment(userID); //this returns the department that the user has on the database.
		System.out.println("The department of the user is " + userDepartment);

		for(String s : hashMap.get(userDepartment))
		{
	        if(s.equals(selectedBuilding))
	        {
	        	check = true;
	        	break;
	        }
	    }
		return check;
	}
	
	protected static void inithashMap() //Initialising the hashMap for department building search.
	{
		hashMap.put("Computer Science", C1);
		hashMap.put("Engineering", C2); hashMap.put("Digital Design", C2); hashMap.put("Communications/Media Studies", C2); hashMap.put("Games Design", C2);
		hashMap.put("Biomedical Science", C3);
		hashMap.put("Business/Accounting", C4); hashMap.put("Economics/Finance", C4);
		hashMap.put("Law", C5);
		hashMap.put("English", C6); hashMap.put("Education", C6);
		hashMap.put("Maths", C7);
		hashMap.put("Music", C8); hashMap.put("Arts/Theatre", C8);
		hashMap.put("Physiotherapy", C9); hashMap.put("Sports/Health Science", C9);
	}
		
}
