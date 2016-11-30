package com.delivery.rocket.member.reservation.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

@Repository
public class CorpManagerDao {
	private static final String namespaces = "mapper.reservation";
	@Autowired
	SqlSessionTemplate template;
	
	
	public ReservationDto select(ReservationDto reservationDto){
		return this.template.selectOne(namespaces+".corpmanagerselect",reservationDto);
	}
	
	
	/*
	public String select(String f_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String manager_id=null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			String sql = "SELECT manager_id FROM facilities  WHERE f_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, f_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				manager_id=resultSet.getString("manager_id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try{
			resultSet.close();
			preparedStatement.close();
			connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return manager_id;
	}
*/
}
