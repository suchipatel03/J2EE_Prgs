import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class prg25 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<h2>Registered Student Information</h2>");
            out.println("<hr>");

            Enumeration<String> paramNames = request.getParameterNames();

            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String[] paramValues = request.getParameterValues(paramName);
                out.println("<b>" + paramName + ":</b> ");

                if (paramValues != null) {
                    for (int i = 0; i < paramValues.length; i++) {
                        out.print(paramValues[i]);
                        if (i < paramValues.length - 1) {
                            out.print(", ");
                        }
                    }
                }
                out.println("<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}