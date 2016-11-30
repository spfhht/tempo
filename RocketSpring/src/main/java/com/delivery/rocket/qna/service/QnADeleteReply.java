package com.delivery.rocket.qna.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import rocket.qna.action.Action;
import rocket.qna.actionmodel.ActionCommand;
import rocket.qna.dao.QnaDAO;
*/
public class QnADeleteReply /*implements Action*/ {
/*	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		QnaDAO2 qnaDAO = new QnaDAO2();
		// QnACommand qnaCommand = new QnACommand();
		boolean result = false;
		int q_id = Integer.parseInt(request.getParameter("q_id"));
		String m_id = request.getParameter("m_id");
		String reply_content = request.getParameter("reply_content");

		// 추가
		// q_id와 reply_q_id 추가필요
		// result = qnaDAO.deleteReply();

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
