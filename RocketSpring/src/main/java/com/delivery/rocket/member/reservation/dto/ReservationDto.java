package com.delivery.rocket.member.reservation.dto;

public class ReservationDto {
	private String f_id = null;
	private String f_name= null;
	private String f_address= null;
	private String f_tel= null;
	private String f_gps= null;
	private String manager_id= null;
	private String manager_name = null;
	private String delivery_id = null;
	
	private String c_id = null;
	private String c_name = null;
	private String m_id= null;
	private String m_pwd= null;
	private String m_name = null;

	private String isMember= null;
	private String m_group= null;
	private String m_address= null;
	private String m_detail_address= null;
	private String m_tel= null;
	
	private String parcelat_id= null;
	private String p_id= null;
	private String del_state_id= null;
	private String delivery_state= null;
	private String p_isfragile= null;
	private String p_s_address= null;
	private String p_s_name= null;
	private String p_r_address= null;
	private String p_r_name= null;
	private String p_s_tel= null;
	private String p_r_tel= null;
	private String p_kind_id= null;
	private String p_kind_name= null;
	
	private String f_kind_id= null;
	private String f_kind_name= null;
	public String getF_kind_id() {
		return f_kind_id;
	}
	public void setF_kind_id(String f_kind_id) {
		this.f_kind_id = f_kind_id;
	}
	public String getF_kind_name() {
		return f_kind_name;
	}
	public void setF_kind_name(String f_kind_name) {
		this.f_kind_name = f_kind_name;
	}
	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}
	public String getDelivery_id() {
		return delivery_id;
	}

	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
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
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_address() {
		return f_address;
	}
	public void setF_address(String f_address) {
		this.f_address = f_address;
	}
	public String getF_tel() {
		return f_tel;
	}
	public void setF_tel(String f_tel) {
		this.f_tel = f_tel;
	}
	public String getF_gps() {
		return f_gps;
	}
	public void setF_gps(String f_gps) {
		this.f_gps = f_gps;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
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
	public String getIsMember() {
		return isMember;
	}
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}
	public String getM_group() {
		return m_group;
	}
	public void setM_group(String m_group) {
		this.m_group = m_group;
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
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getParcelat_id() {
		return parcelat_id;
	}
	public void setParcelat_id(String parcelat_id) {
		this.parcelat_id = parcelat_id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getDel_state_id() {
		return del_state_id;
	}
	public void setDel_state_id(String del_state_id) {
		this.del_state_id = del_state_id;
	}
	public String getDelivery_state() {
		return delivery_state;
	}
	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}
	public String getP_isfragile() {
		return p_isfragile;
	}
	public void setP_isfragile(String p_isfragile) {
		this.p_isfragile = p_isfragile;
	}
	public String getP_s_address() {
		return p_s_address;
	}
	public void setP_s_address(String p_s_address) {
		this.p_s_address = p_s_address;
	}
	public String getP_s_name() {
		return p_s_name;
	}
	public void setP_s_name(String p_s_name) {
		this.p_s_name = p_s_name;
	}
	public String getP_r_address() {
		return p_r_address;
	}
	public void setP_r_address(String p_r_address) {
		this.p_r_address = p_r_address;
	}
	public String getP_r_name() {
		return p_r_name;
	}
	public void setP_r_name(String p_r_name) {
		this.p_r_name = p_r_name;
	}
	public String getP_s_tel() {
		return p_s_tel;
	}
	public void setP_s_tel(String p_s_tel) {
		this.p_s_tel = p_s_tel;
	}
	public String getP_r_tel() {
		return p_r_tel;
	}
	public void setP_r_tel(String p_r_tel) {
		this.p_r_tel = p_r_tel;
	}
	public String getP_kind_id() {
		return p_kind_id;
	}
	public void setP_kind_id(String p_kind_id) {
		this.p_kind_id = p_kind_id;
	}
	public String getP_kind_name() {
		return p_kind_name;
	}
	public void setP_kind_name(String p_kind_name) {
		this.p_kind_name = p_kind_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
}
