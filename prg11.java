import java.sql.*;
import java.util.*;

class prg11{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = con.createStatement();
            System.out.print("Enter Employee Department : ");
            String dep = in.nextLine();
            String sql = "SELECT * FROM emp WHERE department = '" + dep + "'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){

                System.out.println("Employee Name : " + rs.getString(2));
                System.out.println("Employee Designation : " + rs.getString(3));
               
                System.out.println("\n");
            }
            rs.close();
            statement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}