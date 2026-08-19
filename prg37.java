import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg37 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String selectedColor = request.getParameter("color");

        if (selectedColor == null || selectedColor.trim().isEmpty()) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("bgColor")) {
                        selectedColor = cookie.getValue();
                        break;
                    }
                }
            }
        } else {
            Cookie colorCookie = new Cookie("bgColor", selectedColor);
            colorCookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(colorCookie);
        }

        if (selectedColor == null || selectedColor.trim().isEmpty()) {
            selectedColor = "white";
        }

        out.println("<html>");
        out.println("<head><title>Styled Page</title></head>");
        out.println("<body style=\"background-color: " + selectedColor + ";\">");
        out.println("<h1>Welcome!</h1>");
        out.println("<h1>Current Background Color: " + selectedColor.toUpperCase() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}