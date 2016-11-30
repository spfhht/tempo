package com.delivery.rocket.corp.parcelmanagement.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.parcelmanagement.dto.ParcelManagementDto;

public interface Action {
	public ModelAndView execute(ParcelManagementDto parcelManagementDto);
}
