import java.sql.*;
import java.util.*;

class prg14{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "DELETE FROM stud WHERE rollno = ?";
            PreparedStatement ps = con.prepareStatement(sql);                     

            System.out.print("Enter Student RollNo to delete : ");
            int rollno = in.nextInt();
                                                                                                                                                                                                                                                                   
            ps.setInt(1, rollno); 

            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);
          

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}