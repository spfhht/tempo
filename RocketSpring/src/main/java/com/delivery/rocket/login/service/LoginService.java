package com.delivery.rocket.login.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.action.Action;
import com.delivery.rocket.login.dao.LoginDao;
import com.delivery.rocket.login.dto.LoginDto;

@Service
public class LoginService implements Action {
	@Autowired
	private LoginDao loginDao;
	
	
	
	@Override
	public ModelAndView execute(LoginDto loginDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = null;
		LoginDto daoLoginInfo = null;
		if (loginDto.getM_group().equals("0")) { // admin
			daoLoginInfo = loginDao.userLogin(loginDto);
			modelAndView  = new ModelAndView();
			try {
				if (loginDto.getM_id().equals(daoLoginInfo.getM_id())
						&& loginDto.getM_pwd().equals(daoLoginInfo.getM_pwd())
						&& loginDto.getM_group().equals(daoLoginInfo.getM_group())){
					modelAndView.setViewName("./adminMenu/main");
					modelAndView.addObject("logininfo", daoLoginInfo);

				}
				else{
					modelAndView.setViewName("redirect:/admin.login");

				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Login Fail! no id");
				modelAndView.setViewName("redirect:/admin.login");

			}
		} else if (loginDto.getM_group().equals("1")) {// user
			daoLoginInfo = loginDao.userLogin(loginDto);
			modelAndView  = new ModelAndView();
			try {
				if (loginDto.getM_id().equals(daoLoginInfo.getM_id())
						&& loginDto.getM_pwd().equals(daoLoginInfo.getM_pwd())
						&& loginDto.getM_group().equals(daoLoginInfo.getM_group())) {
					modelAndView.setViewName("./main/main");
					modelAndView.addObject("logininfo", daoLoginInfo);

				} else {

					System.out.println("Login Fail!");
					modelAndView.setViewName("redirect:./usermain");

				}

			} catch (NullPointerException e) { // 로그인이 실패했을때 아이디가 없을때
				System.out.println("Login Fail!");
				modelAndView.setViewName("redirect:./usermain");

			}

		} else if (loginDto.getM_group().equals("2")) { // corp
			daoLoginInfo = loginDao.corpLogin(loginDto);
			modelAndView  = new ModelAndView();
			try {
				if (loginDto.getC_id().equals(daoLoginInfo.getC_id())
						&& loginDto.getC_pwd().equals(daoLoginInfo.getC_pwd())){
					modelAndView.setViewName("./CorpMenu/main");
					daoLoginInfo.setM_group("2");
					modelAndView.addObject("logininfo", daoLoginInfo);
					
				}
				else{
					System.out.println("Login Fail!");
					modelAndView.setViewName("redirect:/corp.login");
			
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Login Fail! no id");
				modelAndView.setViewName("redirect:/corp.login");
	
			}

		} else if(loginDto.getM_group().equals("3")){ // corp manager
			daoLoginInfo = loginDao.corpManagerLogin(loginDto);
			System.out.println(daoLoginInfo.getManager_id());
			modelAndView  = new ModelAndView();
			try {
				if (loginDto.getManager_id().equals(daoLoginInfo.getManager_id())
						&& loginDto.getManager_pwd().equals(daoLoginInfo.getManager_pwd())){
					modelAndView.setViewName("./CorpManagerMenu/main");
					daoLoginInfo.setM_group("3");
					modelAndView.addObject("logininfo", daoLoginInfo);
					

				}
				else{
					System.out.println("Login Fail!");
					modelAndView.setViewName("redirect:/corpmanager.login");

				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Login Fail! no id");
				modelAndView.setViewName("redirect:/corpmanager.login");

			}

		}
		
		return modelAndView;
	}

}
