package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBService;
import com.dto.CustomerInfo;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/cencelservlet")
public class cencelservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CustomerInfo c=new CustomerInfo();
		
		c.setEmail(request.getParameter("k2"));
		
		DBService db = new DBService();
		
		int x=0;
		x=db.DeleteCustomer(c);
		if(x>=1)
		{
			request.setAttribute("sms", "Delete Booking Successfully");
		}
		else
		{
			request.setAttribute("sms", "Booking not error please try again");
		}
		RequestDispatcher rsd = getServletContext().getRequestDispatcher("/mybooking.jsp");
		
		rsd.forward(request,response);		
	}

}