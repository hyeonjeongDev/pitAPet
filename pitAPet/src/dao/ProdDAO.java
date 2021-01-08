package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;

import vo.ProdBean;
import vo.Product;

public class ProdDAO {

	Connection con;
	private static ProdDAO boardDAO;
	
	private ProdDAO() {

	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static ProdDAO getInstance() {
		
		if(boardDAO == null) {
			boardDAO = new ProdDAO();
		}
		return boardDAO;
	}
	
	public ArrayList<Product> selectProdList() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> prodList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				prodList = new ArrayList<Product>();
				
				do {
					prodList.add(new Product(
							rs.getInt("p_id")
							,rs.getString("p_item")
							,rs.getInt("p_best")
							,rs.getString("p_name")
							,rs.getInt("p_price")
							,rs.getString("p_option")
							,rs.getString("p_image")
							,rs.getString("p_content")));
				} while (rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return prodList;
	}
	
	public Product selectProd(int p_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM product WHERE p_id=?");
			pstmt.setInt(1, p_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product(
						rs.getInt("p_id")
						,rs.getString("p_item")
						,rs.getInt("p_best")
						,rs.getString("p_name")
						,rs.getInt("p_price")
						,rs.getString("p_option")
						,rs.getString("p_image")
						,rs.getString("p_content"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return product;
	}
	
	public int insertProd(Product product) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO product VALUES(null,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getP_item());
			pstmt.setInt(2, product.getP_best());
			pstmt.setString(3, product.getP_name());
			pstmt.setInt(4, product.getP_price());
			pstmt.setString(5, product.getP_option());
			pstmt.setString(6, product.getP_image());
			pstmt.setString(7, product.getP_content());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public ArrayList<ProdBean> selectProdItemList(String p_item) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM product WHERE p_item=?";
		ArrayList<ProdBean> prodItemList=new ArrayList<ProdBean>();
		ProdBean pb = null;
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, p_item);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					pb=new ProdBean();
					pb.setP_id(rs.getInt("p_id"));
					pb.setP_item(rs.getString("p_item"));
					pb.setP_best(rs.getInt("p_best"));
					pb.setP_name(rs.getString("p_name"));
					pb.setP_price(rs.getInt("p_price"));
					pb.setP_option(rs.getString("p_option"));
					pb.setP_image(rs.getString("p_image"));
					pb.setP_content(rs.getString("p_content"));
					prodItemList.add(pb);
				} while(rs.next());
			}
		} catch(Exception ex) {
			System.out.println("getDeatilProd 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return prodItemList;
	}
	
	public ArrayList<ProdBean> selectBestItem(Integer p_best) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM product WHERE p_best=?";
		ArrayList<ProdBean> prodItemList=new ArrayList<ProdBean>();
		ProdBean pb = null;
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, p_best);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					pb=new ProdBean();
					pb.setP_id(rs.getInt("p_id"));
					pb.setP_item(rs.getString("p_item"));
					pb.setP_best(rs.getInt("p_best"));
					pb.setP_name(rs.getString("p_name"));
					pb.setP_price(rs.getInt("p_price"));
					pb.setP_option(rs.getString("p_option"));
					pb.setP_image(rs.getString("p_image"));
					pb.setP_content(rs.getString("p_content"));
					prodItemList.add(pb);
				} while(rs.next());
			}
		} catch(Exception ex) {
			System.out.println("getDeatilProd 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return prodItemList;
	}

	public int deleteProd(Integer p_id) {
		PreparedStatement pstmt = null;
		String sql="DELETE FROM product WHERE p_id=?";
		int deleteCount = 0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception ex) {
			System.out.println("deleteProd 에러: " + ex);
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
}
