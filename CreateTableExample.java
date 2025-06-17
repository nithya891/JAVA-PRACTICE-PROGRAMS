import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTableExample {
    public static void main(String[] args) {
        // JDBC URL, username and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/aits";
        String user = "root";
        String password = "Navitha@7955";

        // SQL statement to create table
        String createTableSQL = "CREATE TABLE employees ("
                              + "id INT PRIMARY KEY AUTO_INCREMENT, "
                              + "name VARCHAR(100), "
                              + "email VARCHAR(100), "
                              + "salary DOUBLE"
                              + ")";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Execute the SQL statement
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'employees' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

