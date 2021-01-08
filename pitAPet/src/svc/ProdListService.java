package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.ProdDAO;
import vo.Product;

public class ProdListService {

	public ArrayList<Product> getProdList() {
		ProdDAO prodDAO = ProdDAO.getInstance();
		Connection con = getConnection();
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			prodDAO.setConnection(con);
			prodList = prodDAO.selectProdList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return prodList;
	}
}
