package com.alphabook.version1;

public class Logout {

	public void logout()
	{
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("                  Logged Out Successfully                  ");
		System.out.println("-----------------------------------------------------------");
		System.out.println();

		FrontPage fp= new FrontPage();
		fp.insidepage();
	}
}
