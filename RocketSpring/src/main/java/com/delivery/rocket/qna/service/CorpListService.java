package com.delivery.rocket.qna.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.delivery.rocket.qna.action.Action;
import com.delivery.rocket.qna.dao.QnADAO;
import com.delivery.rocket.qna.dto.QnADTO;

@Service
public class CorpListService implements Action {
	
	@Autowired
	private QnADAO qnaDAO;
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO) {
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		List<QnADTO> corpList = qnaDAO.getCorpList();
		modelAndView.addObject("corpList", corpList);
		modelAndView.setViewName("./qna_view/board_write");

		return modelAndView;
	}

}
