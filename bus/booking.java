package bus;
/**
 * booking is a class which is used by administrator to view bus details and passengers details
 */
import java.sql.*;
public class booking {
     String date;
     int busno;
     
     /**
      * constructor to get details of customers who are traveling on a particular date
      * @param date1 -input date
      */
     booking(String date1)
     {
    	 this.date=date1;
    	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("select * from booking where date=?");
			stmt.setString(1, date);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		 
     }
     
     /**
      * constructor to get details of customer who are traveling on a particular bus
      * @param no -input busno
      */
     booking(int no)
     {
    	 this.busno=no;
    	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("select * from booking where busno=?");
			stmt.setInt(1, busno);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
     }
     
     /**
      * constructor that list the details of customer traveling on a particular bus and at particular
      * date
      * @param no -input busno
      * @param date1 -input date
      */
     booking(int no,String date1)
     {
    	 this.busno=no;
    	 this.date=date1;
    	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("select * from booking where busno=? and date=?");
			stmt.setInt(1, busno);
			stmt.setString(2, date);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
     }
}
