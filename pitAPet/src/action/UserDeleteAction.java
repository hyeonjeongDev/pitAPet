package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserDeleteService;
import vo.ActionForward;

public class UserDeleteAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		PrintWriter out = response.getWriter();
		
		ActionForward forward = null;
		if(id==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./userLogin.do");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.')");
			out.println("location.href='./userLogin.do';");
			out.println("</script>");
		}
		else {
			String deleteId=request.getParameter("id");
			UserDeleteService userDeleteService = new UserDeleteService();
			boolean deleteResult=userDeleteService.deleteUser(deleteId);
			
			if(deleteResult) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./userListAction.do");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('회원정보삭제 실패.')");
				out.println("location.href='./userLogin.do';");
				out.println("</script>");
			}
		}
		return forward;
	}
}
