package com.bank.ejbs;

import javax.ejb.Local;

@Local
public interface MoneyTransactionsLocal 
{
	public String transferAmount(int fromano,int toano,double amount);
	public double getBalance(int ano);

}
