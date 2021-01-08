package action;

import java.io.PrintWriter;
import javax.servlet.http.*;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {
	
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
		} else {
			boolean isModifySuccess = false;
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			BoardBean article = new BoardBean();
			BoardModifyProService boardModifyProService = new BoardModifyProService();
	
			article.setBoard_num(board_num);
			article.setBoard_subject(request.getParameter("board_subject"));
			article.setBoard_content(request.getParameter("board_content"));
			isModifySuccess = boardModifyProService.modifyArticle(article);
			
			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 실패')");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+article.getBoard_num());
			}
		}
		return forward;
	}

}
