package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.ProdCartListService;
import vo.ActionForward;
import vo.Cart;

public class ProdCartListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProdCartListService prodCartListService = new ProdCartListService();
		ArrayList<Cart> cartList = prodCartListService.getCartList(request);
		
		if(cartList != null && cartList.size()>0) {
			//총 금액 계산
			int totalMoney = 0;
			int money = 0;
			
			for (int i = 0; i < cartList.size(); i++) {
				money = cartList.get(i).getP_price()*cartList.get(i).getP_qty();
				totalMoney += money;
			}
			
			request.setAttribute("totalMoney", totalMoney);
			request.setAttribute("cartList", cartList);
			ActionForward forward = new ActionForward("cart.jsp", false);
			return forward;
		} else {
			ActionForward forward = new ActionForward("cart.jsp", false);
			return forward;
		}
	}

}
