package com.delivery.rocket.login.dto;

public class LoginDto {
	///////////////////유저////////////////////////
	private String m_name = null;
	private String m_tel = null;
	private String m_address = null;
	private String m_detail_address = null;
	private String m_birth = null;
	private String m_email = null;
	private String m_id = null;
	private String m_pwd = null;
	private String m_pwd2 = null;
	public String getM_pwd2() {
		return m_pwd2;
	}
	public void setM_pwd2(String m_pwd2) {
		this.m_pwd2 = m_pwd2;
	}
	private String m_group = null;
	private String ismember = null;
	private String corp = null;
	////////////////////////////////////////////////
	
	////////////////////회사/////////////////////////
	private String c_id;
	private String c_name;
	private String c_pwd;
	private String c_address;
	private String c_tel;
	////////////////////////////////////////////////
	
	////////////////회사 매니져//////////////////////////
	private String manager_id;
	private String manager_name;
	private String manager_pwd;
	/////////////////////////////////////////////////
	public String getM_name() {
		return m_name;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_pwd() {
		return c_pwd;
	}
	public void setC_pwd(String c_pwd) {
		this.c_pwd = c_pwd;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_pwd() {
		return manager_pwd;
	}
	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public String getM_detail_address() {
		return m_detail_address;
	}
	public void setM_detail_address(String m_detail_address) {
		this.m_detail_address = m_detail_address;
	}
	public String getM_birth() {
		return m_birth;
	}
	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_group() {
		return m_group;
	}
	public void setM_group(String m_group) {
		this.m_group = m_group;
	}
	public String getIsmember() {
		return ismember;
	}
	public void setIsmember(String ismember) {
		this.ismember = ismember;
	}
	public String getCorp() {
		return corp;
	}
	public void setCorp(String corp) {
		this.corp = corp;
	}
	
}
