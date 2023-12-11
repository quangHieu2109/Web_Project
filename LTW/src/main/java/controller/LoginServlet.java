package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCUtil;
import model.NewsService;
import model.NguoiDung;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenDangNhap = req.getParameter("tenDangNhap") == null ? "" : req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau") == null ? "" : req.getParameter("matKhau");
		NewsService service = (NewsService) req.getSession().getAttribute("newsService");
		JDBCUtil.connection();
		NguoiDung nguoiDung = service.checkDangNhap(tenDangNhap, matKhau);
		if (nguoiDung != null) {// nếu đăng nhập đúng
			req.getSession().setAttribute("nguoiDung", nguoiDung);
			service.setIsLogin(true);
			req.getRequestDispatcher("trangChu.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("dangNhap.jsp").forward(req, resp);
		}
		JDBCUtil.closeConnection();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("dangNhap.jsp").forward(req, resp);
	}
}
