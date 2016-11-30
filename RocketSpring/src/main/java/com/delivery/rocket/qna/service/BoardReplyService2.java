package com.delivery.rocket.qna.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import rocket.qna.action.Action;
import rocket.qna.actionmodel.ActionCommand;
import rocket.qna.dao.QnaDAO;*/

public class BoardReplyService2 /*implements Action*/ {
/*	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		QnaDAO2 qnaDAO = new QnaDAO2();
		// QnACommand qnaCommand = new QnACommand();
		boolean result = false;
		int q_id = Integer.parseInt(request.getParameter("q_id"));
		String m_id = request.getParameter("m_id");
		String reply_content = request.getParameter("reply_content");

		// 덧글저장기능 구현을 위해 추가(06/08)
		result = qnaDAO.addReply(q_id, m_id, reply_content);

		if (result == false) {
			System.out.println("덧글 등록실패");
			return null;
		}
		System.out.println("덧글등록 성공");

		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setForward(false);
		actionCommand.setPath("./BoardDetailService.qdo");
		return actionCommand;

	}*/
}
