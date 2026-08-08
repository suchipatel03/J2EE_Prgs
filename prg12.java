import java.sql.*;
import java.util.*;

class prg12{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "INSERT INTO stud(firstname, lastname, course, semester) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter firstname : ");
            String fname = in.nextLine();
            System.out.print("Enter lastname : ");
            String lname = in.nextLine();
            System.out.print("Enter course : ");
            String course = in.nextLine();
            System.out.print("Enter semester : ");    
            int sem = in.nextInt();

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, course);
            ps.setInt(4, sem);

            System.out.println(ps.executeUpdate());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}