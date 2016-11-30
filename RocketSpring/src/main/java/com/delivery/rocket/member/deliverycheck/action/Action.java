package com.delivery.rocket.member.deliverycheck.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.deliverycheck.dto.DeliveryCheckDto;

public interface Action {
	public ModelAndView execute(DeliveryCheckDto deliveryCheckDto);
}
