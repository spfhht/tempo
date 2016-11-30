package com.delivery.rocket.admin.membermanagement.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.admin.membermanagement.dto.MemberManageDto;

@Repository
public class ManagementDao {
	private static final String namespaces = "mapper.membership";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public int memberDelete(String m_id) {
		
		return template.delete(namespaces + ".deleteMember", m_id);
	}

	public MemberManageDto getListCount(MemberManageDto dto) {

		return template.selectOne(namespaces + ".getListCount", dto);
	}
	public MemberManageDto getDetailList(String m_id) {
		return (MemberManageDto) template.selectOne(namespaces +".detailList",m_id);
	}

	public List<MemberManageDto> getMemberList(int page, int limit, MemberManageDto dto) {
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;
		dto.setStartrow(startrow);
		dto.setEndrow(endrow);
		return template.selectList(namespaces + ".mangementlist", dto);
	}
}
