package com.delivery.rocket.member.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.reservation.action.Action;
import com.delivery.rocket.member.reservation.dao.FacilitiesDao;
import com.delivery.rocket.member.reservation.dto.ReservationDto;
@Service
public class FacilitySearchService implements Action {
	@Autowired
	FacilitiesDao facilitiesDao;
	@Override
	public ModelAndView execute(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		List<ReservationDto> facList = facilitiesDao.select(reservationDto);
		modelAndView.setViewName("./reservationview/selectfacility");
		modelAndView.addObject("facList",facList);
		System.out.println(facList);
		return modelAndView;
	}
	
/*
	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommand actionCommand = new ActionCommand();
		FacilitiesDao facilityDao = new FacilitiesDao();
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		ArrayList<ReservationCommand> facList = facilityDao.select(keyword);
		actionCommand.setForward(true);
		actionCommand.setPath("./reservationview/selectfacility.jsp");
		request.setAttribute("facList", facList);
		request.setAttribute("sender_name", request.getParameter("sender_name"));
		request.setAttribute("sender_address", request.getParameter("sender_address"));
		request.setAttribute("sender_detail_address", request.getParameter("sender_detail_address"));
		request.setAttribute("sender_tel", request.getParameter("sender_tel"));
		request.setAttribute("receiver_name", request.getParameter("receiver_name"));
		request.setAttribute("receiver_address", request.getParameter("receiver_address"));
		request.setAttribute("receiver_tel", request.getParameter("receiver_tel"));
		request.setAttribute("p_kind_list", request.getParameter("p_kind_list"));
		request.setAttribute("is_fragile", request.getParameter("is_fragile"));
		return actionCommand;
	}*/

}
