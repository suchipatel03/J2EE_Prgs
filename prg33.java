import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg33 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String city = request.getParameter("city");

        if (city == null) {
            out.println("<form action='hiddenform' method='POST'>");
            out.println("City: <input type='text' name='city'>");
            out.println("<input type='hidden' name='username' value='" + username + "'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        } else {
            out.println("Username: " + username + "<br>");
            out.println("City: " + city);
        }
    }
}