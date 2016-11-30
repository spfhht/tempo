package com.delivery.rocket.member.deliverycheck.dto;

import java.util.Date;

public class DeliveryCheckDto {
	private String delivery_id; // 수화물 관리 - 운송장 번호
	private String del_state_id; // 수화물 관리 - 배송 상태 id
	private String delivery_state; // 배송 상태 - 배송 상태(한글)
	private String f_id; // 시설물 - 시설물 id
	private String f_name; // 시설물 - 시설물 이름
	private String f_gps; // 시설물 - 시설물 위치정보
	private String p_id; // 수화물 - 수화물 분류 번호
	private String p_s_name; // 수화물 - 보내는 이 이름
	private String p_s_address; // 수화물 - 보내는 이 주소
	private String p_r_name; // 수화물 - 받는 이 이름
	private String p_r_address; // 수화물 - 받는 이 주소
	private String m_name; // 멤버 - 이름
	private String m_id; // 멤버 - 아이디
	private String p_kind_name; // 수화물종류 - 수화물 종류이름
	private Date p_s_date; // 수화물 - 수화물 배송 날짜
	private Date p_r_date; // 수화물 - 수화물 도착 날짜

	public String getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
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

	public String getF_gps() {
		return f_gps;
	}

	public void setF_gps(String f_gps) {
		this.f_gps = f_gps;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_s_name() {
		return p_s_name;
	}

	public void setP_s_name(String p_s_name) {
		this.p_s_name = p_s_name;
	}

	public String getP_s_address() {
		return p_s_address;
	}

	public void setP_s_address(String p_s_address) {
		this.p_s_address = p_s_address;
	}

	public String getP_r_name() {
		return p_r_name;
	}

	public void setP_r_name(String p_r_name) {
		this.p_r_name = p_r_name;
	}

	public String getP_r_address() {
		return p_r_address;
	}

	public void setP_r_address(String p_r_address) {
		this.p_r_address = p_r_address;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getP_kind_name() {
		return p_kind_name;
	}

	public void setP_kind_name(String p_kind_name) {
		this.p_kind_name = p_kind_name;
	}

	public Date getP_s_date() {
		return p_s_date;
	}

	public void setP_s_date(Date p_s_date) {
		this.p_s_date = p_s_date;
	}

	public Date getP_r_date() {
		return p_r_date;
	}

	public void setP_r_date(Date p_r_date) {
		this.p_r_date = p_r_date;
	}

	@Override
	public String toString() {
		return "DeliveryCheckDto [delivery_id=" + delivery_id + ", del_state_id=" + del_state_id + ", delivery_state="
				+ delivery_state + ", f_id=" + f_id + ", f_name=" + f_name + ", f_gps=" + f_gps + ", p_id=" + p_id
				+ ", p_s_name=" + p_s_name + ", p_s_address=" + p_s_address + ", p_r_name=" + p_r_name
				+ ", p_r_address=" + p_r_address + ", m_name=" + m_name + ", m_id=" + m_id + ", p_kind_name="
				+ p_kind_name + ", p_s_date=" + p_s_date + ", p_r_date=" + p_r_date + "]";
	}

}