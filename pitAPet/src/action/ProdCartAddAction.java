package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.ProdCartAddService;
import vo.ActionForward;
import vo.Product;

public class ProdCartAddAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProdCartAddService prodCartAddService = new ProdCartAddService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Product cartProd = prodCartAddService.getCartProd(p_id);
		prodCartAddService.addCart(request, cartProd);
		ActionForward forward = new ActionForward("prodCartList.prod", true);
		return forward;
	}

}
