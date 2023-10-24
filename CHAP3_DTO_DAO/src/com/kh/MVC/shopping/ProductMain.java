package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;

import com.kh.MVC.ProductsAdd.ProductDTO;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view= new ProductView();
		List<ProductDTO> products = controller.getAllProducts();
		
		Scanner sc = new Scanner(System.in);
		
		//���� īƮ �ν��Ͻ� �����ڸ�
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		
		
		switch(choice) {
		case 1 :
		
		//��� ��ǰ ����Ʈ ���������
		//List<ProductDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		case 2 :
		//�������� ��� ��������
		double totalPrice = controller.calculateTotalPrice(products);
		view.showTotalPrice(totalPrice);
		
		case 3:
		// ��ǰ �߰�
			System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� id�� �Է��ϼ��� :");
			//��ǰ ���̵� �Է¹ޱ�
			int productId = sc.nextInt();
			//���� for���� if���� Ȱ���ؼ� ��ǰ ���
			for(ProductDTO p : products) {
				if(p.getProduct_id() == productId) {
					//īƮ�� �߰�
					System.out.println(p.getProduct_name() + "��ٱ��Ͽ� ��ҽ��ϴ�.");
					break;
				}
				
			}
		
			
		case 4 :
			//����
			System.out.println("��ٱ��Ͽ��� ���� �� ��ǰ�� id�� �Է��ϼ���. :");
			int removeProductId = sc.nextInt();
			for(ProductDTO : /*��ٱ��� ��� */)
			
			
		case 5 : 
			//����
			
			default : 
				System.out.println("�߸��� �����Դϴ�.");
	}
		
	}

}
