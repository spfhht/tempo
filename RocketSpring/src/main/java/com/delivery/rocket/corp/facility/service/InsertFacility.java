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
public class InsertFacility implements FacilityAction{
	@Autowired
	private FacilityDao facilityDao;
	private ModelAndView modelAndView;
	



	@Override
	public ModelAndView execute(FacilityDto facilityDto,HttpServletRequest request, HttpServletResponse response) throws IOException {

		FacilityDto daoFacilityinfo = null;
		
			boolean isId =false;
			boolean isManage =false; 
			PrintWriter out = response.getWriter();

//			boolean isId = facilityDao.findId(facilityDto.getF_id());
			
			if(facilityDao.findId(facilityDto.getF_id()) != null) {
				isId = true;
			}
			
			if(facilityDao.findManager(facilityDto.getManager_id()) != null) {
				isManage = true;
			}
		

		try {
			
			if (isId==true) {
				out.println("<script>");
				out.println("alert('duplicated id')");
				out.println(" history.back();");
				out.println("</script>");
				System.out.println("아이디 중복");
				
			} else {
			
				if (isManage== true) {
				
					daoFacilityinfo  = facilityDao.Insert(facilityDto);	//검사가 참이면 입력
					out.println("<script>");
					out.println("alert('Insert success')");
					out.println("location.href='./ListFacility.facility'");
					out.println("</script>");
					
				} else {
					
				
					out.println("<script>");
					out.println("alert('no have manager_id')");
					out.println(" history.back();");
					out.println("</script>");
				}
			}	

		
		} catch (Exception e) {
		System.out.println("id 중복");
		e.printStackTrace();
		}

		return modelAndView;
	}
	

}
