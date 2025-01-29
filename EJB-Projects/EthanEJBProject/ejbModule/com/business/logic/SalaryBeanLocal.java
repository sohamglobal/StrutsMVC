package com.business.logic;

import javax.ejb.Local;

@Local
public interface SalaryBeanLocal 
{
	//public double calcIncomeTax(double annualincome);
	public double calcNetSalary(double basic);

}
