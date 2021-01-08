package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProdDAO;
import static db.JdbcUtil.*;

import vo.ProdBean;

public class ProdMainService {

	public ArrayList<ProdBean> getBestItem(Integer p_best) {
		Connection con = getConnection();
		ProdDAO prodDAO = ProdDAO.getInstance();
		ArrayList<ProdBean> bestItem = new ArrayList<ProdBean>();
		try {
			prodDAO.setConnection(con);
			bestItem = prodDAO.selectBestItem(p_best);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return bestItem;
	}
}
