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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class QnAReplyService implements Action {

	@Autowired
	private QnADAO qnaDAO;
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO)
			throws IOException {
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		int result = 0;

		String realFolder = "";
		String saveFolder = "/resources/upload";
		int fileSize = 5 * 1024 * 1024;

		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
		try {
			MultipartRequest multipartRequest = null;
			multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			String c_id = multipartRequest.getParameter("c_id");
			qnaDTO.setQ_id(Integer.parseInt(multipartRequest.getParameter("q_id")));
			qnaDTO.setM_id(multipartRequest.getParameter("m_id"));
			qnaDTO.setQ_pwd(multipartRequest.getParameter("q_pwd"));
			qnaDTO.setQ_title(multipartRequest.getParameter("q_title"));
			qnaDTO.setQ_content(multipartRequest.getParameter("q_content"));
			qnaDTO.setReply_id(Integer.parseInt(multipartRequest.getParameter("reply_id")));
			qnaDTO.setSort(Integer.parseInt(multipartRequest.getParameter("sort")));
			qnaDTO.setTab(Integer.parseInt(multipartRequest.getParameter("tab")));
			qnaDTO.setQ_file(
					multipartRequest.getFilesystemName((String) multipartRequest.getFileNames().nextElement()));
			qnaDTO.setC_id(c_id);

			//result = qnaDAO.boardReply(qnaDTO);
			if (result == 0) {
				System.out.println("답변 실패");
				return null;
			}
			System.out.println("답변 성공");
			
			modelAndView.setViewName("forward:./detail.qna?q_id="+ result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
