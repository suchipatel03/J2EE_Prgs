import java.sql.*;
import java.util.*;

class prg10{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = con.createStatement();
            System.out.print("Enter Employee ID : ");
            int id = in.nextInt();
            String sql = "SELECT * FROM emp WHERE empno = " + id;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                System.out.println("Employee ID : " + rs.getInt(1));
                System.out.println("Employee Name : " + rs.getString(2));
                System.out.println("Employee Designation : " + rs.getString(3));
                System.out.println("Employee City : " + rs.getString(4));
                System.out.println("Employee Salary : " + rs.getString(5));
                System.out.println("Employee Department : " + rs.getString(6));
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