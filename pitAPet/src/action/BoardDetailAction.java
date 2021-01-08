package action;

import javax.servlet.http.*;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ActionForward forward = new ActionForward();

		if(id != null && id.equals("admin")) {
			forward.setPath("./board_view_admin.jsp");
		} else {
			forward.setPath("./board_view.jsp");
		}
		return forward;
		
	}

}
