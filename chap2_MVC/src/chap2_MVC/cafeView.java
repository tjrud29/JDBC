package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel 이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model = model;
	}
	
	
	
//String name,String address,String phone_number,String operationg_hours
	public void addCafeName() {   
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요");
		System.out.println("상호명 : ");
		String name = sc.nextLine();
		
		System.out.println("카페 주소 :");
		String adress =  sc.nextLine();
		
		System.out.println("카페 전화번호 :");
		String phone_number = sc.nextLine();
		
		System.out.println("카페 운영 시간 : ");
		String operationgHours = sc.nextLine();
		
		//카페 모델에서 insertCafe 라는 메서드를 가지고 와야함
		
		model.insertCafe(name, adress, phone_number, operationgHours);
		System.out.println("insertcafe문 가져오기 완료");
		
	}
	
	public void updateCafesView() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 ID를 입력 후 운영시간을 업데이트 하세요.");
		
		System.out.println("카페 ID : ");
		int cafeid = sc.nextInt();
		
		System.out.println("카페 운영 시간 : ");
		String operationghours = sc.next();
		
		
		
		
		
		
		//model에 있는 updatemenu를 가지고와서 사용자가 작성한 수정 내용 추가하기
		
		model.updateCafesModel(operationghours, cafeid);
		System.out.println("메뉴 설명이 업데이트 되었습니다.");
		
		
	}
	
	public void deleteCafe() {   
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하겠습니다.");
		System.out.println("삭제할 카페의 ID를 입력하세요");
		int cafeId = Integer.parseInt(sc.nextLine());
		int cafeId_other = sc.nextInt();
		
		model.deleteCafe(cafeId_other);
		System.out.println("카페 삭제 완료");
		
		
	}
	
	public void deleteMenu() { 
		System.out.println("삭제할 메뉴의 id를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		int menuid = sc.nextInt();
		
		model.deleteMenu(menuid);
	}
	
	
	
	
	
}
