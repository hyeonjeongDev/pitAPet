package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProdDAO;
import vo.Cart;
import vo.Product;

public class ProdCartAddService {

	public Product getCartProd(int p_id) {
		Connection con = getConnection();
		ProdDAO prodDAO = ProdDAO.getInstance();
		Product product = null;
		try {
			prodDAO.setConnection(con);
			product = prodDAO.selectProd(p_id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return product;
	}
	
	public void addCart(HttpServletRequest request, Product cartProd) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
		}
		
		boolean isNewCart = true;
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartProd.getP_name().equals(cartList.get(i).getP_name())) {
				isNewCart = false;
				cartList.get(i).setP_qty(cartList.get(i).getP_qty()+1);
				break;
			}
		}
		
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setP_image(cartProd.getP_image());
			cart.setP_name(cartProd.getP_name());
			cart.setP_price(cartProd.getP_price());
			cart.setP_qty(1);
			cartList.add(cart);
		}
		session.setAttribute("cartList", cartList);
	}
}
