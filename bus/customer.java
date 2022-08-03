package bus;
/**
 * class that is used to get customer name,busno and date of travel and book the ticket if the ticket is
 * available.If the ticket is not available we print that the bus is fill.We should also allow the customer 
 * to delete the ticket if they opt for it.We also allow customer to change their name and date of travel if
 * they opt for it.
 */
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class customer {
	String name;
	int busno;
	Date date;    //Date is a datatype present in util package.
	String inputdate;
	int id;
	int i,j;
	/**
	 * constructor for inserting a customer record in database and book the ticket if ticket is available.
	 */
	customer()
	{
		try {
			/*
			 * registering the driver
			 */
			Class.forName("com.mysql.jdbc.Driver"); 
			/*
			 * Establishing the connection
			 */
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			System.out.println("Enter your name :");
			Scanner s=new Scanner(System.in);
			name=s.next();
			System.out.println("Enter the bus no :");
			busno=s.nextInt();
			System.out.println("Enter the date of travel in dd-mm-yyyy format :");
			inputdate=s.next();
			System.out.println("Enter your id :");
			id=s.nextInt();
			try {
				/**
				 * SimpleDateFormat is a inbuilt method in java that converts string into data
				 */
			      date=new SimpleDateFormat("dd-MM-yyyy").parse(inputdate);
		      }
  	       catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
			/*
			 * callable statement is used to execute pl-sql queries
			 * the procedure is
			 * create or replace procedure(IN bus INT,IN date VARCHAR(10),OUT i INT,OUT j INT)
			 * begin
			 * select count(*) to i from booking where busno=bus and date=date;
			 * select capacity to j from buses where busno=bus;
			 * end // 
			 */
			CallableStatement stmt1=con.prepareCall("{call a1(?,?,?,?)}");
			stmt1.setInt(1, busno);
			stmt1.setString(2, inputdate);
			/*
			 * registering the out parameter
			 */
			stmt1.registerOutParameter(3,java.sql.Types.INTEGER);
			stmt1.registerOutParameter(4, java.sql.Types.INTEGER);
			stmt1.executeUpdate();
			i=stmt1.getInt(3);
			j=stmt1.getInt(4);
			if(i<j)         //checking for avaibility of seat(booked<capacity)
			{
			con.close();
			Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con2.prepareStatement("insert into booking values(?,?,?,?)");
  	        stmt.setString(1,name);
  	        stmt.setInt(2,busno);
  	        stmt.setString(3, inputdate);
  	        stmt.setInt(4, id);
  	        stmt.executeUpdate();
  	        con2.close();
  	        System.out.println("Ticket booked succesfully...");
			}
			else
				System.out.println("Sorry!! Ticket is full...");
  	        } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
 	    
	}
	
	/**
	 * constructor for deleting a customer booking record from database 
	 * @param name -name of customer
	 * @param busno -busno
	 * @param date -date of travel
	 * @param date1  -date of travel in string format
	 * @param id -customer id
	 */
	customer(String name,int busno,Date date,String date1,int id)
	{
		this.name=name;
		this.busno=busno;
		this.date=date;
		this.id=id;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("delete from booking where name=? and busno=? and date=? and id=?");
			stmt.setString(1, name);
			stmt.setInt(2, busno);
			stmt.setString(3, date1);
			stmt.setInt(4, id);
			stmt.executeUpdate();
			System.out.println("Your ticket is deleted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * constructor for updating customer name in database.
	 * @param name -old name of customer
	 * @param busno -busno
	 * @param newname -updated name of customer
	 * @param date -date of travel
	 * @param id -customer id
	 */
	customer(String name,int busno,String newname,Date date,int id)
	{
		this.name=name;
		this.busno=busno;
		this.date=date;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("update booking set name=? where id=?");
			stmt.setString(1, newname);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Your name has been changed...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * constructor for updating the date of travel in the database
	 * @param name -name of customer
	 * @param busno -busno
	 * @param date -old date of travel
	 * @param id -customer id
	 * @param newdate -new date of travel
	 */
	customer(String name,int busno,Date date,int id,String newdate)
	{
		this.name=name;
		this.busno=busno;
		this.date=date;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("update booking set date=? where id=?");
			stmt.setString(1, newdate);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Your date of travel has been changed...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * constructor for updating the busno in the database
	 * @param name -name of customer
	 * @param busno -old busno
	 * @param date -date of travel
	 * @param id -customer id
	 * @param newbusno -new busno
	 */
	customer(String name,int busno,Date date,int id,int newbusno)
	{
		this.name=name;
		this.busno=busno;
		this.date=date;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus","root","root123");
			PreparedStatement stmt=con.prepareStatement("update booking set busno=? where id=?");
			stmt.setInt(1, newbusno);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Your busno has been changed...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
