package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsService;

@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		String tenDangNhap = req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau");
		NewsService service = (NewsService) req.getSession().getAttribute("newsService");
		if(service.checkDangNhap(tenDangNhap, matKhau)) {//nếu đăng nhập đúng
			
		}
		
		}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.getRequestDispatcher("dangNhap.jsp").forward(req, resp);
}
}
