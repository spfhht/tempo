package com.delivery.rocket.corp.managermanagement.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.managermanagement.dto.ManagerManagementDto;
import com.delivery.rocket.corp.managermanagement.service.ManagerManagementDelete;
import com.delivery.rocket.corp.managermanagement.service.ManagerManagementInsert;
import com.delivery.rocket.corp.managermanagement.service.ManagerManagementList;
import com.delivery.rocket.corp.managermanagement.service.ManagerManagementUpdate;
import com.delivery.rocket.login.dto.LoginDto;

@Controller
public class ManagerManagementFrontController {
	@Autowired
	ManagerManagementDelete managerManagementDelete = null;
	@Autowired
	ManagerManagementInsert managerManagementInsert = null;
	@Autowired
	ManagerManagementUpdate managerManagementUpdate = null;
	@Autowired
	ManagerManagementList managerManagementList = null;

	ManagerManagementDto Dto;

	@RequestMapping("/menuview.manager")
	public String menuViewPage() {
		return "./managermanagementview/menuview";
	}

	@RequestMapping(value = "/update.manager")
	public ModelAndView managerUpdate(@RequestParam("manager_name") String m_name,
			@RequestParam("manager_id") String m_id, @RequestParam("manager_pwd") String m_pwd) {
		Dto = new ManagerManagementDto();
		Dto.setManager_id(m_id);
		Dto.setManager_name(m_name);
		Dto.setManager_pwd(m_pwd);

		return managerManagementUpdate.execute(Dto);
	}

	@RequestMapping("/updatepage.manager")
	public ModelAndView updatePage(@RequestParam("manager_name") String manager_name,
			@RequestParam("manager_id") String manager_id, @RequestParam("manager_pwd") String manager_pwd) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./managermanagementview/update");
		modelAndView.addObject("manager_id", manager_id);
		modelAndView.addObject("manager_name", manager_name);
		modelAndView.addObject("manager_pwd", manager_pwd);

		return modelAndView;
	}

	@RequestMapping(value = "/delete.manager")
	public ModelAndView managerDelete(@RequestParam("manager_id") String id) {
		Dto.setManager_id(id);

		return managerManagementDelete.execute(Dto);
	}

	@RequestMapping(value = "/insertpage.manager")
	public String managerInsert() {
		
		
		return "./managermanagementview/insert";
	}
	@RequestMapping(value = "/insert.manager")
	public ModelAndView doinsert(WebRequest request,SessionStatus status,@RequestParam("name") String manager_name,
			@RequestParam("id") String manager_id, @RequestParam("pwd") String manager_pwd){
		status.setComplete();
		LoginDto sessionInfo = (LoginDto) request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		Dto = new ManagerManagementDto();
		Dto.setC_id(sessionInfo.getC_id());//세션사용할것
		Dto.setManager_id(manager_id);
		Dto.setManager_name(manager_name);
		Dto.setManager_pwd(manager_pwd);
		
		return managerManagementInsert.execute(Dto);
	}

	@RequestMapping(value = "/list.manager")
	public String managerList() {
		return "./managermanagementview/list";
	}

	@RequestMapping(value = "/listresult.manager")
	public ModelAndView managershow(WebRequest request,SessionStatus status) {
		status.setComplete();
		LoginDto sessionInfo = (LoginDto) request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		Dto = new ManagerManagementDto();
		Dto.setC_id(sessionInfo.getC_id());

		return managerManagementList.execute(Dto);

	}
}
