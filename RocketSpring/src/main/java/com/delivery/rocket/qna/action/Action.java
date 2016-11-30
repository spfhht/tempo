package com.delivery.rocket.qna.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.delivery.rocket.qna.dto.QnADTO;

public interface Action {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, QnADTO qnaDTO) throws IOException;
}