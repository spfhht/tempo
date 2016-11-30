package com.delivery.rocket.qna.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.qna.action.Action;
import com.delivery.rocket.qna.dao.QnADAO;
import com.delivery.rocket.qna.dto.QnADTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class QnAModifyService implements Action {

	@Autowired
	private QnADAO qnaDAO;
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response,QnADTO qnaDTO) {
		HttpSession session = request.getSession(true);
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		boolean result = false;
		String realFolder = "";
		String saveFolder = "/resources/upload";
		int fileSize = 5 * 1024 * 1024;
		
		String m_group = "";
		m_group = (String) session.getAttribute("group");

		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);

		try {
			MultipartRequest multipartRequest = null;
			multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			int q_id = Integer.parseInt(multipartRequest.getParameter("q_id"));
			String q_pwd = multipartRequest.getParameter("q_pwd");
			qnaDTO.setM_group(m_group);
			qnaDTO.setQ_id(q_id);
			qnaDTO.setQ_pwd(q_pwd);
			
			boolean usercheck = qnaDAO.isBoardWriter(qnaDTO);
			
			if (usercheck == false) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정할 권한이 없습니다.');");
				out.println("location.href='./list.qna';");
				out.println("</script>");
				out.close();
				return null;
			}

			qnaDTO.setQ_id(q_id);
			qnaDTO.setM_id(multipartRequest.getParameter("m_id"));
			qnaDTO.setQ_title(multipartRequest.getParameter("q_title"));
			qnaDTO.setQ_content(multipartRequest.getParameter("q_content"));
			qnaDTO.setQ_file(
					multipartRequest.getFilesystemName((String) multipartRequest.getFileNames().nextElement()));
			qnaDTO.setOld_file(multipartRequest.getParameter("old_file"));

			result = qnaDAO.boardModify(qnaDTO);

			if (result == false) {
				System.out.println("게시판 수정 실패");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.setViewName("forward:./detail.qna?q_id=" + qnaDTO.getQ_id());
		return modelAndView;
	}
}
