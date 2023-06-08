package com.alphabook.version1;

import java.util.Scanner;

public class Password {
	String password; 
	String email;
	String name;
 	int count;
 	public void checkPassword(String email,String password, int count)
	{
 		checkPasswordinDatabase cpwd= new checkPasswordinDatabase();
 		
		this.email=email;
		this.password=password;
		this.count=count;
		
		if(cpwd.checkPasswordinDB(email,password))
		{
			System.out.println();
	        System.out.println("-----------------------------------------------------------");
			System.out.println("               *** Logged in Successfully ***              ");
		    System.out.println("-----------------------------------------------------------");
			try {
				Thread.sleep(1000);
				
				Profile p= new Profile();
				p.getProfile(email, password);
	 			this.name=p.firstname;
				HomePage hp= new HomePage();
				hp.homepage(name, email, password);
			}
			catch (Exception e) {
				Profile p= new Profile();
				p.getProfile(email, password);
	 			this.name=p.firstname;
				HomePage hp= new HomePage();
				hp.homepage(name, email, password);			}
		}
		else 
		{
			
 			   count=password3Time( email,count);
 		}
		
	}
 	
 	
 	public  int password3Time( String mail  ,int c)
	{
 		int cc=c;
 		Scanner s= new Scanner(System.in);
  		 
  		   if(cc<3)
  		   {
  			   cc++;
   	     	   System.out.println("-----------------------------------------------------------");
     	   	   System.out.println("--------------------Wrong Password-------------------------");
 		       System.out.println("--------------Please Re-Enter Your Password----------------");
 		       System.out.println("                 Pending Attempt "+(4-cc)+"                  ");
 			   System.out.println("-----------------------------------------------------------");

 		     String pwd2=s.next();
 			 Password p= new Password();

  			 p.checkPassword(mail, pwd2,cc);
 			 s.close();
  		   }
  		   else
  		   {
  			  System.out.println("-----------------------------------------------------------");
  		      System.out.println("-------------------Maximum Attemp Reached------------------");
  			  System.out.println("-----------------------------------------------------------");
  			  FrontPage fp= new FrontPage();
  			  fp.insidepage();
  		   }
  		   return c;
	}
 	
  
}
