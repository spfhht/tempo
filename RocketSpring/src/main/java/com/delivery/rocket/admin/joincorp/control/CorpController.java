package com.delivery.rocket.admin.joincorp.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.joincorp.dto.JoinCorpDto;
import com.delivery.rocket.admin.joincorp.service.JoinCorpService;


@Controller
public class CorpController {

	private int currentPage = 1;
	private int showCorpLimit = 10;

	private int showPageLimit = 10;

	private int startCorpNum = 0;
	private int endCorpNum = 0;
	private int totalNum = 0;

	@Autowired
	JoinCorpService joinCorpService;
	

	@RequestMapping("main.joincorp")
	public String corpMain() {
		return "/joincorpview/corp_main";
	}

	@ModelAttribute("joincorp")
	public JoinCorpDto form(HttpServletRequest request) {
		return new JoinCorpDto();
	}

	@RequestMapping("/join.joincorp")
	public String corpJoin(@ModelAttribute("joincorp") JoinCorpDto joinCorpDto) {
		
		return "/joincorpview/corp_join";
	}

	@RequestMapping(value = "/join.joincorp", method = RequestMethod.POST)
	public String joinCorp(@ModelAttribute("joincorp") JoinCorpDto joinCorpDto, BindingResult result) {
		
		String c_id = joinCorpDto.getC_id();
		if(joinCorpService.getOneCorp(c_id)!=null) {
			return "/joincorpview/corp_duple";
		}
		
		joinCorpService.joinCorp(joinCorpDto);
		
		return "joincorpview/corp_join_success";
	}

	@RequestMapping("/list.joincorp")
	public ModelAndView corpList(HttpServletRequest request, HttpServletResponse response) {

		String type = null;
		String keyword = null;

		if (request.getParameter("page") == null || request.getParameter("page").trim().isEmpty()
				|| request.getParameter("page").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		if (request.getParameter("type") != null) {
			type = request.getParameter("type").trim();
		}

		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword").trim();
		}

		startCorpNum = (currentPage - 1) * showCorpLimit + 1;
		endCorpNum = startCorpNum + showCorpLimit - 1;
		
		List<JoinCorpDto> corpList;
		
		if (type != null && keyword != null) {
			corpList = joinCorpService.searchCorp(type, keyword, startCorpNum, endCorpNum);
			totalNum = joinCorpService.getSearchTotalNum(type, keyword);
		} else {
			corpList = joinCorpService.getCorpList(startCorpNum, endCorpNum);
			totalNum = joinCorpService.getTotalNum();
		}
		
		

		
		StringBuffer pageHtml = getPageHtml(currentPage, totalNum, showCorpLimit, showPageLimit, type, keyword);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalNum", totalNum);
		modelAndView.addObject("corpList", corpList);
		modelAndView.addObject("pageHtml", pageHtml);
		modelAndView.setViewName("joincorpview/corp_list");

		return modelAndView;
	}
	
	@RequestMapping("/view.joincorp")
	public ModelAndView corpView(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		String c_id = request.getParameter("c_id");
		
		JoinCorpDto joinCorpDto = joinCorpService.getOneCorp(c_id);
		modelAndView.addObject("joinCorpDto", joinCorpDto);
		modelAndView.setViewName("joincorpview/corp_view");
		return modelAndView;
		
	}
	
	@RequestMapping("/delete.joincorp")
	public ModelAndView corpDelete(HttpServletRequest request, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		String c_id = request.getParameter("c_id");
		joinCorpService.deleteCorp(c_id);
		modelAndView.setViewName("joincorpview/corp_delete_success");
		
		return modelAndView;
	}
	
	@RequestMapping("/modify.joincorp")
	public ModelAndView corpModify(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		String c_id = request.getParameter("c_id");
		JoinCorpDto joinCorpDto = joinCorpService.getOneCorp(c_id);
		
		modelAndView.addObject("joinCorpDto", joinCorpDto);
		modelAndView.setViewName("joincorpview/corp_update");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/modify.joincorp", method=RequestMethod.POST)
	public ModelAndView modifyCorp(@ModelAttribute("joinCorpDto") JoinCorpDto joinCorpDto,
		HttpServletRequest request) {
		
		joinCorpService.modifyCorp(joinCorpDto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("joinCorpDto", joinCorpDto);
		modelAndView.setViewName("joincorpview/corp_update_success");
		
		return modelAndView;
		
	}
	
	
	

	private StringBuffer getPageHtml(int currentPage, int totalNum, int showCorpLimit, int showPageLimit, String type, String keyword) {
		StringBuffer pageHtml = new StringBuffer();
		int startPage = 0;
		int lastPage = 0;

		startPage = ((currentPage - 1) / showPageLimit) * showPageLimit + 1;
		lastPage = startPage + showPageLimit - 1;

		if (lastPage > totalNum / showCorpLimit) {
			lastPage = (totalNum / showCorpLimit) + 1;
		}
		

		if (currentPage == 1) {
			pageHtml.append("<span>");
		} else {
			pageHtml.append("<span><a href=\"list.joincorp?page=" + (currentPage - 1) + "\"><이전></a>&nbsp;&nbsp;");
		}

		for (int i = startPage; i <= lastPage; i++) {
			if (i == currentPage) {
				pageHtml.append(".&nbsp;<strong>");
				pageHtml.append("<a href=\"list.joincorp?page=" + i + "\" class=\"page\">" + i + "</a>");
				pageHtml.append("&nbsp;</strong>");
			} else {
				pageHtml.append(".&nbsp;<a href=\"list.joincorp?page=" + i + "\" class=\"page\">" + i + "</a>&nbsp;");
			}

		}
		if (currentPage == lastPage) {
			pageHtml.append(".</span>");
		} else {
			pageHtml.append(".&nbsp;&nbsp;<a href=\"list.joincorp?page=" + (currentPage + 1) + "\"><다음></a></span>");
		}
		
		return pageHtml;
	}


}
