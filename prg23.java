import jakarta.servlet.http.*;
import java.io.*;

public class prg23 extends HttpServlet {
    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<h1>Welcome " + request.getParameter("username") + "</h1>");
            out.println("<h1>My first servlet</h1>");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}