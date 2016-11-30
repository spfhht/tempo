package com.delivery.rocket.member.join.dto;

public class MemberDto {
	private String m_name;
	private String m_tel;
	private String m_address;
	private String m_detail_address;
	private String m_birth; // 생년월일
	private String m_email;
	private String m_id;
	private String m_pwd;
	private String m_group;
	private String is_member;
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getM_name() {
		return m_name;
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

	public String getIs_member() {
		return is_member;
	}

	public void setIs_member(String is_member) {
		this.is_member = is_member;
	}

	@Override
	public String toString() {
		return "MemberDto [m_name=" + m_name + ", m_tel=" + m_tel + ", m_address=" + m_address + ", m_detail_address="
				+ m_detail_address + ", m_birth=" + m_birth + ", m_email=" + m_email + ", m_id=" + m_id + ", m_pwd="
				+ m_pwd + ", m_group=" + m_group + ", is_member=" + is_member + ", count=" + count + "]";
	}


}
