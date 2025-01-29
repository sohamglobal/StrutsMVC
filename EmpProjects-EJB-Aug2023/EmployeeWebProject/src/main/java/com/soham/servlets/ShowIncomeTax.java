package com.soham.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.soham.ejbs.IncomeTaxCalculator;

/**
 * Servlet implementation class ShowIncomeTax
 */
public class ShowIncomeTax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	IncomeTaxCalculator icalc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowIncomeTax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		double basic=Double.parseDouble(request.getParameter("basic"));
		double tax=icalc.calcIncomeTax(basic);
		
		out.println("<h2>Result by the EJB Module</h2><hr>");
		NumberFormat formatter = new DecimalFormat("#0.00");
		out.println("Your income tax will be : "+formatter.format(tax));
		
		double disc=icalc.calcDiscount(tax);
		out.println("<br>Discount on income tax will be : "+formatter.format(disc));
		
		out.println("<br>Final payable tax : "+formatter.format(tax-disc));
	}

}
