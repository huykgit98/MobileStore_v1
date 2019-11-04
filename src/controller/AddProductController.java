package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Category;
import model.Product;
import model.User;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product-add")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService ;
	CategoryService categoryService;
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init() throws ServletException {
    	productService = new ProductServiceImpl();
    	categoryService = new CategoryServiceImpl();
		super.init();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> listCategories = categoryService.search();
		req.setAttribute("listCategories", listCategories);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product-add.jsp");
		dispatcher.forward(req, resp);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{			
	        String name = request.getParameter("productName");
	        String errorString = null;

	            int price = Integer.valueOf(request.getParameter("price"));
	            int units_in_stock = Integer.valueOf(request.getParameter("units_in_stock"));

	        String description = request.getParameter("description");
	        String manufacturer = request.getParameter("manufacturer");
	        String condition = request.getParameter("condition");

	       String image = request.getParameter("image");
			String categoryID = request.getParameter("category");
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(description);
			product.setManufacturer(manufacturer);
			product.setQty(units_in_stock);
			product.setImage(image);
			product.setCondition(condition);
			product.setCate(categoryService.get(Integer.parseInt(categoryID)));
	        if (errorString == null) {
	            try {
	            	productService.addProduct(product);
	            } catch (Exception e) {
	                e.printStackTrace();
	                errorString = e.getMessage();
	            }
	        }
	 
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("product", product);
	 
	        if (errorString != null) {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/product-add.jsp");
	            dispatcher.forward(request, response);
	        }
	        
	        else {
	            response.sendRedirect(request.getContextPath() + "/admin/product-add");
	        }
	    }catch(Exception e){}

	
	}
	
//	public static void main(String[] args){
//		CategoryService categoryService = new CategoryServiceImpl();
//		List<Category> listCategories = categoryService.search();
//	System.out.println(listCategories.size());
//	for(Category i:listCategories){
//	System.out.println(i.getId());
//	System.out.println(i.getName());
//	}
//}

}
