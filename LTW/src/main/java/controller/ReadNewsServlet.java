package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<BaiBao> baos = (ArrayList<BaiBao>) request.getSession().getAttribute("baos");
		BaiBao bao=baos.get(Integer.valueOf(request.getParameter("index")));
		bao.setLuotXem(bao.getLuotXem()+1);
		request.getSession().setAttribute("bao", bao);
		NewsService newsService = (NewsService) request.getSession().getAttribute("newsService");
		newsService.updateBaiBao(bao);
		request.getRequestDispatcher("docBao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
