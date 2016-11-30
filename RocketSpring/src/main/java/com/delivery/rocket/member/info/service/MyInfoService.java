package com.delivery.rocket.member.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.info.action.Action;
import com.delivery.rocket.member.info.dao.InfoDao;
import com.delivery.rocket.member.info.dto.InfoDto;
@Service
public class MyInfoService implements Action {
	@Autowired
	InfoDao infoDao ;
	@Override
	public ModelAndView execute(InfoDto infoDto) {
		// TODO Auto-generated method stub
		infoDao.myInfoUpdate(infoDto);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./loginview/myinfo");
		return modelAndView;
	}

}
