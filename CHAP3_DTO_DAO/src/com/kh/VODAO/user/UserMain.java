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
	//boolean idTrue = checkId(userId);
	public boolean checkEmail(String userEmail) throws SQLException {
		//1. DB����
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe1";
		String dbPassWord = "khcafe1";
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		
		String sql = "SELECT COUNT(*) FROM USERINFO WHERE email = ?";
		PreparedStatement st = cc.prepareStatement(sql);
		st.setString(1, userEmail);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			int count = rs.getInt(1);
			return count > 0; //1�̻��̸� true
		}
		return false;
	}
	
	public boolean checkId(int userId) throws SQLException {
		//1. DB����
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe1";
		String dbPassWord = "khcafe1";
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		//2. SQL
		String sql = "Select * From USERINFO where user_id = ?";
		
		PreparedStatement st = cc.prepareStatement(sql);
		st.setInt(1, userId);
		//3. IFȰ���ؼ� Result.next()
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			return id >0; //�̻��̸� true
		}
		//     return >0 1�̻��̸� ��ġ
		
		return false; //��ġ���� ���� ��
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
			
			System.out.println("�̸����� �Է����ּ���. : ");
			String userEmail = sc.nextLine();// scȰ��
			
			//select �� ����ϱ� 
			String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND email = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setInt(1, userId);
			st.setString(2, userEmail);
			ResultSet rs = st.executeQuery();
			
			//selectOne if
			if(rs.next()) {
				System.out.println("user ID   : " + rs.getInt("user_id"));
				System.out.println("UserName  : " + rs.getString("username"));
				System.out.println("E M A I L : " + rs.getString("email"));
				System.out.println("Registration Date : " + rs.getDate("reg_date"));
				System.out.println();
			} else {
				//boolean ID or Email �ϳ��� ��ġ���� �ʴ� ��� ó��
				boolean idTrue = checkId(userId);
				boolean emailTrue = checkEmail(userEmail);
				 if(!idTrue && emailTrue) {
					 System.out.println("��ġ���� �ʴ� User ID �Դϴ�.");
					 System.out.println();
				 } else if (idTrue && !emailTrue) {
					 System.out.println("��ġ���� �ʴ� User Email �Դϴ�.");
					 System.out.println();
				 } else {
						System.out.println("��ġ�ϴ� User Id�� email�� ã�� �� �����ϴ�.");
						System.out.println();
				 }

			}
			
			
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	public void selectAll() {
		//1. DB ���� URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe1";
		String dbPassWord = "khcafe1";
		
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
		String dbUserName = "khcafe1";
		String dbPassWord = "khcafe1";
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