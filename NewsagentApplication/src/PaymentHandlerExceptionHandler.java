
public class PaymentHandlerExceptionHandler extends Exception {
	String message;
	
	public PaymentHandlerExceptionHandler(String errMessage) {
		message = errMessage;
	}
	public String getMessage() {
		return message;
	}
}
