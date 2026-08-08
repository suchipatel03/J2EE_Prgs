import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class prg29 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            String op = request.getParameter("op");
            double result = 0;

            switch (op) {
                case "add":
                    result = num1 + num2;
                    break;
                case "sub":
                    result = num1 - num2;
                    break;
                case "mul":
                    result = num1 * num2;
                    break;
                case "div":
                    if (num2 == 0) {
                        out.println("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    out.println("Invalid operation");
                    return;
            }

            out.println("<h1>Result: </h2>" + result);

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}