package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class UserLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('로그아웃되었습니다.')");
		out.println("location.href='./index.jsp';");
		out.println("</script>");
		
		out.close();
	
		return null;
	}

}
