package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class ProdCartQtyDownService {

	public void downCartQty(String p_name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			
			if(cartList.get(i).getP_name().equals(p_name)) {
				cartList.get(i).setP_qty(cartList.get(i).getP_qty()-1);
			}
		}
	}
}
