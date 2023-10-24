package com.kh.MVC.orders;

import java.util.List;

public class OrderView {
	
	public void showOrderList(List<OrdersDTO> orders) {
		for(OrdersDTO o : orders) {
			System.out.println("주문 순서 : " + o.getCafe_id());
			System.out.println("가격 :" +  o.getTotal_price());
			System.out.println("==================================");
		}
	}
	
	public void showOrderTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}
