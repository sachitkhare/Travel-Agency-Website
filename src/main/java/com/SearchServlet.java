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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CustomerInfo c=new CustomerInfo();
		DBService db = new DBService();
		
		String n = (request.getParameter("k2"));
		CustomerInfo sdt = db.getCustomer(n);
		request.setAttribute("CustomerInfo",sdt);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mybookingshow.jsp");
		rd.forward(request, response);
	}
}
