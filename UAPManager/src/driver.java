import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public boolean duplicateID (String userID) //Checks the database for a duplicate userID from the userID column.
	{
		boolean checkBoolean = false;
		try 
		{
			ResultSet rs;
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			Statement select = con.createStatement();

			rs = select.executeQuery("SELECT * FROM users where userID = '" + userID + "' ");
			while (rs.next()) 
			{
				checkBoolean = true;
			}
			
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
		    preparedStmt.setString (4, user.getAccomodation());
		    preparedStmt.setString (5, user.getDepartment());
		    preparedStmt.execute();
		    
		} catch (Exception e1) {System.out.println(e1);}
	}
	
	public boolean checkLogin(String userID, String userPassword) //Checks the database for a match in the login and password from the user input
	{
		boolean checkBoolean = false;
		try 
		{
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			String query = "SELECT * FROM users WHERE userID = '" + userID + "' AND password = '" + userPassword + "' ";
			PreparedStatement ps = con.prepareStatement(query);
	        ResultSet results = ps.executeQuery(query); //where ps is Object of PreparedStatement

	        if(results.next()) //If one result comes from the resultsset, then that means there is a username and password in the database with the match.
	        {
	        	System.out.println(results.getString(1) + " Is the match on the database");
	        	checkBoolean = true;
	        } 
	        results.close();
		} catch (Exception e1) {System.out.println(e1);}
		
		return checkBoolean;
	}
	
	public void removeUser(String usertoRemove) //Removes the profile 
	{
		try 
		{
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			String query = "DELETE FROM users WHERE userID = '" + usertoRemove + "'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate(); 
		} catch (Exception e1) {System.out.println(e1);}
	}
	
	public void updateProfile(String userID, String newAccom, String newDepartment)
	{
		try 
		{
			Connection con = DriverManager.getConnection(url,"root","Simpson1723");
			String query = "UPDATE users SET accomodation = '" + newAccom + "' , department = '" + newDepartment + "' WHERE userID = '" + userID + "' ";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Profile successfully updated");
			ps.executeUpdate(); 
		} catch (Exception e1) {System.out.println(e1);}
		
	}
}


