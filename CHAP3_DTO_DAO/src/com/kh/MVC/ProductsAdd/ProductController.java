package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
		
	}
	//총 가격 계산 메서드
	public double calculateTotalPrice(List<ProductDTO> products) {
		double  totalPrice = 0;
		//향상된 for문을 이용하여 가격을 더해줄 것이기 때문에 totalPrice = 0 으로 설정
		for(ProductDTO totalp : products) {
			totalPrice += totalp.getPrice();
		}
		return totalPrice;
	}
	
	//모든 제품 리스트
	
	public List<ProductDTO> getAllProducts() {
		return dao.getAllProducts();
	}
}
