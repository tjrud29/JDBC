package com.kh.VODAO.user;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		um.selectScanner();
	}
	
	public void selectScanner() {
		//1. DB ���� URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe1";
		String dbPassWord = "khcafe1";
		
		try {
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("User ID �Է����ּ���.");
			System.out.println("�����ϰ�ʹٸ� Ư������ ���� [e] �Է�");
			String input = sc.nextLine();
			
			//���࿡ e�� �Է��ߴٸ�
			//if("e"==input || "E" == input) {
			if("e".equalsIgnoreCase(input)) {
				System.out.println("�����ϰڽ��ϴ�.");
				break; 
				//break�� ������ ������� ���� �����ϰڽ��ϴ� �� ��µ�
			}
			
			
			int userId = Integer.parseInt(input);
			//select �� ����ϱ� 
			String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
			PreparedStatement st = cc.prepareCall(sql);
			st.setInt(1, userId);
			
			ResultSet rs = st.executeQuery();
			
			//selectOne if
			if(rs.next()) {
				System.out.println("user ID" + rs.getInt("user_id"));
				System.out.println("userName :" + rs.getString("username"));
				System.out.println("EMAIL : " + rs.getString("email"));
				System.out.println("Registration Date" + rs.getString("reg_Date"));
				
			}else {
				System.out.println("user�� ã�� �� �����ϴ�.");
			}
			
		

		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	public void selectAll() {
		//1. DB ���� URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			
			List<UserVO> users = userDAO.getAllUsers();
			
			for(UserVO u : users) {
			System.out.println("User ID : " + u.getUserId());
			System.out.println("User Name : " + u.getUserName());
			System.out.println("User Email : " + u.getEmail());
			System.out.println("Registration Date : "+u.getRegDate());
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertRun() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			
			System.out.println("���̵� �Է� ���ּ��� : ");
			String userName = sc.next();
			
			System.out.println("ȸ�������� ���Ǵ� �������ϴ�.");
			System.out.println("���������� �̸��� �ۼ����ּ���. : ");
			String email = sc.next();
			
			Date regDate = new Date(); //���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			
			//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ������ Ȯ�� boolean�� ����ؼ� Ȯ��
			if(userDao.createUser(newUser)) { //true
				System.out.println("������ ���������� ��ϵǾ����ϴ�.");
			} else {						  //false
				System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
			}
			
			//���� �ݱ�
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}