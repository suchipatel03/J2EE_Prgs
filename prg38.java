import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg38 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession();

            if (session.getAttribute("visited") == null) {
                session.setAttribute("visited", "true");
                out.println("<html><body>");
                out.println("<h2>Welcome!!</h2>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Welcome back!!</h2>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
