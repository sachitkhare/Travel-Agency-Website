package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.*;

public class DBService 
{
	Connection con=null;
	public DBService() 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel?user=root&password=Sachit@2001");
		}
		catch(Exception e)
		{
			
		}
	}
	public boolean check(UserInfo u)
	{
		boolean isValid=false;
	
	  try
	  {
		
		PreparedStatement ps = con.prepareStatement("select * from userinfo where username = ? and password = ?");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ResultSet rs =  ps.executeQuery();
		if(rs.next()==true)
		{
			isValid=true;
		}
		else
		{
			isValid=false;
		}
	  }
	  catch(SQLException e)
	  {
		System.out.print("Error in sql statements"+e);
	  }
	  return isValid;
	}
	
	//Admin login
	public boolean adminCheck(UserInfo u)
	{
		boolean isValid=false;
	
	  try
	  {
		
		PreparedStatement ps = con.prepareStatement("select * from admininfo where username = ? and password = ?");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ResultSet rs =  ps.executeQuery();
		if(rs.next()==true)
		{
			isValid=true;
		}
		else
		{
			isValid=false;
		}
	  }
	  catch(SQLException e)
	  {
		System.out.print("Error in sql statements"+e);
	  }
	  return isValid;
	}
	//add customers
	public int addCustomer(CustomerInfo c)
	{
		 int x = 0 ;
		 int y=5;
	try{
		PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setString(3, c.getDate());
		ps.setString(4, c.getDestination());
		ps.setString(5, c.getPassport());
	     x=  ps.executeUpdate();	
        }
catch(SQLException e)
{
System.out.print("Error in sql statements"+e);
}
	return x;
	}

	
	
	//search 
	public CustomerInfo getCustomer(String n)
	{
		CustomerInfo c=new CustomerInfo();	
	try{
		
		PreparedStatement ps = con.prepareStatement("select * from customer where email = ?");
		ps.setString(1,n);
		ResultSet rs =  ps.executeQuery();
		if(rs.next()==true)
		{
			
			c.setName(rs.getString("name"));
			c.setEmail(rs.getString("email"));
			c.setDate(rs.getString("date"));
			c.setDestination(rs.getString("destination"));
			c.setPassport(rs.getString("passport"));
			
		}
		
}
catch(SQLException e)
{
System.out.print("Error in sql statements");
}
	return c;

	}
	
//display
	public ArrayList<CustomerInfo> getallcustomer()
	{
		ArrayList<CustomerInfo>al = new ArrayList<CustomerInfo>();
	
	try{
		
		PreparedStatement ps = con.prepareStatement("select * from customer");
		ResultSet rs =  ps.executeQuery();
		while(rs.next())
		{
			CustomerInfo d = new CustomerInfo();
			d.setName(rs.getString("name"));
			d.setEmail(rs.getString("email"));
			d.setDate(rs.getString("date"));
			d.setDestination(rs.getString("destination"));
			d.setPassport(rs.getString("passport"));
			al.add(d);
		}
		
}
catch(SQLException e)
{
System.out.print("Error in sql statements");
}
	return al;

}

	public int DeleteCustomer(CustomerInfo c)
	{
	int x=0;
	
	try{
		PreparedStatement ps = con.prepareStatement("delete from customer where email=?");
		
		ps.setString(1, c.getEmail());
	
		x =  ps.executeUpdate();	
        }
catch(SQLException e)
{
System.out.print("Error in sql statements");
}
	return x;





}}
	