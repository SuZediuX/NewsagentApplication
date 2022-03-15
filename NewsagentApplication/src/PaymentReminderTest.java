import junit.framework.TestCase;

public class PaymentReminderTest extends TestCase {
    //Test No: 1
	//Objective: To test a valid ID, a valid amount and a valid date |
	
	public void testvalidateReminder001() {
		try {
			PaymentReminder testObject = new PaymentReminder(100, 10, "2022-04-31");
			assertEquals(100, testObject.getID());
			assertEquals(10, testObject.getID());
			assertEquals("2022-04-31", testObject.getDate());
		} catch (PaymentReminderExceptionHandler e) {
			fail("Exception expected");
		}
	}
}
