package com.delivery.rocket.member.join.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.join.dto.MemberDto;

@Repository
public class MemberDao {
	private static final String namespaces = "mapper.memberjoin";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public int memberInsert(MemberDto memberDto) {
		return template.insert(namespaces + ".memberInsert", memberDto);
	}
	public MemberDto idOverlapCheck(MemberDto memberDto) {
		System.out.println(template);
		return template.selectOne(namespaces+".idOverlapCheck", memberDto);
		
	}
}
