package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ProdViewService;
import vo.ActionForward;
import vo.Product;

public class ProdViewAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ProdViewService prodViewService = new ProdViewService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Product product = prodViewService.getProdView(p_id);
		request.setAttribute("product", product);
		ActionForward forward = null;
		if(id != null && id.equals("admin")) {
			forward = new ActionForward("prod_view_admin.jsp", false);
		} else {
			forward = new ActionForward("prod_view.jsp", false);
		}
		return forward;
	}
	
}
