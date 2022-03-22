import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.DateTimeException;
import java.time.LocalDate;

public class PaymentReminder{
	
    //Define variables
	private int id;
	private double amount;
	private String date;
	//private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy[.][-]MM[.][-]dd").withResolverStyle(ResolverStyle.STRICT);
		
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
		
		//DEPRECATED | Attempt to catch multiple exceptions consecutively | Remove before end of Sprint #2 | MUTATION TESTING | All Test Cases Passed
		/*ExecutorService service = Executors.newFixedThreadPool(3);
		
		service.submit( ()-> {
			try { 
				validateID(remID);
			} catch (PaymentReminderExceptionHandler e) {
				e.printStackTrace();
			}
		});
		service.submit( ()-> {
			try {
				validateAmount(dueAmount);
			} catch (PaymentReminderExceptionHandler e) {
				e.printStackTrace();
			}
		});
		service.submit( ()-> validateDate(dueDate));*/
		
		
		
		id = remID;
		amount = dueAmount;
		date = dueDate;
	}
	
	public static boolean validateDate(String dueDate) throws PaymentReminderExceptionHandler, DateTimeParseException{
		//throw new PaymentReminderExceptionHandler("No code written");
		
		if (dueDate.isBlank() || dueDate.isEmpty())
			throw new PaymentReminderExceptionHandler("No input received for Date");
		else
			try {
				LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
				}
			catch(DateTimeParseException e) {
				throw new PaymentReminderExceptionHandler("Invalid Calendar Date!");
			}
		catch(Exception e) {
			return false;
		}
         
        return true;
		
	}
	public static void validateAmount(double dueAmount) throws PaymentReminderExceptionHandler{
		//throw new PaymentReminderExceptionHandler("No code written");
		if (dueAmount < 0 || dueAmount == 0)
			throw new PaymentReminderExceptionHandler("Can't be negative or zero!");
		/*else if (dueAmount == 0)
			throw new PaymentReminderExceptionHandler("Can't be zero");*/
		
	}
	public static void validateID(int remID) throws PaymentReminderExceptionHandler{
		//throw new PaymentReminderExceptionHandler("No code written");
		if(remID<100)
    		throw new PaymentReminderExceptionHandler("Payment ID below expected range");
    	else if (remID>999999)
    		throw new PaymentReminderExceptionHandler("Payment ID above expected range");
	}
}
