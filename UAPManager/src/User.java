
public class User {

	private String userID;
    private String password;
    private String userType;
    private String accomodation;
    private String department;
    
    User(String ID, String pass, String type, String accom, String depmnt) //Constructor for the instance of a User.
    {
    	userID = ID;
    	password = pass;
    	userType = type;
    	accomodation = accom;
    	department = depmnt;
    }
    
    public String getuserID()
    {
    	return(userID);
    }
    
    public String getPassword()
    {
    	return(password);
    }
    
    public String getUserType()
    {
    	return(userType);
    }
    
    public String getAccomodation()
    {
    	return(accomodation);
    }
    
    public String getDepartment()
    {
    	return(department);
    }
    
    public void settuserID(String newID)
    {
    	userID = newID;
    }
    
    public void setPassword(String newPassword)
    {
    	password = newPassword;
    }
    
    public void setUserType(String newType)
    {
    	userType = newType;
    }
    
    public void setAccomodation(String newAccom)
    {
    	accomodation = newAccom;
    }
    
    public void setDepartment(String newDepartment)
    {
    	department = newDepartment;
    }

}
