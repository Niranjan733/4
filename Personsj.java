package jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connect.Jdbcconn;
import com.jdbc.quiery.Quierycon;

public class Personsj {
	static Connection con1 = null;
	static PreparedStatement ps1=null;
	
	public void addpersons() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Add Student Details");
		 con1=Jdbcconn.getConnection();
		   ps1=con1.prepareStatement(Quierycon.pinsert_qry);
		   Scanner sc=new Scanner(System.in);
		   System.out.println("How many Records you Want to Insert");
		   int n=sc.nextInt();
		   for(int i=0;i<n;i++)
		    {
		     System.out.println("Enter Student's Number");
		     int pid=sc.nextInt();
		     ps1.setInt(1,pid);
		     System.out.println("Enter Student's Name:");
		     String pname=sc.next();
		     ps1.setString(2,pname);
		     System.out.println("Enter Students Address");
		     String pcity=sc.next();
		      ps1.setString(3,pcity);
		      int count=ps1.executeUpdate();
		      if(count!=0)
			   System.out.println("Quiery is effected");
		     else
			  System.out.println("Quiery is not effected");
			  }
		
		

	}

	public ResultSet viewpersons() throws ClassNotFoundException, SQLException {
		con1=Jdbcconn.getConnection();
		   ps1=con1.prepareStatement(Quierycon.pview_qry);
		   
		//4   ps1.setInt(1, 10000);
		   ResultSet rs = ps1.executeQuery();
		   
		  
		   
		   
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int personid  = rs.getInt(1);
		         
		         String name = rs.getString(2);
		         String city= rs.getString(3);

		         //Display values
		         System.out.print(personid+"\t"+ name+"\t"+city);
		         
		        
		      }
		      
		      rs.close();
		      ps1.close();
		      return rs;
			
		

	}

	public void deletepersons(int sno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		con1=Jdbcconn.getConnection();
		   ps1=con1.prepareStatement(Quierycon.pdelete_qry);
		   ps1.setString(1, sno+"");
		   ps1.executeUpdate();
		   ps1.close();
		
	
	}

	public void updatepersons(int sno,String g,String s) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		con1=Jdbcconn.getConnection();
		   ps1=con1.prepareStatement(Quierycon.pupdate_qry);
		   ps1.setInt(3,sno); // set input parameter 1
		      ps1.setString(1, g);
		     // set input parameter 2
		      ps1.setString(2,s );
		      ps1.executeUpdate();
		      ps1.close();
		      con1.close();

	}

}
