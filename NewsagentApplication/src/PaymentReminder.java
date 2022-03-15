
public class PaymentReminder {
	
    //Define variables
	private int id;
	private double amount;
	private String date;
	
	//Define setters
	void setID(int remID) {
		id = remID;
	}
	void setAmount(double dueAmount) {
		amount = dueAmount;
	}
	void setDate(String dueDate) {
		date = dueDate;
	}
	
	//Define getters
	int getID() {
		return id;
	}
	double getAmount() {
		return amount;
	}
	String getDate() {
		return date;
	}
	
	//Define constructor
	public PaymentReminder(int remID, double dueAmount, String dueDate) throws PaymentReminderExceptionHandler {
		try {
			validateID(remID);
			validateAmount(dueAmount);
			validateDate(dueDate);
		}
		catch(PaymentReminderExceptionHandler e) {
			throw e;
		}
	}
	public static void validateDate(String dueDate) throws PaymentReminderExceptionHandler {
		throw new RuntimeException("No code written");
		
	}
	public static void validateAmount(double dueAmount) throws PaymentReminderExceptionHandler{
		throw new RuntimeException("No code written");
		
	}
	public static void validateID(int remID) throws PaymentReminderExceptionHandler{
		throw new RuntimeException("No code written");
		
	}
}
