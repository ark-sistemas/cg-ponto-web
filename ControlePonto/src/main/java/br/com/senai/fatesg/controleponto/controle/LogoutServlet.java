package br.com.senai.fatesg.controleponto.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("inicio.jspx").include(request, response);

		HttpSession session = request.getSession(false);
		session.invalidate();
		out.print("You are successfully logged out!");

		out.close();
		/**
		 * final HttpServletRequest request =  ServletActionContext.getRequest();
		final HttpSession session = request.getSession();
		//request.getRequestDispatcher("inicio.jspx").include(request, response);

		request.logout();
	    session.invalidate();
		 */
		
		
	}
}
