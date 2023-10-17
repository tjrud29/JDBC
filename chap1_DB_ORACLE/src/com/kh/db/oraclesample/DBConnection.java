package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		
		// 1.드라이버 연결 : Oracle JDBC  드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
				//2.오라클 내 컴퓨터 연결
				//                              나의 ip주소 : port번호
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "kh1016";
				String password = "kh1016";
				Connection con = null;
				try {
					//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
					con = DriverManager.getConnection(url,user,password);
					System.out.println("데이터 베이스 연결 성공!!!!!!!!!!!!!!!!");
					
					//select 쿼리 
					String selectQuery = "SELECT * FROM BANK";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
					//result.next() : result 객체에서 다음 행(row)으로 이동
					//다음 행이 있으면 true반환,그렇지 않으면 false반환
					while(result.next()) {
						//					khbank에 있는 bank테이블결과집합에서 account_id를 가져옴
						int accountID = result.getInt("account_id");
						String accountName = result.getString("account_name");
						double balance = result.getDouble("balance");
						String accountNumber = result.getString("account_number");
						String branchName = result.getString("branch_name");
						
						
						 
						System.out.println("Account_ID :  " + accountID);
						System.out.println("Account_name :  " + accountName);
						System.out.println("balance :  " + balance);
						System.out.println("account_number :" + accountNumber);
						System.out.println("branch :" + branchName);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
