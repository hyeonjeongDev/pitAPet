package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardDeleteProService {
		
	public boolean removeArticle(int board_num) throws Exception {

		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		try {
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			int deleteCount = boardDAO.deleteArticle(board_num);
			
			if(deleteCount > 0) {
				commit(con);
				isRemoveSuccess = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isRemoveSuccess;
	}

}
