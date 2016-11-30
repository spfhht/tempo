package com.delivery.rocket.member.reservation.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.member.reservation.dto.ReservationDto;
import com.delivery.rocket.member.reservation.service.FacilitySearchService;
import com.delivery.rocket.member.reservation.service.Reservation;
import com.delivery.rocket.member.reservation.service.ReservationIntro;

@Controller
public class ReservationFrontController {

	@Autowired
	ReservationIntro reservationIntro;
	@Autowired
	FacilitySearchService facilitySearchService;
	@Autowired
	Reservation reservation;
	@RequestMapping(value = "/selectfac.reservation")
	public ModelAndView selectFacility(@RequestParam("sender_name") String sender_name,
			@RequestParam("sender_address") String sender_address,
			@RequestParam("sender_detail_address") String sender_detail_address,
			@RequestParam("sender_tel") String sender_tel,
			@RequestParam("receiver_name") String receiver_name,
			@RequestParam("receiver_address") String receiver_address,
			@RequestParam("receiver_tel") String receiver_tel,
			@RequestParam("p_kind_list") String p_kind_list,
			@RequestParam("is_fragile") String is_fragile){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./reservationview/selectfacility");
		modelAndView.addObject("sender_name",sender_name);
		modelAndView.addObject("sender_address",sender_address);
		modelAndView.addObject("sender_detail_address",sender_detail_address);
		modelAndView.addObject("sender_tel",sender_tel);
		modelAndView.addObject("receiver_name",receiver_name);
		modelAndView.addObject("receiver_address",receiver_address);
		modelAndView.addObject("receiver_tel",receiver_tel);
		modelAndView.addObject("p_kind_list",p_kind_list);
		modelAndView.addObject("is_fragile",is_fragile);
		return modelAndView;
	}
	@RequestMapping(value = "/intro.reservation")
	public ModelAndView introReservationPage(){
		ModelAndView modelAndView = null;
		ReservationDto reservationDto = null;
		modelAndView = reservationIntro.execute(reservationDto);
		return modelAndView;
	}
	@RequestMapping("/do.reservation")
	public ModelAndView doReservation(@RequestParam("sender_name") String sender_name,
			@RequestParam("sender_address") String sender_address,
			@RequestParam("sender_detail_address") String sender_detail_address,
			@RequestParam("sender_tel") String sender_tel,
			@RequestParam("receiver_name") String receiver_name,
			@RequestParam("receiver_address") String receiver_address,
			@RequestParam("receiver_tel") String receiver_tel,
			@RequestParam("p_kind_list") String p_kind_list,
			@RequestParam("is_fragile") String is_fragile,
			@RequestParam("fac") String f_id,
			WebRequest request,
			SessionStatus status){
		ModelAndView modelAndView = null;
		ReservationDto reservationDto = new ReservationDto();
		LoginDto loginDto = (LoginDto) request.getAttribute("logininfo", RequestAttributes.SCOPE_SESSION);
		
		reservationDto.setP_s_name(sender_name);
		reservationDto.setP_s_address(sender_address+" "+sender_detail_address);
		reservationDto.setP_s_tel(sender_tel);
		reservationDto.setP_r_name(receiver_name);
		reservationDto.setP_r_address(receiver_address);
		reservationDto.setP_r_tel(receiver_tel);
		reservationDto.setP_kind_id(p_kind_list);
		reservationDto.setP_isfragile(is_fragile);
		reservationDto.setF_id(f_id);
		try{ //member
			reservationDto.setM_id(loginDto.getM_id());
		}catch(NullPointerException e){ // non-member
			reservationDto.setM_id("non-member");
		}

		modelAndView = reservation.execute(reservationDto);
		return modelAndView;
	}
	@RequestMapping(value = "/facsearch.reservation")
	public ModelAndView facSearch(@RequestParam("sender_name") String sender_name,
			@RequestParam("sender_address") String sender_address,
			@RequestParam("sender_detail_address") String sender_detail_address,
			@RequestParam("sender_tel") String sender_tel,
			@RequestParam("receiver_name") String receiver_name,
			@RequestParam("receiver_address") String receiver_address,
			@RequestParam("receiver_tel") String receiver_tel,
			@RequestParam("p_kind_list") String p_kind_list,
			@RequestParam("is_fragile") String is_fragile,
			@RequestParam("keyword") String keyword){
		ModelAndView modelAndView = null;
		ReservationDto reservationDto = new ReservationDto();
		reservationDto.setF_address("%"+keyword+"%");
		System.out.println(reservationDto.getF_address());
		modelAndView = facilitySearchService.execute(reservationDto);
		modelAndView.addObject("sender_name",sender_name);
		modelAndView.addObject("sender_address",sender_address);
		modelAndView.addObject("sender_detail_address",sender_detail_address);
		modelAndView.addObject("sender_tel",sender_tel);
		modelAndView.addObject("receiver_name",receiver_name);
		modelAndView.addObject("receiver_address",receiver_address);
		modelAndView.addObject("receiver_tel",receiver_tel);
		modelAndView.addObject("p_kind_list",p_kind_list);
		modelAndView.addObject("is_fragile",is_fragile);
		return modelAndView;
		
	}
}
