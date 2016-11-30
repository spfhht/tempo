package com.delivery.rocket.checkoffice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.checkoffice.dto.OfficeDto;

@Repository
public class CheckofficeDao {
	private static final String namespace = "mapper.officecheck";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	public List<OfficeDto> checkOffice(OfficeDto officeDto){
		officeDto.setC_id("%"+officeDto.getC_id()+"%");
		return this.template.selectList(namespace+".selectAll", officeDto);//mapper.check.selectAll
		
	}
	public List<OfficeDto> select(){
		List<OfficeDto> officeList = template.selectList(namespace+".select");//mapper.check.select
		return officeList;
	}
	
	public OfficeDto checkofficef_id(OfficeDto officeDto){
		return this.template.selectOne(namespace+".select2",officeDto);
	}
	 
	// public ArrayList<OfficeDto> checkoffice(String c_id) {
	// OfficeDto officeDto ;
	// ArrayList<OfficeDto> checkarrayList = new ArrayList<OfficeDto>();
	// Connection connection = null;
	// PreparedStatement preparedStatement = null;
	// ResultSet resultSet = null;
	// try {
	// Context context = new InitialContext();
	// DataSource dataSource = (DataSource)
	// context.lookup("java:comp/env/jdbc/OracleDB");
	// connection = dataSource.getConnection();
	// String sql = "select
	// c.C_NAME,cm.MANAGER_NAME,f.F_NAME,f.F_ADDRESS,f.F_TEL, c.C_ID,f.F_ID,
	// f.F_GPS from CORP c,CORP_MANAGER cm,FACILITIES f ";
	// sql += " where c.C_ID=cm.C_ID and cm.MANAGER_ID=f.MANAGER_ID and c.C_ID
	// like ?";
	//
	// preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setString(1, "%" + c_id + "%");
	// resultSet = preparedStatement.executeQuery();
	//
	// while (resultSet.next()) {
	// officeCommand = new OfficeCommand();
	// officeCommand.setC_name(resultSet.getString("C_name"));
	// officeCommand.setManager_name(resultSet.getString("Manager_name"));
	// officeCommand.setF_name(resultSet.getString("F_name"));
	// officeCommand.setF_address(resultSet.getString("F_address"));
	// officeCommand.setF_tel(resultSet.getString("F_tel"));
	// officeCommand.setC_id(resultSet.getString("C_ID"));
	// officeCommand.setF_id(resultSet.getString("F_ID"));
	// officeCommand.setF_gps(resultSet.getString("F_GPS"));
	// checkarrayList.add(officeCommand);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return checkarrayList;
	// }
	//
	// public ArrayList<OfficeCommand> checkofficef_id(String c_id, String f_id)
	// {
	// OfficeCommand officeCommand;
	// ArrayList<OfficeCommand> checkarrayList = new ArrayList<OfficeCommand>();
	// Connection connection = null;
	// PreparedStatement preparedStatement = null;
	// ResultSet resultSet = null;
	// try {
	// Context context = new InitialContext();
	// DataSource dataSource = (DataSource)
	// context.lookup("java:comp/env/jdbc/OracleDB");
	// connection = dataSource.getConnection();
	//
	// String sql = "select
	// c.C_NAME,cm.MANAGER_NAME,f.F_NAME,f.F_ADDRESS,f.F_TEL, c.C_ID,f.F_ID,
	// f.F_GPS from CORP c,CORP_MANAGER cm,FACILITIES f ";
	// sql += " where c.C_ID=cm.C_ID and cm.MANAGER_ID=f.MANAGER_ID and c.C_ID
	// like ? and f.f_id=? ";
	//
	// preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setString(1, "%" + c_id + "%");
	// preparedStatement.setString(2, f_id);
	// resultSet = preparedStatement.executeQuery();
	//
	// while (resultSet.next()) {
	// officeCommand = new OfficeCommand();
	// officeCommand.setC_name(resultSet.getString("C_name"));
	// officeCommand.setManager_name(resultSet.getString("Manager_name"));
	// officeCommand.setF_name(resultSet.getString("F_name"));
	// officeCommand.setF_address(resultSet.getString("F_address"));
	// officeCommand.setF_tel(resultSet.getString("F_tel"));
	// officeCommand.setC_id(resultSet.getString("C_ID"));
	// officeCommand.setF_id(resultSet.getString("F_ID"));
	// officeCommand.setF_gps(resultSet.getString("F_GPS"));
	// checkarrayList.add(officeCommand);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return checkarrayList;
	// }

}
