package service.impl;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;
import java.util.Calendar;


public class ProductServiceImpl implements service.ProductService {

	ProductDao productDao=new ProductDaoImpl();
	Calendar cal = Calendar.getInstance();
	
	@Override
	public void addProduct(Product product) {
		product.setId(cal.getTimeInMillis());
		 productDao.addProduct(product);
		
	}

	@Override
	public Product getProductbyId(long id) {
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		list=productDao.getAllProducts();
		return list;
	}
	
	//test
//	public static void main(String[] args){
		
//	ProductService productService = new ProductServiceImpl();
//	List<Product> products=productService.getAllProducts();
//	System.out.println(products.size());
//	for(Product i:products){
//		System.out.println(i.getCate().getName());
//		System.out.println(i.getId());
	//}
		
		// create a calendar
//	      Calendar cal = Calendar.getInstance();
//
//	      // print current time in milliseconds
//	      System.out.println("Current time is : " + cal.getTimeInMillis());
//
//	      // add a delay of 2 seconds
//	      try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	      // create a new calendar
//	      Calendar cal2 = Calendar.getInstance();
//
//	      // print the next time in milliseconds
//	      long d = cal2.getTimeInMillis();
//	      System.out.println("Next time is : " + d);
//	      
//	}
	

}
