import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg28 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        out.println("<html><body>");
        if ("admin".equals(username) && "admin".equals(password)) {
            out.println("<h2> Welcome Admin</h2>");
            out.println("<p>successful<p>");
        }else{
            out.println("<h2> Invalid Username or Password</h2>");
        }
        out.println("</body></html>");
    }
}