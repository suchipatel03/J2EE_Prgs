import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg43 extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");

        if (username != null && !username.isEmpty()) {
            session.setAttribute("user", username);
        }

        String currentUser = (String) session.getAttribute("user");

        if (currentUser == null) {
            response.sendRedirect("index.html");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h2>Welcome, " + currentUser + "!</h2>");
        }
    }
}
