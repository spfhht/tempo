package com.delivery.rocket.corp.facility.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.facility.dto.FacilityDto;



public interface FacilityAction {
	public ModelAndView execute(FacilityDto facilityDto,HttpServletRequest request, HttpServletResponse response )throws Exception;
}
