import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Connection myConn = null;
        Statement myStamt = null;
        PreparedStatement myPtamt = null;
        ResultSet myRes = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "krlos", "//654321");
            /*
            *** Insert
            String sql = "INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)";
            myPtamt = myConn.prepareStatement(sql);
            myPtamt.setString(1, "Johana");
            myPtamt.setString(2, "Dorantes");

            int rowsAffected = myPtamt.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Se ha creado un nuevo cliente");
            }
            *** Update
            String sql = "UPDATE employees SET email = ? WHERE first_name = ?";
            myPtamt = myConn.prepareStatement(sql);
            myPtamt.setString(1, "johanado2@example.com");
            myPtamt.setString(2, "Johana");

            int rowsAffected = myPtamt.executeUpdate();
            */
            String sql = "DELETE FROM employees WHERE first_name = ?";
            myPtamt = myConn.prepareStatement(sql);
            myPtamt.setString(1, "Johana");
            int rowsAffected = myPtamt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registro eliminado");
            }

            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery("SELECT * FROM employees ORDER BY pa_surname");
            while (myRes.next()) {
                System.out.println(myRes.getString("first_name")+", "+myRes.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal...");
        } finally {
            try {
                if (myConn != null) {
                    myConn.close();
                }
                if (myStamt != null) {
                    myStamt.close();
                }
                if (myPtamt != null){
                    myPtamt.close();
                }
                if (myRes != null) {
                    myRes.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
