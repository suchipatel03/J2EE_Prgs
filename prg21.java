import jakarta.servlet.http.*;
import java.io.*;

public class prg21 extends HttpServlet {
    @Override
    public  void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<h1> Hello World!! </h1>");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}