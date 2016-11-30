package com.delivery.rocket.member.info.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.info.action.Action;
import com.delivery.rocket.member.info.dao.InfoDao;
import com.delivery.rocket.member.info.dto.InfoDto;

@Service
public class WithdrawalService implements Action {

	@Autowired
	InfoDao infoDao; 
	@Override
	public ModelAndView execute(InfoDto infoDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = null;
		if(infoDto.getM_pwd().equals(infoDto.getM_pwd2())){
			infoDao.delete(infoDto);
			modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:./user.login");
			modelAndView.addObject("success", "true");
		}
		else {
			modelAndView = new ModelAndView();
			modelAndView.setViewName("./loginview/withdrawal");
			modelAndView.addObject("success", "false");
		}
		return modelAndView;
	}

}
