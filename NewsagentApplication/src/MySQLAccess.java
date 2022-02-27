import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host = "localhost:3306";
	final private String user = "root";  //Replace with your local MySQL instance credential
	final private String password = "root";  //Replace with your local MySQL instance credential
	
	public MySQLAccess() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://"+ host + "/news_sys?" + "user=" + user + "&password=" + password);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	//Add your own methods for CRUD
	
	public boolean insertNewPaymentDetail(PaymentHandler p) {
		boolean insertSuccessfull = true;
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO news_sys.payment(customer_id, payment_method) VALUES (?, ?)");
			preparedStatement.setInt(1, p.getID());
			preparedStatement.setString(2, p.getMethod());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			insertSuccessfull = false;
		}
		
		return insertSuccessfull;
	}
	
	public ResultSet displayAllPaymentDetails() {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM news_sys.payment");
		}
		catch(Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean updateExistingPaymentDetail(PaymentHandler p) {
		boolean updateSuccessfull = true;
		
		
		
		return updateSuccessfull;
	}
	
	public boolean deletePaymentByID(int payID) {
		boolean deleteSuccessfull = true;
		try {
			if(payID == -99)
				preparedStatement = connect.prepareStatement("DELETE FROM news_sys.payment");
			else 
				preparedStatement = connect.prepareStatement("DELETE FROM news_sys.payment WHERE ID = " + payID);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			deleteSuccessfull = false;
		}
		return deleteSuccessfull;
	}

}
