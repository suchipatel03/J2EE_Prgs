import java.sql.*;

class prg20{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            DatabaseMetaData dbm = con.getMetaData();

            System.out.println(dbm.getDriverName());
            System.out.println(dbm.getDriverVersion());
            System.out.println(dbm.getUserName());
            System.out.println(dbm.getDatabaseProductVersion());

            String[] types = {"TABLE"};
            ResultSet rs = dbm.getTables(null,null,null,types);

            while(rs.next()){
                System.out.println(rs.getString(3));
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}