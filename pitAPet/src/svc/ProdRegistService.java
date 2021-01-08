package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.ProdDAO;
import vo.Product;

public class ProdRegistService {

	public boolean registProd(Product product) {
		ProdDAO prodDAO = ProdDAO.getInstance();
		Connection con = getConnection();
		boolean isRegistSuccess = false;
		try {
			prodDAO.setConnection(con);
			int insertCount = prodDAO.insertProd(product);
			
			if(insertCount>0) {
				commit(con);
				isRegistSuccess=true;
			} else {
				rollback(con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isRegistSuccess;
	}
}
