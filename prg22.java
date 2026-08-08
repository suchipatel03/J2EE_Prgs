import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.util.*;

public class prg22 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Today's Date and Time</h1>");
            out.println(" <p> " + new Date() + "</p>");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}