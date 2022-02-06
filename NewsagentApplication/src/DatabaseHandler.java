import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
private String jdbcURL = "jdbc:mysql://localhost:330/demo?useSSL=false";
private String jdbcUsername = "root";
private String jdbcPassword = "root";

private static final String INSERT_USERS_SQL = "INSERT INTO customers"+" (name, phone) VALUES "+ "(?, ?);";

private static final String SELECT_USER_BY_ID = "select id, name, phone from customers where id =?";
private static final String SELECT_ALL_USERS = "select * from customers";
private static final String DELETE_USERS_SQL = "delete from customers where id = ?;";
private static final String UPDATE_USERS_SQL = "update customers set name = ?,phone= ? where id = ?;";

public DatabaseHandler() {}

protected Connection getConnection() {
	Connection connection = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	}catch(SQLException e) {
		
	}catch(ClassNotFoundException e) {
		
	}
	return connection;
}

}
