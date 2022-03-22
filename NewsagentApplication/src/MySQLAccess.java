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
		boolean insertSuccessful = true;
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO news_sys.payment(customer_id, payment_method) VALUES (?, ?)");
			preparedStatement.setInt(1, p.getID());
			preparedStatement.setString(2, p.getMethod());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			insertSuccessful = false;
		}
		
		return insertSuccessful;
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
		boolean updateSuccessful = true;
		
		try {
			preparedStatement = connect.prepareStatement("UPDATE news_sys.payment SET payment_method = ? WHERE customer_id = ?)");
			preparedStatement.setInt(1, p.getID());
			preparedStatement.setString(2, p.getMethod());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			updateSuccessful = false;
		}
		
		return updateSuccessful;
	}
	
	public boolean deletePaymentByID(int payID) {
		boolean deleteSuccessfull = true;
		try {
			if(payID == -99)
				preparedStatement = connect.prepareStatement("DELETE FROM news_sys.payment");
			else 
				preparedStatement = connect.prepareStatement("DELETE FROM news_sys.payment WHERE customer_id = " + payID);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			deleteSuccessfull = false;
		}
		return deleteSuccessfull;
	}
	
	public boolean insertNewPaymentReminder(PaymentReminder r) {
		boolean insertSuccessful = true;
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO news_sys.PAY_REMINDER(CUSTOMER_ID, AMOUNT_DUE, DATE_DUE) VALUES (?, ?, ?)");
			preparedStatement.setInt(1, r.getID());
			preparedStatement.setDouble(2, r.getAmount());
			preparedStatement.setDate(3, java.sql.Date.valueOf(r.getDate()));
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			insertSuccessful = false;
		}
		
		return insertSuccessful;
	}
	
	public ResultSet displayAllPaymentReminders() {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM news_sys.pay_reminder");
		}
		catch(Exception e) {
			resultSet = null;
		}
		return resultSet;
	}
	
	public boolean updateExistingPaymentReminder(PaymentReminder r) {
		boolean updateSuccessful = true;
		
		try {
			preparedStatement = connect.prepareStatement("UPDATE news_sys.PAY_REMINDER SET AMOUNT_DUE = ?, DATE_DUE = ? WHERE CUSTOMER_ID = ?)");
			
			preparedStatement.setDouble(1, r.getAmount());
			preparedStatement.setDate(2, java.sql.Date.valueOf(r.getDate()));
			preparedStatement.setInt(3, r.getID());
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			updateSuccessful = false;
		}
		
		return updateSuccessful;
	}
	
	public boolean deletePaymentReminderByID(int reminderID) {
		boolean deleteSuccessfull = true;
		try {
			if(reminderID == -99)
				preparedStatement = connect.prepareStatement("DELETE FROM news_sys.PAY_REMINDER");
			else 
				preparedStatement = connect.prepareStatement("DELETE FROM news_sys.PAY_REMINDER WHERE CUSTOMER_ID = " + reminderID);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			deleteSuccessfull = false;
		}
		return deleteSuccessfull;
	}

}
