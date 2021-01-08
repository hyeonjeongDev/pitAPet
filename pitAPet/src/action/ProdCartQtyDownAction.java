package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProdCartQtyDownService;
import vo.ActionForward;

public class ProdCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String p_name = request.getParameter("p_name");
		ProdCartQtyDownService prodCartQtyDownService = new ProdCartQtyDownService();
		prodCartQtyDownService.downCartQty(p_name,request);
		ActionForward forward = new ActionForward("prodCartList.prod",true);
		return forward;
	}

}
