// To compile: javac JDBCSelect.java
// To run: java -cp .:mysqljdbc.jar JDBCSelect
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;

	public class driver {
	
	protected ResultSet rs;
	protected static String url = "jdbc:mysql://localhost:3306/UAPManager";
	
	public static void main(String args[]) 
	{
		try 
		{
			ResultSet rs;
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			Statement select = con.createStatement();

			rs = select.executeQuery("SELECT * FROM users");
			while (rs.next()) 
			{
				System.out.println(rs.getString(1)); //gets the first column's rows.
			}

			rs.close();
		} catch (Exception e) {System.out.println(e);}  
	}
	
	public boolean duplicateID(JTextField userID) //Checks the database for a duplicate userID from the userID column.
	{
		boolean checkBoolean = false;
		try 
		{
			ResultSet rs;
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			Statement select = con.createStatement();

			rs = select.executeQuery("SELECT userID FROM users");
			while (rs.next()) 
			{
				for(int i = 1; i < Register.getarraySize(); i++)
				{
					System.out.println(Register.getarraySize() + " is the size of the users array");
					String check = rs.getString(i);
					String checkuserID = userID.getText();
					if(check.equals(checkuserID))
					{
						checkBoolean = true;
						System.out.println("There is a duplicate ID!");
						break;
					}
				}
			}
			rs.close();
		} catch (Exception e1) {System.out.println(e1);}
		 
		return checkBoolean;
	}
	
	public void addAccount(User user) //Adds the account to the database from the registration page
	{
		try 
		{
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			String query = "INSERT INTO users (userID, password, userType, accomodation, department)" + " values (?, ?, ?, ?, ?)";
			
			//Create the preparted statement for the values to be inputted
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, user.getuserID());
		    preparedStmt.setString (2, user.getPassword());
		    preparedStmt.setString (3, user.getUserType());
		    preparedStmt.setString(4, user.getAccomodation());
		    preparedStmt.setString (5, user.getDepartment());
		    preparedStmt.execute();
		    
		} catch (Exception e1) {System.out.println(e1);}
	}
}


