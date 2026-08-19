import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg35 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie userCookie = new Cookie("username", "Admin");
        userCookie.setMaxAge(86400);
        response.addCookie(userCookie);

        out.println("<html><body>");
        out.println("Cookie created: username = Admin<br>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            out.println("<h3>Cookies received:</h3>");
            for (Cookie c : cookies) {
                out.println(c.getName() + " : " + c.getValue() + "<br>");
            }
        } else {
            out.println("<p>No cookies were sent by the browser.</p>");
        }
        out.println("</body></html>");
    }
}