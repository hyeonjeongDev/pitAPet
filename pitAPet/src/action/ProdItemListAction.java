package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ProdItemListService;
import vo.ActionForward;
import vo.ProdBean;

public class ProdItemListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProdItemListService prodItemListService = new ProdItemListService();
		String p_item = request.getParameter("p_item");
		ArrayList<ProdBean> prodItemList=prodItemListService.getProdItemList(p_item);
		request.setAttribute("prodItemList", prodItemList);

		ActionForward forward = null;
		forward = new ActionForward();
		forward.setPath("./prod_item_list.jsp");
		
		return forward;
	}
}