package com.delivery.rocket.admin.joincorp.dto;

import java.sql.Date;

public class JoinCorpDto {

	private int c_num; // 회사 번호
	private String c_name; // 택배회사 이름
	private String c_id; // 택배회사 아이디
	private String c_pwd; // 택배회사 비밀번호
	private String c_address; // 택배회사 주소
	private String c_tel; // 택배회사 전화번호
	private Date join_date;

	

	@Override
	public String toString() {
		return "JoinCorpDto [c_num=" + c_num + ", c_name=" + c_name + ", c_id=" + c_id + ", c_pwd=" + c_pwd
				+ ", c_address=" + c_address + ", c_tel=" + c_tel + ", join_date=" + join_date + ", read_count="
				+ read_count + "]";
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_Num(int c_num) {
		this.c_num = c_num;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	private int read_count;

	// *******************************************************

	public JoinCorpDto() {
	}

	public JoinCorpDto(String c_name, String c_id, String c_pwd, String c_address, String c_tel) {
		super();
		this.c_name = c_name;
		this.c_id = c_id;
		this.c_pwd = c_pwd;
		this.c_address = c_address;
		this.c_tel = c_tel;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
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

}
