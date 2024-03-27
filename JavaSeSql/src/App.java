import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Connection myConn = null;
        // Statement myStamt = null;
        PreparedStatement myPtamt = null;
        // ResultSet myRes = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "krlos", "//654321");
            /*
             * Para Select 
            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery("SELECT * FROM employees");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name"));
            }*/
            String sql = "INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)";
            myPtamt = myConn.prepareStatement(sql);
            myPtamt.setString(1, "Johana");
            myPtamt.setString(2, "Dorantes");

            int rowsAffected = myPtamt.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Se ha creado un nuevo cliente");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectar DB");
        }
    }
}
