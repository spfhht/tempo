package com.delivery.rocket.member.deliverycheck.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.rocket.member.deliverycheck.dto.DeliveryCheckDto;

@Repository
public class DeliveryCheckDao {
	private static final String namespaces = "mapper.deliverycheck";
	@Autowired
	SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public DeliveryCheckDto show(DeliveryCheckDto deliveryCheckDto) {
		return template.selectOne(namespaces + ".show", deliveryCheckDto);
	}

	public List<DeliveryCheckDto> showList(DeliveryCheckDto deliveryCheckDto) {
		return template.selectList(namespaces + ".showList", deliveryCheckDto);
	}

	public DeliveryCheckDto hasParcel(DeliveryCheckDto deliveryCheckDto) {
		return template.selectOne(namespaces + ".hasParcel", deliveryCheckDto);
	}

}
