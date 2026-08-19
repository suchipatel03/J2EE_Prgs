import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg42 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String color = request.getParameter("color");

        HttpSession session = request.getSession();

        if (color != null && !color.isEmpty()) {
            session.setAttribute("bgColor", color);
        } else {
            color = (String) session.getAttribute("bgColor");
            if (color == null) {
                color = "white";
            }
        }

        out.println("<html>");
        out.println("<head><title>Applied Color</title></head>");
        out.println("<body style='background-color: " + color + ";'>");
        out.println("<h2>Current Background Color: " + color + "</h2>");
        out.println("<a href='index.html'>Back to Form</a>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
