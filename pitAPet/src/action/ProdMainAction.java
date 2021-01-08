package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProdMainService;
import vo.ActionForward;
import vo.ProdBean;

public class ProdMainAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProdMainService prodMainService = new ProdMainService();
		Integer p_best = Integer.parseInt(request.getParameter("p_best"));
		ArrayList<ProdBean> bestItem=prodMainService.getBestItem(p_best);
		request.setAttribute("bestItem", bestItem);

		ActionForward forward = null;
		forward = new ActionForward();
		forward.setPath("./main.jsp");
		
		return forward;
	}
}