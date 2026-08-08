import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg31 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title> 404 PAGE NOT FOUND </title></head>");

            out.println("<body style= 'text-align: center; font-family:Arial;'>");
            out.println("<h1>404 Page not found</h1>");

            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}