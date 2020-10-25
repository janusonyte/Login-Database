package application;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * CRUD
 * Create 
 * Read/Retrieve 
 * Update 
 * Delete
 * 
 * */
public class Model 
{
	 Connection con;
	 Statement stmt;
	 PreparedStatement pstmt;
	 ResultSet rset;

	public Model()
	{

	}

	private void connectdb()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb?useTimezone=true&serverTimezone=UTC", "root", "root");
			System.out.println("Connection successful");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Connection Unsuccessful: Class Not Found");
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("Connection Unsuccessful: SQL");
			e.printStackTrace();
		}
	}

	private void insertUser(String fname, String lname, String uname, String pword)
	{
		String sql = "INSERT INTO users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";// second version that works
		int userID = 0;

		try 
		{
			// Wednesday class version
						pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						pstmt.setString (1, fname);
						pstmt.setString (2, lname);
						pstmt.setString  (3, uname);
						pstmt.setString(4, pword);
						
						int rowAffected = pstmt.executeUpdate();
						if(rowAffected == 1)
						{
							rset = pstmt.getGeneratedKeys();
							if(rset.next())
							{
							userID = rset.getInt(1);
							}
			
						}

			System.out.println("User added to database");
		}
		catch(SQLException e)
		{
			System.out.println("Error Executing Statement");
			e.printStackTrace();
		}
				finally
				{
					try 
					{
						if(rset != null)
						{
							rset.close();
						}
					}
					catch(SQLException e)
					{
						System.out.println("Unable to close Result Set");
						e.printStackTrace();
					}
				}

	}
	//check if user is in database
	private boolean checkUserInDb(String uname, String pword)
	{
		System.out.println(uname + pword);
		String sql = "SELECT username, password FROM users WHERE username LIKE ? AND password LIKE ?";
//		int userID = 0;
		boolean userInDb = false;
		
		try 
		{
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			
			rset = pstmt.executeQuery();
			if(rset.next())
			{
//				userID = rset.getInt(1);
				System.out.println("User in DB");
				userInDb = true;
				return userInDb;
			}
			System.out.println("User not in DB");
			
			return false;

					
		}
		catch(SQLException e)
		{
			System.out.println("User Check Unsuccessful");
			e.printStackTrace();
			
		}
		return userInDb;
	}
	
	
	//class methods
	public void setConnection()
	{
		this.connectdb();
	}

	public void setUser(String fname, String lname, String uname, String pword)
	{
		this.insertUser(fname, lname, uname, pword);
	}
	
	//Read/Record
	public boolean checkUser(String uname, String pword)
	{
		boolean userInDb = this.checkUserInDb(uname, pword);
		return userInDb;
		
	}
	
	//get user info
	private ArrayList<String> getUserInfo(String uname, String pword)
	{
		ArrayList<String> ret = new ArrayList<>();
		
		String sql = "SELECT ID, firstname, lastname, username, password FROM users WHERE username LIKE ? AND password LIKE ?";
		
		try 
		{
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			
			rset = pstmt.executeQuery();
			if(rset.next())
			{
//				userID = rset.getInt(1);
				System.out.println("User returned successfully");
				int ID = rset.getInt("ID");
				String firstName = rset.getString("firstname");
				String lastName = rset.getString("lastname");
				String userName = rset.getString("username");
				String password = rset.getString("password");
				ret.add(firstName);
				ret.add(lastName);
				ret.add(userName);
				ret.add(password);
				return ret;
			}
					
		}
		catch(SQLException e)
		{
			System.out.println("Cannot return user");
			e.printStackTrace();
			
		}
		return ret;
	}
	
	public ArrayList<String> getUser(String uname, String pword)
	{
		return this.getUserInfo(uname, pword);
	}
	
	//update user details
	private void updateUserDetails(String uname, String pword, String newFirstName, String newLastName, String newUserName, String newPassword)
	{
		System.out.println(uname + pword);
		String sql = "SELECT ID FROM users WHERE username LIKE ? AND password LIKE ?";
		try 
		{
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);

			rset = pstmt.executeQuery();
			
			if (rset.next()) 
			{
				int id = rset.getInt("ID");
				String sqlUpdate = "UPDATE users set firstname = ?, lastname = ?, username = ?, password = ? WHERE ID = ?";

				pstmt = con.prepareStatement(sqlUpdate);

				pstmt.setString(1, newFirstName);
				pstmt.setString(2, newLastName);
				pstmt.setString(3, newUserName);
				pstmt.setString(4, newPassword);
				pstmt.setInt(5, id);
				pstmt.executeUpdate();

			}
		}
		catch(SQLException e)
		{
			System.out.println("Cannot update user");
			e.printStackTrace();
			
		}
	}
	
	public void updateDetails(String uname, String pword, String newFirstName, String newLastName, String newUserName, String newPassword)
	{
		this.updateUserDetails(uname, pword, newFirstName, newLastName, newUserName, newPassword);
	}
	
	
	//delete profile
	
	private void deleteUserProfile(String uname, String pword)
	{
		System.out.println(uname + pword);
		String sql = "SELECT ID FROM users WHERE username LIKE ? AND password LIKE ?";
		try 
		{
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);

			rset = pstmt.executeQuery();
			
			if (rset.next()) 
			{
				int id = rset.getInt("ID");
				String sqlDelete = "DELETE FROM users WHERE ID = ?";
				pstmt = con.prepareStatement(sqlDelete);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				System.out.println("Profile deleted successfully");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Cannot delete user");
			e.printStackTrace();
			
		}
	}
	
	public void deleteProfile(String uname, String pword)
	{
		this.deleteUserProfile(uname, pword);
	}
	
	
}//end of class

