package com.delivery.rocket.member.join.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.join.dto.MemberDto;
import com.delivery.rocket.member.join.service.MemberIdCheckService;
import com.delivery.rocket.member.join.service.MemberService;

@Controller
public class MemberFrontController {
	@Autowired
	MemberService memberServic = null;
	@Autowired
	MemberIdCheckService memberIdCheckService = null;

	@RequestMapping(value = "/member.SignUp")
	public String memberPage() {
		return "./member/member_insert";
	}	

	@RequestMapping("/do.SignUp")
	public ModelAndView doMember(@RequestParam("m_name") String name, @RequestParam("m_id") String id,
			@RequestParam("m_pwd") String pwd, @RequestParam("m_birth") String birth, @RequestParam("m_tel") String tel,
			@RequestParam("m_address") String address, @RequestParam("m_detail_address") String detail_address,
			@RequestParam("m_email") String email) {
		ModelAndView modelAndView = null;
		MemberDto memberDto = new MemberDto();
		memberDto.setM_name(name);
		memberDto.setM_id(id);
		memberDto.setM_pwd(pwd);
		memberDto.setM_birth(birth);
		memberDto.setM_tel(tel);
		memberDto.setM_address(address);
		memberDto.setM_detail_address(detail_address);
		memberDto.setM_email(email);
		memberDto.setM_group("1");
		memberDto.setIs_member("1");
		System.out.println(memberDto.toString());
		modelAndView = memberServic.execute(memberDto);
		return modelAndView;

	}

	@RequestMapping("/idOverlapCheck.SignUp")
	@ResponseBody
	public ModelAndView idOverlapCheck(@RequestParam("m_id") String id) throws Exception {
		ModelAndView modelAndView = null;
		System.out.println(id);
		MemberDto memberDto = new MemberDto();
		memberDto.setM_id(id);
		modelAndView = memberIdCheckService.execute(memberDto);
		return modelAndView;
	}
}
