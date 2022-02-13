
public class PaymentHandler {
	//Define vars
	private int id;
	private String method;
	
	//Define setters
	void setID(int payID) {
		id = payID;
	}
	
	void setMethod(String payMethod) {
		method = payMethod;
	}
	
	//Define getters
	int getID() {
		return id;
	}
	
	String getMethod() {
		return method;
	}
	
	//Define constructor
	public PaymentHandler(int payID, String payMethod) throws PaymentHandlerExceptionHandler {
		//id = 0; //auto increment in DB
		
		//validate inputs
		try {
			validateID(payID);
			validateMethod(payMethod);
		}
		catch(PaymentHandlerExceptionHandler e) {
			throw e;
		}
		
		id = payID;
		method = payMethod;
	}
	
    public static void validateID(int payID) throws PaymentHandlerExceptionHandler{
		//throw new RuntimeException("No code written");
    	if(payID<100)
    		throw new PaymentHandlerExceptionHandler("Payment ID below expected range");
    	else if (payID>999999)
    		throw new PaymentHandlerExceptionHandler("Payment ID above expected range");
	}
    
    public static void validateMethod(String payMethod) throws PaymentHandlerExceptionHandler{
    	//throw new RuntimeException("No code written");
    	if (payMethod.isBlank() || payMethod.isEmpty())
    		throw new PaymentHandlerExceptionHandler("No input received for Payment method");
    	else if(!"Cash".equals(payMethod) & !"Card".equals(payMethod))
    		throw new PaymentHandlerExceptionHandler("Input not in either expected category");
    	/*else if(!"Card".equals(payMethod))
    		throw new PaymentHandlerExceptionHandler("Input not in either expected category");
    	else if(!"Cash".equals(payMethod))
    		throw new PaymentHandlerExceptionHandler("Input not in either expected category");*/
	}
	
	//Add new payment record
	public void addNewPay(int payID, String payMethod) {
		throw new RuntimeException("No code written");
	}
	//View existing payment record
    public void viewPay(int payID) {
		throw new RuntimeException("No code written");
	}
	//Modify existing payment record
	public void updatePay(int payID) {
		throw new RuntimeException("No code written");		
	}
	//Purge existing payment record
    public void deletePay(int payID) {
    	throw new RuntimeException("No code written");
	}
}
