package mainsystem;
import java.sql.*;
public class DBController {

	private static Connection conn;
	
	private DBController(){}
	
	public static Connection getConnection()
	{
		try
		{
			if(conn==null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/softhoops","root","");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}