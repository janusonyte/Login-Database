package application;
import java.util.ArrayList;
import java.util.regex.*;

public class Controller 
{
	private boolean valid = false;
	private Model m;
	
	public Controller()
	{
		m = new Model();
		//blank constructor
	}
	
	
	private void sanitiseInput(String fname, String lname, String uname, String pword)

	{
		System.out.println(fname + lname + uname + pword);
		
		String regex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String regexOne = "^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String regexTwo = "^(?=.*\\d).{4,8}$";
		boolean a = Pattern.matches(regex, fname);
		boolean b = Pattern.matches(regex, lname);
		boolean c = Pattern.matches(regexOne, uname);
		boolean d = Pattern.matches(regexTwo, pword);
		
		if(a && b && c && d == true)
		{
			this.valid = true;
		}
		else 
		{
			this.valid = false;
			System.out.println("Please check if fields are filled correctly");
		}
		
		//password needs to be between 4-8 digits long and include 1 number
	}
	
	
	
	public void setInput(String fname, String lname, String uname, String pword)
	{
		this.sanitiseInput(fname, lname, uname, pword);
	}
	
	public void setUser(String fname, String lname, String uname, String pword)
	{
		m.setConnection();
		m.setUser(fname, lname, uname, pword);
	}
	
	public boolean checkUser(String uname, String pword)
	{
		m.setConnection();
		boolean userInDb = m.checkUser(uname, pword);
		return userInDb;
	}
	
	public boolean getValid()
	{
		
		return this.valid;
		
	}
	
	public ArrayList<String> getUser(String uname, String pword)
	{
		return m.getUser(uname, pword);
	}
	
	public void updateDetails(String uname, String pword, String newFirstName, String newLastName, String newUserName, String newPassword)
	{
		m.updateDetails(uname, pword, newFirstName, newLastName, newUserName, newPassword);
	}
	
	public void deleteProfile(String uname, String pword)
	{
		m.deleteProfile(uname, pword);
	}
	
}//end of class
