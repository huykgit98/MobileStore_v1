package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import model.Category;
import model.Product;
import utils.DBHelper;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public Category get(int id) {
		Category category=new Category();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBHelper.getConnection();
			String sql="select * from categories where CategoryID=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs.next()){
				category.setId(rs.getInt("CategoryID"));
				category.setName(rs.getString("CateName"));
				category.setDescription(rs.getString("Description"));

				return category;
			}
			else{
				return null;
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
					stmt=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Category> search() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Category> listCategories = new ArrayList<Category>();
		
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT * FROM categories ";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.setId(rs.getInt("CategoryID"));
				category.setName(rs.getString("CateName"));
				listCategories.add(category);
			}
			return listCategories;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			
			if(stmt!=null){
				try {
					stmt.close();
					stmt=null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
