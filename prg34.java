import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg34 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        boolean Found = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("myCookie")) {
                    Found = true;
                    break;
                }
            }
        }
        if (!Found) {
            Cookie newCookie = new Cookie("myCookie", "Welcome");
            response.addCookie(newCookie);
            out.println("<h3> A new cookie has been created </h3>");
        } else {
            out.println("<h3> Cookie already exists </h3>");
        }

        out.println("<h3>All Cookies Sent by Browser: </h3>");
        cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>Cookie Name: " + c.getName() + "<br>");
                out.println("Cookie Value: " + c.getValue() + "</p>");
                out.println("<hr>");
            }
        } else {
            out.println("No cookies found");
        }
        out.close();
    }
}
