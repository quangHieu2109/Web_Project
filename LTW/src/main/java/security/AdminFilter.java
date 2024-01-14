package security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsService;
import model.NguoiDung;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns ={"/admin/*","/UserServlet?*type=danhSachDangKy*"})
public class AdminFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AdminFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute("nguoiDung");
		
			NewsService newsService = (NewsService) req.getSession().getAttribute("newsService");
			if(nguoiDung.getTenDangNhap()==null) {
				
				
				res.sendRedirect(newsService.rewriteURL(req.getContextPath()+"/UserServlet?type=dangNhap"));
			}else {
				if(nguoiDung.isAdmin() ) {
					chain.doFilter(req, res);
				}else {
					res.sendRedirect(newsService.rewriteURL(req.getContextPath()+"/thongBaoLoi.jsp"));
				}
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
