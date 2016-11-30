package com.delivery.rocket.corp.managermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.managermanagement.action.Action;
import com.delivery.rocket.corp.managermanagement.dao.ManagerManagementDao;
import com.delivery.rocket.corp.managermanagement.dto.ManagerManagementDto;

@Service
public class ManagerManagementInsert implements Action {
	@Autowired
	ManagerManagementDao managerManagementDao;

	@Override
	public ModelAndView execute(ManagerManagementDto managerManagementDto) {
		// managerManagementDto.setC_id("hyundai");
		ModelAndView modelAndView = new ModelAndView();
		managerManagementDao.insert(managerManagementDto);

	
		modelAndView.setViewName("./managermanagementview/insertcomplete");
		

		return modelAndView;
	}

}
