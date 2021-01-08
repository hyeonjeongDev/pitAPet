package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ProdListService;
import vo.ActionForward;
import vo.Product;

public class ProdListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ProdListService prodListService = new ProdListService();
		ArrayList<Product> prodList = prodListService.getProdList();
		request.setAttribute("prodList", prodList);
		ActionForward forward = null;
		if(id != null && id.equals("admin")) {
			forward = new ActionForward("prod_list.jsp", false);
		} else {
			forward = new ActionForward("view_all.jsp", false);
		}
		return forward;
	}

}
