
public class PaymentReminder {
	
    //Define variables
	private int id;
	private int amount;
	private String date;
	
	//Define setters
	void setID(int remID) {
		id = remID;
	}
	void setAmount(int dueAmount) {
		amount = dueAmount;
	}
	void setDate(String dueDate) {
		date = dueDate;
	}
	
	//Define getters
	int getID() {
		return id;
	}
	int getAmount() {
		return amount;
	}
	String getDate() {
		return date;
	}
	
	//Define constructor
	public PaymentReminder(int remID, int dueAmount, String dueDate) throws PaymentReminderExceptionHandler {
		try {
			validateID(dueAmount);
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
	public static void validateAmount(int dueAmount) throws PaymentReminderExceptionHandler{
		throw new RuntimeException("No code written");
		
	}
	public static void validateID(int remID) throws PaymentReminderExceptionHandler{
		throw new RuntimeException("No code written");
		
	}
}
