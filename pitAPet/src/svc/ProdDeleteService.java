package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ProdDAO;

public class ProdDeleteService {

	public boolean deleteProd (Integer deleteId) {
		boolean deleteResult = false;
		Connection con = getConnection();
		try {
			ProdDAO prodDAO = ProdDAO.getInstance();
			prodDAO.setConnection(con);
			int deleteCount = prodDAO.deleteProd(deleteId);
			if(deleteCount > 0) {
				commit(con);
				deleteResult=true;
			}
			else {
				rollback(con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return deleteResult;
	}
}
