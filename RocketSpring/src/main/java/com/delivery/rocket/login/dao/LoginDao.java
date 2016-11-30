package com.delivery.rocket.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.login.dto.LoginDto;

@Repository
public class LoginDao {
	private static final String namespaces = "mapper.login";
	@Autowired
	SqlSessionTemplate template;
	public SqlSessionTemplate getTemplate() {
		return template;
	}
	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	public LoginDto userLogin(LoginDto loginDto){
		return template.selectOne(namespaces+".userlogin",loginDto);
	}
	public LoginDto corpLogin(LoginDto loginDto){
		return template.selectOne(namespaces+".corplogin",loginDto);
	}
	public LoginDto corpManagerLogin(LoginDto loginDto){
		return template.selectOne(namespaces+".corpmanagerlogin",loginDto);
	}
}
