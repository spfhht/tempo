package com.delivery.rocket.member.info.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.action.Action;
import com.delivery.rocket.login.dto.LoginDto;
@Service
public class MyInfoIntroService implements Action {

	@Override
	public ModelAndView execute(LoginDto loginDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();;
		String receivedPwd = loginDto.getM_pwd2();
		String sessionPwd = loginDto.getM_pwd();
		if(receivedPwd.equals(sessionPwd)){
			modelAndView.setViewName("./loginview/myinfoafterintro");
			modelAndView.addObject("success","true");
		}
		else{
			modelAndView.setViewName("./loginview/myinfoafterintro");
			modelAndView.addObject("success","false");
		}
		return modelAndView;
	}

}
