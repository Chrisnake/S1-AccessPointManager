// To compile: javac JDBCSelect.java
// To run: java -cp .:mysqljdbc.jar JDBCSelect
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
	
	public boolean duplicateID(JTextField userID) //checks the database for a duplicate userID from the userID column.
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
				
					String check = rs.getString(1);
					String checkuserID = userID.getText();
					if(check.equals(checkuserID))
					{
						checkBoolean = true;
						System.out.println("There is a duplicate ID!");
						break;
					}
			}
			rs.close();
		} catch (Exception e1) {System.out.println(e1);}
		 
		return checkBoolean;
	}
}


