package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.Item;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;


@WebServlet("/addtocart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }


private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quantity = 1;
		long id = Long.parseLong(req.getParameter("productId"));

		if(req.getParameter("productId")!=null) {
			//id = Long.parseLong(req.getParameter("productId"));
			Product product = productService.getProductbyId(id);
			if(product!=null) {
				if(req.getParameter("quantity")!=null) {
					quantity = Integer.parseInt(req.getParameter("quantity"));
				}
				HttpSession session = req.getSession();
				if(session.getAttribute("order")==null) {
					Order order = new Order();
					List<Item> listItems = new ArrayList<Item>();
					Item item = new Item();
					item.setQty(quantity);
					item.setProduct(product);
					item.setPrice(product.getPrice());
					listItems.add(item);
					order.setItems(listItems);
					session.setAttribute("order", order);
				} else {
					Order order = (Order) session.getAttribute("order");
					List<Item> listItems = order.getItems();
					boolean check = false;
					for(Item item : listItems) {
						if(item.getProduct().getId()==product.getId()) {
							item.setQty(item.getQty()+quantity);
							check = true;
						}
					}
					if(check==false) {
						Item item = new Item();
						item.setQty(quantity);
						item.setProduct(product);
						item.setPrice(product.getPrice());
						listItems.add(item);
					}
					session.setAttribute("order", order);
				}
			}
			resp.sendRedirect(req.getContextPath()+"/client/cart.jsp");
		} else {
			resp.sendRedirect(req.getContextPath()+"/product-list.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		super.doPost(req, resp);
	}
}