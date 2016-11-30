package com.delivery.rocket.member.reservation.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

@Repository
public class CorpDao {
	private static final String namespaces = "mapper.reservation";
	@Autowired
	SqlSessionTemplate template;
	
	
	public List<ReservationDto> select(){
		return this.template.selectList(namespaces+".corpselect");
	}
	
/*	
	
	public void myInfoUpdate(InfoDto infoDto){
		template.update(namespaces+".myinfoupdate",infoDto);
	}
	public void pwdUpdate(InfoDto infoDto){
		template.update(namespaces+".pwdchange",infoDto);
	}
	public void delete(InfoDto infoDto){
		template.delete(namespaces+".delete", infoDto);
	}
	*/
/*
	
	public ArrayList<ReservationCommand> select() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ReservationCommand reservationCommand = null;
		ArrayList<ReservationCommand> corpList = new ArrayList<ReservationCommand>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			String sql = "SELECT c_id,c_name FROM corp ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				reservationCommand = new ReservationCommand();
				reservationCommand.setC_id(resultSet.getString("c_id"));
				reservationCommand.setC_name(resultSet.getString("c_name"));
				corpList.add(reservationCommand);
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
		return corpList;
	}*/
}
