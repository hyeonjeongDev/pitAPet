package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserJoinService;
import vo.ActionForward;
import vo.UserBean;

public class UserJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserBean user = new UserBean();
		boolean joinResult = false;

		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setMobile(request.getParameter("mobile"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));

		UserJoinService userJoinService = new UserJoinService();
		joinResult = userJoinService.joinUser(user);

		ActionForward forward = null;
		if (joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./join_success.jsp");
		}
		return forward;
	}

}
