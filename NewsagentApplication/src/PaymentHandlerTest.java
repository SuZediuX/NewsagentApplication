import junit.framework.TestCase;

public class PaymentHandlerTest extends TestCase {
    //Test No: 1
	//Objective: To test a valid ID and method input
	
	public void testvalidatePaymentID001() {
		try {
			PaymentHandler testObject = new PaymentHandler(100, "Cash");
			//fail("Exception expected");
			assertEquals(100, testObject.getID());
			assertEquals("Cash", testObject.getMethod());
		} catch (PaymentHandlerExceptionHandler e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			fail("Exception not expected");
		}
		
		
	}
	//Test No: 2
	//Objective: To test an invalid boundary ID below 100 and invalid method input
	/*
	public void testvalidatePaymentID002() {
		try {
			//fail("Exception expected");
			PaymentHandler testObject = new PaymentHandler(99, "Cheque");
			assertEquals(99, testObject.getID());
			assertEquals("Cheque", testObject.getMethod());
			//fail("Exception expected");
		}
		catch(Exception e){
			//e.printStackTrace();
			fail("Exception not expected");
		}
		
	}*/
}

