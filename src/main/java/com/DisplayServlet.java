
package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBService;
import com.dto.CustomerInfo;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DBService db = new DBService();
		ArrayList<CustomerInfo>al= db.getallcustomer();
		request.setAttribute("getallcustomer",al);
		RequestDispatcher rd = request.getRequestDispatcher("/mybookingA.jsp");
		rd.forward(request, response);
	}
}
