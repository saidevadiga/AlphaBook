package com.alphabook.version1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkPasswordinDatabase {

	private String email;
private String password;
	
	boolean status;

	public boolean checkPasswordinDB(String email,String password)
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
					status= true;
					break;
				}
				else {
					status= false;
				}
			}
 			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		}
		return status;
	}
}
