package com.delivery.rocket.member.deliverycheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.deliverycheck.action.Action;
import com.delivery.rocket.member.deliverycheck.dao.DeliveryCheckDao;
import com.delivery.rocket.member.deliverycheck.dto.DeliveryCheckDto;

@Service
public class CheckByWayBill implements Action {

	@Autowired
	private DeliveryCheckDao deliveryCheckDao;
	
	@Override
	public ModelAndView execute(DeliveryCheckDto deliveryCheckDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = null;
		DeliveryCheckDto daoCheckInfo = null;
		modelAndView = new ModelAndView();
		try {
			daoCheckInfo = deliveryCheckDao.hasParcel(deliveryCheckDto);
			if (deliveryCheckDto.getDelivery_id().equals(daoCheckInfo.getDelivery_id())) {
				daoCheckInfo = deliveryCheckDao.show(deliveryCheckDto);
				modelAndView.addObject("check", daoCheckInfo);
				modelAndView.setViewName("./check/checkView");
			} else {
				modelAndView.setViewName("./check/emptyParcel");
			}
		} catch (Exception e) {
			modelAndView.setViewName("./check/emptyParcel");
			e.printStackTrace();
		}
		return modelAndView;
	}
}