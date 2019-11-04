package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/product-detail"})
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;

    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		productService = new ProductServiceImpl();
		long id = Long.parseLong(req.getParameter("id"));
		Product product = productService.getProductbyId(id);
		req.setAttribute("product", product);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/client/product-detail.jsp");
		requestDispatcher.forward(req, resp);
	}


}
