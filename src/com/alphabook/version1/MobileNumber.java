package com.alphabook.version1;

public class MobileNumber {
	
	public boolean mobileNumber(long num)
	{
		if(num>999999999l && num<10000000000l)
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
	
}
