package security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NguoiDung;

@WebFilter("/*")
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path = req.getServletPath();
		NguoiDung nguoiDung = (NguoiDung) req.getSession().getAttribute("nguoiDung");
//		System.out.println(nguoiDung);
		System.out.println();
		
		
		if (SecurityUltils.isSecurityPage(req,path)) {// coi xem có phải trang cần đăng nhập không
			if(nguoiDung==null) {
				
				
				res.sendRedirect(req.getContextPath()+"/MainServlet");
				return;
			}
			if(nguoiDung.getRoles()==null) {// nếu chưa đăng nhập
				res.sendRedirect(req.getContextPath()+"/LoginServlet");
				return ;
			}
			if(!SecurityUltils.hasPermission(req,nguoiDung)) {// nếu không đủ quyền 
				request.getRequestDispatcher("/MainServlet").forward(req, response);
				return;
			}
			
		}
		
		chain.doFilter(req, res);
	}

}
