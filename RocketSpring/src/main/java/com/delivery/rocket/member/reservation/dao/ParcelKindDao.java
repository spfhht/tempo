package com.delivery.rocket.member.reservation.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

@Repository
public class ParcelKindDao {
	private static final String namespaces = "mapper.reservation";
	@Autowired
	SqlSessionTemplate template;
	
	
	public List<ReservationDto> select(){
		return this.template.selectList(namespaces+".pkindselect");
	}
	
	
/*
	public ArrayList<ReservationCommand> select() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ReservationCommand reservationCommand = null;
		ArrayList<ReservationCommand> p_kind_List = new ArrayList<ReservationCommand>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			String sql = "SELECT * FROM parcels_kind ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				reservationCommand = new ReservationCommand();
				reservationCommand.setP_kind_id(resultSet.getString("p_kind_id"));
				reservationCommand.setP_kind_name(resultSet.getString("p_kind_name"));
				p_kind_List.add(reservationCommand);
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
		return p_kind_List;
	}*/
}
