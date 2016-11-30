/*
 * 작성자 : 이용재
 * 
 * 날짜 : 2016.03.31
 * 
 * 클래스  
 * public class ParcelAtDao: DB내 PARCELAT 테이블 접근하는 메소드들을 정의한다. (insert가 사용되었다.)
 * 
 * 
 */




package com.delivery.rocket.member.reservation.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

@Repository
public class ParcelAtDao {
	
	private static final String namespaces = "mapper.reservation";
	@Autowired
	SqlSessionTemplate template;
	
	
	public void insert(ReservationDto reservationDto){
		this.template.insert(namespaces+".insertparcelat",reservationDto);
	}
/*
	public boolean insert(ReservationCommand reservationCommand){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isSuccess = false;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			String sql = "insert into PARCELAT VALUES (?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, reservationCommand.getParcelat_id());
			preparedStatement.setString(2, reservationCommand.getP_id());
			preparedStatement.setString(3, reservationCommand.getF_id());
			preparedStatement.executeUpdate();
			
			isSuccess = true;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try{preparedStatement.close();
				connection.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		return isSuccess;
	}
*/
}
