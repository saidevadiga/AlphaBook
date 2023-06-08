package com.alphabook.version1;

public class CheckPassword {
	
	public boolean checkSpecial(String str)
	{
		int spl=0;
		int num=0;
		int alpha=0;
		for(int i=0;i<str.length();i++)
		{
			if(!(str.charAt(i)>=48 && str.charAt(i)<=57 || str.charAt(i)>=65 && str.charAt(i)<=90 || str.charAt(i)>=97 && str.charAt(i)<=122))
			{
				spl++;
			}
			if((str.charAt(i)>=48 && str.charAt(i)<=57))
			{
				num++;
			}
			 if(str.charAt(i)>=65 && str.charAt(i)<=90 || str.charAt(i)>=97 && str.charAt(i)<=122)
			 {
				 alpha++;
			 }
		}
		
		if(spl==0||num==0||alpha==0)
		{
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public boolean checkpassword(String str)
	{
 		if(str.length()<8)
		{
			return false;
		}
 		else if(!checkSpecial(str))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
