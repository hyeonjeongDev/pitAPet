package action;

import java.io.PrintWriter;

import javax.servlet.http.*;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyFormAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		ActionForward forward = null;
		if(id==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./userLogin.do");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.')");
			out.println("location.href='./userLogin.do';");
			out.println("</script>");
		}
		else {	
			forward = new ActionForward();
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			BoardDetailService boardDetailService = new BoardDetailService();
			BoardBean article = boardDetailService.getArticle(board_num);
			request.setAttribute("article", article);
			forward.setPath("./board_modify.jsp");
		}
		return forward;
	}

}
