package com.alphabook.version1;

public class Submit {
	
	  String firstname;
	  String lastname;
	  String gender;
	  long contact;
	   String email;
	  String password;
	
	public void submit(String firstname,String lastname, String gender, long contact, String email, String password)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.gender=gender;
		this.contact=contact;
		this.email=email;
		this.password=password;
		
		AddToDataBase a= new AddToDataBase();
		a.newAccount(firstname,lastname,gender,contact,email,password);
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("         *** Account Created Successfully ***              ");
		System.out.println("-----------------------------------------------------------");
 		
		try {
			Thread.sleep(1000);
			
			Profile p= new Profile();
			p.getProfile(email, password);
			HomePage hp= new HomePage();
			hp.homepageSignUp(firstname, email, password);
		}
		catch (Exception e) {
			Profile p= new Profile();
			p.getProfile(email, password);
			HomePage hp= new HomePage();
			hp.homepageSignUp(firstname, email, password);		}

	}

}
