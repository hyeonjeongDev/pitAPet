package action;

import java.io.PrintWriter;
import javax.servlet.http.*;
import svc.BoardDeleteProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

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
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			String nowPage = request.getParameter("page");
			BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
			
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
			
			if(!isDeleteSuccess) {
				response.setContentType("text/html;charset = UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page="+nowPage);
			}
		}
		return forward;
	}

}
