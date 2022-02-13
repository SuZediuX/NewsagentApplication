import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseHelper {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultset = null;
	
	final private String host = "localhost:3306";
	final private String user = "root";
	final private String password = "root";
	
	public DatabaseHelper() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newsagent2021?" + "user=" + "&password=" + password);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public boolean insertPaymentDetails(PaymentHandler p) {
		boolean insertSuccessfull = true;
		return insertSuccessfull = false;
		
	}
			
}
