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
import model.BinhLuan;
import model.DSTheLoai;
import model.NewsService;
import model.NguoiDung;
import model.TheLoai;

/**
 * Servlet implementation class NewsServlet
 */
@MultipartConfig
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String type = request.getParameter("type");
		if (type.equals("upAnh")) {
			upAnh(request, response);
		} else if (type.equals("dangBai")) {
			dangBai(request, response);
		} else if (type.equals("avt")) {
			doiAVT(request, response);
		} else if (type.equals("showList")) {
			showList(request, response);
		} else if (type.equals("read")) {
			read(request, response);
		} else if (type.equals("edit")) {
			edit(request, response);
		} else if (type.equals("search")) {
			search(request, response);
		}else if (type.equals("cmt")) {
			cmt(request, response);
		} else if (type.equals("dangBao")) {
			 response.sendRedirect("pageJournalist/dangBai.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void cmt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");
		String maBaiBao = request.getParameter("maBaiBao");
		String noiDung = request.getParameter("noiDung");
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		BaiBao baiBao = newsService.getBaiBaoByMaBB(maBaiBao);
		BinhLuan binhLuan = new BinhLuan(nguoiDung, noiDung, baiBao);
		newsService.addBinhLuan(binhLuan);
		request.getSession().setAttribute("bao", baiBao);
		request.getSession().setAttribute("cmts", newsService.getBinhLuan(baiBao));
		response.sendRedirect("docBao.jsp");
//		request.getRequestDispatcher("docBao.jsp").forward(request, response);
		
	}
	protected void upAnh(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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

	protected void dangBai(HttpServletRequest request, HttpServletResponse response)
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

	protected void doiAVT(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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

	protected void showList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		String tenDangNhap = request.getParameter("tenDangNhap");
		ArrayList<BaiBao> baos = newsService.getBaiBaoByTenDanhNap(tenDangNhap);
		request.setAttribute("baos", baos);
		String type = request.getParameter("typeShow");
		if (type.equalsIgnoreCase("danhSachBaiBao")) {
			request.getRequestDispatcher("pageJournalist/danhSachBaiBao.jsp").forward(request, response);
		} else if (type.equalsIgnoreCase("trangCaNhan")) {
			request.getRequestDispatcher("thongTinTaiKhoan.jsp").forward(request, response);
		}
//		

	}

	protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String type = req.getParameter("typeSearch");
		NewsService newsService = (NewsService) req.getSession().getAttribute("newsService");
		if (type != null && type.equalsIgnoreCase("searchByTheLoai")) {
			String theLoaiChinh = req.getParameter("theLoaiChinh");
			String theLoaiPhu = req.getParameter("theLoaiPhu");
			req.getSession().setAttribute("baos", newsService.getBaiBaoByTheLoai(theLoaiChinh, theLoaiPhu));

		} else {

			String txtSearch = req.getParameter("txtSearch");
			req.setAttribute("key", txtSearch);
			req.getSession().setAttribute("baos", newsService.searchBaiBao(txtSearch));
		}
		req.getRequestDispatcher("ketQuaTimKiem.jsp").forward(req, resp);
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");

		BaiBao bao = newsService.getBaiBaoByMaBB(request.getParameter("maBaiBao") + "");

		if (request.getSession().getAttribute("bao") != null) {
			request.getSession().removeAttribute("bao");
		}
		
		request.getSession().setAttribute("bao", bao);
		request.getSession().setAttribute("cmts", newsService.getBinhLuan(bao));
		newsService.updateBaiBao(bao);
		response.sendRedirect("docBao.jsp");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		String type = request.getParameter("typeEdit");
		if (type.equals("edit")) {
			String maBaiBao = request.getParameter("maBaiBao");
			BaiBao baiBao = newsService.getBaiBaoByMaBB(maBaiBao);
			if (request.getSession().getAttribute("baiBao") != null) {
				request.getSession().removeAttribute("baiBao");
			}
			request.getSession().setAttribute("baiBao", baiBao);
			request.getRequestDispatcher("pageJournalist/chinhSuaBaiBao.jsp").forward(request, response);
		} else if (type.equals("remove")) {
			String maBaiBao = request.getParameter("maBaiBao");
			BaiBao baiBao = newsService.getBaiBaoByMaBB(maBaiBao);
			newsService.removeBaiBao(baiBao);
			NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");
			request.setAttribute("baos", newsService.getBaiBaoByTenDanhNap(nguoiDung.getTenDangNhap()));
			request.getRequestDispatcher("pageJournalist/danhSachBaiBao.jsp").forward(request, response);
		} else if (type.equals("upAnh")) {
			// Lấy tệp tin được tải lên từ yêu cầu
			Part filePart = request.getPart("file");
			String fileName = getFileName(filePart);
			filePart.write(getServletContext().getRealPath("/img") + "//" + fileName);
			String filePath = getServletContext().getRealPath("/img") + "//" + fileName;

			if (request.getSession().getAttribute("filePath") != null) {
				request.getSession().removeAttribute("filePath");
			}
			request.getSession().setAttribute("filePath", filePath);

			String link = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/img/" + fileName;
//			request.setAttribute("image", link);
			request.getSession().setAttribute("fileName", fileName);

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

			BaiBao baiBao = (BaiBao) request.getSession().getAttribute("baiBao");
			baiBao.setTieuDe(tieuDe);
			baiBao.setNoiDung(noiDung);
			baiBao.setFilePath(link);
			baiBao.setTheLoai(dsTheLoai);
			baiBao.setMoTa(moTa);

			request.getSession().setAttribute("baiBao", baiBao);
			System.out.println(baiBao);
			request.setAttribute("bao", baiBao);
			// Chuyển hướng trở lại trang dangbai.jsp
			request.getRequestDispatcher("pageJournalist/chinhSuaBaiBao.jsp").forward(request, response);
		} else {
			BaiBao baiBao = (BaiBao) request.getSession().getAttribute("baiBao");
			String link = null;
			if (request.getSession().getAttribute("filePath") != null) {
				System.out.println("FilePath not null");
				File file = new File(request.getSession().getAttribute("filePath") + "");
				InputStream is = new FileInputStream(file);
				String fileName = request.getSession().getAttribute("fileName") + "";
				link = APISaveImage.uploadImageAndGetLink(is, fileName);
				file.delete();
				is.close();
//				NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
				request.getSession().removeAttribute("filePath");
			} else {
				link = baiBao.getFilePath();
			}

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

			baiBao.setTieuDe(tieuDe);
			baiBao.setNoiDung(noiDung);
			baiBao.setFilePath(link);
			baiBao.setTheLoai(dsTheLoai);
			baiBao.setMoTa(moTa);
			newsService.updateBaiBao(baiBao);
			response.sendRedirect("MainServlet");
		}

	}

	protected String getFileName(Part part) {
		String header = part.getHeader("content-disposition");
		for (String headerPart : header.split(";")) {
			if (headerPart.trim().startsWith("filename")) {
				return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;

	}
}
