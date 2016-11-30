package com.delivery.rocket.qna.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.qna.action.Action;
import com.delivery.rocket.qna.dao.QnADAO;
import com.delivery.rocket.qna.dto.QnADTO;

@Service
public class QnAModifyDetailService implements Action {

	@Autowired
	private QnADAO qnaDAO;
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO)
			throws IOException {
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();

		int q_id = Integer.parseInt(request.getParameter("q_id"));
		qnaDTO = qnaDAO.getDetail(q_id);

		if (qnaDTO == null) {
			System.out.println("(수정)상세보기 실패");
			return null;
		}
		
		modelAndView.addObject("qnaDTO", qnaDTO);
		modelAndView.setViewName("./qna_view/board_modify");
		
		return modelAndView;
	}
}
