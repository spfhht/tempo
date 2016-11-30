package com.delivery.rocket.admin.membermanagement.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.membermanagement.dto.MemberManageDto;
import com.delivery.rocket.admin.membermanagement.service.DeleteMemberService;
import com.delivery.rocket.admin.membermanagement.service.DetailListService;
import com.delivery.rocket.admin.membermanagement.service.ListMemberService;

@Controller
public class MemberMangementController {
	@Autowired
	private ListMemberService listMemberService;
	@Autowired
	private DetailListService detailListService;
	@Autowired
	private DeleteMemberService deleteMemberService;

	@RequestMapping(value = "/MemberDelete.AmmDo")
	public ModelAndView managerDelete(@RequestParam("m_id") String id) {
		MemberManageDto dto = new MemberManageDto();
		dto.setM_id(id);

		return deleteMemberService.execute(dto);
	}

	@RequestMapping(value = "/Member.AmmDo", method = RequestMethod.GET)
	public ModelAndView memberList(@RequestParam("page") String page) {
		ModelAndView modelAndView = null;
		MemberManageDto memberManageDto = new MemberManageDto();
		memberManageDto.setPage(page);
		modelAndView = listMemberService.execute(memberManageDto);
		return modelAndView;

	}

	@RequestMapping(value = "DetailList.AmmDo", method = RequestMethod.GET)
	public ModelAndView detailList(@RequestParam("m_id") String id) {
		ModelAndView modelAndView = null;
		MemberManageDto memberManageDto = new MemberManageDto();
		memberManageDto.setM_id(id);
		modelAndView = detailListService.execute(memberManageDto);
		return modelAndView;

	}
}
