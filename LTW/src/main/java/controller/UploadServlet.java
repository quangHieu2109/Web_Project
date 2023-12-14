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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String type = request.getParameter("type") + "";
		if (type.equals("upAnh")) {
			// Lấy tệp tin được tải lên từ yêu cầu
			Part filePart = request.getPart("file");
			String fileName = getFileName(filePart);
			filePart.write(getServletContext().getRealPath("/img") + "//" + fileName);
			String filePath = getServletContext().getRealPath("/img") + "//" + fileName;

			request.getSession().setAttribute("filePath", filePath);
			request.setAttribute("fileName", fileName);
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");

			System.out.println(filePath);
			String theLoai = request.getParameter("theLoai");
			List<String> values;
			if (theLoai != null) {
				values = Arrays.asList(request.getParameterValues(theLoai));
			} else {
				theLoai = "";
				values = new ArrayList<String>();
			}
			TheLoai tl = null;
			String tieuDe = request.getParameter("tieuDe");
			String moTa = request.getParameter("moTa");
			String noiDung = request.getParameter("noiDung");
			NguoiDung nguoiDung = (NguoiDung) request.getSession().getAttribute("nguoiDung");
			BaiBao baiBao = new BaiBao(tieuDe, moTa, filePath, noiDung, nguoiDung, new DSTheLoai());
			request.getSession().setAttribute("baiBao", baiBao);
			// Chuyển hướng trở lại trang dangbai.jsp
			request.getRequestDispatcher("dangBai.jsp").forward(request, response);
		} else {
			// thêm bài báo ở đây
			File file = new File(request.getSession().getAttribute("filePath") + "");
			InputStream is = new FileInputStream(file);
//			System.out.println(filePart.toString());

			String filePath = APISaveImage.uploadImageAndGetLink(is, "123");
			System.out.println(filePath);
			file.delete();
			is.close();
			NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
			newsService.addBaiBao((BaiBao) request.getSession().getAttribute("baiBao"));
			request.getSession().removeAttribute("filePath");
			request.getRequestDispatcher("trangChu.jsp").forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
