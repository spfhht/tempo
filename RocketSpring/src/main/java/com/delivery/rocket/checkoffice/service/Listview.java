package com.delivery.rocket.checkoffice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.checkoffice.action.CheckAction;
import com.delivery.rocket.checkoffice.dao.CheckofficeDao;
import com.delivery.rocket.checkoffice.dto.OfficeDto;
@Service
public class Listview implements CheckAction {
	@Autowired
	CheckofficeDao checkofficeDao;
	@Override
	public ModelAndView execute(OfficeDto officeDto) {
		// TODO Auto-generated method stub
		ModelAndView modelAndView = new ModelAndView();

		OfficeDto officeDetail = checkofficeDao.checkofficef_id(officeDto);
		modelAndView.addObject("view",officeDetail);
		modelAndView.setViewName("./Checkofficeview/list_view");
		return modelAndView;
	}
	
	/*public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String c_id = request.getParameter("c_id");

		String f_id = request.getParameter("f_id");

		CheckofficeDao checkofficeDao = new CheckofficeDao();
		ArrayList<OfficeCommand> arrayList = null;
		ActionCommand actionCommand = new ActionCommand();

		arrayList = checkofficeDao.checkofficef_id(c_id, f_id);

		request.setAttribute("arrayList", arrayList);
		actionCommand.setRedirect(false);
		actionCommand.setPath("./checkofficeview/list_view.jsp");

		return actionCommand;
	}*/
}
