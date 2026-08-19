import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg41 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("visitCount");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("visitCount", count);

        out.println("Page Visit Count: " + count);
    }

}
