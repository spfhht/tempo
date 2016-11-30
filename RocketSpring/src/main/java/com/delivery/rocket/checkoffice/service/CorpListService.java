package com.delivery.rocket.checkoffice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.checkoffice.action.CheckAction;
import com.delivery.rocket.checkoffice.dao.CheckofficeDao;
import com.delivery.rocket.checkoffice.dto.OfficeDto;

@Service
public class CorpListService implements CheckAction{
	@Autowired
	private CheckofficeDao corpDao;
	@Override
	public ModelAndView execute(OfficeDto officeDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		 List<OfficeDto> corpList = corpDao.select();
		 modelAndView.setViewName("./Checkofficeview/officeform");
		 modelAndView.addObject("corpList", corpList);
		return modelAndView;
	}
	
/*	@Override
	public CheckAction execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<OfficeCommand> arrayList = null;
		ActionCommand actionCommand = new ActionCommand();
		CorpDao corpDao = new CorpDao();
		arrayList = corpDao.select();
		request.setAttribute("corpList", arrayList);
		actionCommand.setRedirect(false);
		actionCommand.setPath("./checkofficeview/officeform.jsp");

		return actionCommand;
	}
*/
}
