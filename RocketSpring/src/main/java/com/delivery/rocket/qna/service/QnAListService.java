package com.delivery.rocket.qna.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.qna.action.Action;
import com.delivery.rocket.qna.dao.QnADAO;
import com.delivery.rocket.qna.dto.QnADTO;

@Service
public class QnAListService implements Action {

	@Autowired
	private QnADAO qnaDAO;

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO) {
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		HttpSession session = request.getSession(true);
		LoginDto sessionDto = (LoginDto) session.getAttribute("logininfo");

		try {
			if (sessionDto.getM_id() != null || sessionDto.getC_id() != null) {
				if (sessionDto.getM_group().equals("2")) {
					qnaDTO.setC_id(sessionDto.getC_id());
				} else {
					qnaDTO.setC_id(qnaDTO.getC_id());
				}
			} else {
				qnaDTO.setC_id(qnaDTO.getC_id());
			}
		} catch (Exception e) {
			qnaDTO.setC_id(qnaDTO.getC_id());
		}

		// 택배회사 코드가 null이 아닌경우.
		if (qnaDTO.getC_id() != null) {
			// 전체글보기의 경우!
			if (qnaDTO.getC_id().equals("all")) {
				qnaDTO.setC_id("");
			}
			// 택배회사 코드가 null인 경우.
		} else {
			qnaDTO.setC_id("");
		}

		List<QnADTO> corpList = qnaDAO.getCorpList();
		modelAndView.addObject("corpList", corpList);
		int listcount = qnaDAO.getListCount(qnaDTO);
		List<QnADTO> boardList = qnaDAO.getBoardList(qnaDTO);

		modelAndView.addObject("m_group", qnaDTO.getM_group());
		modelAndView.addObject("listcount", listcount);
		modelAndView.addObject("boardList", boardList);
		modelAndView.setViewName("./qna_view/board_list");
		return modelAndView;
	}
}
