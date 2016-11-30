package com.delivery.rocket.admin.membermanagement.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.membermanagement.dto.MemberManageDto;

public interface Action {
	public ModelAndView execute(MemberManageDto memberManageDto);
}
