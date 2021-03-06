package com.delivery.rocket.corp.facility.service;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.facility.action.FacilityAction;
import com.delivery.rocket.corp.facility.dao.FacilityDao;
import com.delivery.rocket.corp.facility.dto.FacilityDto;
import com.delivery.rocket.login.dto.LoginDto;

@Service
public class ListFacility implements FacilityAction {
	@Autowired
	private FacilityDao facilityDao;
	private ModelAndView modelAndView;

	
	@Override
	public ModelAndView execute(FacilityDto facilityDto,HttpServletRequest request, HttpServletResponse response){
		

		
		modelAndView = new ModelAndView();
		List<FacilityDto> daoFacilityinfo = null;

		
       HttpSession session = request.getSession();
		LoginDto loginDto = (LoginDto) session.getAttribute("logininfo");
		String c_id = loginDto.getC_id();
		System.out.println(c_id);
		int page = 1;
		int limit = 10;
		System.out.println("get!!");
		
		int listcount = facilityDao.getListCount();
		
		
		System.out.println("get2");
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 10 - 1;
		if (endpage > maxpage) {
		endpage = maxpage;
		}
		
		
		
		try {
			daoFacilityinfo = facilityDao.List( c_id);	
			System.out.println(daoFacilityinfo);

			//System.out.println(daoFacilityinfo.size());
			
			modelAndView.addObject("maxpage", maxpage);
			modelAndView.addObject("startpage", startpage);
			modelAndView.addObject("endpage", endpage);
			modelAndView.addObject("list", daoFacilityinfo);
			modelAndView.addObject("listcount", listcount);
			modelAndView.addObject("page", 1);

			//modelAndView.setViewName("./CorpMenu/LisfFacility");
			
		} catch (Exception e) {
			System.out.println("오류");
		}
		return  modelAndView;
	}

}
