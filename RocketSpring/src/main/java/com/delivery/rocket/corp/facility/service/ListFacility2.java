package com.delivery.rocket.corp.facility.service;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.corp.facility.action.FacilityAction;
import com.delivery.rocket.corp.facility.dao.FacilityDao;
import com.delivery.rocket.corp.facility.dto.FacilityDto;

@Service
public class ListFacility2 implements FacilityAction {
	@Autowired
	private FacilityDao facilityDao;
	private ModelAndView modelAndView;
	
	@Override
	public ModelAndView execute(FacilityDto facilityDto, HttpServletRequest request, HttpServletResponse response) {
		modelAndView = new ModelAndView();
		List<FacilityDto> daoFacilityinfo = null;

		try {
			daoFacilityinfo  = facilityDao.List2(facilityDto.getF_id());//검사가 참이면 입력
			System.out.println(daoFacilityinfo.size());		
			modelAndView.addObject("list", daoFacilityinfo);	
			
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
		
		
		

		
		return modelAndView;
	}

}
