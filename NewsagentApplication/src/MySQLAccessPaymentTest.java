import junit.framework.TestCase;
import java.sql.ResultSet;

public class MySQLAccessPaymentTest extends TestCase {

	//Test No: 0
	//Objective: Successfully instantiate MySQLAccess object
	
	public void testvalidateMySQLAccess000() {
		
		try {
			MySQLAccess dao = new MySQLAccess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Connection not established");
		}
	}
	
	//Test No: 1
	//Objective: Push Create statement for Payment successfully
	
	public void testvalidateMySQLAccess001() {
		
		try {
			MySQLAccess testHelper = new MySQLAccess();
			PaymentHandler testObject = new PaymentHandler(200, "Card");
			
			boolean result = testHelper.insertNewPaymentDetail(testObject);
			
			assertEquals(200, testObject.getID());
			assertEquals("Card", testObject.getMethod());
		} catch(Exception e) {
			fail("Exception not expected!");
		}
	}
	
	//Test No: 2
	//Objective: Push Read statement for Payment successfully
	
	public void testvalidateMySQLAccess002() {
		
		try {
			MySQLAccess testHelper = new MySQLAccess();
			
			ResultSet testObject = testHelper.displayAllPaymentDetails();
			if(testObject == null) {
				fail("No record(s) found");
			}
		} catch(Exception e) {
			fail("Exception not expected!");
		}
	}
	
	//Test No: 3
	//Objective: Push Update statement for Payment successfully
	
	public void testvalidateMySQLAccess003() {
		
		try {
			MySQLAccess testHelper = new MySQLAccess();
			PaymentHandler testObject = new PaymentHandler(200, "Cash");
			
			boolean result = testHelper.updateExistingPaymentDetail(testObject);
			
			assertEquals(200, testObject.getID());
			assertEquals("Cash", testObject.getMethod());
		}catch(Exception e) {
			fail("Exception not expected");
		}
	}
	
	//Test No: 4
	// Objective: Push Delete statement for Payment successfully
	
	public void testvalidateMySQLAccess004() {
		
		try {
			MySQLAccess testHelper = new MySQLAccess();
			
			boolean testObject = testHelper.deletePaymentByID(200);
			assertEquals(true, testObject);
			
		} catch(Exception e) {
			fail("Exception not expected!");
		}
	}
	
	//Test No: 5
	// Objective:
	
	//Test No: 6
	// Objective:
	
	//Test No: 7
	// Objective:
	
public void testvalidateMySQLAccess005() {
		
		try {
			MySQLAccess testHelper = new MySQLAccess();
			PaymentReminder testObject = new PaymentReminder(200, 100.101, "2022-01-01");
			
			boolean result = testHelper.updateExistingPaymentReminder(testObject);
			
			assertEquals(200, testObject.getID());
			assertEquals(100.101, testObject.getAmount());
			assertEquals("2022-01-01", testObject.getDate());
		}catch(Exception e) {
			fail("Exception not expected");
		}
	}
	
	//Test No: 8
	// Objective:
}
