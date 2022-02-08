import junit.framework.TestCase;

public class PaymentHandlerTest extends TestCase {
    //Test No: 1
	//Objective: To verify if the entered payment ID contains 3 to 6 valid characters between 0 to 9
	
	public void testvalidatePaymentID001() {
		PaymentHandler testObject = new PaymentHandler();
		try {
			fail("Exception expected");
		}
		catch(Exception e){
			
		}
		
	}
	//Test No: 2
	//Objective: To verify if the entered payment method contains one among the following of the values: cash, card
	
	public void testvalidatePaymentID002() {
		try {
			
		}
		catch(Exception e){
			
		}
		
	}
}
