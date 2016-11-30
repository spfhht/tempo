package com.delivery.rocket.corp.facility.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.corp.facility.dto.FacilityDto;

import java.util.List;
@Repository
public class FacilityDao {
	private static final String namespaces = "mapper.facility";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public FacilityDto Insert(FacilityDto facilityDto) {
		return template.selectOne(namespaces + ".insert", facilityDto);
	}

	public FacilityDto Delete(FacilityDto facilityDto) {
		return template.selectOne(namespaces + ".delete", facilityDto);
	}

	public FacilityDto Update(FacilityDto facilityDto) {

		return template.selectOne(namespaces + ".update", facilityDto);
	}

	public int getListCount() {
		return (Integer) template.selectOne(namespaces + ".getlistcount");
	}

	public List<FacilityDto> List(String c_id) {

		System.out.println(template.selectList(namespaces + ".list", c_id).toString());
		return template.selectList(namespaces + ".list", c_id);
	}

	public List<FacilityDto> List2(String f_id) {

		return template.selectList(namespaces + ".list2", f_id);
	}

	public List<FacilityDto> List3(String keyword, String keyfield) {

		if (!"".equals(keyword)) {
			if ("f_id".equals(keyfield)) {
				return template.selectList(namespaces + ".list32", keyfield);
			} else if ("f_name".equals(keyfield)) {
				return template.selectList(namespaces + ".list33", keyfield);
			}
		}

		return template.selectList(namespaces + ".list31", keyfield);

	}

	public FacilityDto findManager(String manager_id) {
		return template.selectOne(namespaces + ".findManager", manager_id);
	}

	public FacilityDto findId(String f_id) {
		return template.selectOne(namespaces + ".findId", f_id);
	}

}
