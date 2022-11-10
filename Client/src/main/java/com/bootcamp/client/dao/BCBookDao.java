package com.bootcamp.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bootcamp.dto.regcampDto;



	public class BCBookDao {
	
			DataSource dataSource;
		
		public BCBookDao() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/camping");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
	
	// View							// 여기서 받아오는 이름이 밑에서 쓸 변수랑 같으면 안댐, 에러남 그래서 강사님이 sbId라고 받아왔음 
	public regcampDto DetailView(String reSeq) { // 데이터가 1개뿐이라 dto에 담아서 가지고 와서 보여줄 거임 
		regcampDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; // 이거 쓸꺼면 ? 써도 댐 
		ResultSet resultSet = null;
		System.out.println("dao DetailView 안의 syso reSeq ="+reSeq);
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from regcamp where regSeq = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(reSeq));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int regSeq = resultSet.getInt("regSeq");   // 위에 * 적은게 DB안에 꺼 다 적으면 가능함 .
				String regTel = resultSet.getString("regTel");
				String regDetailaddress = resultSet.getString("regDetailaddress");
				String regName = resultSet.getString("regName");
				Timestamp regDate = resultSet.getTimestamp("regDate");
				Timestamp regMdate = resultSet.getTimestamp("regMdate");
				Timestamp regDdate = resultSet.getTimestamp("regDdate");
				String regSummary = resultSet.getString("regSummary");
				String regCategory = resultSet.getString("regCategory");
				String regImage1 = resultSet.getString("regImage1");
				String regImage2 = resultSet.getString("regImage2");
				String regImage3 = resultSet.getString("regImage3");
				String regImage4 = resultSet.getString("regImage4");
				int host_hSeq = resultSet.getInt("host_hSeq");
				System.out.println(regSummary);										/* ,<<<<<<<<<<<<<<<<<<<<<<< 8 */
				 dto = new regcampDto(regSeq,regTel,regDetailaddress,regName,regDate,regMdate,regDdate,regSummary,regCategory,regImage1,regImage2,regImage3,regImage4,host_hSeq);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
		
		
		
		// CheckBook  예약한 정보를 불러올꺼임 			// 여기서 받아오는 이름이 밑에서 쓸 변수랑 같으면 안댐, 에러남 그래서 강사님이 sbId라고 받아왔음 
//		public bookDto checkBook(String rbookSeq) { // 데이터가 1개뿐이라 dto에 담아서 가지고 와서 보여줄 거임 
//			bookDto dto = null;
//			Connection connection = null;
//			PreparedStatement preparedStatement = null; // 이거 쓸꺼면 ? 써도 댐 
//			ResultSet resultSet = null;
//			
//			try {
//				connection = dataSource.getConnection();
//				
//				String query = "select * from book where boSeq = ?";
//				preparedStatement = connection.prepareStatement(query);
//				preparedStatement.setInt(1, Integer.parseInt(rbookSeq));
//				resultSet = preparedStatement.executeQuery();
//
//				
//				if(resultSet.next()) {
//					int boSeq = resultSet.getInt("boSeq");   // 위에 * 적은게 DB안에 꺼 다 적으면 가능함 .
//					int boPrice = resultSet.getInt("boPrice");
//					Timestamp boDate = resultSet.getTimestamp("boDate");
//					Timestamp boCheckindate = resultSet.getTimestamp("boCheckindate");
//					Timestamp boCheckoutdate = resultSet.getTimestamp("boCheckoutdate");
//					int boCount = resultSet.getInt("boCount");
//					Timestamp boCanceldate = resultSet.getTimestamp("boCanceldate");
//					int client_cId = resultSet.getInt("client_cId");
//					int room_roSeq = resultSet.getInt("room_roSeq");
//					int room_regcamp_regSeq = resultSet.getInt("room_regcamp_regSeq");
//					int room_regcamp_host_hSeq = resultSet.getInt("room_regcamp_host_hSeq");
//					int pay_cid = resultSet.getInt("pay_cid");
//					 dto = new bookDto(boSeq, boPrice, boDate, boCheckindate, boCheckoutdate,boCount,boCanceldate,client_cId,room_roSeq,room_regcamp_regSeq,room_regcamp_host_hSeq,pay_cid);
//				}
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(resultSet != null) resultSet.close();
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//			return dto;
//
//	}//contentView End
	
	
}//BDao End
