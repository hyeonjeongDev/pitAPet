package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProdCartQtyUpService;
import vo.ActionForward;

public class ProdCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String p_name = request.getParameter("p_name");
		ProdCartQtyUpService prodCartQtyUpService = new ProdCartQtyUpService();
		prodCartQtyUpService.upCartQty(p_name,request);
		ActionForward forward = new ActionForward("prodCartList.prod",true);
		return forward;
	}

}
