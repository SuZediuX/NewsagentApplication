import junit.framework.TestCase;

public class PaymentHandlerTest extends TestCase {
    //Test No: 1
	//Objective: To verify if the entered payment ID contains 3 to 6 valid characters between 0 to 9
	
	public void testvalidatePaymentID001() {
		try {
			PaymentHandler testObject = new PaymentHandler(100, "Cash");
			//fail("Exception expected");
			assertEquals(0, testObject.getID());
			assertEquals("Cash", testObject.getMethod());
		} catch (PaymentHandlerExceptionHandler e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception not expected");
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
