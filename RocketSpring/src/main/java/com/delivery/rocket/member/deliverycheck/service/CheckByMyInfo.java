package com.delivery.rocket.member.deliverycheck.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.deliverycheck.action.Action;
import com.delivery.rocket.member.deliverycheck.dao.DeliveryCheckDao;
import com.delivery.rocket.member.deliverycheck.dto.DeliveryCheckDto;

@Service
public class CheckByMyInfo implements Action {

	@Autowired
	private DeliveryCheckDao deliveryCheckDao;

	@Override
	public ModelAndView execute(DeliveryCheckDto deliveryCheckDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		List<DeliveryCheckDto> list = deliveryCheckDao.showList(deliveryCheckDto);
		modelAndView.addObject("check", list);
		modelAndView.setViewName("./check/checkViewList");
		return modelAndView;
	}

}
