package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsService;
@WebServlet("search")
public class SearchServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String txtSearch = req.getParameter("txtSearch");
	NewsService newsService = (NewsService) req.getSession().getAttribute("newsService");
	req.setAttribute("key", txtSearch);
	req.getSession().setAttribute("baos", newsService.searchBaiBao(txtSearch));
}
}
