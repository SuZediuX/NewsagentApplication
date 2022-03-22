import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Scanner;

public class CommandLine {
	
	private static void listMainMenu() {
		System.out.println("Choose any one of the following");
		System.out.println("1. Manage customer(s)");
		System.out.println("2. Manage Subscription(s)");
		System.out.println("3. Manage Deliveries");
		System.out.println("4. Manage Payment(s)");
		System.out.println("5. Manage Reminder(s)");
	}
	
	private static void listCustomerMenu() {
		System.out.println("Choose any one of the following");
		System.out.println("1. Create a customer record");
		System.out.println("2. View all customer records");
		System.out.println("3. Update a customer record");
		System.out.println("4. Delete a customer record");
		
	}
	
    private static void listSubscriptionMenu() {
    	System.out.println("Choose any one of the following");
		System.out.println("1. Create a subscription record");
		System.out.println("2. View all subscription records");
		System.out.println("3. Update a subscription record");
		System.out.println("4. Delete a subscription record");
	}

    private static void listDeliveryMenu() {
    	System.out.println("Choose any one of the following");
		System.out.println("1. Create a delivery record");
		System.out.println("2. View all delivery records");
		System.out.println("3. Update a delivery record");
		System.out.println("4. Delete a delivery record");
}

    private static void listPaymentMenu() {
    	System.out.println("Choose any one of the following");
		System.out.println("1. Create a payment record");
		System.out.println("2. View all payment record(s)");
		System.out.println("3. Update a payment record");
		System.out.println("4. Delete a payment record");
}
    
    private static void listPaymentReminderMenu() {
    	System.out.println("Choose any one of the following");
		System.out.println("1. Create a new payment reminder");
		System.out.println("2. View all payment reminder(s)");
		System.out.println("3. Update a payment reminder");
		System.out.println("4. Delete a payment reminder");
}


	private static boolean printPaymentTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Payment Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int payID = rs.getInt("payment_id");
			String payMethod = rs.getString("payment_method");
			int custID = rs.getInt("customer_id");
			System.out.printf("%30s", payID);
			System.out.printf("%30s", payMethod);
			System.out.printf("%30s", custID);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}
	
    private static boolean printReminderTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Payment Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int payID = rs.getInt("payment_id");
			String payMethod = rs.getString("payment_method");
			int custID = rs.getInt("customer_id");
			System.out.printf("%30s", payID);
			System.out.printf("%30s", payMethod);
			System.out.printf("%30s", custID);
			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MySQLAccess dao = new MySQLAccess();
			
			int payID = 0;
			int reminderID = 0;
			String payMethod = "";
			double reminderAmount = 0;
			String reminderDate = "";
			Scanner keyboard = new Scanner(System.in);
			String taskNumber = "-99";
			String operationNumber = "-99";
			boolean keepAppOpen = true;
			
			while(keepAppOpen == true) {
				listMainMenu();
				taskNumber = keyboard.next();
				
				switch(taskNumber){
					case "1":
						listCustomerMenu();
						break;
					case "2":
						listSubscriptionMenu();
						break;
					case "3":
						listDeliveryMenu();
						break;
					case "4":
						listPaymentMenu();
						operationNumber = keyboard.next();
						switch(operationNumber) {
						case "1":
							System.out.println("Enter the Customer's ID: \n");
							String ID = keyboard.next();
							try {
								payID = Integer.parseInt(ID);

								System.out.println("Enter a Payment Method: \n");
								payMethod = keyboard.next();
								
								PaymentHandler p = new PaymentHandler(payID, payMethod);
								
								boolean insertResult = dao.insertNewPaymentDetail(p);
								
								if(insertResult == true) 
									System.out.println("Payment Details Entered!");
								else
									System.out.println("ERROR: Please Try Again");
							}catch(Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;
						case "2":
							ResultSet rs = dao.displayAllPaymentDetails();
							if(rs == null) {
								System.out.println("No records found");
								break;
							}
							else {
								boolean tablePrinted = printPaymentTable(rs);
								if(tablePrinted == true)
									rs.close();
							}
							break;
						case "3":
							System.out.println("Enter the Customer's ID: \n");
							String toBeUpdatedID = keyboard.next();
							int toBeUpdatedPayID = Integer.parseInt(toBeUpdatedID);
							System.out.println("Enter a new Payment Method: \n");
							String toBeUpdatedPayMethod = keyboard.next(); 
							
							PaymentHandler pH = new PaymentHandler(toBeUpdatedPayID, toBeUpdatedPayMethod);
							
							boolean updateResult = dao.updateExistingPaymentDetail(pH);
							
							if(updateResult == true) 
								System.out.println("Payment Details Entered!");
							else
								System.out.println("ERROR: Please Try Again");
							break;
						case "4":
							System.out.println("Enter Payment ID to be deleted or -99 to Clear all Rows");
							String deletePayID = keyboard.next();
							
							boolean deletePayRes = dao.deletePaymentByID(Integer.parseInt(deletePayID));
							
							if((deletePayRes == true) && (deletePayID.equals("-99")))
								System.out.println("Payment Table Emptied");
							else if (deletePayRes == true)
								System.out.println("Payment Record Deleted");
							else
								System.out.println("ERROR: Operation Unsuccessful");
							break;
						case "99":
							keepAppOpen = false;
							System.out.println("Closing the Application");
							break;
						default:
							System.out.println("Invalid input!");
							break;
						}
						break;
					case "5":
						listPaymentReminderMenu();
						operationNumber = keyboard.next();
						switch(operationNumber) {
						case "1":
							try {
								System.out.println("Enter the Customer's ID: \n");
								String ID = keyboard.next();
								reminderID = Integer.parseInt(ID);

								System.out.println("Enter the due amount: \n");
								String Amount = keyboard.next();
								reminderAmount = Integer.parseInt(Amount);
								
								System.out.println("Enter the date due: \n");
								reminderDate = keyboard.next();
								
								PaymentReminder r = new PaymentReminder(reminderID, reminderAmount, reminderDate);
								
								boolean insertResult = dao.insertNewPaymentReminder(r);
								
								if(insertResult == true) 
									System.out.println("Payment Details Entered!");
								else
									System.out.println("ERROR: Please Try Again");
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;
						case "2":
							ResultSet rs = dao.displayAllPaymentDetails();
							if(rs == null) {
								System.out.println("No records found");
								break;
							}
							else {
								boolean tablePrinted = printReminderTable(rs);
								if(tablePrinted == true)
									rs.close();
							}
							break;
						case "3":
							try {
							System.out.println("Enter the Customer's ID: \n");
							String toBeUpdatedID = keyboard.next();
							int toBeUpdatedPayID = Integer.parseInt(toBeUpdatedID);
							
							System.out.println("Enter a new due amount: \n");
							String toBeUpdatedAmount = keyboard.next(); 
							Double toBeUpdatedReminderAmount = Double.parseDouble(toBeUpdatedAmount);
							
							System.out.println("Enter a new due date: \n");
							String toBeUpdatedDate = keyboard.next();
							
							PaymentReminder r = new PaymentReminder(toBeUpdatedPayID, toBeUpdatedReminderAmount, toBeUpdatedDate);
							
							boolean updateResult = dao.updateExistingPaymentReminder(r);
							
							if(updateResult == true) 
								System.out.println("Payment Details Entered!");
							else
								System.out.println("ERROR: Please Try Again");
							break;
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						case "4":
							try {
							System.out.println("Enter Payment ID to be deleted or -99 to Clear all Rows");
							String deleteReminderID = keyboard.next();
							
							boolean deletePayRes = dao.deletePaymentReminderByID(Integer.parseInt(deleteReminderID));
							
							if((deletePayRes == true) && (deleteReminderID.equals("-99")))
								System.out.println("Payment Table Emptied");
							else if (deletePayRes == true)
								System.out.println("Payment Record Deleted");
							else
								System.out.println("ERROR: Operation Unsuccessful");
							break;
							}
							catch(Exception e) {
								System.out.println(e.getMessage());
							}
						case "99":
							keepAppOpen = false;
							System.out.println("Closing the Application");
							break;
						default:
							System.out.println("Invalid input!");
							break;
						}
						break;
					default:
						System.out.println("Invalid input!");
						break;
				}
			}
			keyboard.close();
			
		}
		catch(Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE: " + e.getMessage());
		}
	}

}
