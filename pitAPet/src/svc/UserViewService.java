package svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserViewService {

	public UserBean getUser(String viewId) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		UserBean user = null;
		try {
			userDAO.setConnection(con);
			user = userDAO.selectUser(viewId);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return user;
	}
}
