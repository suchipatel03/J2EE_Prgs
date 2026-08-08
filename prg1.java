//1.Write a program to insert a record of an employee into the emp table.

import java.sql.*;
import java.util.*;

class prg1{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = con.createStatement();

            System.out.print("Enter Name : ");
            String empnm = in.next();

            System.out.print("Enter Designation : ");
            String designation = in.next();    

            System.out.print("Enter City : ");
            String city = in.next();

            System.out.print("Enter Salary : ");
            float salary = in.nextFloat();

            System.out.print("Enter Department : ");
            String department = in.next();

            //String sql = "INSERT INTO emp(empnm, designation, city, salary, department) VALUES (empnm, designation, city, salary, department)";
            String sql = "INSERT INTO emp (empnm, designation, city, salary, department) VALUES ('" + empnm + "', '" + designation + "', '" + city + "', " + salary + ", '" + department + "')";
            stmt.executeUpdate(sql);
            System.out.println("Record Inserted Successfully!");

            stmt.close();
            con.close();
            in.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}