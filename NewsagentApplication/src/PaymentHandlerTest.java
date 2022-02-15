import junit.framework.TestCase;

public class PaymentHandlerTest extends TestCase {
    //Test No: 1
	//Objective: To test a valid ID and method input | ID BVA #1/4 | Payment Method EP #1/2 | Payment Method CT #1/3
	
	public void testvalidatePayment001() {
		try {
			PaymentHandler testObject = new PaymentHandler(100, "Cash");
			assertEquals(100, testObject.getID());
			assertEquals("Cash", testObject.getMethod());
		} catch (PaymentHandlerExceptionHandler e) {
			fail("Exception not expected");
		}
	}
	//Test No: 2
	//Objective: To test an invalid boundary ID below 100 | ID BVA #2/4 | ID EP #2/3
	
	public void testvalidatePayment002() {
		try {
			PaymentHandler.validateID(99);
			fail("Exception expected");
		}
		catch(PaymentHandlerExceptionHandler e){
			assertEquals("Payment ID below expected range", e.getMessage());
		}
	}
	//Test No: 3
	//Objective: To test an invalid method input | Payment Method BVA #1 | Payment Method EP #2/2 | Payment Method CT #2/3
		
		public void testvalidatePayment003() {
			try {
				PaymentHandler testObject = new PaymentHandler(999999, "000");
				assertEquals(999999, testObject.getID());
				testObject.validateMethod("000");
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
				assertEquals("Input not in either expected category", e.getMessage());
			}
		}
		
	//Test No: 4
	//Objective: To test a valid ID and an invalid method input
		
		public void testvalidatePayment004() {
			try {
				PaymentHandler.validateMethod("Cheque");
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
				assertEquals("Input not in either expected category", e.getMessage());
			}
		}
}

