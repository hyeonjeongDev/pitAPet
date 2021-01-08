package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class ProdCartRemoveService {

	public void cartRemove (HttpServletRequest request, String[] p_nameArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < p_nameArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if(cartList.get(j).getP_name().equals(p_nameArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}
}
