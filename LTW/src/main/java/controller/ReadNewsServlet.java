package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCUtil;
import model.BaiBao;
import model.NewsService;

/**
 * Servlet implementation class ReadNewsServlet
 */
@WebServlet("/read")
public class ReadNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		JDBCUtil.connection();
		System.out.println("Mã bài báo: "+request.getParameter("maBaiBao"));
		List<BaiBao> baos = (ArrayList<BaiBao>) request.getSession().getAttribute("baos");
		
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		
		BaiBao bao=newsService.getBaiBaoByMaBB(request.getParameter("maBaiBao")+"");
	
//		bao.setLuotXem(bao.getLuotXem()+1);
		if(request.getSession().getAttribute("bao") != null) {
			request.getSession().removeAttribute("bao");
		}
		request.getSession().setAttribute("bao", bao);
		newsService.updateBaiBao(bao);
		request.getRequestDispatcher("docBao.jsp").forward(request, response);
//		JDBCUtil.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
