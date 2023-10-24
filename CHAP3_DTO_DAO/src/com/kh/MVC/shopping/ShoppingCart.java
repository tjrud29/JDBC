package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
//ArrayList
		private List <ProductDTO> cartList;
		
		//����īƮ ������
		public ShoppingCart() {
			cartList = new ArrayList<>();
		}
		
		//��ٱ��Ͽ� �߰��� �޼��� ����
		public void addCart(ProductDTO product) {
			cartList.add(product);
			System.out.println(product.getProduct_name() + "��ٱ����߰��Ϸ�");
		}
		
		//��ٱ��Ͽ��� ��ǰ�� ���� �� �޼��� ����
		public void removeGoods(ProductDTO product) {
			if(cartList.remove(product)) {
				System.out.println("��ٱ��Ͽ��� �����߽��ϴ�.");
			} else {
				System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
			}
			
		}
		
}
