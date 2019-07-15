package jdbcexample;

import java.sql.SQLException;
import java.util.Scanner;

public class Jdbctest extends Personsj {
	static void mainMenu(){
		System.out.println("Enter your choices");
		System.out.println("Enter 1 to insert");
		System.out.println("Enter 2 to delete");
		System.out.println("Enter 3 to update");
		System.out.println("Enter 4 to view ");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Jdbctest jb = new Jdbctest();
		mainMenu();
	
	

	while(true)
	{
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			jb.addpersons();
			mainMenu();
			break;
		case 2:
			System.out.println("Enter Students Number");
			int sno=sc.nextInt();
			jb.deletepersons(sno);
			mainMenu();
			break;
		case 3:
			System.out.println("Enter Students Number");
			int sno1=sc.nextInt();
			System.out.println("enter name");
			String s =sc.next();
			System.out.println("enter city");
			String g =sc.next();
			jb.updatepersons(sno1,s,g);
			mainMenu();
			break;
		case 4 :
			jb.viewpersons();
			mainMenu();
			break;

			default:
				mainMenu();
		}

	}

}

		
	}
