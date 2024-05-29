
	package com;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.DBService;
	import com.UserInfo;
	import com.mysql.cj.xdevapi.PreparableStatement;

	@WebServlet("/AdminServlet")
	public class AdminServlet extends HttpServlet 
	{
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			UserInfo u = new UserInfo();
			u.setUsername(request.getParameter("t1"));
			u.setPassword(request.getParameter("t2"));
			DBService db = new DBService();
			boolean isValid =  db.adminCheck(u);
			String target="";
			PrintWriter out = response.getWriter();
			if(isValid==true)
			{
				target="/adminindex.jsp";
			}
			else
			{
				request.setAttribute("sms","Invalid Username/Password");
				target="/AdminLogin.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
			rd.forward(request, response);
		
		}

	}
