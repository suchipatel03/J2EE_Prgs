import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg39 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession();

            String username = (String) session.getAttribute("sessionUsername");

            if (username == null) {
                username = request.getParameter("username");

                if (username != null && !username.trim().isEmpty()) {
                    session.setAttribute("sessionUsername", username);
                    out.println("<h3>Hello, " + username + "! </h3>");
                } else {
                    out.println("<h3>no username found</h3>");
                    return;
                }
            } else {
                out.println("<h3>Welcome back, " + username + "!</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}