package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ProdDeleteService;
import vo.ActionForward;

public class ProdDeleteAction implements Action {
	
	@Override
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
			Integer deleteId=Integer.parseInt(request.getParameter("p_id"));
			ProdDeleteService prodDeleteService = new ProdDeleteService();
			boolean deleteResult=prodDeleteService.deleteProd(deleteId);
			
			if(deleteResult) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./prodList.prod");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('상품정보삭제 실패.')");
				out.println("location.href='./prodView.prod';");
				out.println("</script>");
			}
		}
		return forward;
	}
}
