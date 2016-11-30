/*
 * 작성자 : 이용재
 * 
 * 날짜 : 2016.03.31
 * 
 * 클래스  
 * public class MemberReservation implements ReservationContro : 회원의 택배 예약 기능을 담당하는 클래스이다. 
 * 
 * 
 * 
 */


package com.delivery.rocket.member.reservation.service;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.member.reservation.action.Action;
import com.delivery.rocket.member.reservation.dao.CorpManagerDao;
import com.delivery.rocket.member.reservation.dao.ParcelAtDao;
import com.delivery.rocket.member.reservation.dao.ParcelManageDao;
import com.delivery.rocket.member.reservation.dao.ParcelsDao;
import com.delivery.rocket.member.reservation.dto.ReservationDto;


@Service
public class Reservation implements Action {
	@Autowired
	ParcelAtDao parcelAtDao;
	@Autowired
	ParcelManageDao parcelManageDao;
	@Autowired
	ParcelsDao parcelsDao;
	@Autowired
	CorpManagerDao corpManagerDao;
	@Override
	public ModelAndView execute(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		
		reservationDto.setManager_id(corpManagerDao.select(reservationDto).getManager_id());//f_id
		int value = (int) (Math.random()*10000+1);
		reservationDto.setP_id(this.makeP_ID()+Integer.toString(value));
		int value2 = (int) (Math.random()*1000+1);
		reservationDto.setDelivery_id(this.makeP_ID()+Integer.toString(value2));
		reservationDto.setParcelat_id(this.makeP_ID()+reservationDto.getP_isfragile()+reservationDto.getP_kind_id());
		reservationDto.setDel_state_id("0");
		parcelAtDao.insert(reservationDto);
		parcelManageDao.insert(reservationDto);
		parcelsDao.insert(reservationDto);
		modelAndView.setViewName("./reservationview/reservationok");
		modelAndView.addObject("delivery_id", reservationDto.getDelivery_id());
		return modelAndView;
	}
	private String makeP_ID(){
		Calendar calendar = Calendar.getInstance();
		String p_id =null;
		int result;
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get (Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		result = year+month+date+hour+min+sec;
		p_id = Integer.toString(result);
		return p_id;
	}
/*
	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommand actionCommand = new ActionCommand();
		ParcelAtDao parcelAtDao = new ParcelAtDao();
		ParcelManageDao parcelManageDao = new ParcelManageDao();
		ParcelsDao parcelsDao = new ParcelsDao();
		CorpManagerDao corpManagerDao = new CorpManagerDao();
		ReservationCommand reservationCommand = new ReservationCommand();
		HttpSession session = request.getSession();
		System.out.println(request.getParameter("sender_name"));
		System.out.println(request.getParameter("sender_tel"));
		System.out.println(request.getParameter("p_kind_list"));
		reservationCommand.setP_s_name(request.getParameter("sender_name"));
		reservationCommand.setP_s_address(request.getParameter("sender_address")+" "+request.getParameter("sender_detail_address"));
		reservationCommand.setP_s_tel(request.getParameter("sender_tel"));
		reservationCommand.setP_r_name(request.getParameter("receiver_name"));
		reservationCommand.setP_r_address(request.getParameter("receiver_address"));
		reservationCommand.setP_r_tel(request.getParameter("receiver_tel"));
		reservationCommand.setP_kind_id(request.getParameter("p_kind_list"));
		reservationCommand.setP_isfragile(request.getParameter("is_fragile"));
		reservationCommand.setF_id(request.getParameter("fac"));
		reservationCommand.setM_id((String)session.getAttribute("id"));
		reservationCommand.setManager_id(corpManagerDao.select(reservationCommand.getF_id()));
		int value = (int) (Math.random()*10000+1);
		reservationCommand.setP_id(this.makeP_ID()+Integer.toString(value));
		int value2 = (int) (Math.random()*1000+1);
		reservationCommand.setDelivery_id(this.makeP_ID()+Integer.toString(value2));
		reservationCommand.setParcelat_id(this.makeP_ID()+reservationCommand.getP_isfragile()+reservationCommand.getP_kind_id());
		reservationCommand.setDel_state_id("0");
		parcelAtDao.insert(reservationCommand);
		parcelManageDao.insert(reservationCommand);
		parcelsDao.insert(reservationCommand);
		actionCommand.setForward(true);
		actionCommand.setPath("./reservationview/reservationok.jsp");
		request.setAttribute("delivery_id", reservationCommand.getDelivery_id());
		return actionCommand;
	}

	private String makeP_ID(){
		Calendar calendar = Calendar.getInstance();
		String p_id =null;
		int result;
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get (Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		result = year+month+date+hour+min+sec;
		p_id = Integer.toString(result);
		return p_id;
	}*/
}

/*
  로그인 되어있을때 예약 기능을 제공합니다. 
  LoginControl에 id_now를 이용합니다. 
  자세한 기능은 하면서 회의하는걸로~
*/