package com.ethan.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.business.logic.SalaryBean;

/**
 * Servlet implementation class FindSalary
 */
@WebServlet("/FindSalary")
public class FindSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	SalaryBean obj;
	
    public FindSalary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double bas,net;
		bas=Double.parseDouble(request.getParameter("bas"));
		net=obj.calcNetSalary(bas);
		HttpSession ses=request.getSession(true);
		ses.setAttribute("basic",bas);
		ses.setAttribute("netsal",net);
		response.sendRedirect("ShowSalary.jsp");
		
	}

}
