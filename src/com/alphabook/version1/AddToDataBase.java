package com.alphabook.version1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddToDataBase {

	public  void newAccount(String firstname,String lastname, String gender, long contact, String email, String password)
	{
		String url="jdbc:mysql://localhost:3306/alphabook";
		String username="root";
		String DataBasepassword="root";
		String querry="insert into user values(?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(url,username,DataBasepassword);	
			PreparedStatement ps = conn.prepareStatement(querry);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, gender);
			ps.setLong(4, contact);
			ps.setString(5, email);
			ps.setString(6, password);

			ps.execute();
			
			ps.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateStatus(String email)
	{
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("        Enter the Status to be posted and click Enter      ");
		Scanner s= new Scanner(System.in);
		String Status=s.nextLine();
  		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		String time =dtf.format(now);
		
		String url="jdbc:mysql://localhost:3306/alphabook";
		String username="root";
		String DataBasepassword="root";
		String querry="insert into status values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(url,username,DataBasepassword);	
			PreparedStatement ps = conn.prepareStatement(querry);
			ps.setString(1, email);
			ps.setString(2, Status);
			ps.setString(3, time);
			 

			ps.execute();
			
			ps.close();
			conn.close();
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("                         Post Uploaded                     ");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

}
