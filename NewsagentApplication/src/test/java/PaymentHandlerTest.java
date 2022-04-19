import junit.framework.TestCase;
//

public class PaymentHandlerTest extends TestCase {
    //Test No: 1
	//Objective: To test a valid ID and a valid payment method | ID BVA #1/4 | ID ECP #1/3 |Payment Method ECP #1/2 | Payment Method CT #1/3
	
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
	//Objective: To test an invalid ID | ID BVA #2/4 | ID ECP #2/3 | ID EP #2/3
	
	public void testvalidatePayment002() {
		try {
			PaymentHandler.validateID(99);
			fail("Exception expected");
		}
		catch(PaymentHandlerExceptionHandler e){
			assertEquals("PAYMENT ID below expected range", e.getMessage());
		}
	}
	//Test No: 3
	//Objective: To test an invalid payment method | Payment Method ECP #2/2 | Payment Method CT #2/3
		
		public void testvalidatePayment003() {
			try {
				PaymentHandler.validateMethod("Cheque");
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
				assertEquals("Input not in either expected category for PAYMENT METHOD", e.getMessage());
			}
		}
		
	//Test No: 4
	//Objective: To test a valid ID and an invalid payment method | ID BVA #3/4
		
		public void testvalidatePayment004() {
			try {
				
				PaymentHandler testObject = new PaymentHandler(999999, "000");
				assertEquals(999999, testObject.getID());
				testObject.validateMethod("000");
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
				assertEquals("Input not in either expected category for PAYMENT METHOD", e.getMessage());
			}
		}
		
	//Test No: 5
	//Objective: To test an invalid ID and an valid payment method | ID BVA #4/4 | ID ECP #3/3 | Payment Method CT #3/3
			
		public void testvalidatePayment005() {
			try {
					
				PaymentHandler testObject = new PaymentHandler(1000000, "Card");
				assertEquals("Card", testObject.getMethod());
				testObject.validateID(1000000);
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
					assertEquals("PAYMENT ID above expected range", e.getMessage());
			}
		}
			
	//Test No: 6
	//Objective: To test an invalid amount | Branch coverage attempt
			
		public void testvalidatePayment006() {
			try {
				
				PaymentHandler testObject = new PaymentHandler(999999, "");
				assertEquals(999999, testObject.getID());
				testObject.validateMethod("");
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
				assertEquals("No input received for PAYMENT METHOD", e.getMessage());
			}
		}
		
	//Test No: 7
	//Objective: To test an invalid amount | Branch coverage attempt
				
		public void testvalidatePayment007() {
			try {
					
				PaymentHandler testObject = new PaymentHandler(999999, " ");
				assertEquals(999999, testObject.getID());
				testObject.validateMethod(" ");
				fail("Exception expected");
			}
			catch(PaymentHandlerExceptionHandler e){
				assertEquals("No input received for PAYMENT METHOD", e.getMessage());
			}
			}
		
	//Test No: 8
	//Objective: To test an invalid amount | Branch coverage attempt
				
		public void testvalidatePayment008() {
			try {
					
				PaymentHandler testObject = new PaymentHandler(999999, "cash");
				assertEquals(999999, testObject.getID());
				assertEquals("cash", testObject.getMethod());
				testObject.setMethod("card");
				assertEquals("card", testObject.getMethod());
				
			}
			catch(PaymentHandlerExceptionHandler e){
				fail("Exception not expected");
			}
			}
		
	//Test No: 9
	//Objective: To test an invalid amount | Branch coverage attempt
					
		public void testvalidatePayment009() {
			try {
					
				PaymentHandler testObject = new PaymentHandler(999999, "card");
				assertEquals(999999, testObject.getID());
				assertEquals("card", testObject.getMethod());
				testObject.setID(111);
				assertEquals(111, testObject.getID());
					
			}
			catch(PaymentHandlerExceptionHandler e){
				fail("Exception not expected");
			}
			}
		
	//Test No: 10
	//Objective: To test a valid ID and a valid payment method | ID BVA #1/4 | ID ECP #1/3 |Payment Method ECP #1/2 | Payment Method CT #1/3
		
		public void testvalidatePayment010() {
			try {
				PaymentHandler testObject = new PaymentHandler(100, "Card");
				assertEquals(100, testObject.getID());
				assertEquals("Card", testObject.getMethod());
			} catch (PaymentHandlerExceptionHandler e) {
				fail("Exception not expected");
			}
		}
}

