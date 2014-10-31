

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager
{
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	public static String Insert(Getsets sets) 
	{
	  
		String sql =  "INSERT INTO userinfo (fname,lname,username,password) VALUES (?,?,?,?)";
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sets.getFname());
			pstmt.setString(2, sets.getLname());
			pstmt.setString(4, sets.getUsername());
			pstmt.setString(5, sets.getPassword());
			pstmt.executeUpdate();
			ConnectionManager.getInstance().closeConnection();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "index";
		
	}
	
	
	public static String Authenticate(Getsets sets) 
	{   Statement stmt= null;
        int count =0;
		try
		{
			String msg;
			String str = "SELECT * FROM userinfo WHERE username= '"+sets.getUsername()+"' password= '"+sets.getPassword()+"' ";
			stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(str);
			 if(rs.next())
			 {
				 String un = rs.getString("username");
				 String pswd = rs.getString("password");
				 if(un.equals(sets.getUsername())&& pswd.equals(sets.getPassword()))
				 {	 
				 System.out.println("Login Suucessful");
				 msg  = "Hello" + sets.getUsername() +" Your Login is Successful";
				 }
				 
			 }
			 else
			 {  
				 msg  = "Hello" + sets.getUsername() +" Your Login is failed";
				 count++;
				 if(count>3)
				 {
					 
				 }	 
				 else
				 {
					 return "login1";
				 }
				 
				 
			 }
			 rs.close();
			 stmt.close();
		 } 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "index";
		
	}
	
}
