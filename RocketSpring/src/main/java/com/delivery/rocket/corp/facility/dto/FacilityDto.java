package com.delivery.rocket.corp.facility.dto;

public class FacilityDto {

	private String f_id;
	private String f_name;
	private String f_address;
	private String f_tel;
	private String f_gps;
	private String manager_id;
	private String manager_name;
	private String f_kind_id;
	private String f_kind_name;
	private String keyword;
	private String keyfield;
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyfield() {
		return keyfield;
	}

	public void setKeyfield(String keyfield) {
		this.keyfield = keyfield;
	}

	public String getF_kind_name() {
		return f_kind_name;
	}

	public void setF_kind_name(String f_kind_name) {
		this.f_kind_name = f_kind_name;
	}

	public String getF_kind_id() {
		return f_kind_id;
	}

	public void setF_kind_id(String f_kind_id) {
		this.f_kind_id = f_kind_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
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


}

/*
 * - 가이드 택배 회사의 시설물을 관리하는 커맨드 클래스입니다. 데이터베이스 테이블을 보고 시설물 정보에 대한 변수들을 정의하세요. 생성자를
 * 만들고 setter , getter 함수를 정의합니다.
 */
