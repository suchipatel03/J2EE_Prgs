import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg30 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("https://www.google.com");

    }
}