package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductView {
public void showProductList(List<ProductDTO> products) {
	for(ProductDTO p :products) {
		System.out.println("��ǰ�� :" + p.getProduct_name());
		System.out.println("���� : " + p.getPrice());
		System.out.println("=======================================");
	}
}

//��ǰ ���� ���� �޼���
	public void showTotalPrice(double totalPrice) {
		System.out.println(" �� ���� :" + totalPrice);
	}
}
