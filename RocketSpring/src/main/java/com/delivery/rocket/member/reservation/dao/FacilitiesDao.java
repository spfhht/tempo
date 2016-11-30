/*
 * 작성자 : 이용재
 * 
 * 날짜 : 2016.03.31
 * 
 * 클래스  
 * public class FacilitiesDao : DB내 FACILITIES 테이블 접근하는 메소드들을 정의한다. (select가 사용되었다.)
 * 
 * 
 */


package com.delivery.rocket.member.reservation.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

@Repository
public class FacilitiesDao {
	
	private static final String namespaces = "mapper.reservation";
	@Autowired
	SqlSessionTemplate template;
	
	
	public List<ReservationDto> select(ReservationDto reservationDto){
		return this.template.selectList(namespaces+".facselect",reservationDto);
	}
	
	
/*
	public ArrayList<ReservationCommand> select(String keyword) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ReservationCommand reservationCommand = null;
		ArrayList<ReservationCommand> facList = new ArrayList<ReservationCommand>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			String sql = "SELECT f.f_id,f.f_name,f.f_address,f.f_tel,f.f_gps,fk.f_kind_name,cm.manager_id,cm.manager_name FROM facilities f,facility_kind fk,corp_manager cm Where f.f_kind_id=fk.f_kind_id and f.manager_id = cm.manager_id and f.f_address like '%"+keyword+"%' ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				reservationCommand = new ReservationCommand();
				reservationCommand.setManager_id(resultSet.getString("manager_id"));
				reservationCommand.setF_id(resultSet.getString("f_id"));
				reservationCommand.setF_name(resultSet.getString("f_name"));
				reservationCommand.setF_address(resultSet.getString("f_address"));
				reservationCommand.setF_tel(resultSet.getString("f_tel"));
				reservationCommand.setF_gps(resultSet.getString("f_gps"));
				reservationCommand.setF_kind_name(resultSet.getString("f_kind_name"));
				reservationCommand.setManager_name(resultSet.getString("manager_name"));
				facList.add(reservationCommand);
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
		return facList;
	}*/
}
