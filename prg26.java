import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg26 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("--- STAGE 1: Servlet Initialized (init() method called) ---");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("--- STAGE 2: Servlet Executing (service/doGet() method called) ---");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Servlet Lifecycle Demonstration</h1>");
        out.println("<p>service() method invoked for client request</p>");
        out.println("<p>doGet() method executed</p>");

        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("--- STAGE 3: Servlet Destroyed (destroy() method called) ---");
    }
}