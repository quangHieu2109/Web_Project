package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsService;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	super.doGet(req, resp);
	NewsService newsService = (NewsService)req.getSession().getAttribute("newsService");
	if(newsService==null) {
		newsService = new NewsService();
		req.getSession().setAttribute("newsService", newsService);
	}
	req.getRequestDispatcher("trangChu.jsp").forward(req, resp);
}
}
