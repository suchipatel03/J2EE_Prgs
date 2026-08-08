import jakarta.servlet.http.*;
import java.io.*;

public class prg24 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String empNo = request.getParameter("empNo");
            String empName = request.getParameter("empName");
            String designation = request.getParameter("designation");
            String qualifications = request.getParameter("qualifications");

            out.println("Employee Number: " + empNo + "<br>");
            out.println("Employee Name: " + empName + "<br>");
            out.println("Designation: " + designation + "<br>");
            out.println("Qualifications: " + qualifications + "<br>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}