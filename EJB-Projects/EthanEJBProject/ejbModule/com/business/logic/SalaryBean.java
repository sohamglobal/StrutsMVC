package com.business.logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SalaryBean
 */
@Stateless(mappedName = "sal")
@LocalBean
public class SalaryBean implements SalaryBeanLocal {

    /**
     * Default constructor. 
     */
	private double netsalary;
    public SalaryBean() {
        netsalary=0.0;
    }
    
    public double calcNetSalary(double basic)
    {
    	double all,inc,tot,tax;
    	all=basic*45/100;
    	inc=basic*30/100;
    	tot=basic+all+inc;
    	tax=tot*5/100;
    	netsalary=tot-tax;
    	return netsalary;
    }

}
