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
public class QnADetailService implements Action {
	@Autowired
	private QnADAO qnaDAO;
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO) {
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		int q_id = Integer.parseInt(request.getParameter("q_id"));

		qnaDAO.setReadCountUpdate(q_id);
		qnaDTO = qnaDAO.getDetail(q_id);

		// 추가
		//List<QnADTO> qnaDTO2 = qnaDAO.getReply(q_id);

		if (qnaDTO == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");

		modelAndView.addObject("qnaDTO", qnaDTO);
		//modelAndView.addObject("qnaDTO2", qnaDTO2);
		modelAndView.setViewName("./qna_view/board_view");
		return modelAndView;
		
	}
}
