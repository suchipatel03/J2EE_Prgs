import jakarta.servlet.http.*;
import java.io.*;

public class servlet1 extends HttpServlet {
    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<h1>Addition answer is : </h1>");
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));

            out.println(a + b);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
