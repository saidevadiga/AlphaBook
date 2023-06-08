package com.alphabook.version1;

public class CheckEmail {
	
	public boolean checkemail(String str)
	{
		if((str.length()>10)&&(str.substring(str.length()-10).equals("@gmail.com")||str.substring(str.length()-10).equals("@email.com")||str.substring(str.length()-10).equals("@yahoo.com")))
		{
			return true;
		}
	
		else {
			return false;
		}
	}
	
}
