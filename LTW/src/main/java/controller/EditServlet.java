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

import dao.BaiBaoDAO;
import dao.TheLoaiDAO;
import model.APISaveImage;
import model.BaiBao;
import model.DSTheLoai;
import model.NewsService;
import model.NguoiDung;
import model.TheLoai;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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
		// TODO Auto-generated method stub
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		String type = request.getParameter("type");
		if (type.equals("edit")) {
			String maBaiBao = request.getParameter("maBaiBao");
			BaiBao baiBao = newsService.getBaiBaoByMaBB(maBaiBao);
			if (request.getSession().getAttribute("baiBao") != null) {
				request.getSession().removeAttribute("baiBao");
			}
			request.getSession().setAttribute("baiBao", baiBao);
			request.getRequestDispatcher("chinhSuaBaiBao.jsp").forward(request, response);
		}else if(type.equals("remove")) {
			String maBaiBao = request.getParameter("maBaiBao");
			BaiBao baiBao = newsService.getBaiBaoByMaBB(maBaiBao);
			newsService.removeBaiBao(baiBao);
			response.sendRedirect("MainServlet");
		}
		else if (type.equals("upAnh")) {
			// Lấy tệp tin được tải lên từ yêu cầu
			Part filePart = request.getPart("file");
			String fileName = getFileName(filePart);
			filePart.write(getServletContext().getRealPath("/img") + "//" + fileName);
			String filePath = getServletContext().getRealPath("/img") + "//" + fileName;

			if(request.getSession().getAttribute("filePath") != null) {
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
			DSTheLoai dsTheLoai = new DSTheLoai(TheLoaiDAO.selectByMaTheLoai(theLoai), dsTLPhu);

			String tieuDe = request.getParameter("tieuDe");
			String moTa = request.getParameter("moTa");
			String noiDung = request.getParameter("noiDung");

			BaiBao baiBao = (BaiBao)request.getSession().getAttribute("baiBao");
			baiBao.setTieuDe(tieuDe);
			baiBao.setNoiDung(noiDung);
			baiBao.setFilePath(link);
			baiBao.setTheLoai(dsTheLoai);
			baiBao.setMoTa(moTa);
			if (request.getSession().getAttribute("baiBao") != null) {
				request.getSession().removeAttribute("baiBao");
			}
			request.getSession().setAttribute("baiBao", baiBao);
			System.out.println(baiBao);
			request.setAttribute("bao", baiBao);
			// Chuyển hướng trở lại trang dangbai.jsp
			request.getRequestDispatcher("chinhSuaBaiBao.jsp").forward(request, response);
		} else {
			BaiBao baiBao = (BaiBao)request.getSession().getAttribute("baiBao");
			String link = null;
			 if(request.getSession().getAttribute("filePath") != null) {
				System.out.println("FilePath not null");
				File file = new File(request.getSession().getAttribute("filePath") + "");
				InputStream is = new FileInputStream(file);
				String fileName = request.getSession().getAttribute("fileName") + "";
				 link = APISaveImage.uploadImageAndGetLink(is, fileName);
				file.delete();
				is.close();
//				NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
				request.getSession().removeAttribute("filePath");
			}else {
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
			if(values != null) {
				for(String s : values) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
