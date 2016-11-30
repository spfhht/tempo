package com.delivery.rocket.qna.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
import com.delivery.rocket.qna.action.Action;
import com.delivery.rocket.qna.dao.QnADAO;
import com.delivery.rocket.qna.dto.QnADTO;

@Service
public class QnADeleteService implements Action {

	@Autowired
	private QnADAO qnaDAO;

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO)
			throws IOException {
		HttpSession session = request.getSession(true);
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		boolean result = false;
		boolean usercheck = false;

		LoginDto sessionDto = (LoginDto) session.getAttribute("logininfo");

		int q_id = Integer.parseInt(request.getParameter("q_id"));
		String q_pwd = request.getParameter("q_pwd");
		String group = sessionDto.getM_group();

		qnaDTO.setQ_id(q_id);
		qnaDTO.setQ_pwd(q_pwd);
		qnaDTO.setM_group(group);
		System.out.println("동동1" + qnaDTO.getQ_id());
		System.out.println("동동2" + qnaDTO.getQ_pwd());
		System.out.println("동동3" + qnaDTO.getM_group());

		System.out.println(qnaDTO.getQ_id() + qnaDTO.getQ_pwd() + qnaDTO.getM_group());

		usercheck = qnaDAO.isBoardWriter(qnaDTO);

		if (usercheck == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글을 삭제할 권한이 없습니다.');");
			out.println("location.href='./list.qna';");
			out.println("</script>");
			out.close();
			return null;
		}

		// result = qnaDAO.boardDelete(q_id);
		// if (result == false) {
		// System.out.println("게시판 삭제 실패");
		// return null;
		// }
		// System.out.println("게시판 삭제 성공");
		//
		// actionCommand.setForward(true);
		// actionCommand.setPath("./BoardList.qdo");
		// return actionCommand;
		// }

		if (qnaDTO.getM_group() != null) {
			if (qnaDTO.getM_group().equals("0")) {
				System.out.println("이수동짱2");
				System.out.println("김제우 스타그만해라" + qnaDTO.getQ_id());
				result = qnaDAO.boardDelete_Admin(qnaDTO);
			} else {
				result = qnaDAO.boardDelete(qnaDTO);
			}
		}else{
			result = qnaDAO.boardDelete(qnaDTO);	
		}
		if (result == false) {
			System.out.println("게시판 삭제 실패");
			return null;
		}
		System.out.println("게시판 삭제 성공");
		modelAndView.setViewName("forward:./list.qna");
		return modelAndView;

	}
}
