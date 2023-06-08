package com.alphabook.version1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {
	
 	public void home(String choice)
	{
 		
		switch(choice)
		{
		case "1":
		        {
	        	   	SignUp su= new SignUp();	
	        		su.signup();
	        	}
		break;
		case "2": {
		        	Login l= new Login();
		        	l.login();
		        }
		break;
		case "3": {
			         FrontPage fp= new FrontPage();
			         fp.firstfrontpage();
                }
		break;
		default:{
			System.out.println("-----------------------------------------------------------");
			System.out.println("--------------------Enter a Valid Input--------------------");
			System.out.println("-----------------------------------------------------------");
			FrontPage fp= new FrontPage();
			fp.secondfrontpage();
		}
		}
	}
 	
 	public void home2(String choice)
	{
 		
		switch(choice)
		{
		case "1":
		        {
	        	   	SignUp su= new SignUp();	
	        		su.signup();
	        	}
		break;
		case "2": {
		        	Login l= new Login();
		        	l.login();
		        }
		break;
		case "3": {
			         Exit e= new Exit();
        	         e.exit();
                }
		break;
		default:{
			System.out.println("-----------------------------------------------------------");
			System.out.println("--------------------Enter a Valid Input--------------------");
			System.out.println("-----------------------------------------------------------");
			FrontPage fp= new FrontPage();
			fp.secondfrontpage();
		}
		}
	}
 	
 	public void home3(String choice,String mail,String password)
	{
 		Profile p= new Profile();
 		p.getProfile(mail, password);
 		
     	String name=p.firstname;
    	String email=p.email;
    	String pwd=p.password;
    	
 		switch(choice)
		{
		case "1":
		        {
		        	homepage(name, email, pwd);
	        	}
		break;
		case "2": {
			        Logout l= new Logout();
			        l.logout();
		        }
		break;
		default:{
			System.out.println("-----------------------------------------------------------");
			System.out.println("--------------------Enter a Valid Input--------------------");
			System.out.println("-----------------------------------------------------------");
			 
 			p.getProfile(email, pwd);
			
		}
		}
 		
	}
 	
 	public void homepage(String name,String email,String password)
 	{
 		System.out.println();
 		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("                                                AlphaBook  ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("                   Welcome Back "+name+"                   ");
		System.out.println("-----------------------------------------------------------");
		System.out.println(" 1. Post Status ");
		System.out.println(" 2. View My Status ");
		System.out.println(" 3. Profile ");
		System.out.println(" 4. Logout  ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("---------------------Enter Your Choice---------------------");
		System.out.println("-----------------------------------------------------------");
		Scanner s= new Scanner(System.in);
		String choice= s.next();
		switch(choice)
		{
		
		case "1":{
			
			Profile p= new Profile();
			p.getProfile(email, password);			
			email=p.email;			
			
 
			AddToDataBase ATD = new AddToDataBase();
			ATD.updateStatus(email);
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("             1. Back                2. Logout              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("                     Enter Your Choice                     ");
			System.out.println("-----------------------------------------------------------");
			Scanner sc= new Scanner(System.in);
			String choice2=sc.next();
 			home3(choice2,p.email,p.password);

		}
		break;
		
		case "2":{
			
			Profile p= new Profile();
			p.getProfile(email, password);			
			email=p.email;	
			
			String url="jdbc:mysql://localhost:3306/alphabook";
			String username="root";
			String DataBasepassword="root";
			String querry="select * from status";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn= DriverManager.getConnection(url,username,DataBasepassword);	
				
				PreparedStatement ps = conn.prepareStatement(querry);
				
				
				ResultSet rs= ps.executeQuery();
				int count=0;
				while( rs.next())
				{
					if(rs.getString(1).equals(email))
					{
						count++;
					    System.out.println("-----------------------------------------------------------");
					   	System.out.println("     "+rs.getString(2) );
					   	System.out.println("     "+rs.getString(3) );
					   	}
					
				}
				if(count==0)
				{
					System.out.println("-----------------------------------------------------------");
			     	System.out.println("                        Not Posted Anything                ");	
			     	
				}
	 			ps.close();
				conn.close();
				
			} catch (ClassNotFoundException | SQLException e) {		
				e.printStackTrace();
			}
			System.out.println("-----------------------------------------------------------");
			System.out.println("             1. Back                2. Logout              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("---------------------Enter Your Choice---------------------");
			System.out.println("-----------------------------------------------------------");
			String choice2=s.next();
			home3(choice2,p.email,p.password);

		}
		break;
		case "3":{	
 				
			Profile p= new Profile();
			p.getProfile(email, password);
			System.out.println();
	 		System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println("First Name    :"+p.firstname);
			System.out.println("Last Name     :"+p.lastname);
			System.out.println("Gender        :"+p.gender);
			System.out.println("Mobile Number :"+p.contact);
			System.out.println("Email Id      :"+p.email);
			System.out.println("-----------------------------------------------------------");
			System.out.println("             1. Back                2. Logout              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("---------------------Enter Your Choice---------------------");
			System.out.println("-----------------------------------------------------------");
			String choice2=s.next();
			home3(choice2, p.email,p.password);
				 
			
 		}
		break;
		case "4":
		{
			Logout l= new Logout();
			l.logout();
		}
		break;
		default:{
			System.out.println("-----------------------------------------------------------");
			System.out.println("--------------------Enter a Valid Input--------------------");
			System.out.println("-----------------------------------------------------------");
			 HomePage hp= new HomePage();
			 hp.homepage(name, email, password);
		}
		}
		s.close();
 	}
 	
 	
 	public void homepageSignUp(String name,String email,String password)
 	{
 		System.out.println();
 		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("                                                AlphaBook  ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("                   Hello...... "+name+"                    ");
		System.out.println("                  Happy to See You here                    ");
		System.out.println("-----------------------------------------------------------");
		System.out.println(" 1. Post Status ");
		System.out.println(" 2. View My Status ");
		System.out.println(" 3. Profile ");
		System.out.println(" 4. Logout  ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("---------------------Enter Your Choice---------------------");
		System.out.println("-----------------------------------------------------------");
		Scanner s= new Scanner(System.in);
		String choice= s.next();
		switch(choice)
		{
		case "1":{
			
			Profile p= new Profile();
			p.getProfile(email, password);			
			email=p.email;		
			
			
			
			AddToDataBase ATD = new AddToDataBase();
			ATD.updateStatus(email);
			
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("             1. Back                2. Logout              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("                     Enter Your Choice                     ");
			System.out.println("-----------------------------------------------------------");
			Scanner sc= new Scanner(System.in);
			String choice2=sc.next();
 			home3(choice2,p.email,p.password);
		}
		break;
		
		case "2":{
			
			Profile p= new Profile();
			p.getProfile(email, password);			
			email=p.email;	
			
			String url="jdbc:mysql://localhost:3306/alphabook";
			String username="root";
			String DataBasepassword="root";
			String querry="select * from status";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn= DriverManager.getConnection(url,username,DataBasepassword);	
				
				PreparedStatement ps = conn.prepareStatement(querry);
				
				
				ResultSet rs= ps.executeQuery();
				int count=0;
				while( rs.next())
				{
					if(rs.getString(1).equals(email))
					{
						count++;
					    System.out.println("-----------------------------------------------------------");
					   	System.out.println("     "+rs.getString(2) );
					   	System.out.println("     "+rs.getString(3) );
 					}
					
				}
				if(count==0)
				{
					System.out.println("-----------------------------------------------------------");
			     	System.out.println("                        Not Posted Anything                ");	
				}
	 			ps.close();
				conn.close();
				
			} catch (ClassNotFoundException | SQLException e) {		
				e.printStackTrace();
			}
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("             1. Back                2. Logout              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("---------------------Enter Your Choice---------------------");
			System.out.println("-----------------------------------------------------------");
			String choice2=s.next();
			home3(choice2,p.email,p.password);

		}
		break;
		
		case "3":{
				 
			Profile p= new Profile();
			p.getProfile(email, password);
			System.out.println();
	 		System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println("First Name    :"+p.firstname);
			System.out.println("Last Name     :"+p.lastname);
			System.out.println("Gender        :"+p.gender);
			System.out.println("Mobile Number :"+p.contact);
			System.out.println("Email Id      :"+p.email);

			System.out.println("-----------------------------------------------------------");
			System.out.println("             1. Back                2. Logout              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("---------------------Enter Your Choice---------------------");
			System.out.println("-----------------------------------------------------------");
			String choice2=s.next();
			home3(choice2,p.email,p.password);
			
		}
		break;
		case "4":
		{
			Logout l= new Logout();
			l.logout();
		}
		break;
		default:{
			System.out.println("-----------------------------------------------------------");
			System.out.println("--------------------Enter a Valid Input--------------------");
			System.out.println("-----------------------------------------------------------");
			 HomePage hp= new HomePage();
			 hp.homepageSignUp(name, email, password);
		}
		s.close();
		}

 	}

}
