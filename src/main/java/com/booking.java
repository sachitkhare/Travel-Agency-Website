package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CustomerInfo;

/**
 * Servlet implementation class booking
 */
@WebServlet("/booking")
public class booking extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	CustomerInfo c=new CustomerInfo();
	c.setName(request.getParameter("k1"));
	c.setEmail(request.getParameter("k2"));
	c.setDate(request.getParameter("k3")); 
	c.setDestination(request.getParameter("k4"));
	c.setPassport(request.getParameter("k5"));
	DBService db = new DBService();
	
	int x=0;
	x=db.addCustomer(c);
	if(x>=1)
	{
		request.setAttribute("sms", "Booking Successfully");
	}
	else
	{
		request.setAttribute("sms", "Booking error please try again");
	}
	RequestDispatcher rsd = getServletContext().getRequestDispatcher("/payment.jsp");
	
	rsd.forward(request,response);
	
	}
	
	
}
