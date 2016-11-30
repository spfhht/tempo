package com.delivery.rocket.admin.membermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.membermanagement.action.Action;
import com.delivery.rocket.admin.membermanagement.dao.ManagementDao;
import com.delivery.rocket.admin.membermanagement.dto.MemberManageDto;

@Service
public class DetailListService implements Action {

	@Autowired
	private ManagementDao mangementDao;

	@Override
	public ModelAndView execute(MemberManageDto memberManageDto) {
		
		ModelAndView modelAndView = new ModelAndView();
		memberManageDto = mangementDao.getDetailList(memberManageDto.getM_id());
		if (memberManageDto == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		modelAndView.addObject("command", memberManageDto);
		modelAndView.setViewName("./membermanagement/detailList");
		return modelAndView;
	}

}
