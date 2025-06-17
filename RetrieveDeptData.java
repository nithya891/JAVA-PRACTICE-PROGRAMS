import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveDeptData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/aits"; // your DB URL
        String username = "root";                            // your DB username
        String password = "Navitha@7955";                            // your DB password

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load driver (optional in recent JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Create a statement
            statement = connection.createStatement();

            // Execute query to select all rows from DEPT table
            String sql = "SELECT DEPTNO, DNAME, LOC FROM DEPT";
            resultSet = statement.executeQuery(sql);

            // Print header
            System.out.printf("%-10s %-20s %-20s%n", "DEPTNO", "DNAME", "LOC");
            System.out.println("-------------------------------------------------");

            // Loop through the results and print
            while (resultSet.next()) {
                int deptno = resultSet.getInt("DEPTNO");
                String dname = resultSet.getString("DNAME");
                String loc = resultSet.getString("LOC");

                System.out.printf("%-10d %-20s %-20s%n", deptno, dname, loc);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception:");
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
