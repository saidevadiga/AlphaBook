package com.alphabook.version1;

public class MainClass {

	public static void main(String[] args) {
		System.out.println();
 		System.out.println();
		System.out.println("***********************************************************");
		System.out.println("                  WeloCome To ALPHA-Book                   ");
		System.out.println("***********************************************************");
		System.out.println();
 		System.out.println();

		
		try {
			
			Thread.sleep(1000);
			
			FrontPage f= new FrontPage();
			f.firstfrontpage();
			
		} 
		catch (Exception e) {
 			FrontPage f= new FrontPage();
			f.firstfrontpage();
			}
	}
}
