package com.delivery.rocket.corp.managermanagement.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.corp.managermanagement.dto.ManagerManagementDto;

@Repository
public class ManagerManagementDao {

	private static final String namespaces = "mapper.manager";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public void insert(ManagerManagementDto dto) {
		template.insert(namespaces + ".managerinsert", dto);
	}

	public void update(ManagerManagementDto dto) {
		template.update(namespaces + ".managerupdate", dto);
	}

	public List<ManagerManagementDto> list(ManagerManagementDto dto) {
		return template.selectList(namespaces + ".managerlist", dto);
	}

	public void delete(ManagerManagementDto dto) {
		template.delete(namespaces + ".managerdelete", dto);
	}
}
