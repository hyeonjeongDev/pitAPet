package svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserLoginService {
	
	public boolean login (UserBean user) {
		boolean loginResult = false;
		Connection con = getConnection();
		try {
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		String loginId = userDAO.selectLoginId(user);
		if(loginId != null) {
			loginResult = true;
		}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return loginResult;
	}
}
