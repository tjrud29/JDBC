package com.kh.MVC.bank;

import java.util.List;

public class bankView {
	public void showBankList(List<bankDTO> banks) {
		for(bankDTO b : banks) {
			System.out.println("�� ���� �� : " + b.getBalance());
			System.out.println("���̵� :" + b.getAccount_id());
			System.out.println("=====================================");
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("������ �� :" + totalPrice);
	}
}
