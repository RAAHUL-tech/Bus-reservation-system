package bus;
/**
 * Class that contains the information of the buses like busno, it has ac or not,its capacity and its route of 
 * travel.
 */
import java.sql.*;        
import java.sql.DriverManager;
import java.sql.SQLException;

public class businfo {

	private int busno;
	private int ac;         //ac=1 and non-ac=0
	private int capacity;
	private String from;    //source
	private String to;      //destination
	/**
	 * businfo is a constructor which uses the mysql database to get information about the buses.
	 */
	businfo()
	{
	   
 	   try {
 		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from buses");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		con.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}  
}
