package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

//@WebServlet(name = "ProductController",urlPatterns = { "/productlist" })
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductService productService = new ProductServiceImpl();

    public ProductListController() {
        super();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = productService.getAllProducts();
       

		req.setAttribute("productList", products);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/client/product-list.jsp");
		requestDispatcher.forward(req, resp);
	}
	
//	public static void main(String[] args){
//	
//	ProductService productService = new ProductServiceImpl();
//	List<Product> products=productService.getAllProducts();
//	System.out.println(products.size());
//	for(Product i:products){
//		System.out.println(i.getImage());
//	}
//	}
}