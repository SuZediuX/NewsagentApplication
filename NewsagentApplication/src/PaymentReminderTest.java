

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
			PaymentReminder.validateAmount(1000000);
			PaymentReminder.validateDate("2022-02-28");
			PaymentReminder.validateID(1000000);
			fail("Exception expected");
		}catch(Exception e) {
			assertEquals("Payment ID above expected range", e.getMessage());
		}
		}
		
		//Test No: 3
		//Objective: To test an invalid ID, a valid amount and a valid date |
					
	public void testvalidateReminder004() {
					
		try {
			PaymentReminder.validateAmount(1000000000);
			PaymentReminder.validateDate("2222-02-27");
			PaymentReminder.validateID(99);
			fail("Exception expected");
		}catch(Exception e) {
			assertEquals("Payment ID below expected range", e.getMessage());
		}
		}
				
		//Test No: 3
		//Objective: To test a valid ID, an invalid amount and a valid date |
					
	public void testvalidateReminder005() {
					
		try {
			PaymentReminder.validateID(100);
			PaymentReminder.validateDate("3000-01-01");
			PaymentReminder.validateAmount(0.0);
			fail("Exception expected");
		}catch(Exception e) {
			assertEquals("Can't be negative or zero!", e.getMessage());
		}
		}
	
		//Test No: 3
				//Objective: To test a valid ID, a valid amount and an invalid date |
							
				public void testvalidateReminder006() {
							
					try {
						PaymentReminder.validateID(100);
						PaymentReminder.validateAmount(0.01);
						PaymentReminder.validateDate("");
						fail("Exception expected");
					}catch(Exception e) {
						assertEquals("No input received for Date!", e.getMessage());
							}
						}
				
				//Test No: 3
				//Objective: To test a valid ID, a valid amount and an invalid date |
							
				public void testvalidateReminder007() {
							
					try {
						PaymentReminder.validateID(100);
						PaymentReminder.validateAmount(0.01);
						PaymentReminder.validateDate("   ");
						fail("Exception expected");
					}catch(Exception e) {
						assertEquals("No input received for Date!", e.getMessage());
							}
						}
			
				//Test No: 3
				//Objective: To test a valid ID, a valid amount and an invalid date |
							
				public void testvalidateReminder008() {
							
					try {
						PaymentReminder testObject = new PaymentReminder(100, -0.01, "2022-04-30");
						fail("Exception expected");
					}catch(Exception e) {
						assertEquals("Can't be negative or zero!", e.getMessage());
							}
						}
				
				//Test No: 1
				//Objective: To test a valid ID, a valid amount and a valid date |
				
				public void testvalidateReminder000() {
					try {
						PaymentReminder testObject = new PaymentReminder(100, 10001.10001, "3000-08-15");
						testObject.setID(200);
						testObject.setAmount(0.0001);
						testObject.setDate("2999-09-19");
						assertEquals(200, testObject.getID());
						assertEquals(0.0001, testObject.getAmount());
						assertEquals("2999-09-19", testObject.getDate());

					}catch(Exception e) {
						fail("Exception not expected");
					}
				}
	
}
