package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProdCartRemoveService;
import vo.ActionForward;

public class ProdCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] p_nameArray = request.getParameterValues("remove");
		ProdCartRemoveService prodCartRemoveService = new ProdCartRemoveService();
		prodCartRemoveService.cartRemove(request,p_nameArray);
		ActionForward forward = new ActionForward("prodCartList.prod",true);
		return forward;
	}

}
