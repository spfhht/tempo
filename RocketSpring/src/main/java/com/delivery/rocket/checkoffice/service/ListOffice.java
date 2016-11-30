package com.delivery.rocket.checkoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.checkoffice.action.CheckAction;
import com.delivery.rocket.checkoffice.dao.CheckofficeDao;
import com.delivery.rocket.checkoffice.dto.OfficeDto;
@Service
public class ListOffice implements CheckAction {
	@Autowired
	CheckofficeDao checkofficeDao;
	
	@Override
	public ModelAndView execute(OfficeDto officeDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();
		if (officeDto.getC_id().equals("all")) {
			officeDto.setC_id("");
		}
		List<OfficeDto> list = checkofficeDao.checkOffice(officeDto);
		List<OfficeDto> corplist = checkofficeDao.select();
		modelAndView.setViewName("./Checkofficeview/officeform");
		modelAndView.addObject("check", list);
		System.out.println(list.size());
		modelAndView.addObject("corpList", corplist);
		return modelAndView;
	}
	
	
/*	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String c_id = request.getParameter("keyfield");
		if (c_id.equals("all")) {
			c_id = "";
		}

		CheckofficeDao checkofficeDao = new CheckofficeDao();
		ArrayList<OfficeCommand> arrayList = null;
		ActionCommand actionCommand = new ActionCommand();
		arrayList = checkofficeDao.checkoffice(c_id);

		request.setAttribute("check", arrayList);
		actionCommand.setRedirect(false);
		actionCommand.setPath("./CorpList.mcodo");

		return actionCommand;
	}*/
}
