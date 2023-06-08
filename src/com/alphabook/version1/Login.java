package com.alphabook.version1;

import java.util.Scanner;

public class Login {
	
	String choice;
	String email;
	String password;
	int count=1;
	public void login()
	{
		Scanner s= new Scanner (System.in);
		System.out.println("-----------------------------------------------------------");
		System.out.println("-------------------Enter Your Email ID---------------------");
		System.out.println("             1. Back                  2. Exit              ");
		System.out.println("-----------------------------------------------------------");
		email=s.next();
		switch(email) {
		case("1"):{
			Cancel c= new Cancel();
			c.cancelLogin();
		}
		break;
		case("2"):{
			Exit e= new Exit();
        	e.exit();
		}
		break;
		default:{
			
			checkEmailInDataBase ce= new checkEmailInDataBase();

			if(ce.checkEmail(email))
			{
				
				System.out.println("-----------------------------------------------------------");
				System.out.println("--------------------Enter Your Password--------------------");
				System.out.println("-----------------------------------------------------------");

				password=s.next();
				
				Password p= new Password();
				p.checkPassword(email, password,count);
			}
			else
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("----------------Coundn't find the Email ID-----------------");
				System.out.println("----------------------Please Try Again---------------------");
				System.out.println("-----------------------------------------------------------");


				Login l= new Login();
				l.login();
			}
		}
		s.close();
		}
	}

	
//	public void directLogin(String email)
//	{
//		Scanner s= new Scanner(System.in);
//		checkEmailInDataBase ce= new checkEmailInDataBase();
//		if(ce.checkEmail(email))
//		{
//			System.out.println("-------------Account found with the Email ID---------------");
//			System.out.println("1. Login to the account       2. Back             3. Exit  ");
//			System.out.println("-----------------------------------------------------------");
//			System.out.println("----------------------Enter Your Choice--------------------");
//			System.out.println("-----------------------------------------------------------");
//
//			choice=s.next();
//			
//			switch(choice)
//			{
//			case "1":
//			{
//				System.out.println("------------------Enter Your Password------------------");
//				password=s.next();
//				
//				Password p= new Password();
//				p.checkPassword(email, password,count);
//			}
//			break;
//			case "2":
//			{
//				FrontPage f= new FrontPage();	
//				f.insidepage();
//			}
//			break;
//
//			case "3":
//			{
//				Exit e= new Exit();
//            	e.exit();
//			}
//			break;
//			default:
//			{
//				FrontPage f= new FrontPage();	
//				f.frontpage();
//			}
//			}
//			
//			 
//		}
//		else
//		{
//			System.out.println("--------Coundn't find the Account with that Email ID-------");
//			System.out.println("-----------------------------------------------------------");
//			System.out.println("  1. SignUp              2. Login                 3. Exit  ");
//			System.out.println("-----------------------------------------------------------");
//			System.out.println("----------------------Enter Your Choice--------------------");
//			System.out.println("-----------------------------------------------------------");
//
// 			String choice=s.next();
//			HomePage h= new HomePage();
//			h.home(choice);
//			s.close();
//		}
//		s.close();
//	}
}
