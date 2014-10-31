

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager
{
	private Connection conn = null;
	private static ConnectionManager instance =null;
	

	public static ConnectionManager getInstance()
	 {
		 if(instance ==null)
		 {
			 instance = new ConnectionManager();
		 }
		 
		 return instance;
	 }
	
	 private boolean openConnection()
	 {
		 try
		 {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+ "databaseName=loginInfo;user=sa;password=akshu");
			 System.out.println("Connection Successful"); 
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 } 
		 catch (ClassNotFoundException e) 
		 {
			
			e.printStackTrace();
		 }
		 return true;
	 }
	 
	 public Connection getConnection()
	 {
		 if(conn == null)
		 	{
			 	if(openConnection())
			 	{
			 		System.out.println("Connection Opened");
			 		return conn;
			 	}
			 	else
			 	{
			 		return null;
			 	}
		 }
		 return conn;
	 }
	public void closeConnection()
	{
		System.out.println("Closing Connection");
		try 
		{
			conn.close();
    	} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}	
	}

	}


