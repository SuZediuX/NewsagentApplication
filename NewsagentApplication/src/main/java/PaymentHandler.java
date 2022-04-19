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
	
    	if(payID<100)
    		throw new PaymentHandlerExceptionHandler("PAYMENT ID below expected range");
    	else if (payID>999999)
    		throw new PaymentHandlerExceptionHandler("PAYMENT ID above expected range");
	}
    
    public static void validateMethod(String payMethod) throws PaymentHandlerExceptionHandler{
    
    	if (payMethod.isEmpty() || payMethod.isBlank())
    		throw new PaymentHandlerExceptionHandler("No input received for PAYMENT METHOD");
    	else if(!"Cash".equals(payMethod) & !"Card".equals(payMethod) & !"cash".equals(payMethod) & !"card".equals(payMethod))
    		throw new PaymentHandlerExceptionHandler("Input not in either expected category for PAYMENT METHOD");
    	
	}
	
}
