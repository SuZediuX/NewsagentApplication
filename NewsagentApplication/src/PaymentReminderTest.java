

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
	//Objective: To test a valid ID, a valid amount and an invalid date |
		
	public void testvalidateReminder002() {
		
		try {
			PaymentReminder.validateID(999999);
			PaymentReminder.validateAmount(0.001);
			PaymentReminder.validateDate("2022-02-31");
			fail("Exception expected");
		}catch(Exception e) {
			assertEquals("Invalid Calendar Date!", e.getMessage());
		}
	}
	
	//Test No: 3
		//Objective: To test an invalid ID, a valid amount and a valid date |
			
		public void testvalidateReminder003() {
			
			try {
				PaymentReminder.validateID(1000000);
				PaymentReminder.validateAmount(1000000);
				PaymentReminder.validateDate("2022-02-28");
				fail("Exception expected");
			}catch(Exception e) {
				assertEquals("Payment ID above expected range", e.getMessage());
			}
		}
		
		//Test No: 3
				//Objective: To test an invalid ID, a valid amount and a valid date |
					
				public void testvalidateReminder004() {
					
					try {
						PaymentReminder.validateID(99);
						PaymentReminder.validateAmount(1000000000);
						PaymentReminder.validateDate("2222-02-27");
						fail("Exception expected");
					}catch(Exception e) {
						assertEquals("Payment ID below expected range", e.getMessage());
					}
				}
	
	
}
