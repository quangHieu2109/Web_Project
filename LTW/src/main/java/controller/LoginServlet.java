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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		if(req.getSession().getAttribute("nguoiDung") != null) {
			req.getSession().removeAttribute("nguoiDung");
		}
		if (nguoiDung != null) {// nếu đăng nhập đúng
			System.out.println(nguoiDung);
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
