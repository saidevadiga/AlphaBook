package com.alphabook.version1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile {
	
	  String firstname;
	  String lastname;
	  String gender;
	  long contact;
	  String email;
	  String password;
	
	
	public void getProfile(String email,String password)
	{
		this.email=email;
		this.password=password;
		String url="jdbc:mysql://localhost:3306/alphabook";
		String username="root";
		String DataBasepassword="root";
		String querry="select * from user";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn= DriverManager.getConnection(url,username,DataBasepassword);	
			
			PreparedStatement ps = conn.prepareStatement(querry);
			
			
			ResultSet rs= ps.executeQuery();
			while( rs.next())
			{
				if(rs.getString(5).equals(email) && rs.getString(6).equals(password))
				{
					this.firstname=rs.getString(1);
					this.lastname=rs.getString(2);
					this.gender=rs.getString(3);
					this.contact=rs.getLong(4);
					this.email=rs.getString(5);
					this.password=rs.getString(6);
				}
				 
			}
 			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		}
	}

}
