package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

/**
 * Servlet implementation class RemoveCartItemController
 */
//@WebServlet(urlPatterns = "/remove-cart-item")
@WebServlet(name = "RemoveCartItemController", urlPatterns = {"/remove-cart-item"})
public class RemoveCartItemController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productId = req.getParameter("id");
		// them vao session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("order");
		if (obj != null) {
			// ep kieu doi tuong sang List
			List<Item> carts = (List<Item>) obj;
			// tim trong list xem co thang product hay chua
			// delete item in list?
			for (Item cartItem : carts) {
				if (cartItem.getProduct().getId() == Long.valueOf(productId)) {
					carts.remove(cartItem);
					break;
				}
			}
			if (carts.isEmpty()) {
				session.removeAttribute("order");
				//session.setAttribute("soLuong", 0);
			} else {
				int soLuong = 0;
				for(Item cartItem : carts){
					soLuong += cartItem.getQty();
					
				}
				session.setAttribute("order", carts);
				//session.setAttribute("soLuong", soLuong);
			}
			
		}
		// end
		resp.sendRedirect(req.getContextPath() + "/gio-hang");
	}
	
}
