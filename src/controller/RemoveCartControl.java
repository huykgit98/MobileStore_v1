package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

/**
 * Servlet implementation class RemoveCartControl
 */
//@WebServlet(urlPatterns="/remove-cart")
@WebServlet(name = "RemoveCartControl", urlPatterns = {"/remove-cart"})
public class RemoveCartControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productId = req.getParameter("idP");
		// them vao session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("carts");
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
				session.removeAttribute("carts");
				session.setAttribute("soLuong", 0);
			} else {
				int soLuong = 0;
				for(Item cartItem : carts){
					soLuong += cartItem.getQty();
				}
				session.setAttribute("carts", carts);
				session.setAttribute("soLuong", soLuong);
			}
			
		}
		// end
		resp.sendRedirect(req.getContextPath() + "/gio-hang");
	}
}