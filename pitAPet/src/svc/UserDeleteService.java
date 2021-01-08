package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserDeleteService {

	public boolean deleteUser (String deleteId) {
		boolean deleteResult = false;
		Connection con = getConnection();
		try {
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		int deleteCount = userDAO.deleteUser(deleteId);
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
