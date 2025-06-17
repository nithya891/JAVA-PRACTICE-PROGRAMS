import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptInsertExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // change to your DB
        String username = "root";                            // your DB username
        String password = "Navitha@7955";                            // your DB password

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load driver (optional for recent JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Prepare SQL INSERT statement
            String sql = "INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            // Set values (example values)
            preparedStatement.setInt(1, 10);             // DEPTNO
            preparedStatement.setString(2, "ACCOUNTING"); // DNAME
            preparedStatement.setString(3, "NEW YORK");   // LOC

            // Execute the insert
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new department was inserted successfully!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error:");
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
