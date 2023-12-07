package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsService;
import model.NguoiDung;

@WebServlet("RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenDangNhap = req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau");
		String hoTen = req.getParameter("hoTen");
		String email = req.getParameter("email");
		String ngaySinh = req.getParameter("ngaySinh");
		NewsService service = (NewsService) req.getSession().getAttribute("newsService");
		service.addNguoiDung(new NguoiDung(tenDangNhap, matKhau, hoTen, email, null));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("dangKy.jsp").forward(req, resp);
	}
}
