package com.delivery.rocket.member.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.join.action.Action;
import com.delivery.rocket.member.join.dao.MemberDao;
import com.delivery.rocket.member.join.dto.MemberDto;

@Service
public class MemberService implements Action {
	@Autowired
	private MemberDao memberDao;

	@Override
	public ModelAndView execute(MemberDto memberDto) {
		ModelAndView modelAndView = null;
		int count = 0;

		count = memberDao.memberInsert(memberDto);
		modelAndView = new ModelAndView();
		if (count > 0) {
			modelAndView.setViewName("./member/afterjoin");
			modelAndView.addObject("success", "true");
		} else {
			modelAndView.setViewName("redirect:./member/afterjoin");
			modelAndView.addObject("success", "false");

		}

		return modelAndView;
	}

}
