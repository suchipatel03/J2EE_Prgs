import java.sql.*;
import java.util.*;

class prg19{
    public static void main(String[] args){
        String dbUrl="jdbc:mysql://localhost:3306/tyc_44";
        String dbUser="root";
        String dbPassword="";
        try{
            Scanner in = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement ps = null;
            int choice;

            do{
                System.out.println("Product CRUD menu: ");
                System.out.println("1. INSERT Product ");
                System.out.println("2. DISPLAY ALL Product  ");
                System.out.println("3. UPDATE Product  ");
                System.out.println("4. DELETE Product ");
                System.out.println("5. EXIT ");
                choice = in.nextInt();
                in.nextLine();

                switch(choice){
                    case 1: 
                        System.out.print("Enter Product Name : ");
                        String pname = in.nextLine();
                        System.out.print("Enter Product Price : ");
                        double price = in.nextDouble();
                        System.out.print("Enter Product Quantity : ");
                        int pqty = in.nextInt();

                        String insertsql = "INSERT INTO product(productname, price, quantity) VALUES (?,?,?)";
                        ps =con.prepareStatement(insertsql);
                        ps.setString(1, pname);
                        ps.setDouble(2, price);
                        ps.setInt(3, pqty);

                        int inserted = ps.executeUpdate();
                        if (inserted > 0){ 
                            System.out.println("Product added successfully!");
                        }
                        break;

                    case 2:
                        Statement stmt = con.createStatement();
                        String selectsql = "SELECT * FROM product ";
                        ResultSet rs = stmt.executeQuery(selectsql);
                        while(rs.next()){
                            
                            System.out.println("Product ID : " + rs.getString(1));
                            System.out.println("Product Name : " + rs.getString(2));
                            System.out.println("Product Price : " + rs.getString(3));
                            System.out.println("Product Quantity : " + rs.getString(4));
                            System.out.println("\n");

                         }
                        break;
                    case 3:
                        System.out.print("Enter Product ID to update: ");
                        int updateId = in.nextInt();
                        in.nextLine();

                        System.out.print("Enter New Product Name: ");
                        String newName = in.nextLine();
                        System.out.print("Enter New Price: ");
                        double newPrice = in.nextDouble();
                        System.out.print("Enter New Quantity: ");
                        int newQty = in.nextInt();

                        String updateSql = "UPDATE product SET productname = ?, price = ?, quantity = ? WHERE pid = ?";
                        ps = con.prepareStatement(updateSql);

                        ps.setString(1, newName);
                        ps.setDouble(2, newPrice);
                        ps.setInt(3, newQty);
                        ps.setInt(4, updateId);

                        int updated = ps.executeUpdate();
                        if (updated > 0) {
                            System.out.println("Product ID " + updateId + " updated successfully!");
                        } else {
                            System.out.println("Product ID not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Product ID to delete: ");
                        int deleteId = in.nextInt();

                        String deleteSql = "DELETE FROM product WHERE pid = ?";
                        ps = con.prepareStatement(deleteSql);
                        ps.setInt(1, deleteId);

                        int deleted = ps.executeUpdate();
                        if (deleted > 0) {
                            System.out.println("Product ID " + deleteId + " deleted successfully!");
                        } else {
                            System.out.println("Product ID not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting the application!");
                        break;

                    default:
                        System.out.println("Invalid entry");
                }
            } while (choice != 5);

            if (ps != null) {
                ps.close();
            }
            con.close();
            in.close();

        } catch (Exception e) {
                    e.printStackTrace();
        }
    }
}                     
