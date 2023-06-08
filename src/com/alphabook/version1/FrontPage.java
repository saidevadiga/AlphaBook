package com.alphabook.version1;

import java.util.Scanner;

public class FrontPage {
	
	public void firstfrontpage()
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("             1. Let's Start          2. Exit               ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("---------------------Enter Your Choice---------------------");
		System.out.println("-----------------------------------------------------------");
		Scanner s= new Scanner(System.in);
		String choice=s.next();
		switch(choice) {
		case "1":{
			FrontPage fp= new FrontPage();
			fp.secondfrontpage();
		}
		break;
		case "2":{
			Exit e= new Exit();
        	e.exit();
		}
		break;
		default:{
			System.out.println("-----------------------------------------------------------");
			System.out.println("--------------------Enter a Valid Input---------------------");
			System.out.println("-----------------------------------------------------------");
			FrontPage fp= new FrontPage();
			fp.firstfrontpage();
		}
		}
		s.close();
 	}

	
	public void secondfrontpage()
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("           1. Don't have an account.....? Sign Up.         ");
		System.out.println("           2. Already have an account...? Log In.          ");
		System.out.println("           3. Back.                                        ");
		System.out.println("-----------------------------------------------------------");
		Scanner s= new Scanner(System.in);
		String choice=s.next();
		HomePage h= new HomePage();
		h.home(choice);
		s.close();
	}

//	public void frontpage() {
//
//	System.out.println("-----------------------------------------------------------");
//	System.out.println("  1. SignUp              2. Login                 3. Exit  ");
//	System.out.println("-----------------------------------------------------------");
//
//	Scanner s= new Scanner(System.in);
//	String choice=s.next();
//	HomePage h= new HomePage();
//	h.home(choice);
//	s.close();
//	
//	}
	
	public void insidepage() {

		System.out.println("-----------------------------------------------------------");		
		System.out.println("  1. SignUp              2. Login                 3. Back  ");
		System.out.println("-----------------------------------------------------------");

		Scanner s= new Scanner(System.in);
		String choice=s.next();
		HomePage h= new HomePage();
		h.home(choice);
		s.close();
		
		}
}
