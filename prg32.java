import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg32 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");

            out.println("<html><body>");

            if (username != null && !username.trim().isEmpty()) {
                out.println("<h2>Hello, <b>" + username + "</b>!</h2>");

                String targetUrl = "url?username=" + username;
                String encodedUrl = response.encodeURL(targetUrl);
            } else {
                out.println("<p>No username found. Please go back to <a href='index.html'>Home</a>.</p>");
            }

            out.println("</body></html>");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
