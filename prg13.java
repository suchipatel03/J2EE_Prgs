import java.sql.*;
import java.util.*;

class prg13{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "UPDATE stud SET firstname = ?, lastname = ?, course = ?, semester = ? WHERE rollno = ?";
            PreparedStatement ps = con.prepareStatement(sql);          

            System.out.print("Enter firstname : ");
            String fname = in.next();
            System.out.print("Enter lastname : ");
            String lname = in.next();
            System.out.print("Enter course : ");
            String course = in.next();
            System.out.print("Enter semester : ");
            int sem = in.nextInt();

            System.out.print("Enter Student RollNo to update : ");
            int rollno = in.nextInt();

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, course);
            ps.setInt(4, sem);
            ps.setInt(5, rollno); 

            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);
          

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}