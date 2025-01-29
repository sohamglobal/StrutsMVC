package com.soham.ejbs;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class IncomeTaxCalculator
 */
@Stateless(mappedName = "itc")
@LocalBean
public class IncomeTaxCalculator implements IncomeTaxCalculatorLocal {

    /**
     * Default constructor. 
     */
    public IncomeTaxCalculator() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public double calcIncomeTax(double basic) {
		// TODO Auto-generated method stub
		double incentives,allowances,total,annual,itax;
		incentives=basic*45/100;
		allowances=basic*30/100;
		total=basic+incentives+allowances;
		annual=total*12;
		if(annual>350000)
			itax=annual*5/100;
		else
			itax=0;
		return itax;
	}

	@Override
	public double calcDiscount(double amount) {
		// TODO Auto-generated method stub
		double discount=amount*9/100;
		return discount;
	}
    
    

}
