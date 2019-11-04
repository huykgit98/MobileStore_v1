package dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;


public interface ProductDao {
		
	//add product 
	boolean addProduct(Product product);
	
	public Product getProductById(long id);
	
	public List<Product> getAllProducts();

	
}
