package com.delivery.rocket.member.join.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.join.dto.MemberDto;

public interface Action {
	public ModelAndView execute(MemberDto memberDto);
}
