package com.delivery.rocket.login.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.login.service.LoginService;

@Controller
@SessionAttributes("logininfo")
public class LoginFrontController  {
	@Autowired
	LoginService LoginService = null;
	@RequestMapping(value = "/user.login")
	public String userLoginPage(){
		return "./loginview/userlogin";
	}
	@RequestMapping(value = "/corp.login")
	public String corpLoginPage(){
		return "./loginview/corplogin";
	}
	@RequestMapping(value = "/admin.login")
	public String adminLoginPage(){
		return "./loginview/adminlogin";
	}
	@RequestMapping(value = "/corpmanager.login")
	public String corpmanagerLoginPage(){
		return "./loginview/corpmanagerlogin";
	}

	@RequestMapping("/do.login")
	public ModelAndView doLogin(@RequestParam("id")String id ,@RequestParam("pwd")String pwd,@RequestParam("m_group")String m_group){
		ModelAndView modelAndView = null;
		LoginDto loginDto = new LoginDto();
		System.out.println(id+pwd+m_group);
		if(m_group.equals("0") || m_group.equals("1")){
			loginDto.setM_id(id);
			loginDto.setM_pwd(pwd);
			loginDto.setM_group(m_group);
		}
		else if(m_group.equals("2")){ //corp
			loginDto.setC_id(id);
			loginDto.setC_pwd(pwd);
			loginDto.setM_group(m_group);
		}
		else { //corp manager
			loginDto.setManager_id(id);
			loginDto.setManager_pwd(pwd);
			loginDto.setM_group(m_group);
		}
		modelAndView = LoginService.execute(loginDto);
		return modelAndView;
	}
	@RequestMapping("/logout.login")
	public ModelAndView doLogout(WebRequest request, SessionStatus status,@RequestParam("flag")String m_group){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(m_group);
		status.setComplete();
		request.removeAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		if(m_group.equals("0")){ // admin
			modelAndView.setViewName("redirect:./admin.login");
		}
		else if(m_group.equals("1")){ // user
			modelAndView.setViewName("redirect:./usermain");
		}
		else if(m_group.equals("2")){ // corp
			modelAndView.setViewName("redirect:./corp.login");
		}
		else if(m_group.equals("3")){ //corp manager
			System.out.println("111111");
			modelAndView.setViewName("redirect:./corpmanager.login");
		}
		return modelAndView;
	}

}
