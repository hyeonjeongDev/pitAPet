package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardListService {
	public int getListCount() throws Exception {
		
		int listCount = 0;
		Connection con = getConnection();
		try {
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			listCount = boardDAO.selectListCount();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}
	
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
		
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		try {
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			articleList = boardDAO.selectArticleList(page, limit);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return articleList;
	}
}
