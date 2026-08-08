import java.sql.*;

class prg7{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = con.createStatement();
            String sql = "SELECT COUNT(*) FROM emp ";
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                System.out.println("Total Employees : " + rs.getInt(1));
            }
            rs.close();
            statement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}