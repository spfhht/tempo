package com.delivery.rocket.member.deliverycheck.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.member.deliverycheck.dto.DeliveryCheckDto;
import com.delivery.rocket.member.deliverycheck.service.CheckByMyInfo;
import com.delivery.rocket.member.deliverycheck.service.CheckByWayBill;

@Controller
//@SessionAttributes("check")
public class DeliveryCheckFrontController {
	@Autowired
	CheckByWayBill checkByWayBill = null;
	@Autowired
	CheckByMyInfo checkByMyInfo = null;

	@RequestMapping(value = "/waybill.check")
	public String checkByWayBill() {
		return "./check/inputForm";
	}

	@RequestMapping(value = "/myinfo.check")
	public ModelAndView checkByMyInfo(WebRequest request, SessionStatus status) {
		status.setComplete();
		ModelAndView modelAndView = null;
		DeliveryCheckDto deliveryCheckDto = new DeliveryCheckDto();
		LoginDto loginDto = (LoginDto) request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		deliveryCheckDto.setM_id(loginDto.getM_id());
		modelAndView = checkByMyInfo.execute(deliveryCheckDto);
		return modelAndView;
	}

	@RequestMapping(value = "/return.check")
	public String returnInputForm() {
		return "./check/inputForm";
	}

	@RequestMapping(value = "/view.check")
	public ModelAndView deliveryCheck(@RequestParam("delivery_id") String delivery_id) {
		ModelAndView modelAndView = null;
		DeliveryCheckDto deliveryCheckDto = new DeliveryCheckDto();
		deliveryCheckDto.setDelivery_id(delivery_id);
		modelAndView = checkByWayBill.execute(deliveryCheckDto);
		return modelAndView;
	}
}
