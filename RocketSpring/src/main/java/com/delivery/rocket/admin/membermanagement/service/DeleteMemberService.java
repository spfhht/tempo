package com.delivery.rocket.admin.membermanagement.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.delivery.rocket.admin.membermanagement.action.Action;
import com.delivery.rocket.admin.membermanagement.dao.ManagementDao;
import com.delivery.rocket.admin.membermanagement.dto.MemberManageDto;

@Service
public class DeleteMemberService implements Action {

	@Autowired
	private ManagementDao memberMangeDao;

	@Override
	public ModelAndView execute(MemberManageDto MemberManageDto) {
		ModelAndView modelAndView = new ModelAndView();
		int result = 0;
		String m_id = MemberManageDto.getM_id();
		result = memberMangeDao.memberDelete(m_id);
		if (result == 0) {
			System.out.println("회원 삭제 실패");
			return null;
		}
		System.out.println("회원 삭제 성공");
	
	

		modelAndView.setViewName("redirect:./Member.AmmDo?page=1");
		return modelAndView;
	}

}

/*
 * public class DeleteMember implements Action {
 * 
 * @Override public ActionCommand execute(HttpServletRequest request,
 * HttpServletResponse response) throws Exception { ActionCommand actionCommand
 * = new ActionCommand(); boolean result = false; String m_id =
 * request.getParameter("m_id"); MemberManageDAO dao = new MemberManageDAO();
 * result = dao.memberDelete(m_id); if (result == false) { System.out.println(
 * "회원 삭제 실패"); return null; } System.out.println("회원 삭제 성공");
 * response.setContentType("text/html;charset=UTF-8"); PrintWriter out =
 * response.getWriter( ); out.println("<script>"); out.println(
 * "alert('삭제 되었습니다.');"); out.println("location.href='./Member.ammdo';");
 * out.println("</script>"); out.close( ); actionCommand.setRedirect(true);
 * actionCommand.setPath("./Member.ammdo"); return actionCommand; }
 */