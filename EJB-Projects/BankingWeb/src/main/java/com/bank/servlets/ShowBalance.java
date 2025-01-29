package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.ejbs.MoneyTransactions;

/**
 * Servlet implementation class ShowBalance
 */
@WebServlet("/ShowBalance")
public class ShowBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	MoneyTransactions obj;
	
    public ShowBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int no=Integer.parseInt(request.getParameter("acno"));
		double bal=obj.getBalance(no);
		
		
		String stat=obj.transferAmount(1029,1001,5000);
		
		HttpSession ses=request.getSession(true);
		ses.setAttribute("accbal", bal);
		ses.setAttribute("status", stat);
		
		response.sendRedirect("SearchInfo.jsp");
		
	}

}
