package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.BoardBean;
import dao.BoardDAO;

public class BoardModifyProService {
	
	public boolean modifyArticle(BoardBean article) throws Exception {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		try {
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			int updateCount = boardDAO.updateArticle(article);
			
			if(updateCount > 0) {
				commit(con);
				isModifySuccess = true;
			} else {
				rollback(con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isModifySuccess;
	}

}
