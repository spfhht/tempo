package com.delivery.rocket.member.info.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.info.dto.InfoDto;

@Repository
public class InfoDao {
	private static final String namespaces = "mapper.info";
	@Autowired
	SqlSessionTemplate template;
/*	public SqlSessionTemplate getTemplate() {
		return template;
	}
	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}*/
	
	
	public void myInfoUpdate(InfoDto infoDto){
		template.update(namespaces+".myinfoupdate",infoDto);
	}
	public void pwdUpdate(InfoDto infoDto){
		template.update(namespaces+".pwdchange",infoDto);
	}
	public void delete(InfoDto infoDto){
		template.delete(namespaces+".delete", infoDto);
	}
	
/*	public LoginDto corpLogin(LoginDto loginDto){
		return template.selectOne(namespaces+".corplogin",loginDto);
	}
	public LoginDto corpManagerLogin(LoginDto loginDto){
		return template.selectOne(namespaces+".corpmanagerlogin",loginDto);
	}*/
}