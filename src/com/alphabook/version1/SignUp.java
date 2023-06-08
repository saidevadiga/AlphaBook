package com.alphabook.version1;

import java.util.Scanner;

public class SignUp {
	
	private String firstname;
	private String lastname;
	private String gender;
	private long contact;
	private String email;
	private String password;
	
	public void signup()
	{
		Scanner s= new Scanner(System.in);
		System.out.println("-----------------------------------------------------------");
		System.out.println("Enter First Name              :");
		firstname=s.next();
		System.out.println("-----------------------------------------------------------");
		System.out.println("Enter Last Name               :");
		lastname=s.next();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Choose Your Gender            :");
		System.out.println("-----------------------------------------------------------");
		System.out.println("  1. Male              2. Female                 3. Others ");
		String chooseGender=s.next();
		Gender g= new Gender();
		gender=g.checkGender(chooseGender);
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Enter 10 Digit Mobile Number  :");
		MobileNumber m= new MobileNumber();
		int z=0;
		while(z<1) {
			try {
				String phnno=s.next();
			    this.contact=Long.parseLong(phnno);
				boolean b=m.mobileNumber(this.contact);
				if(b==false)
				{
					System.out.println("-----------------------------------------------------------");
					System.out.println("Mobile Number Should contain 10 Digits");
					System.out.println("Please Re-Enter 10 Digit Mobile Number :");
					System.out.println("-----------------------------------------------------------");

 				}
				else {
				     z++;
				}
			}
			catch(Exception e)
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("           Enter Valid Input            ");
				System.out.println("Please Re-Enter 10 Digit Mobile Number :");
				System.out.println("-----------------------------------------------------------");
			}
		}
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Enter your email Address      :");
		email=s.next();
		int extra=0;
		while(extra<1)
		{
			CheckEmail ce= new CheckEmail();
			boolean b1= ce.checkemail(email);
			checkEmailInDataBase cedb= new checkEmailInDataBase();
			boolean b2=cedb.checkEmail(email);
			if(b1== true && b2==false)
			{
				break;
			}
			else if( b2==true)
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("----------Account already found with that Email ID---------");
				System.out.println("--------------Please enter another Email ID----------------");
 				System.out.println("-----------------------------------------------------------");	
 				email=s.next();
			}
			else
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("       Please enter Valid email Id with Proper Domain      ");
				System.out.println("       @gmail.com    OR   @email.com   OR   @yahoo.com     ");
				System.out.println("-----------------------------------------------------------");
				email=s.next();
			}
		}
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("                    Enter a Strong Password                ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("        Note: Password must be contains 8 characters       ");
		System.out.println("              Atleast 1 special character                  ");
		System.out.println("              Atleast 1 Upper Case and 1 Numeric character ");
		System.out.println("-----------------------------------------------------------");
		password=s.next();
		int ps=0;
		
		while(ps<1)
		{
			CheckPassword cpwd= new CheckPassword();
			boolean b1 = cpwd.checkpassword(password);
			if(b1==true)
			{
				break;
			}
			else
			{
				System.out.println("-----------------------------------------------------------");
				System.out.println("                   Your Password is weak                   ");
				System.out.println("-----------------------------------------------------------");
				System.out.println("Note: Password must be contains 8 characters       ");
				System.out.println("      Atleast 1 Upper Case and 1 Numeric character ");
				System.out.println("      Atleast 1 special character                  ");
				System.out.println("-----------------------------------------------------------");
				System.out.println(" Please Enter a Strong Password Here        ");
				System.out.println("-----------------------------------------------------------");

				password=s.next();
			}
		}
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("  1. Submit       2. Clear        3. Back         4. Exit  ");
		System.out.println("-----------------------------------------------------------");
		System.out.println("---------------------Enter Your Choice---------------------");
		System.out.println("-----------------------------------------------------------");
		String choice=s.next();
		switch(choice)
		{
		case "1": {
			Submit sub= new Submit();
			sub.submit(firstname,lastname,gender,contact,email,password);
		}
		break;
		case "2": {
			Cancel c= new Cancel();
			c.cancelSignup();
		}
		break;
		case "3": {
			FrontPage f= new FrontPage();
			f.insidepage();
		}
		break;
		case "4": {
        	Exit e= new Exit();
        	e.exit();
        }
        break;
		default:{
			SignUp su= new SignUp();	
			su.signup();
		}
		s.close();
	}

 }
}
