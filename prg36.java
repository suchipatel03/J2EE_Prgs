import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg36 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        boolean isFirstVisit = true;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitedBefore")) {
                    isFirstVisit = false;
                    break;
                }
            }
        }

        out.println("<html><body>");
        if (isFirstVisit) {
            Cookie visitCookie = new Cookie("visitedBefore", "yes");
            visitCookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(visitCookie);

            out.println("<h1>Welcome!</h1>");
        } else {
            out.println("<h1>Welcome back!</h1>");
        }
        out.println("</body></html>");
    }
}