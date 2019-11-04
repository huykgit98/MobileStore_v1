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

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Item;
import model.Order;
import model.Product;

/**
 * Servlet implementation class AddToCartControl
 */
//@WebServlet(urlPatterns = { "/add-cart"})
@WebServlet(name = "AddToCartControl", urlPatterns = {"/add-cart"})
public class AddToCartControl extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = new ProductDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idProduct = req.getParameter("idP");
		Product product = productDao.getProductById(Long.parseLong(idProduct));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("carts");
		if (obj == null) {
			Order order = new Order();
			Item cartItem = new Item();
			cartItem.setProduct(productDao.getProductById(Long.parseLong(idProduct)));
			cartItem.setQty(1);
			List<Item> carts = new ArrayList<Item>();
			carts.add(cartItem);
			order.setItems(carts);
			int soLuong = 0;

			for(Item item : carts){
				soLuong += item.getQty();

			}
			session.setAttribute("soLuong", soLuong);
			session.setAttribute("carts", carts);

		} else {
			List<Item> carts = (List<Item>) obj;
			// kiem tra xem product xem da co trong cart chua, neu co thi tang so luong,
			// chua co thi tao moi cartItem.
			boolean checkProduct = true;// gia su chua co product
			for (Item cartItem : carts) {
				if (cartItem.getProduct().getId() == Long.parseLong(idProduct)) {
					cartItem.setQty(cartItem.getQty() + 1);
					checkProduct = false;// da co product trong carts
					break;
				}
			}
			if (checkProduct) {
				Item cartItem = new Item();
				cartItem.setProduct(productDao.getProductById(Long.parseLong(idProduct)));
				cartItem.setQty(1);
				carts.add(cartItem);
			}
			int soLuong = 0;

			for(Item cartItem : carts){
				soLuong += cartItem.getQty();

			}
			int tong = 0;
			for(Item item : carts){
				tong+= item.getQty()*item.getProduct().getPrice();
			}
			session.setAttribute("carts", carts);
			session.setAttribute("soLuong", soLuong);
		
			req.setAttribute("tong", tong);

		}
		resp.sendRedirect(req.getContextPath() + "/gio-hang");
	}
}