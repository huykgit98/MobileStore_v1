package service;

import java.util.List;

import model.Product;

public interface ProductService {
	void addProduct(Product book);
	Product getProductbyId(long id);
    public List<Product> getAllProducts();

}
