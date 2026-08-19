import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg40 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if ("admin".equals(req.getParameter("u")) && "123".equals(req.getParameter("p"))) {
            req.getSession().setAttribute("user", req.getParameter("u"));
            out.println("Welcome " + req.getParameter("u") + "<br><a href='prg40?logout=true'>Logout</a>");
        } else {
            out.println("Invalid login. <a href='index.html'>Retry</a>");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("logout") != null) {
            HttpSession s = req.getSession(false);
            if (s != null) s.invalidate();
            res.sendRedirect("index.html");
        }
    }
}
