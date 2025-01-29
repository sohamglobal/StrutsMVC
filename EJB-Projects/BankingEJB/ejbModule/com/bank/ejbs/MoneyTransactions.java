package com.bank.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.sql.*;

/**
 * Session Bean implementation class MoneyTransactions
 */
@Stateless(mappedName = "trans")
@LocalBean
public class MoneyTransactions implements MoneyTransactionsLocal {

    /**
     * Default constructor. 
     */
	
	private double balance;
	private String status;
	
    public MoneyTransactions() {
        balance=0.0;
        status="";
    	
    }
    
    public double getBalance(int ano)
    {
    	Connection con;
    	PreparedStatement pst;
    	ResultSet rs;
    	
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://bwxkjmcph5prgjl2hloh-mysql.services.clever-cloud.com:3306/bwxkjmcph5prgjl2hloh?user=uzb2eo26hzxl6jpj&password=8Dxb50kXEJsGfgACPcGF");
    		pst=con.prepareStatement("select balance from accounts where accno=?;");
    		pst.setInt(1, ano);
    		rs=pst.executeQuery();
    		if(rs.next())
    		{
    			balance=rs.getDouble("balance");
    		}
    		else
    			balance=0;
    		con.close();
    	}
    	catch(Exception e)
    	{
    		balance=-1;
    	}
    	
    	
    	return balance;
    	
    }
    
    public String transferAmount(int fromano,int toano,double amount)
    {
    	Connection con;
    	PreparedStatement pst;
    	
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://bwxkjmcph5prgjl2hloh-mysql.services.clever-cloud.com:3306/bwxkjmcph5prgjl2hloh?user=uzb2eo26hzxl6jpj&password=8Dxb50kXEJsGfgACPcGF");
    		pst=con.prepareStatement("update accounts set balance=balance-? where accno=?;");
    		pst.setDouble(1, amount);
    		pst.setInt(2, fromano);
    		pst.executeUpdate();
    		
    		pst=con.prepareStatement("update accounts set balance=balance+? where accno=?;");
    		pst.setDouble(1, amount);
    		pst.setInt(2, toano);
    		pst.executeUpdate();
    		
    		status="success";
    		con.close();
    	}
    	catch(Exception e)
    	{
    		status="failed";
    	}
    	
    	
    	return status;
    }

}
