import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveEmpData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/aits"; // Replace with your DB info
        String username = "root";
        String password = "Navitha@7955";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver

            connection = DriverManager.getConnection(jdbcURL, username, password);
            statement = connection.createStatement();

            String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP";
            resultSet = statement.executeQuery(sql);

            // Print header
            System.out.printf("%-6s %-15s %-10s %-6s %-12s %-8s %-8s %-6s%n", 
                "EMPNO", "ENAME", "JOB", "MGR", "HIREDATE", "SAL", "COMM", "DEPTNO");
            System.out.println("----------------------------------------------------------------------------");

            // Iterate and print rows
            while (resultSet.next()) {
                int empno = resultSet.getInt("EMPNO");
                String ename = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB");
                int mgr = resultSet.getInt("MGR");
                java.sql.Date hiredate = resultSet.getDate("HIREDATE");
                int sal = resultSet.getInt("SAL");
                int comm = resultSet.getInt("COMM");
                int deptno = resultSet.getInt("DEPTNO");

                System.out.printf("%-6d %-15s %-10s %-6d %-12s %-8d %-8d %-6d%n", 
                    empno, ename, job, mgr, hiredate.toString(), sal, comm, deptno);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception:");
            e.printStackTrace();
        } finally {
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
