package com.kh.MVC.bank;

import java.sql.Date;

public class bankDTO {
	private int account_id;
	private int account_number;
	private String account_name;
	private double balance;
	private String branch_name;
	private Date last_transaction_date;
	
	private bankDTO(int account_id,int account_number,String account_name,double balance, String branch_name,Date last_transaction_date) {
		this.account_id = account_id;
		this.account_number = account_number;
		this.balance = balance;
		this.branch_name = branch_name;
		this.last_transaction_date = last_transaction_date;
		
		
		
		
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public Date getLast_transaction_date() {
		return last_transaction_date;
	}

	public void setLast_transaction_date(Date last_transaction_date) {
		this.last_transaction_date = last_transaction_date;
	}
	
	
	
}
