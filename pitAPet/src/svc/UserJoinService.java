package svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserJoinService {
	
	public boolean joinUser (UserBean user) {
		boolean joinSuccess = false;
		UserDAO userDAO = UserDAO.getInstance();
		Connection con = getConnection();
		try {
		userDAO.setConnection(con);
		int insertCount = userDAO.insertUser(user);
		if(insertCount > 0) {
			joinSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		close(con);
		}
		return joinSuccess;
	}
}
