import junit.framework.TestCase;

public class PaymentReminderTest extends TestCase {
    //Test No: 1
	//Objective: To test a valid ID, a valid amount and a valid date |
	
	public void testvalidateReminder001() {
		try {
			PaymentReminder testObject = new PaymentReminder(100, 10.0, "2022-04-30");
			assertEquals(100, testObject.getID());
			assertEquals(10.0, testObject.getAmount());
			assertEquals("2022-04-30", testObject.getDate());

		}catch(Exception e) {
			fail("Exception not expected");
		}
	}
	
	//Test No: 2
	//Objective: To test a invalid ID, a invalid amount and a invalid date |
		
	public void testvalidateReminder002() {
		try {
			PaymentReminder.validateID(0);
			PaymentReminder.validateAmount(0.0);
			PaymentReminder.validateDate("2022-02-31");
			fail("Exception expected");
		}catch(Exception e) {
			assertEquals("Payment ID below expected range", e.getMessage());
		}
	}
	
	
}
