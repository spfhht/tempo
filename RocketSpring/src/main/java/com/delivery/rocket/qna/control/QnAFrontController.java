package com.delivery.rocket.qna.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.qna.dto.QnADTO;
import com.delivery.rocket.qna.service.CorpListService;
import com.delivery.rocket.qna.service.QnADeleteService;
import com.delivery.rocket.qna.service.QnADetailService;
import com.delivery.rocket.qna.service.QnADownloadService;
import com.delivery.rocket.qna.service.QnAListService;
import com.delivery.rocket.qna.service.QnAModifyService;
import com.delivery.rocket.qna.service.QnAReplyService;
import com.delivery.rocket.qna.service.QnAWriteService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
@SessionAttributes("logininfo")
public class QnAFrontController {
	
	@Autowired
	QnAListService qnaListService = null;
	@Autowired
	QnADeleteService qnaDeleteService = null;
	@Autowired
	QnAWriteService qnaWriteService = null;
	@Autowired
	CorpListService corpListService = null;
	@Autowired
	QnAModifyService qnaModifyService = null;
	@Autowired
	QnADetailService qnaDetailService = null;
	@Autowired
	QnAReplyService qnaReplyService = null;
	@Autowired
	QnADownloadService qnaDownloadService = null;

	// QnAModifyService qnaModifyService = null;

	// @RequestMapping(value = "/move.qna")
	// public String qnaIndex() {
	// return "./qna_view/board_write";
	// }

	@RequestMapping("/corpList.qna")
	public ModelAndView doCorpList(HttpServletRequest request, HttpServletResponse response) {
		

		ModelAndView modelAndView = null;
		QnADTO qnaDTO = new QnADTO();
		modelAndView = corpListService.execute(request, response, qnaDTO);
		return modelAndView;
	}

	@RequestMapping("/list.qna")
	public ModelAndView doList(@RequestParam(value = "c_id", required = false, defaultValue = "all") String c_id, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = null;
		QnADTO qnaDTO = new QnADTO();
		qnaDTO.setC_id(c_id);
		modelAndView = qnaListService.execute(request, response, qnaDTO);
		return modelAndView;
	}

	@RequestMapping(value = "/write.qna")
	public ModelAndView doWrite(@RequestParam(value="m_id",required = false)String m_id, @RequestParam(value="q_pwd",required = false)String q_pwd, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ModelAndView modelAndView = null;
		QnADTO qnaDTO = new QnADTO();
		qnaDTO.setM_id(m_id);
		qnaDTO.setQ_pwd(q_pwd);
		System.out.println("제우1" + qnaDTO.getM_id());
		System.out.println("제우2" + qnaDTO.getQ_pwd());
		modelAndView = qnaWriteService.execute(request, response, qnaDTO);
		return modelAndView;

	}
	
	@RequestMapping("/delete.qna")
	public ModelAndView doDelete(@RequestParam("q_id") int q_id,@RequestParam(value = "m_group", required = false, defaultValue = "") String m_group,@RequestParam(value="q_pwd") String q_pwd, WebRequest webRequest,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = null;
		QnADTO qnaDTO = new QnADTO();
		// status.setComplete();

		qnaDTO.setQ_id(q_id);
		qnaDTO.setQ_pwd(q_pwd);
		qnaDTO.setM_group(m_group);

		modelAndView = qnaDeleteService.execute(request, response, qnaDTO);
		return modelAndView;
	}

	 @RequestMapping("/modify.qna")
	 public ModelAndView doUpdate(HttpServletRequest request, HttpServletResponse response) {
	
	 ModelAndView modelAndView = null;
	 QnADTO qnaDTO = new QnADTO();
	 //status.setComplete();
	
	 modelAndView = qnaModifyService.execute(request, response, qnaDTO);
	 return modelAndView;
	 }
	 
	 @RequestMapping("/detail.qna")
	 public ModelAndView doDetail(HttpServletRequest request, HttpServletResponse response) {
	
	 ModelAndView modelAndView = null;
	 QnADTO qnaDTO = new QnADTO();
	 //status.setComplete();
	 
	 modelAndView = qnaDetailService.execute(request, response, qnaDTO);
	 return modelAndView;
	 }

	// @RequestMapping("/do.write")
	// public ModelAndView doWrite() {
	// ModelAndView modelAndView = null;
	// QnADTO qnaDTO = new QnADTO();
	//
	// modelAndView = qnaWriteService.execute(qnaDTO);
	// return modelAndView;
	// }
	//
	// @RequestMapping("/do.delete")
	// public ModelAndView doDelete() {
	// ModelAndView modelAndView = null;
	// QnADTO qnaDTO = new QnADTO();
	//
	//// loginDto.setManager_id(id);
	//// loginDto.setManager_pwd(pwd);
	//// loginDto.setM_group(m_group);
	//
	// modelAndView = qnaWriteService.execute(qnaDTO);
	// return modelAndView;
	// }
	//
	// @RequestMapping("/do.modify")
	// public ModelAndView doModify() {
	// ModelAndView modelAndView = null;
	// QnADTO qnaDTO = new QnADTO();
	//
	//// loginDto.setManager_id(id);
	//// loginDto.setManager_pwd(pwd);
	//// loginDto.setM_group(m_group);
	//
	// modelAndView = qnaModifyService.execute(qnaDTO);
	// return modelAndView;
	// }

}
