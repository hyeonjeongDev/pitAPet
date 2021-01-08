package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.ProdDAO;
import vo.Product;

public class ProdViewService {

	public Product getProdView(int p_id) {
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
}
