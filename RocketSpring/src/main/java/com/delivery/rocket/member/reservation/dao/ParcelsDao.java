/*
 * 작성자 : 이용재
 * 
 * 날짜 : 2016.03.31
 * 
 * 클래스  
 * public class ParcelsDao: DB내 PARCELS 테이블 접근하는 메소드들을 정의한다. (insert가 사용되었다.)
 * 
 * 
 */


package com.delivery.rocket.member.reservation.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

@Repository
public class ParcelsDao {
	
	
	private static final String namespaces = "mapper.reservation";
	@Autowired
	SqlSessionTemplate template;
	
	
	public void insert(ReservationDto reservationDto){
		this.template.insert(namespaces+".insertparcels",reservationDto);
	}

/*	public boolean insert(ReservationCommand reservationCommand){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isSuccess = false;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			String sql = "insert into PARCELS VALUES(?,?,?,?,?,?,?,?,?,sysdate,null)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, reservationCommand.getP_id());
			preparedStatement.setString(2, reservationCommand.getP_isfragile());
			preparedStatement.setString(3, reservationCommand.getP_s_address());
			preparedStatement.setString(4, reservationCommand.getP_r_address());
			preparedStatement.setString(5, reservationCommand.getP_s_name());
			preparedStatement.setString(6, reservationCommand.getP_r_name());
			preparedStatement.setString(7, reservationCommand.getP_s_tel());
			preparedStatement.setString(8, reservationCommand.getP_r_tel());
			preparedStatement.setString(9, reservationCommand.getP_kind_id());
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
