package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaiBao;
import model.NewsService;
import model.NguoiDung;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
//    	super.doGet(req, resp);
    	NewsService newsService = (NewsService)req.getSession().getAttribute("newsService");
    	if(newsService==null) {
    		newsService = new NewsService();
    		req.getSession().setAttribute("newsService", newsService);
    	}
//    	req.getSession().setAttribute("baos", newsService.getBaiBaoMoiNhat(34));
    	req.getSession().setAttribute("baos", newsService.getBaiBaoMoiNhat());
    	req.getSession().setAttribute("xuHuong", newsService.getXuHuong());
    	req.getSession().setAttribute("topView", newsService.getTopView());
    	if(req.getSession().getAttribute("nguoiDung") == null) {
    		req.getSession().setAttribute("nguoiDung", new NguoiDung());
    	}
    	req.getRequestDispatcher("trangChu.jsp").forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
