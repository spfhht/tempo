package com.delivery.rocket.admin.joincorp.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.joincorp.dto.JoinCorpDto;

public interface CorpAction {
		public ModelAndView execute(JoinCorpDto joinCorpDto);
}
