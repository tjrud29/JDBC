package com.kh.MVC.bank;

import java.util.List;

public class bankView {
	public void showBankList(List<bankDTO> banks) {
		for(bankDTO b : banks) {
			System.out.println("»¬ µ·ÀÇ °ª : " + b.getBalance());
			System.out.println("¾ÆÀÌµð :" + b.getAccount_id());
			System.out.println("=====================================");
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("°èÁÂÀÇ µ· :" + totalPrice);
	}
}
