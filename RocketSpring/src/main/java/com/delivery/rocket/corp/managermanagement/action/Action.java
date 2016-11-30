package com.delivery.rocket.corp.managermanagement.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.managermanagement.dto.ManagerManagementDto;

public interface Action {

	public ModelAndView execute(ManagerManagementDto managerManagementDto);	
	
	}
