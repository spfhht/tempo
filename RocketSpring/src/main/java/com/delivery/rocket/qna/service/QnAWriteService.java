package com.delivery.rocket.qna.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.login.dto.LoginDto;
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.delivery.rocket.qna.action.Action;
import com.delivery.rocket.qna.dao.QnADAO;
import com.delivery.rocket.qna.dto.QnADTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class QnAWriteService implements Action {

	@Autowired
	private QnADAO qnaDAO;

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO)
			throws IOException {

		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		HttpSession session = request.getSession(true);
		LoginDto sessionDto = (LoginDto) session.getAttribute("logininfo");
		boolean result = true;
		boolean getQid = false;

		String realFolder = "";
		String saveFolder = "/resources/upload";
		int fileSize = 5 * 1024 * 1024;
		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);

		MultipartRequest multipartRequest = null;
		multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());

		// 글내용 줄바꿈 인식을 위한 장치.
		String q_content = multipartRequest.getParameter("q_content").replaceAll("\r\n", "<br>");
		// 회원권한에 따른 조건을 부여하기위해 "group"값을 받아옴.

		String group = null;

		try {

			if (sessionDto.getM_group() != null) {
				System.out.println("신용재1");
				group = sessionDto.getM_group();
				System.out.println(group);
			}
		} catch (NullPointerException e) {
			System.out.println("비회원 글등록 ing ....");
		}
		/*
		 * if (sessionDto.getM_group() != null) { System.out.println("신용재1");
		 * group = sessionDto.getM_group(); System.out.println(group); }
		 */
		// 로그인 한 사용자의 경우!
		if (group != null) {
			// 회사관리자의 경우에는 "id"값을 c_id변수에 할당하여 커맨드에 저장함.
			// (회사관리자의 id는 c_id와 동일)
			if (group.equals("2")) {
				// String c_id = (String) session.getAttribute("id");
				String c_id = sessionDto.getC_id();
				qnaDTO.setC_id(c_id);
				System.out.println("신용재" + qnaDTO.getC_id());

			} else {
				// 회사관리자가 아닌 경우(admin 또는 일반회원)에는 파라미터 값을 커맨드에 저장함.
				qnaDTO.setC_id(multipartRequest.getParameter("c_id"));
			}
		}
		// 비로그인 사용자의 경우!
		else {
			qnaDTO.setC_id(multipartRequest.getParameter("c_id"));
		}
		try {
			if (sessionDto.getM_group() != null) {
				if (sessionDto.getM_group().equals("2")) {
					qnaDTO.setM_id(multipartRequest.getParameter("c_id"));
					qnaDTO.setQ_pwd(multipartRequest.getParameter("c_pwd"));
				} else {
					qnaDTO.setM_id(multipartRequest.getParameter("m_id"));
					qnaDTO.setQ_pwd(multipartRequest.getParameter("q_pwd"));
				}
			} else {
				qnaDTO.setM_id(multipartRequest.getParameter("m_id"));
				qnaDTO.setQ_pwd(multipartRequest.getParameter("q_pwd"));
			}
		} catch (Exception e) {
		}
		qnaDTO.setM_id(multipartRequest.getParameter("m_id"));
		qnaDTO.setQ_pwd(multipartRequest.getParameter("q_pwd"));
		qnaDTO.setQ_title(multipartRequest.getParameter("q_title"));
		qnaDTO.setQ_content(q_content);
		qnaDTO.setQ_file(multipartRequest.getFilesystemName((String) multipartRequest.getFileNames().nextElement()));

		System.out.println("수동" + qnaDTO.getM_id());
		System.out.println("수동1" + qnaDTO.getQ_pwd());
		System.out.println("수동2" + qnaDTO.getQ_title());
		System.out.println("수동3" + qnaDTO.getQ_content());

		// 글번호 구하기.
		qnaDTO.setQ_id(qnaDAO.getQid());
		// 게시글 등록.

		try {
			if (group.equals("2"))
				result = qnaDAO.setBoardInsert_corp(qnaDTO);
			else
				result = qnaDAO.setBoardInsert(qnaDTO);

		} catch (NullPointerException e) {
			// 비회원
			result = qnaDAO.setBoardInsert(qnaDTO);

		}

		if (result == false) {
			System.out.println("게시판 등록 실패");
			return null;
		} else {
			System.out.println("게시판 등록 완료");
		}
		modelAndView.setViewName("forward:./list.qna");
		return modelAndView;

		// List<QnADTO> corpList = qnaDAO.getCorpList();
		// modelAndView.addObject("corpList", corpList);

		// if (group != null) {
		// // 회사관리자의 경우에는 "id"값을 c_id변수에 할당하여 커맨드에 저장함.
		// // (회사관리자의 id는 c_id와 동일)
		// if (group.equals("2")) {
		// String c_id = (String) session.getAttribute("id");
		// qnaCommand.setC_id(c_id);
		// } else {
		// // 회사관리자가 아닌 경우(admin 또는 일반회원)에는 파라미터 값을 커맨드에 저장함.
		// qnaCommand.setC_id(multipartRequest.getParameter("c_id"));
		// }
		// }
		// // 비로그인 사용자의 경우!
		// else {
		// qnaCommand.setC_id(multipartRequest.getParameter("c_id"));
		// }
		//
		// qnaCommand.setM_id(multipartRequest.getParameter("m_id"));
		// qnaCommand.setQ_pwd(multipartRequest.getParameter("q_pwd"));
		// qnaCommand.setQ_title(multipartRequest.getParameter("q_title"));
		// qnaCommand.setQ_content(q_content);
		// qnaCommand.setQ_file(
		// multipartRequest.getFilesystemName((String)
		// multipartRequest.getFileNames().nextElement()));
		//
		//
		//
		//
		// result = qnaDAO.boardInsert(qnaDTO);

	}
}
