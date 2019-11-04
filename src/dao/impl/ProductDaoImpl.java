package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import dao.ProductDao;
import model.Category;
import model.Product;
import utils.DBHelper;

public class ProductDaoImpl implements ProductDao{

	CategoryDao categoryDao = new CategoryDaoImpl();

	
	public ProductDaoImpl() {

	}

	@Override
	public boolean addProduct(Product product) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=DBHelper.getConnection();
			//String sql = "INSERT INTO products(ProductID,Name, Manufacturer, Image, Price, CategoryID, Description, Quantity,Condition) VALUES(?,?,?,?,?,?,?,?,?)";
			String sql = "INSERT INTO `products` (`ProductID`, `Name`, `Manufacturer`, `Image`, `Price`, `CategoryID`, `Description`, `Quantity`, `Condition`) VALUES(?,?,?,?,?,?,?,?,?)";

			
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getManufacturer());
			stmt.setString(4, product.getImage());
			stmt.setInt(5, product.getPrice());
			stmt.setInt(6, product.getCate().getId());			
			stmt.setString(7, product.getDescription());
			stmt.setInt(8, product.getQty());
			stmt.setString(9,product.getCondition());
			stmt.execute();
			return true;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
//SELECT * FROM products p INNER JOIN categories c ON p.CategoryID = c.CategoryID WHERE p.ProductID = 1569824797134

	@Override
	public Product getProductById(long id) {
		Product product;
		Category category;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT * FROM products p INNER JOIN categories c ON p.CategoryID = c.CategoryID WHERE p.ProductID = ?";
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs=stmt.executeQuery();
			if(rs.next()){
				product=new Product();
				category = new Category();
				product.setId(rs.getLong("ProductID"));
				product.setCate(categoryDao.get(rs.getInt("CategoryID")));
				product.setName(rs.getString("Name"));
				product.setDescription(rs.getString("Description"));
				product.setManufacturer(rs.getString("Manufacturer"));
				product.setImage(rs.getString("Image"));
				product.setPrice(rs.getInt("Price"));
				product.setQty(rs.getInt("Quantity"));
				category.setId(rs.getInt("CategoryID"));
				category.setName(rs.getString("CateName"));
				product.setCate(category);
				return product;
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
	public List<Product> getAllProducts() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Product> products=new ArrayList<Product>();
		
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT * FROM products p INNER JOIN categories c ON p.CategoryID = c.CategoryID";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				Product product=new Product();
				Category category = new Category();
				product.setId(rs.getLong("ProductID"));
				product.setCate(categoryDao.get(rs.getInt("CategoryID")));
				product.setName(rs.getString("Name"));
				product.setDescription(rs.getString("Description"));
				product.setManufacturer(rs.getString("Manufacturer"));
				product.setImage(rs.getString("Image"));
				product.setPrice(rs.getInt("Price"));
				product.setQty(rs.getInt("Quantity"));
				category.setId(rs.getInt("CategoryID"));
				category.setName(rs.getString("CateName"));
				product.setCate(category);
				products.add(product);
			}
			return products;
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

	
	
//	public static void main(String[] args){
//		ProductDao a=new ProductDaoImpl();
//		Product product = new Product("1",1,1,"1","1","1");
//		a.addProduct(product);
//		
//	}
//	public static void main(String[] args){
//		ProductDao a=new ProductDaoImpl();
//		List<Product> items=a.getAllProducts();
//		System.out.println(items.size());
//		for(Product i:items){
//		System.out.println(i.getId());
//		System.out.println(i.getCate().getName());
//		}
//	}
	
	
}
