package controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BaiBao;
import model.TheLoai;
/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	//Vị trí của file sauu khi được upload
	private static final String UPLOAD_DIRECTORY = "/img";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	String type = request.getParameter("type")+"";
    	if(type.equals("upAnh")) {
        // Lấy tệp tin được tải lên từ yêu cầu
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        String filePath = getServletContext().getRealPath(UPLOAD_DIRECTORY) + "\\" + fileName;
        filePart.write(filePath);

        
        request.setAttribute("filePath", filePath);
        request.setAttribute("fileName", fileName);
        System.out.println(filePath);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        
		String theLoai = request.getParameter("theLoai");
		List<String> values;
		if(theLoai != null) {
			values = Arrays.asList(request.getParameterValues(theLoai));
		}else {
			theLoai ="";
			values = new ArrayList<String>();
		}
		TheLoai tl = null;
		String tieuDe = request.getParameter("tieuDe");
		String moTa = request.getParameter("moTa");
		String noiDung = request.getParameter("noiDung");
		BaiBao baiBao = null;
		request.setAttribute("baiBao", baiBao);
        
        
        // Chuyển hướng trở lại trang dangbai.jsp
        request.getRequestDispatcher("dangBai.jsp").forward(request, response);
    	}else {
    		// thêm bài báo ở đây
    		System.out.println("Thêm bài báo");
    		response.sendRedirect("trangchu.jsp");
    	}
    }
	 private String getFileName(Part part) {
	        String header = part.getHeader("content-disposition");
	        for (String headerPart : header.split(";")) {
	            if (headerPart.trim().startsWith("filename")) {
	                return headerPart.substring(headerPart.indexOf('=') + 1).trim()
	                        .replace("\"", "");
	            }
	        }
	        return null;
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
