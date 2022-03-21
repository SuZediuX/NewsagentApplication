
public class PaymentIDExceptionHandler extends PaymentHandlerExceptionHandler {
	String message;
	
	public PaymentIDExceptionHandler(String errMessage) {
		super(errMessage);
		message = errMessage;
	}
	public String getMessage() {
		return message;
	}
}
