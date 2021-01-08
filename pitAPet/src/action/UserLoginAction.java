package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserLoginService;
import vo.ActionForward;
import vo.UserBean;

public class UserLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserBean user = new UserBean();

		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));

		UserLoginService userLoginService = new UserLoginService();
		boolean loginResult = userLoginService.login(user);
		ActionForward forward = null;
		if (loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", user.getId());
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		} else {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("location.href='./userLogin.do';");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./userLogin.do");
		}
		return forward;
	}

}
