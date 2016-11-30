package com.delivery.rocket.member.info.action;

import org.springframework.web.servlet.ModelAndView;
import com.delivery.rocket.member.info.dto.InfoDto;

public interface Action {
	public ModelAndView execute(InfoDto infoDto);
}
