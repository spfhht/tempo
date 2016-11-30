package com.delivery.rocket.member.info.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.member.info.dto.InfoDto;
import com.delivery.rocket.member.info.service.MyInfoIntroService;
import com.delivery.rocket.member.info.service.MyInfoService;
import com.delivery.rocket.member.info.service.PwdChangeService;
import com.delivery.rocket.member.info.service.WithdrawalService;
@Controller
public class InfoFrontController {
	@Autowired
	MyInfoIntroService myInfoIntroService = null;
	@Autowired
	MyInfoService myInfoService = null;
	@Autowired
	PwdChangeService pwdChangeSevice = null;
	@Autowired
	WithdrawalService withdrawalService = null;
	
	@RequestMapping(value = "/myinfointro.info")
	public String myinfointroPage(){
		return "./loginview/myinfointro";
	}
	@RequestMapping(value = "/myinfo.info")
	public String myinfoPage(){
		return "./loginview/myinfo";
	}
	@RequestMapping(value = "/pwdchange.info")
	public String pwdChangePage(){
		return "./loginview/pwdchange";
	}
	@RequestMapping(value = "/withdrawal.info")
	public String withdrawalPage(){
		return "./loginview/withdrawal";
	}
	@RequestMapping(value = "/myinfointrodo.info")
	public ModelAndView myinfointrodoPage(WebRequest request, SessionStatus status,@RequestParam("pwd")String pwd){
		ModelAndView modelAndView = null;
		status.setComplete();
		LoginDto loginDto = (LoginDto) request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		loginDto.setM_pwd2(pwd);
		modelAndView = myInfoIntroService.execute(loginDto);
		return modelAndView;
	}
	@RequestMapping(value = "/update.info")
	public ModelAndView myinfoupdatePage(WebRequest request, SessionStatus status,@RequestParam("add")String add,@RequestParam("d_add")String d_add,@RequestParam("tel")String tel,@RequestParam("email")String email){
		ModelAndView modelAndView = null;
		status.setComplete();
		LoginDto logininfo = (LoginDto) request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		InfoDto infoDto = this.change(logininfo);
		if(!add.equals("")){
			logininfo.setM_address(add);
			infoDto.setM_address(add);
		}
		if(!d_add.equals("")){
			logininfo.setM_detail_address(d_add);
			infoDto.setM_detail_address(d_add);
		}
		if(!tel.equals("")){
			logininfo.setM_tel(tel);
			infoDto.setM_tel(tel);
		}
		if(!email.equals("")){
			logininfo.setM_email(email);
			infoDto.setM_email(email);
		}
		modelAndView = myInfoService.execute(infoDto);
		request.setAttribute("logininfo", logininfo, RequestAttributes.SCOPE_SESSION);
		return modelAndView;
	}
	@RequestMapping(value = "/pwdchangedo.info")
	public ModelAndView pwdchangedoPage(WebRequest request, SessionStatus status,@RequestParam("pwd")String pwd,@RequestParam("confirm_pwd")String confirm_pwd){
		ModelAndView modelAndView = null;
		status.setComplete();
		LoginDto loginDto = (LoginDto)request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		InfoDto infoDto = new InfoDto();
		System.out.println(loginDto.getM_id());
		infoDto.setM_id(loginDto.getM_id());
		infoDto.setM_pwd(pwd);
		infoDto.setM_pwd2(confirm_pwd);
		modelAndView = pwdChangeSevice.execute(infoDto);
		Map<String, Object> map = modelAndView.getModel();
		String success = (String)map.get("success");
		if(success.equals("true")){
			loginDto.setM_pwd(pwd);
			request.setAttribute("logininfo", loginDto, RequestAttributes.SCOPE_SESSION);
		}
		return modelAndView;
	}
	@RequestMapping(value = "/Withdrawaldo.info")
	public ModelAndView withdrawalDoPage(WebRequest request, SessionStatus status,@RequestParam("pwd")String pwd){
		ModelAndView modelAndView = null;
		status.setComplete();
		LoginDto loginDto = (LoginDto)request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		InfoDto infoDto = new InfoDto();
		System.out.println(loginDto.getM_id());
		infoDto.setM_id(loginDto.getM_id());
		infoDto.setM_pwd(pwd);
		infoDto.setM_pwd2(loginDto.getM_pwd());
		modelAndView = withdrawalService.execute(infoDto);
		Map<String, Object> map = modelAndView.getModel();
		String success = (String)map.get("success");
		if(success.equals("true")){
			request.removeAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		}
		return modelAndView;
	}
	private InfoDto change(LoginDto logininfo){
		InfoDto infoDto = new InfoDto();
		infoDto.setM_id(logininfo.getM_id());
		infoDto.setM_name(logininfo.getM_name());
		infoDto.setM_pwd(logininfo.getM_pwd());
		infoDto.setM_tel(logininfo.getM_tel());
		infoDto.setM_address(logininfo.getM_address());
		infoDto.setM_detail_address(logininfo.getM_detail_address());
		infoDto.setM_birth(logininfo.getM_birth());
		infoDto.setM_email(logininfo.getM_email());
		infoDto.setM_group(logininfo.getM_group());
		return infoDto;
	}
}
