package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCUtil;
import model.NewsService;
import model.NguoiDung;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau");
		String hoTen = req.getParameter("hoTen");
		String email = req.getParameter("email");
		String ngaySinh = req.getParameter("ngaySinh");
		NewsService service = (NewsService) req.getSession().getAttribute("newsService");
		if (service == null) {
			service = new NewsService();
			req.getSession().setAttribute("newsService", service);
			
		}
//		JDBCUtil.connection();
		if(service.addNguoiDung(new NguoiDung(tenDangNhap, matKhau, hoTen, email, Date.valueOf(ngaySinh)))!=0) {
			
			req.getRequestDispatcher("dangNhap.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("dangKy.jsp").forward(req, resp);
		}
//		JDBCUtil.closeConnection();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("dangKy.jsp").forward(req, resp);
	}
}
