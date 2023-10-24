package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
		
	}
	//�� ���� ��� �޼���
	public double calculateTotalPrice(List<ProductDTO> products) {
		double  totalPrice = 0;
		//���� for���� �̿��Ͽ� ������ ������ ���̱� ������ totalPrice = 0 ���� ����
		for(ProductDTO totalp : products) {
			totalPrice += totalp.getPrice();
		}
		return totalPrice;
	}
	
	//��� ��ǰ ����Ʈ
	
	public List<ProductDTO> getAllProducts() {
		return dao.getAllProducts();
	}
}
