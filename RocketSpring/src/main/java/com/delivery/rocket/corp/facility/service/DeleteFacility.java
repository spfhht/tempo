package com.delivery.rocket.corp.facility.service;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.facility.action.FacilityAction;
import com.delivery.rocket.corp.facility.dao.FacilityDao;
import com.delivery.rocket.corp.facility.dto.FacilityDto;


@Service
public class DeleteFacility implements FacilityAction{
	@Autowired
	private FacilityDao facilityDao;
	private ModelAndView modelAndView;
	
	
	@Override
	public ModelAndView execute(FacilityDto facilityDto,HttpServletRequest request, HttpServletResponse response) throws IOException  {

		FacilityDto daoFacilityinfo = null;
		boolean isId =false;
		PrintWriter out = response.getWriter();
		if(facilityDao.findId(facilityDto.getF_id()) != null) {
			isId = true;
		}
		
		
		try {
			if (isId==true) {
		
				daoFacilityinfo  = facilityDao.Delete(facilityDto);	//검사가 참이면 입력
				out.println("<script>");
				out.println("alert('Delete Success')");
				out.println("location.href='./ListFacility.facility'");
				out.println("</script>");
			} else {
			
				out.println("<script>");
				out.println("alert('no ID')");
				out.println(" history.back();");
				out.println("</script>");
			}	
			
			
//			modelAndView.setViewName("./CorpMenu/main");
//			modelAndView.addObject("facilityinfo", facilityDto);
		
	} catch (Exception e) {
		System.out.println("삭제실패");

		//modelAndView.setViewName("./CorpMenu/FacilityInsertView");
	}
		
		
		return modelAndView;
	}

	
}
