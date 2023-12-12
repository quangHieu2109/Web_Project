package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

/**
 * Servlet implementation class LoginServlet
 */
=======
>>>>>>> ac5cecdd308c916437b8ac83adf6a45018bde85d


import database.JDBCUtil;
import model.NewsService;
import model.NguoiDung;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = req.getParameter("tenDangNhap") == null ? "" : req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau") == null ? "" : req.getParameter("matKhau");
		NewsService service = (NewsService) req.getSession().getAttribute("newsService");
		if (service == null) {
			service = new NewsService();
			
		}
		JDBCUtil.connection();
		NguoiDung nguoiDung = service.checkDangNhap(tenDangNhap, matKhau);
<<<<<<< HEAD
		System.out.println(nguoiDung);
		if (nguoiDung!=null) {// nếu đăng nhập đúng
			req.getSession().setAttribute("nguoiDung", nguoiDung);
			PrintWriter print = new PrintWriter(new FileWriter("data.txt", true));
			print.println("123123456456");
			print.close();
=======
		if (nguoiDung != null) {// nếu đăng nhập đúng
			req.getSession().setAttribute("nguoiDung", nguoiDung);
			service.setIsLogin(true);
>>>>>>> ac5cecdd308c916437b8ac83adf6a45018bde85d
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
<<<<<<< HEAD
	public static void main(String[] args) throws IOException {
		
	}
	
=======
>>>>>>> ac5cecdd308c916437b8ac83adf6a45018bde85d
}
