package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	//Database Driver
	private static final String driver = "com.mysql.jdbc.Driver";
	//url connected to database
	private static final String url = "jdbc:mysql://localhost:3306/mobile_store";
	//Database username
	private static final String username = "root";
	//Database password
	private static final String password = "";
	
	private static Connection conn=null;
	
	//static code block to load drive
	static{
		try{
			Class.forName(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//return database connection object
	public static Connection getConnection() throws Exception
	{
		if(conn==null){
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args){
		try{
			Connection conn=DBHelper.getConnection();
			if(conn!=null){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
