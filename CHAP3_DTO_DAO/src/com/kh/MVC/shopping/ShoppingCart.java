package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
//ArrayList
		private List <ProductDTO> cartList;
		
		//쇼핑카트 생성자
		public ShoppingCart() {
			cartList = new ArrayList<>();
		}
		
		//장바구니에 추가할 메서드 생성
		public void addCart(ProductDTO product) {
			cartList.add(product);
			System.out.println(product.getProduct_name() + "장바구니추가완료");
		}
		
		//장바구니에서 물품을 제거 할 메서드 생성
		public void removeGoods(ProductDTO product) {
			if(cartList.remove(product)) {
				System.out.println("장바구니에서 제거했습니다.");
			} else {
				System.out.println("장바구니에 해당 제품이 없습니다.");
			}
			
		}
		
}
