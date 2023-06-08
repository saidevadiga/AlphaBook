package com.alphabook.version1;

import java.util.Scanner;

public class Gender {
	String gen;
	public String checkGender(String choice)
	{
		switch(choice)
		{
		case "1":gen="Male";
		break;
		case "2":gen="Female";
		break;
		case "3":gen="Others";
		break;
		default:{
			System.out.println("Please Choose Correct Options                              ");
			System.out.println("-----------------------------------------------------------");
			System.out.println("  1. Male              2. Female                 3. Others ");
			Scanner s= new Scanner(System.in);
			String newgen=s.next();
			Gender g= new Gender();
			g.checkGender(newgen);
		  }
		}
		return gen;
	}

}
