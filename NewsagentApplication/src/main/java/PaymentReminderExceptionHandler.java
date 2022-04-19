public class PaymentReminderExceptionHandler extends Exception {
    String message;
	
	public PaymentReminderExceptionHandler(String errMessage) {
		message = errMessage;
	}
	public String getMessage() {
		return message;
	}
}
