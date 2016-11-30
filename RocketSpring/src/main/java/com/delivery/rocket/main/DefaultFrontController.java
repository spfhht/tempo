package com.delivery.rocket.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultFrontController {
	@RequestMapping("/corpmanagermain")
	public ModelAndView corpmanagerMenuMain(@RequestParam(value = "menu", required=false) String menu){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu",menu);
		modelAndView.setViewName("./CorpManagerMenu/main");
		return modelAndView;
	}
	@RequestMapping("/corpmain")
	public ModelAndView corpMenuMain(@RequestParam(value = "menu", required=false) String menu){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu",menu);
		modelAndView.setViewName("./CorpMenu/main");
		return modelAndView;
	}
	@RequestMapping("/center")
	public ModelAndView center(@RequestParam(value = "menu", required=false) String menu){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu",menu);
		modelAndView.setViewName("./CorpMenu/main");
		return modelAndView;
	}
	@RequestMapping("/adminmain")
	public ModelAndView adminMenuMain(@RequestParam(value = "menu", required=false) String menu){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu",menu);
		modelAndView.setViewName("./adminMenu/main");
		return modelAndView;
	}
	@RequestMapping("/usermain")
	public ModelAndView userMenuMain(@RequestParam(value = "menu", required=false) String menu){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menu",menu);
		modelAndView.setViewName("./main/main");
		return modelAndView;
	}
	@RequestMapping("/member_insert")
	public String memberInsertPage(){
		return "./member/member_insert";
	}
	@RequestMapping("/centerright")
	public String centerRight(){
		return "./main/centerright";
	}
}
