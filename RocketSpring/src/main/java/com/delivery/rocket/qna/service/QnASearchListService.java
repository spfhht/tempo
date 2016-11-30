package com.delivery.rocket.qna.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import rocket.qna.action.Action;
import rocket.qna.actionmodel.ActionCommand;
import rocket.qna.dao.QnaDAO;*/

public class QnASearchListService /*implements Action*/ {
/*	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyword = null;
		keyword = (String) request.getParameter("keyword");
		String keyfield = null;
		keyfield = (String) request.getParameter("keyfield");

		QnaDAO2 qnaDAO = new QnaDAO2();
		List<?> searchBoardlist = new ArrayList<Object>();
		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int searchlistcount = qnaDAO.getSearchListCount(keyword, keyfield);
		searchBoardlist = qnaDAO.getSearchList(keyword, keyfield, page, limit);

		int maxpage = (int) ((double) searchlistcount / limit + 0.95);

		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;

		int endpage = startpage + 10 - 1;

		if (endpage > maxpage) {
			endpage = maxpage;
		}
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("searchlistcount", searchlistcount);
		request.setAttribute("searchBoardlist", searchBoardlist);
		request.setAttribute("keyword", keyword);
		request.setAttribute("keyfield", keyfield);

		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setForward(false);
		actionCommand.setPath("./qna_view/board_search_list.jsp");
		return actionCommand;
	}*/
}
