package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProdDAO;
import static db.JdbcUtil.*;

import vo.ProdBean;

public class ProdItemListService {

	public ArrayList<ProdBean> getProdItemList(String p_item) {
		ProdDAO prodDAO = ProdDAO.getInstance();
		Connection con = getConnection();
		ArrayList<ProdBean> prodItemList = new ArrayList<ProdBean>();
		try {
			prodDAO.setConnection(con);
			prodItemList = prodDAO.selectProdItemList(p_item);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return prodItemList;
	}
}
