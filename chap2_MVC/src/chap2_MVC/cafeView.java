package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
	
	
	
//String name,String address,String phone_number,String operationg_hours
	public void addCafeName() {   
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���");
		System.out.println("��ȣ�� : ");
		String name = sc.nextLine();
		
		System.out.println("ī�� �ּ� :");
		String adress =  sc.nextLine();
		
		System.out.println("ī�� ��ȭ��ȣ :");
		String phone_number = sc.nextLine();
		
		System.out.println("ī�� � �ð� : ");
		String operationgHours = sc.nextLine();
		
		//ī�� �𵨿��� insertCafe ��� �޼��带 ������ �;���
		
		model.insertCafe(name, adress, phone_number, operationgHours);
		System.out.println("insertcafe�� �������� �Ϸ�");
		
	}
	
	public void updateCafesView() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ID�� �Է� �� ��ð��� ������Ʈ �ϼ���.");
		
		System.out.println("ī�� ID : ");
		int cafeid = sc.nextInt();
		
		System.out.println("ī�� � �ð� : ");
		String operationghours = sc.next();
		
		
		
		
		
		
		//model�� �ִ� updatemenu�� ������ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		
		model.updateCafesModel(operationghours, cafeid);
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�.");
		
		
	}
	
	public void deleteCafe() {   
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.println("������ ī���� ID�� �Է��ϼ���");
		int cafeId = Integer.parseInt(sc.nextLine());
		int cafeId_other = sc.nextInt();
		
		model.deleteCafe(cafeId_other);
		System.out.println("ī�� ���� �Ϸ�");
		
		
	}
	
	public void deleteMenu() { 
		System.out.println("������ �޴��� id�� �Է��ϼ���.");
		
		Scanner sc = new Scanner(System.in);
		int menuid = sc.nextInt();
		
		model.deleteMenu(menuid);
	}
	
	
	
	
	
}
