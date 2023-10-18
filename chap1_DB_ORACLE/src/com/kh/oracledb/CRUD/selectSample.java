package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.crypto.Data;

public class selectSample {

	public static void main(String[] args) { 

		SelectALL();
		
	}
	static void SelectALL() { 
		// 1.����̹� ���� : Oracle JDBC  �夷�����̹� Ŭ���� �̸�
				String driver = "oracle.jdbc.driver.OracleDriver";
						//2.����Ŭ �� ��ǻ�� ����
						//                              ���� ip�ּ� : port��ȣ
						String url = "jdbc:oracle:thin:@localhost:1521:xe";
						String user = "kh1016";
						String password = "kh1016";
						Connection con = null;
						try {
							//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
							con = DriverManager.getConnection(url,user,password);
							System.out.println("������ ���̽� ���� ����!!!!!!!!!!!!!!!!");
							
							//select ���� 
							String selectQuery = "SELECT * FROM BANK";
							PreparedStatement selectState = con.prepareStatement(selectQuery);
							ResultSet result = selectState.executeQuery();
							//result.next() : result ��ü���� ���� ��(row)���� �̵�
							//���� ���� ������ true��ȯ,�׷��� ������ false��ȯ
							while(result.next()) {
								//					khbank�� �ִ� bank���̺�������տ��� account_id�� ������
								int accountID = result.getInt("account_id");
								String accountName = result.getString("account_name");
								double balance = result.getDouble("balance");
								String accountNumber = result.getString("account_number");
								String branchName = result.getString("branch_name");
								Date lata =  result.getDate("LAST_TRANSACTION_DATE");
								
								 
								System.out.print("Account_ID :  " + accountID);
								System.out.print("Account_name :  " + accountName);
								System.out.print("balance :  " + balance);
								System.out.print("account_number :" + accountNumber);
								System.out.print("branch :" + branchName);
								System.out.println("LAST_TRANSACTION_DATE" + lata)	;
								
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

	}
	static void selectone() {   
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe1";
		String password = "khcafe1";
		
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���� ����!!!");
			
			String selectquery = "select * from menu";
			
			PreparedStatement selectState = con.prepareStatement(selectquery);
				
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				
				
			int menuid = result.getInt("menu_id");
			int cafeid = result.getInt("cafe_id");
			String menuname = result.getString("menu_name");
			int price = result.getInt("price");
			String description = result.getString("description");
				
			
			
			System.out.print("menu_id :" + menuid);
			System.out.print("cafe_id :" + cafeid );
			System.out.print("menu_name :" + menuname);
			System.out.print("price : " + price );
			System.out.println("description : " + description);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void selectIf() { 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh1016";
		String password = "kh1016";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where �� �߰��Ͽ� ���� �߰�
			String selectQuery = "SELECT * FROM bank WHERE account_number = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			//���⿡ ���ϴ� ������ account_id ����
			int targetAID =1;
			
			//���� ����
			String[] targerAN = {"1234567890","5555666777"};
			selectState.setString(1, targerAN[0]); //���� ���ڴ� ���� ������. 
			
			
			
			ResultSet result = selectState.executeQuery();
			
			if(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				int d = result.getInt("balance");
				String e = result.getString("branch_name");
			
				
				
				
				System.out.println("account_id :" + a);
				System.out.println("account_number :" + b);
				System.out.println("account_name :" + c);
				System.out.println("balance :" + d);
				System.out.println("branch_name :" + e);
				
				
				
			}else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

	