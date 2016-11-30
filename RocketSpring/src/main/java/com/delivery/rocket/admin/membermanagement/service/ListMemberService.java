package com.delivery.rocket.admin.membermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.membermanagement.action.Action;
import com.delivery.rocket.admin.membermanagement.dao.ManagementDao;
import com.delivery.rocket.admin.membermanagement.dto.MemberManageDto;

@Service
public class ListMemberService implements Action {

	@Autowired
	private ManagementDao mangementDao;

	@Override
	public ModelAndView execute(MemberManageDto memberManageDto) {
		ModelAndView modelAndView = new ModelAndView();

		List<?> memberList = new ArrayList<Object>();

		int page = 1;
		int limit = 10;

		if (memberManageDto.getPage() != null) {
			page = Integer.parseInt(memberManageDto.getPage());
		}

		int listcount = mangementDao.getListCount(memberManageDto).getCount();
		memberList = mangementDao.getMemberList(page, limit, memberManageDto);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 10 - 1;
		if (endpage > maxpage) {
			endpage = maxpage;
		}
		modelAndView.addObject("page", page);
		modelAndView.addObject("maxpage", maxpage);
		modelAndView.addObject("startpage", startpage);
		modelAndView.addObject("listcount", listcount);
		modelAndView.addObject("memberList", memberList);
		modelAndView.setViewName("./membermanagement/ListMember");

		return modelAndView;

	}

}

