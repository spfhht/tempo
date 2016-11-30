package com.delivery.rocket.checkoffice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.checkoffice.dto.OfficeDto;
import com.delivery.rocket.checkoffice.service.CorpListService;
import com.delivery.rocket.checkoffice.service.ListOffice;
import com.delivery.rocket.checkoffice.service.Listview;

@Controller
public class CheckOfficeFrontController {
	@Autowired
	CorpListService corpListService;
	@Autowired
	ListOffice listOffice;
	@Autowired
	Listview listview;
//	@RequestMapping(value = "/index.office")
//	public String indexPage() {
//		return "./Checkofficeview/NewFile";
//	}

	@RequestMapping("/corplist.office")
	public ModelAndView corpListPage() {
		ModelAndView modelAndView = null;
		OfficeDto officeDto = null;
		modelAndView = corpListService.execute(officeDto);
		return modelAndView;
	}
	@RequestMapping(value = "/check.office")
	public ModelAndView checkOfficePage(@RequestParam String keyfield){
		ModelAndView modelAndView = null;
		OfficeDto officeDto = new OfficeDto();
		officeDto.setC_id(keyfield);
		modelAndView = listOffice.execute(officeDto);
		return modelAndView;
	}
	@RequestMapping(value="/detail.office")
	public ModelAndView detailViewPage(@RequestParam("c_id") String c_id,@RequestParam("f_id") String f_id){
		ModelAndView modelAndView = null;
		OfficeDto officeDto = new OfficeDto();
		officeDto.setC_id("%"+c_id+"%");
		officeDto.setF_id(f_id);
		modelAndView = listview.execute(officeDto); 
		return modelAndView;
	}
	// if (pathURL.equals("/CorpList.mcodo")) {
	// action = new CorpListService();
	// try {
	// actionCommand = action.execute(request, response);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// } else if (pathURL.equals("/Check.mcodo")) {
	// action = new ListOffice();
	// try {
	// actionCommand = action.execute(request, response);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// } else if (pathURL.equals("/List.mcodo")) {
	//
	// action = new Listview();
	//
	// try {
	// actionCommand = action.execute(request, response);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// if (actionCommand != null) {
	// if (actionCommand.isRedirect()) {
	//
	// response.sendRedirect(actionCommand.getPath());
	// } else {
	//
	// RequestDispatcher dispatcher =
	// request.getRequestDispatcher(actionCommand.getPath());
	// dispatcher.forward(request, response);
	// }
	// }
	// }
	//
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// service(request, response);
	// }
	//
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// service(request, response);
	// }

}
