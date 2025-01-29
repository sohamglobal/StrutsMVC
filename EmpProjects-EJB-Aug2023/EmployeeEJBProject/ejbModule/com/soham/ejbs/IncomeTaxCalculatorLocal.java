package com.soham.ejbs;

import jakarta.ejb.Local;

@Local
public interface IncomeTaxCalculatorLocal {
	
	public double calcIncomeTax(double basic);
	public double calcDiscount(double amount);

}
