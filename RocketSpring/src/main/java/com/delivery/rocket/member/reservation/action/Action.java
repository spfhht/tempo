package com.delivery.rocket.member.reservation.action;

import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.reservation.dto.ReservationDto;

public interface Action {
	public ModelAndView execute(ReservationDto reservationDto);
}
