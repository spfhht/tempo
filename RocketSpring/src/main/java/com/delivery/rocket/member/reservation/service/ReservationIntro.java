package com.delivery.rocket.member.reservation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.reservation.action.Action;
import com.delivery.rocket.member.reservation.dao.ParcelKindDao;
import com.delivery.rocket.member.reservation.dto.ReservationDto;
@Service
public class ReservationIntro implements Action {

	@Autowired
	ParcelKindDao parcelKindDao;
	@Override
	public ModelAndView execute(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		List<ReservationDto> p_kind_List = parcelKindDao.select();
		modelAndView.setViewName("./reservationview/reservation");
		modelAndView.addObject("p_kind_List", p_kind_List);
		return modelAndView;
	}
/*
	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommand actionCommand = new ActionCommand();
		CorpDao corpDao = new CorpDao();
		ParcelKindDao parcelKindDao = new ParcelKindDao();
		ArrayList<ReservationCommand> corpList = corpDao.select();
		ArrayList<ReservationCommand> p_kind_List = parcelKindDao.select();
		actionCommand.setForward(true);
		actionCommand.setPath("./reservationview/reservation.jsp");
		request.setAttribute("corpList",corpList);
		request.setAttribute("p_kind_List", p_kind_List);
		return actionCommand;
	}*/

}
