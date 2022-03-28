import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ECOURSE", "12345");

            if (c != null){
                System.out.println("Connnected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
