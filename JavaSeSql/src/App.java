import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "krlos", "//654321");
            System.out.println("Conectado a DB");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectar DB");
        }
    }
}
