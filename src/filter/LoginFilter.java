package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns= {"/admin/*"})
public class LoginFilter implements Filter {

   
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest httpReq	 = (HttpServletRequest) req;
		HttpSession session = httpReq.getSession();
		if(session.getAttribute("current_user")!=null) {
			chain.doFilter(req, resp);
		}
		else {
			HttpServletResponse httpResp = (HttpServletResponse) resp;
			String url = httpReq.getRequestURI();
			if(url.contains("admin")) {
				httpResp.sendRedirect(httpReq.getContextPath()+"/login");
			}
		}
		resp.setCharacterEncoding("UTF-8");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
