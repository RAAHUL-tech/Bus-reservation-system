package bus;

/**
 * @author Raahul krishna
 * Date of start of project : 28-07-2022
 * Date of completion of project : 03-08-2022
 * Date last modified/updated : 03-08-2022
 * 
 * Topic of project : Bus reservation system
 * 
 * Technologies used : Java,JDBC(Java Database Connectivity),My-SQL,Maria database
 * 
 *   To main motto of this project is to develop a console based bus reservation system which books the ticket
 *   for customer by getting their name ,their date of travel and their id.
 *   
 *   We also allow customers to delete their tickets and update their name or date of travel or 
 *   busno .(If in case of any dispensary)
 *   
 *   ADMINISTRATIVE PREVILAGES:
 *      We allow only actual(true) admins to view the bus list and customer list. We verify 
 *      this by cross-checking their admin-ids.
 *      
 *      They can also view the customer list on a specified bus or specified date or both.
 *      
 * I have also used a fruitful of try-catch to avoid errors and if occurred we handle them correctly.
 */
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws Exception {   //args is a unused command line argument
		int admid;
		/*
		 * arr is a array that contains the id of the admins.
		 */
		int arr[]= {101,102,103}; 
		boolean isadm;
		// TODO Auto-generated method stub
       try
       {
    	   System.out.println("Welcome to RKD bus services...");
    	   while(true)
    	   {
    	   System.out.println("Enter 1 if you are a customer and 2 for admin and 3 for exit...");
    	   Scanner s=new Scanner(System.in);
    	   int choice=s.nextInt();
    	   if(choice==1)
    	   {
    		  System.out.println("Enter 1 to book tickets and 2 to delete ticket and 3 to update name and 4 to update date and 5 to update busno and 6 to exit..");
    		  int choice1=s.nextInt();
    		  if(choice1==1)
    		  {
    			customer c=new customer();  
    		  }
    		  else if(choice1==2)
    		  {
    			 System.out.println("Enter your name :");
    			 String name1=s.next();
    			 System.out.println("Enter your busno :");
    			 int busno1=s.nextInt();
    			 System.out.println("Enter date of travel :");
    			 String date1=s.next();
    			 System.out.println("Enter your id :");
    			 int id=s.nextInt();
    			 try {
   			      Date date=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
   			      customer c=new customer(name1,busno1,date,date1,id);
   		      }
     	       catch (ParseException e) {
   			// TODO Auto-generated catch block
   			     e.printStackTrace();
   		      }
    		  }
    		  else if(choice1==3)
    		  {
    			 System.out.println("Enter your name :");
     			 String name1=s.next();
     			 System.out.println("Enter your busno :");
     			 int busno1=s.nextInt();
     			 System.out.println("Enter date of travel :");
     			 String date1=s.next();
     			 System.out.println("Enter your new name :");
     			 String newname=s.next();
     			 System.out.println("Enter your id :");
   			     int id=s.nextInt();
     			 try {
    			      Date date=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
    			      customer c=new customer(name1,busno1,newname,date,id);
    		      }
      	       catch (ParseException e) {
    			// TODO Auto-generated catch block
    			     e.printStackTrace();
    		      } 
    		  }
    		  else if(choice1==4)
    		  {
    			 System.out.println("Enter your name :");
      			 String name1=s.next();
      			 System.out.println("Enter your busno :");
      			 int busno1=s.nextInt();
      			 System.out.println("Enter date of travel :");
      			 String date1=s.next();
      			 System.out.println("Enter your new date :");
      			 String newdate=s.next();
      			 System.out.println("Enter your id :");
    			 int id=s.nextInt();
      			 try {
     			      Date date=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
     			      customer c=new customer(name1,busno1,date,id,newdate);
     		      }
       	       catch (ParseException e) {
     			// TODO Auto-generated catch block
     			     e.printStackTrace();
     		      }  
    		  }
    		  else if(choice1==5)
    		  {
    			 System.out.println("Enter your name :");
       			 String name1=s.next();
       			 System.out.println("Enter your busno :");
       			 int busno1=s.nextInt();
       			 System.out.println("Enter date of travel :");
       			 String date1=s.next();
       			 System.out.println("Enter your new busno :");
       			 int newbusno=s.nextInt();
       			 System.out.println("Enter your id :");
     			 int id=s.nextInt();
       			 try {
      			      Date date=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
      			      customer c=new customer(name1,busno1,date,id,newbusno);
      		      }
        	       catch (ParseException e) {
      			// TODO Auto-generated catch block
      			     e.printStackTrace();
      		      }   
    		  }
    		  else
    		  {
    			  System.exit(0);
    		  }
    	   }
    	   else if(choice==2)
    	   {
    		  System.out.println("Enter the admin id :");
    		  admid=s.nextInt();
    		  isadm=false;
    		  for(int x:arr)
    		  {
    			  if(x==admid)
    			  {
    				  isadm=true;
    				  break;
    			  }
    		  }
    		  if(isadm==true)
    		  {
    			  System.out.println("Enter 1 to view the bus list and 2 to view the passenger list :");
    			  int choice2=s.nextInt();
    			  if(choice2==1)
    			  {
    				  businfo b=new businfo();
    			  }
    			  else if(choice2==2)
    			  {
    				  System.out.println("Enter 1 to get passenger list at a particular date, 2 to get passenger list\nat a particular bus and 3 to get passenger list /nat specified date and bus\n and 4 for exit: ");
    				  int choice3=s.nextInt();
    				  if(choice3==1)
    				  {
    					  System.out.println("Enter the date:");
    					  String date1=s.next();
    					  booking b=new booking(date1);
    				  }
    				  else if(choice3==2)
    				  {
    					  System.out.println("Enter the busno :");
    					  int no=s.nextInt();
    					  booking b=new booking(no);
    				  }
    				  else if(choice3==3)
    				  {
    					 System.out.println("Enter the busno :");
    					 int no=s.nextInt();
    					 System.out.println("Enter the date :");
    					 String date2=s.next();
    					 booking b=new booking(no,date2);
    				  }
    				  else
    					  System.exit(0);
    			  }
    			  else
    				  System.exit(0);
    		  }
    		  else
    			  System.out.println("Wrong admin id...");
    	   }
    	   else
    	   {
    		   System.exit(0);
    	   }
    	  }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
	}

}
