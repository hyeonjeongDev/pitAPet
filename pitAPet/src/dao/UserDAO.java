package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;
import vo.UserBean;
import static db.JdbcUtil.*;

public class UserDAO {
	public static UserDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private UserDAO() {
		
	}
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public String selectLoginId(UserBean user) {
		String loginId = null;
		String sql="SELECT id FROM user WHERE id=? AND password=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("id");
			}
		} catch(Exception ex) {
			System.out.println(" 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}
	
	public int insertUser(UserBean user) {
		String sql="INSERT INTO user VALUES (?,?,?,?,?,?)";
		int insertCount=0;
		
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getMobile());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getAddress());
			insertCount=pstmt.executeUpdate();
			
		} catch(Exception ex) {
			System.out.println("joinUser 에러: " + ex);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public ArrayList<UserBean> selectUserList() {
		String sql="SELECT * FROM user";
		ArrayList<UserBean> userList=new ArrayList<UserBean>();
		UserBean ub = null;
		try {
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					ub=new UserBean();
					ub.setId(rs.getString("id"));
					ub.setPassword(rs.getString("password"));
					ub.setName(rs.getString("name"));
					ub.setMobile(rs.getString("mobile"));
					ub.setEmail(rs.getString("email"));
					ub.setAddress(rs.getString("address"));
					userList.add(ub);
				} while(rs.next());
			}
		} catch(Exception ex) {
			System.out.println("getDeatilUser 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return userList;
	}
	
	public UserBean selectUser(String id) {
		String sql="SELECT * FROM user WHERE id=?";
		UserBean ub = null;
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ub=new UserBean();
				ub.setId(rs.getString("id"));
				ub.setPassword(rs.getString("password"));
				ub.setName(rs.getString("name"));
				ub.setMobile(rs.getString("mobile"));
				ub.setEmail(rs.getString("email"));
				ub.setAddress(rs.getString("address"));
			}
		} catch(Exception ex) {
			System.out.println("getDeatilUser 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return ub;
	}
	
	public int deleteUser(String id) {
		String sql="DELETE FROM user WHERE id=?";
		int deleteCount = 0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception ex) {
			System.out.println("deleteUser 에러: " + ex);
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
}
