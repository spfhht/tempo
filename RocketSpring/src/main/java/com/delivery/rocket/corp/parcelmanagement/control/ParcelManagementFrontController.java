package com.delivery.rocket.corp.parcelmanagement.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.parcelmanagement.dto.ParcelManagementDto;
import com.delivery.rocket.corp.parcelmanagement.service.ParcelManagementService;
import com.delivery.rocket.login.dto.LoginDto;

@Controller
public class ParcelManagementFrontController {

	private int page = 1;
	private int limit = 10;
	private int showPageLimit = 10;
	private int startrow;
	private int endrow;
	private int totalNum = 0;

	@Autowired
	ParcelManagementService parcelManagementService;

	@RequestMapping("/bring.parcelmanagement")
	public String bringParcel(@ModelAttribute("bring") ParcelManagementDto parcelManagementDto) {
		return "/parcelmanagementview/parcel_bring";

	}

	@RequestMapping(value = "/bring.parcelmanagement", method = RequestMethod.POST)
	public String parcelBring(HttpServletRequest request, HttpServletResponse response) {

		String delivery_id = request.getParameter("delivery_id");
		HttpSession session = request.getSession();
		LoginDto loginDto = (LoginDto) session.getAttribute("logininfo");
		String manager_id = loginDto.getManager_id();

		String now_c_id = parcelManagementService.getCorpId(manager_id).getC_id();
		System.out.println("delivery_id : " + delivery_id + "manager_id :  " + manager_id + "now_c_id : " + now_c_id);

		ParcelManagementDto parcelManagementDto2 = parcelManagementService.isParcel(delivery_id);

		if (parcelManagementDto2 == null) {
			System.out.println("수화물이 없다");
			return "parcelmanagementview/bring_fail_non";
		} else {

			String target_c_id = parcelManagementService.getCorpId(parcelManagementDto2.getManager_id()).getC_id();
			System.out.println("target_c_id : " + target_c_id + " now_c_id : " + now_c_id);
			if (!now_c_id.equals(target_c_id)) {
				System.out.println("다른회사다");
				return "parcelmanagementview/bring_fail_another";
			}

			parcelManagementService.parcelBring(delivery_id, manager_id);
		}

		System.out.println("성공했다");
		return "parcelmanagementview/bring_success";

	}

	@RequestMapping("/parcellist.parcelmanagement")
	public ModelAndView parcelList(HttpServletRequest request, HttpServletResponse response) {

		String type = null;
		String keyword = null;

		if (request.getParameter("page") == null || request.getParameter("page").trim().isEmpty() || request.getParameter("page").equals("0")) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}

		if (request.getParameter("type") != null) {
			type = request.getParameter("type").trim();
		}

		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword").trim();
		}

		startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호.
		endrow = startrow + limit - 1; // 실읽을 마지막 row 번호.

		List<ParcelManagementDto> parcelList;
		HttpSession session = request.getSession();
		LoginDto loginDto = (LoginDto) session.getAttribute("logininfo");

		if (type != null && keyword != null) {
			parcelList = parcelManagementService.getSearchList(type, keyword, startrow, endrow, loginDto.getManager_id());
			totalNum = parcelManagementService.getSearchListCount(type, keyword, loginDto.getManager_id());
		} else {
			parcelList = parcelManagementService.getParcelList(startrow, endrow, loginDto.getManager_id());
			totalNum = parcelManagementService.getListCount(loginDto.getManager_id());
		}

		StringBuffer pageHtml = getPageHtml(page, totalNum, limit, showPageLimit, type, keyword);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("parcelList", parcelList);
		modelAndView.addObject("totalNum", totalNum);
		modelAndView.addObject("pageHtml", pageHtml);
		modelAndView.setViewName("parcelmanagementview/parcel_list");

		return modelAndView;
	}

	@RequestMapping("/updatedelstate.parcelmanagement")
	public ModelAndView updatedelstate(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		String delivery_id = request.getParameter("delivery_id");
		String manager_id = request.getParameter("manager_id");
		ParcelManagementDto viewParcelInfo = parcelManagementService.getDetail(manager_id, delivery_id);

		modelAndView.addObject("delivery_id", delivery_id);
		modelAndView.addObject("manager_id", manager_id);
		modelAndView.addObject("parcelList", viewParcelInfo);
		modelAndView.setViewName("parcelmanagementview/parcel_delStateUpdate");
		return modelAndView;
	}

	@RequestMapping(value = "/updatedelstate.parcelmanagement", method = RequestMethod.POST)
	public ModelAndView delstateUpdate(@ModelAttribute("parcelManagementDto") ParcelManagementDto parcelManagementDto, HttpServletRequest request) {

		System.out.println(parcelManagementDto.getDelivery_id());
		System.out.println(request.getParameter("del_state_id"));
		String del_state_id = request.getParameter("del_state_id");
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		LoginDto loginDto = (LoginDto) session.getAttribute("logininfo");
		String manager_id = loginDto.getManager_id();
		String delivery_id = request.getParameter("delivery_id");
		
		parcelManagementService.updateDelState(delivery_id, del_state_id);
		
		ParcelManagementDto parcelInfo = null;
		parcelInfo = parcelManagementService.getDetail(manager_id, delivery_id);

		modelAndView.addObject("manager_id", manager_id);
		modelAndView.addObject("delivery_id", delivery_id);
		modelAndView.addObject("pacelList", parcelInfo);
		modelAndView.setViewName("parcelmanagementview/update_success");

		return modelAndView;
	}

	@RequestMapping("/getdetail.parcelmanagement")
	public ModelAndView getDetail(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		LoginDto loginDto = (LoginDto) session.getAttribute("logininfo");

		String delivery_id = request.getParameter("delivery_id");
		String manager_id = loginDto.getManager_id();

		ParcelManagementDto parcelInfo = null;
		System.out.println("딜리버리 " + delivery_id);
		parcelInfo = parcelManagementService.getDetail(manager_id, delivery_id);

		System.out.println(manager_id);
		System.out.println(parcelInfo.getDelivery_state());
		modelAndView.addObject("manager_id", manager_id);
		modelAndView.addObject("delivery_id", delivery_id);
		modelAndView.addObject("pacelList", parcelInfo);
		modelAndView.setViewName("parcelmanagementview/parcel_view");
		return modelAndView;
	}

	private StringBuffer getPageHtml(int page, int totalNum, int limit, int showPageLimit, String type, String keyword) {
		StringBuffer pageHtml = new StringBuffer();
		int startPage = 0;
		int lastPage = 0;

		startPage = ((page - 1) / showPageLimit) * showPageLimit + 1;
		lastPage = startPage + showPageLimit - 1;

		if (lastPage > totalNum / limit) {
			lastPage = (totalNum / limit) + 1;
		}

		if (page == 1) {
			pageHtml.append("<span>");
		} else {
			pageHtml.append("<span><a href=\"parcellist.parcelmanagement?page=" + (page - 1) + "\"><이전></a>&nbsp;&nbsp;");
		}

		for (int i = startPage; i <= lastPage; i++) {
			if (i == page) {
				pageHtml.append(".&nbsp;<strong>");
				pageHtml.append("<a href=\"parcellist.parcelmanagement?page=" + i + "\" class=\"page\">" + i + "</a>");
				pageHtml.append("&nbsp;</strong>");
			} else {
				pageHtml.append(".&nbsp;<a href=\"parcellist.parcelmanagement?page=" + i + "\" class=\"page\">" + i + "</a>&nbsp;");
			}

		}
		if (page == lastPage) {
			pageHtml.append(".</span>");
		} else {
			pageHtml.append(".&nbsp;&nbsp;<a href=\"parcellist.parcelmanagement?page=" + (page + 1) + "\"><다음></a></span>");
		}

		return pageHtml;
	}

}
