package com.kh.MVC.bank;

import java.util.List;

public class bankCollector {
private bankDAO dao;

public bankCollector(bankDAO dao) {
	this.dao = dao;
	
}

	public double calculateTotalPrice(List<bankDTO> banks) {
		double totalPrice = 0;
		
		for(bankDTO totalb : banks) {
			totalPrice +=
		}
	}
}
