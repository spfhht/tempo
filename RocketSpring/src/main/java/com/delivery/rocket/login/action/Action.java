package com.delivery.rocket.login.action;

import org.springframework.web.servlet.ModelAndView;
import com.delivery.rocket.login.dto.LoginDto;

public interface Action {
	public ModelAndView execute(LoginDto loginDto);
}
