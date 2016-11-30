package com.delivery.rocket.qna.dto;

import java.sql.Date;

public class QnADTO {

	private int q_id = 0; // 글번호
	private String q_title = null; // 글 제목
	private String q_content = null; // 내용
	private String c_id = null; // 택배회사 코드
	private String m_id = null; // 글쓴이 아이디
	private String q_pwd = null; // 비밀번호
	private String c_name = null; // 택배회사 이름
	private String q_file = null; // 첨부파일
	private String old_file = null;

	// private Date regdate; // 작성일
	private String regdate = null;
	private int hit; // 조회수
	private int reply_id; // 글 그룹 번호
	private int sort; // 답글 정렬 번호
	private int tab; // 들여 쓰기

	// 덧글기능 구현을 위해 추가(06/08)
	private String reply_name;
	private String reply_content;
	private Date reply_date;

	// 프로젝트 진행중 필요에 의해 추가(07/05)
	private String m_group = null;

	// private int no; // 글번호
	// private String id; // 아이디
	// private String pwd; // 비밀번호
	// private String title; // 제목
	// private String content; // 내용
	// private Date regdate; // 작성일
	// private int hit; // 조회수
	// private int parent; // 글 그룹 번호
	// private int sort; // 답글 정렬 번호
	// private int tab; // 들여 쓰기

	
	
	public Date getReply_date() {
		return reply_date;
	}

	public String getM_group() {
		return m_group;
	}

	public void setM_group(String m_group) {
		this.m_group = m_group;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply_name() {
		return reply_name;
	}

	public void setReply_name(String reply_name) {
		this.reply_name = reply_name;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getOld_file() {
		return old_file;
	}

	public void setOld_file(String old_file) {
		this.old_file = old_file;
	}

	public String getC_name() {
		return c_name;
	}

	// public Date getRegdate() {
	// return regdate;
	// }
	//
	// public void setRegdate(Date regdate) {
	// this.regdate = regdate;
	// }

	public int getHit() {
		return hit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}

	public String getQ_file() {
		return q_file;
	}

	public void setQ_file(String q_file) {
		this.q_file = q_file;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getQ_pwd() {
		return q_pwd;
	}

	public void setQ_pwd(String q_pwd) {
		this.q_pwd = q_pwd;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
}
/*
 * - 가이드
 * 
 * QnA에 필요한 변수들을 정의합니다. 생성자 getter,setter
 * 
 * 이거할때 팀장 콜합니다.
 */