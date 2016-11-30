package com.delivery.rocket.member.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.join.action.Action;
import com.delivery.rocket.member.join.dao.MemberDao;
import com.delivery.rocket.member.join.dto.MemberDto;

@Service
public class MemberIdCheckService implements Action {
	@Autowired
	private MemberDao memberDao;

	@Override
	public ModelAndView execute(MemberDto memberDto) {
		ModelAndView modelAndView = null;
		MemberDto daoMemberInfo = null;
		daoMemberInfo = memberDao.idOverlapCheck(memberDto);
		System.out.println(daoMemberInfo);
		modelAndView = new ModelAndView();
		System.out.println("테스트"+memberDto.getM_id());
		if (daoMemberInfo.getCount() == 0) {
			modelAndView.setViewName("./member/aftercheck");
			modelAndView.addObject("success", "true");
		} else {
			modelAndView.setViewName("./member/aftercheck");
			modelAndView.addObject("success", "false");
		}

		return modelAndView;
	}

}
