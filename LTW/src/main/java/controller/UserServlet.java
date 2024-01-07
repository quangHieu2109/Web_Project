package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DangKyDangBai;
import model.NewsService;
import model.NguoiDung;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String type = request.getParameter("type");
		if (type.equals("dangNhap")) {
			dangNhap(request, response);
		} else if (type.equals("dangKy")) {
			dangKy(request, response);
		} else if (type.equals("login")) {
			login(request, response);
		} else if (type.equals("register")) {
			register(request, response);
		} else if (type.equals("logout")) {
			logout(request, response);
		} else if (type.equals("editIn4")) {
			editIn4(request, response);
		}else if (type.equals("dangKyDangBai")) {
			dangKyDangBai(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		NewsService service = (NewsService) request.getSession().getAttribute("newsService");
		if (service == null) {
			service = new NewsService();

		}
		String error = "";
		NguoiDung nguoiDung = service.getNguoiDung(tenDangNhap);
		if (nguoiDung == null) {
			error = "Tài khoản không chính xác";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/dangNhap.jsp").forward(request, response);
		} else {
			if (!nguoiDung.getMatKhau().equals(matKhau)) {
				error = "Mật khẩu không chính xác";
				request.setAttribute("error", error);
				request.getRequestDispatcher("/dangNhap.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("nguoiDung", nguoiDung);

				request.getRequestDispatcher("/MainServlet").forward(request, response);
			}
		}

	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("MainServlet");
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String ngaySinh = request.getParameter("ngaySinh");
		NewsService service = (NewsService) request.getSession().getAttribute("newsService");
		if (service == null) {
			service = new NewsService();
			request.getSession().setAttribute("newsService", service);

		}
		if (service.addNguoiDung(new NguoiDung(tenDangNhap, matKhau, hoTen, email, Date.valueOf(ngaySinh))) != 0) {
			request.setAttribute("error", "Đăng ký tài khoản thành công!");
			request.getRequestDispatcher("dangNhap.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("dangKy.jsp").forward(request, response);
		}
	}

	protected void dangNhap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("dangNhap.jsp");
	}

	protected void dangKy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("dangKy.jsp");
	}
	protected void dangKyDangBai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String typeDK = request.getParameter("typeDK");
		NewsService newsService =(NewsService) request.getSession().getAttribute("newsService");
		if(typeDK.equals("danhSach")) {
			request.getSession().setAttribute("danhSachDK", newsService.getDangKyDangBai());
			System.out.println("size :"+newsService.getDangKyDangBai().size());
			response.sendRedirect("danhSachDangKy.jsp");
		}else if(typeDK.equals("xoa")) {
			String maDK = request.getParameter("maDK");
			newsService.deleteDangKy(maDK);
			request.getSession().setAttribute("danhSachDK", newsService.getDangKyDangBai());
			response.sendRedirect("danhSachDangKy.jsp");
		}else if(typeDK.equals("chapNhan")) {
			String maDK = request.getParameter("maDK");
			DangKyDangBai dkdb = newsService.getDangKyDangBaiByMaDK(maDK);
			NguoiDung nguoiDung = dkdb.getNguoiDung();
			nguoiDung.setTheLoaiND("NhaBao");
			newsService.updateNguoiDung(nguoiDung);
			newsService.deleteDangKy(maDK);
			request.getSession().setAttribute("danhSachDK", newsService.getDangKyDangBai());
			response.sendRedirect("danhSachDangKy.jsp");
		}
	}
	protected void editIn4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");
		String matKhau = request.getParameter("matKhau");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String ngaySinh = request.getParameter("ngaySinh");
		nguoiDung.setHoVaTen(hoTen);
		nguoiDung.setMatKhau(matKhau);
		nguoiDung.setEmail(email);
		nguoiDung.setNgaySinh(Date.valueOf(ngaySinh));
		NewsService service = (NewsService) request.getSession().getAttribute("newsService");
		if (service == null) {
			service = new NewsService();
			request.getSession().setAttribute("newsService", service);

		}
		service.updateNguoiDung(nguoiDung);
		request.setAttribute("thongBao", "Thay đổi thông tin thành công");
		request.getRequestDispatcher("thayDoiThongTin.jsp").forward(request, response);
	}

}
