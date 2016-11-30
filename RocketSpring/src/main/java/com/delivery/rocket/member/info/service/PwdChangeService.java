package com.delivery.rocket.member.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.info.action.Action;
import com.delivery.rocket.member.info.dao.InfoDao;
import com.delivery.rocket.member.info.dto.InfoDto;

@Service
public class PwdChangeService implements Action {
	@Autowired
	InfoDao infoDao = null;
	@Override
	public ModelAndView execute(InfoDto infoDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		if(infoDto.getM_pwd().equals(infoDto.getM_pwd2())){
			infoDao.pwdUpdate(infoDto);
			modelAndView.setViewName("./loginview/pwdchangeafter");
			modelAndView.addObject("success","true");
		}
		else{
			modelAndView.setViewName("redirect:./pwdchange.info");
			modelAndView.addObject("success","false");
		}
		return modelAndView;
	}

	

}
