package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaiBao;
import model.NewsService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String type = req.getParameter("type");
		NewsService newsService = (NewsService) req.getSession().getAttribute("newsService");
		if (type!=null&& type.equalsIgnoreCase("searchByTheLoai")) {
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
