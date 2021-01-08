package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteProAction implements Action {
	
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
			BoardBean boardBean = null;
			String realFolder = "";
			String saveFolder = "/img";
			int fileSize = 5*1024*1024;
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			boardBean = new BoardBean();
			boardBean.setBoard_subject(multi.getParameter("board_subject"));
			boardBean.setBoard_content(multi.getParameter("board_content"));
			boardBean.setBoard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
			BoardWriteProService boardWriteProService = new BoardWriteProService();
			boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);
			
			if(!isWriteSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패')");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo");
			}
		}
		return forward;
	}

}

