package svc;

import java.sql.Connection;
import java.util.ArrayList;
import dao.UserDAO;
import static db.JdbcUtil.*;
import vo.UserBean;

public class UserListService {

	public ArrayList<UserBean> getUserList() {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		try {
			userDAO.setConnection(con);
			userList = userDAO.selectUserList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return userList;
	}
}
