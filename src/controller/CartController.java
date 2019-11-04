package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.Order;
import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

			if (action.equalsIgnoreCase("clear")) {
				doGet_Remove(req, resp);
			}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/client/cart.jsp");
		dispatcher.forward(req, resp);
	}
//	protected void doGet_RemoveAll(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//		Order order = (Order) session.getAttribute("order");
//		order.);
//        session.setAttribute("order", order);
//        response.sendRedirect("order");
//    }
	protected void doGet_Remove(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	String key = req.getParameter("key");

	HttpSession session = req.getSession();
	Object obj = session.getAttribute("order");

	if (obj != null) {
		//resp.sendRedirect(req.getContextPath()+"/client/cart.jsp");

		Map<Long, Item> map = (Map<Long, Item>) obj;

		// xoa theo key
		map.remove(Long.parseLong(key));

		// update session
		session.setAttribute("order", map);
	}
	resp.sendRedirect(req.getContextPath() + "/client/cart.jsp");
	}
//	protected void doGet_Remove1(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		long id = Long.parseLong(request.getParameter("productId"));
//		HttpSession session = request.getSession();
//		List<Item> cart = (List<Item>) session.getAttribute("order");
//		int index = isExisting(id, cart);
//		cart.remove(index);
//		session.setAttribute("order", cart);
//		response.sendRedirect("order");
//	}
//	private int isExisting(Long id, Order oder) {
//		List<Item> cart=oder.getItems();
//		for (int i = 0; i < cart.size(); i++) {
//			if (cart.get(i)==id) {
//				return i;
//			}
//		}
//		return -1;
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		super.doPost(req, resp);
	}
}