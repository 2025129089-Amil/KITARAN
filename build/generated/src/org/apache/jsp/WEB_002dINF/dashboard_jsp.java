package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kitaran.bean.User;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/globals.css\" rel=\"stylesheet\">\n");
      out.write("    <title>Dashboard - Kitaran</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!--Check user authenticate ke tidak-->\n");
      out.write("    ");

        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
    
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- Hamburger Menu Button -->\n");
      out.write("    <button class=\"hamburger-btn\" id=\"hamburgerBtn\" aria-label=\"Toggle Menu\">\n");
      out.write("        <span></span>\n");
      out.write("        <span></span>\n");
      out.write("        <span></span>\n");
      out.write("    </button>\n");
      out.write("    \n");
      out.write("    <!-- Sidebar Overlay -->\n");
      out.write("    <div class=\"sidebar-overlay\" id=\"sidebarOverlay\"></div>\n");
      out.write("    \n");
      out.write("    <div class=\"app-container\">\n");
      out.write("        <aside class=\"sidebar\">\n");
      out.write("            <div class=\"logo\">Ki<span>TARAN</span></div>\n");
      out.write("            <nav class=\"nav-links\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"dashboard\" class=\"active\">Dashboard</a></li>\n");
      out.write("                    <li><a href=\"request.jsp\">New Request</a></li>\n");
      out.write("                    <li class=\"spacer\"></li>\n");
      out.write("                    <li>\n");
      out.write("                        <form action=\"logout\" method=\"post\">\n");
      out.write("                            <button type=\"submit\" class=\"logout\">Logout</button>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </aside>\n");
      out.write("\n");
      out.write("        <main class=\"main-content\">\n");
      out.write("            <h2>Welcome, <span id=\"username-display\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h2>\n");
      out.write("\n");
      out.write("            <div class=\"stats-row\">\n");
      out.write("                <div class=\"stat-card\">\n");
      out.write("                    <span class=\"stat-num\" id=\"total-weight\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalWeight != null ? totalWeight : '0'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" kg</span>\n");
      out.write("                    <span class=\"stat-label\">Total Recycled Weight</span>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"stat-card\">\n");
      out.write("                    <span class=\"stat-num\" id=\"bill-amount\">RM ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${outstandingPenalty != null ? outstandingPenalty : '0.00'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                    <span class=\"stat-label\">Outstanding Penalty</span>\n");
      out.write("                    \n");
      out.write("                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${outstandingPenalty > 0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <div style=\"width:100%; margin-top:10px;\">\n");
      out.write("                            <button onclick=\"payBill()\" class=\"btn btn-red\" style=\"padding:8px; font-size:0.8rem;\">Pay Now</button>\n");
      out.write("                        </div>\n");
      out.write("                    </c:if>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"box\">\n");
      out.write("                <h3>My Recycling History</h3>\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Type</th>\n");
      out.write("                            <th>Item</th>\n");
      out.write("                            <th>Verified Weight</th>\n");
      out.write("                            <th>Penalty Cost</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody id=\"user-table\">\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"5\" class=\"text-center text-muted\">No recycling history yet</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        // Hamburger menu toggle\n");
      out.write("        const hamburgerBtn = document.getElementById('hamburgerBtn');\n");
      out.write("        const sidebar = document.getElementById('sidebar');\n");
      out.write("        const sidebarOverlay = document.getElementById('sidebarOverlay');\n");
      out.write("\n");
      out.write("        function toggleSidebar() {\n");
      out.write("            hamburgerBtn.classList.toggle('active');\n");
      out.write("            sidebar.classList.toggle('active');\n");
      out.write("            sidebarOverlay.classList.toggle('active');\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        hamburgerBtn.addEventListener('click', toggleSidebar);\n");
      out.write("        sidebarOverlay.addEventListener('click', toggleSidebar);\n");
      out.write("\n");
      out.write("        // Close sidebar when clicking a link (optional for better UX)\n");
      out.write("        const sidebarLinks = sidebar.querySelectorAll('a');\n");
      out.write("        sidebarLinks.forEach(link => {\n");
      out.write("            link.addEventListener('click', () => {\n");
      out.write("                if (window.innerWidth <= 768) {\n");
      out.write("                    toggleSidebar();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
