/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.16
 * Generated at: 2019-08-12 04:09:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class music_005fchart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1562127548312L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-5.1.3.RELEASE.jar", Long.valueOf(1565139562810L));
    _jspx_dependants.put("jar:file:/C:/Users/user1/Documents/finalfinal_/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/dolduck_project/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/WEB-INF/views/board/../header.jsp", Long.valueOf(1565581815304L));
    _jspx_dependants.put("jar:file:/C:/Users/user1/Documents/finalfinal_/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/dolduck_project/WEB-INF/lib/spring-security-taglibs-5.1.3.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1547128166000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess;

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
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("\r\n");
      out.write("<meta name=\"_csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("<meta name=\"_csrf_header\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.headerName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/> \r\n");
      out.write("\r\n");
      out.write("<title>All About K-POP! DD - 실시간 음원차트 순위</title>\r\n");
      out.write("<!-- Bootstdap 4 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/styles/bootstrap-4.1.2/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/styles/chart.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/styles/main_styles.css\">\r\n");
      out.write("<!-- jQuery library -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.4.1.js\"></script>\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"resources/styles/bootstrap-4.1.2/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"resources/js/chart.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   \r\n");
      out.write("   <!-- Header -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"description\" content=\"Mixtape template project\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"resources/styles/bootstrap-4.1.2/bootstrap.min.css\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"resources/plugins/OwlCarousel2-2.2.1/animate.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"resources/styles/main_styles.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"resources/styles/responsive.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<title>Header</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- Header -->\r\n");
      out.write("\t<header class=\"header\">\r\n");
      out.write("\t\t<section\r\n");
      out.write("\t\t\tclass=\"header_content d-flex flex-row align-items-center justify-content-center\">\r\n");
      out.write("\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t<a href=\"home.do\">DOL-Duck</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"log_reg\">\r\n");
      out.write("\t\t\t\t<ul class=\"d-flex flex-row align-items-start justify-content-start\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_sec_005fauthorize_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_sec_005fauthorize_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<nav class=\"main_nav\">\r\n");
      out.write("\t\t\t\t<ul class=\"d-flex flex-row align-items-start justify-content-start\">\r\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"home.do\">HOME</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"youtube.do\">YouTube</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"vote.do\">Vote</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"chart.do\">Music Chart</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">LIVE</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Board</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"heartShop.do\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\">Market</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\" role=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"dropdown-item:hover\"><a href=\"heartShop.do\">heartShop</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"dropdown-item:hover\"><a href=\"Goodies.do\">Goodies</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"form-group has-search\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-search form-control-feedback\"></span> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t\t<div class=\"hamburger ml-auto\">\r\n");
      out.write("\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\tclass=\"d-flex flex-column align-items-end justify-content-between\">\r\n");
      out.write("\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- Menu -->\r\n");
      out.write("\r\n");
      out.write("\t<section class=\"menu\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<div class=\"menu_overlay\"></div>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tclass=\"menu_container d-flex flex-column align-items-start justify-content-center\">\r\n");
      out.write("\t\t\t\t<div class=\"menu_log_reg\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"d-flex flex-row align-items-start justify-content-start\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"loginform.do\">Login</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Register</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<nav class=\"menu_nav\">\r\n");
      out.write("\t\t\t\t\t<ul\r\n");
      out.write("\t\t\t\t\t\tclass=\"d-flex flex-column align-items-start justify-content-start\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"home.do\">HOME</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"youtube.do\">You Tube</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"vote.do\">Vote</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"chart.do\">Music Chart</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">LIVE</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Board</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"heartShop.do\">heartShop</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"Goodies.do\">Goodies</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/home.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.4.1.js\"></script>\r\n");
      out.write("<script src=\"resources/styles/bootstrap-4.1.2/popper.js\"></script>\r\n");
      out.write("<script src=\"resources/styles/bootstrap-4.1.2/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/greensock/TweenMax.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/greensock/TimelineMax.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/scrollmagic/ScrollMagic.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/greensock/animation.gsap.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/greensock/ScrollToPlugin.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/easing/easing.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/progressbar/progressbar.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/parallax-js-master/parallax.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/jPlayer/jquery.jplayer.min.js\"></script>\r\n");
      out.write("<script src=\"resources/plugins/jPlayer/jplayer.playlist.min.js\"></script>\r\n");
      out.write("<script src=\"resources/js/custom.js\"></script>\r\n");
      out.write("<script src=\"https://d3js.org/d3.v4.min.js\"></script>\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/c1455fa856.js\"></script>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   <h1> Melon Realtime Music Chart</h1>\r\n");
      out.write("   <hr><br><br><br><br><br>\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   <div class=\"container\">\r\n");
      out.write("      <div class=\"center musicchart-board\">   \r\n");
      out.write("         <p>검색시간 : <label class=\"label-search\"></label><p>\r\n");
      out.write("         <table class=\"table \">\r\n");
      out.write("            <thead>\r\n");
      out.write("               <tr>\r\n");
      out.write("                  <th scope=\"col\">Rank</th>\r\n");
      out.write("                  <th scope=\"col\">Thumbs</th>\r\n");
      out.write("                  <th scope=\"col\">Song title</th>\r\n");
      out.write("                  <th scope=\"col\">Singer</th>\r\n");
      out.write("                  <th scope=\"col\">Album</th>\r\n");
      out.write("               </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody></tbody>\r\n");
      out.write("         </table>\r\n");
      out.write("         <button class=\"button-pagination\">더 보기</button>   \r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("   </div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_sec_005fauthorize_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f0 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f0_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f0.setParent(null);
      // /WEB-INF/views/board/../header.jsp(42,5) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f0.setAccess("isAnonymous()");
      int _jspx_eval_sec_005fauthorize_005f0 = _jspx_th_sec_005fauthorize_005f0.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("/login.do\">Login</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("/join.do\">Register</a></li>\r\n");
        out.write("\t\t\t\t\t");
      }
      if (_jspx_th_sec_005fauthorize_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f0);
      _jspx_th_sec_005fauthorize_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthorize_005f0, _jsp_getInstanceManager(), _jspx_th_sec_005fauthorize_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f1 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f1_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f1.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f1.setParent(null);
      // /WEB-INF/views/board/../header.jsp(46,5) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f1.setAccess("isAuthenticated()");
      int _jspx_eval_sec_005fauthorize_005f1 = _jspx_th_sec_005fauthorize_005f1.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li><a href=\"logout.do\">Logout</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("/mypage.do\">Mypage</a></li>\r\n");
        out.write("\t\t\t\t\t");
      }
      if (_jspx_th_sec_005fauthorize_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f1);
      _jspx_th_sec_005fauthorize_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthorize_005f1, _jsp_getInstanceManager(), _jspx_th_sec_005fauthorize_005f1_reused);
    }
    return false;
  }
}
