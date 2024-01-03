package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.TheLoaiDAO;
import model.APISaveImage;
import model.BaiBao;
import model.DSTheLoai;
import model.NewsService;
import model.NguoiDung;
import model.TheLoai;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cấu hình request respone
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		// Lấy kiểu form
		String type = request.getParameter("type") + "";
		System.out.println(type);
		if (type.equals("upAnh")) {
			upAnh(request, response);
		} else if (type.equals("dangBai")) {
			dangBai(request, response);
		} else if (type.equals("avt")) {
			doiAVT(request, response);
		} else {

			request.getRequestDispatcher("pageJournalist/dangBai.jsp").forward(request, response);
		}

	}

	private String getFileName(Part part) {
		String header = part.getHeader("content-disposition");
		for (String headerPart : header.split(";")) {
			if (headerPart.trim().startsWith("filename")) {
				return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

		// Cấu hình

	}

	private void upAnh(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Lấy tệp tin được tải lên từ yêu cầu
		Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);
		filePart.write(getServletContext().getRealPath("/img") + "/" + fileName);
		String filePath = getServletContext().getRealPath("/img") + "/" + fileName;

		request.getSession().setAttribute("filePath", filePath);

		String link = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/img/" + fileName;
		request.setAttribute("image", link);
		request.getSession().setAttribute("fileName", fileName);

		System.out.println(filePath);
		String theLoai = request.getParameter("theLoai");
		List<String> values = null;
		if (theLoai != null) {
			if (request.getParameterValues(theLoai) != null) {
				values = Arrays.asList(request.getParameterValues(theLoai));
			}
		} else {
			theLoai = "";
			values = new ArrayList<String>();
		}
		ArrayList<TheLoai> dsTLPhu = new ArrayList<TheLoai>();
		if (values != null) {
			for (String s : values) {
				dsTLPhu.add(TheLoaiDAO.selectByMaTheLoai(s));
			}
		}
		TheLoai tlChinh = (TheLoaiDAO.selectByMaTheLoai(theLoai) == null) ? new TheLoai()
				: TheLoaiDAO.selectByMaTheLoai(theLoai);
		DSTheLoai dsTheLoai = new DSTheLoai(tlChinh, dsTLPhu);

		String tieuDe = request.getParameter("tieuDe");
		String moTa = request.getParameter("moTa");
		String noiDung = request.getParameter("noiDung");
		NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");

		BaiBao baiBao = new BaiBao(tieuDe, moTa, link, noiDung, nguoiDung, dsTheLoai);
		request.getSession().setAttribute("baiBao", baiBao);
		System.out.println(baiBao);
		request.getSession().setAttribute("bao", baiBao);
		// Chuyển hướng trở lại trang dangbai.jsp
		response.sendRedirect("UploadServlet");
	}

	private void dangBai(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		File file = new File(request.getSession().getAttribute("filePath") + "");
		InputStream is = null;
		if (file.exists()) {
			is = new FileInputStream(file);
		} else {
			is = request.getPart("file").getInputStream();
		}

		String fileName = request.getSession().getAttribute("fileName") + "";
		String link = APISaveImage.uploadImageAndGetLink(is, fileName);
		file.delete();
		is.close();
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		request.getSession().removeAttribute("filePath");
//					TheLoai tl = null;

		String theLoai = request.getParameter("theLoai");
		List<String> values = null;
		if (theLoai != null) {
			if (request.getParameterValues(theLoai) != null) {
				values = Arrays.asList(request.getParameterValues(theLoai));
			}
		} else {
			theLoai = "";
			values = new ArrayList<String>();
		}
		ArrayList<TheLoai> dsTLPhu = new ArrayList<TheLoai>();
		if (values != null) {
			for (String s : values) {
				dsTLPhu.add(TheLoaiDAO.selectByMaTheLoai(s));
			}
		}
		DSTheLoai dsTheLoai = new DSTheLoai(TheLoaiDAO.selectByMaTheLoai(theLoai), dsTLPhu);

		String tieuDe = request.getParameter("tieuDe");
		String moTa = request.getParameter("moTa");
		String noiDung = request.getParameter("noiDung");

		System.out.println("link : " + link);
		NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");
		BaiBao baiBao = new BaiBao(tieuDe, moTa, link, noiDung, nguoiDung, dsTheLoai);

		newsService.addBaiBao(baiBao);
		response.sendRedirect("MainServlet");
	}

	private void doiAVT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);
		String link = APISaveImage.uploadImageAndGetLink(filePart.getInputStream(), fileName);
		NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");
		nguoiDung.setAvt(link);
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		newsService.updateNguoiDung(nguoiDung);
		ArrayList<BaiBao> baos = newsService.getBaiBaoByTenDanhNap(nguoiDung.getTenDangNhap());
		request.setAttribute("baos", baos);
//		response.sendRedirect("thongTinTaiKhoan.jsp");
		request.getRequestDispatcher("thongTinTaiKhoan.jsp").forward(request, response);
	}
}
