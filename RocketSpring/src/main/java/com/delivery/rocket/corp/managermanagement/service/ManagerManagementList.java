package com.delivery.rocket.corp.managermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.managermanagement.action.Action;
import com.delivery.rocket.corp.managermanagement.dao.ManagerManagementDao;
import com.delivery.rocket.corp.managermanagement.dto.ManagerManagementDto;

@Service
public class ManagerManagementList implements Action {
	@Autowired
	ManagerManagementDao managerManagementDao;

	@Override
	public ModelAndView execute(ManagerManagementDto managerManagementDto) {

		ModelAndView modelAndView = new ModelAndView();

		List<ManagerManagementDto> managerlist = managerManagementDao.list(managerManagementDto);	
		modelAndView.setViewName("./managermanagementview/listresult");// 목적지
		modelAndView.addObject("listvalue", managerlist);// 넘겨줄 파라미터, 파라미터     , view에 파라미터 전달하는거지머
															// 이름,실제값

		return modelAndView;
	}

}
