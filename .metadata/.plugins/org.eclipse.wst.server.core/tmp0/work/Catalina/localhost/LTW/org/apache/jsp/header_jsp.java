/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2023-12-01 01:40:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".label2 {\r\n");
      out.write("\tfont-size: 25px;\r\n");
      out.write("\tfont-weight: 600;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\theight: max-content;\r\n");
      out.write("\tmargin-top: auto;\r\n");
      out.write("\tmargin-bottom: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".label2:hover .div2 {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".div2 {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tmargin-top: 5px; /* Điều chỉnh khoảng cách giữa .label2 và .div2 */\r\n");
      out.write("\twidth: max-content;\r\n");
      out.write("\tright: -120%;\r\n");
      out.write("\tborder: 1px solid;\r\n");
      out.write("\tborder-color: #bebaba;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tpadding-right: 20px;\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".div2::before {\r\n");
      out.write("\tcontent: \"\";\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 15%;\r\n");
      out.write("\ttop: -10%;\r\n");
      out.write("\theight: 15%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li {\r\n");
      out.write("\tmargin-top: 15px;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div\r\n");
      out.write("\t\tstyle=\"display: flex; margin: 0 10% 0 10%; justify-content: space-between;\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"\"><img alt=\"logo\"\r\n");
      out.write("\t\t\t\tsrc=\"https://tse4.mm.bing.net/th?id=OIP._IfEaUssjZQwZ1u92b1_GgHaEK&pid=Api&P=0&h=180\"\r\n");
      out.write("\t\t\t\tstyle=\"max-height: 100px\"> </a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"margin-top: auto; margin-bottom: auto; display: flex; width: 20%; justify-content: space-between;\">\r\n");
      out.write("\t\t\t<a href=\"dangNhap.jsp\"style=\"padding: 12px; font-size: 20px; border-radius: 7px; color: white; font-weight: 600; background: #363628ed; text-decoration: none; text-align: center;\">Đăng\r\n");
      out.write("\t\t\t\tnhập</a> <a href=\"dangKy.jsp\"\r\n");
      out.write("\t\t\t\tstyle=\"padding: 12px; font-size: 20px; border-radius: 7px; color: white; font-weight: 600; background: #363628ed; text-decoration: none; text-align: center;\">Đăng\r\n");
      out.write("\t\t\t\tký</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"label2\" style=\"display: none\">\r\n");
      out.write("\t\t\t<label>Xin chào ...</label>\r\n");
      out.write("\t\t\t<div class=\"div2\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"dangBai.jsp\" style=\"text-decoration: none; color: black;\">Đăng  bài</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" style=\"text-decoration: none; color: black;\">Thông\r\n");
      out.write("\t\t\t\t\t\t\ttin tài khoản</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" style=\"text-decoration: none; color: black;\">Thay\r\n");
      out.write("\t\t\t\t\t\t\tđổi thông tin</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" style=\"text-decoration: none; color: black;\">Đổi\r\n");
      out.write("\t\t\t\t\t\t\tmật khẩu</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 1px; margin: 0; list-style: none;\"><hr\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"\"></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"text-decoration: none; color: black; margin-top: 10px\">Đăng\r\n");
      out.write("\t\t\t\t\t\t\txuất</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}