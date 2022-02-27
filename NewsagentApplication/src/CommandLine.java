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
		System.out.println("2. View all payment records");
		System.out.println("3. Update a payment record");
		System.out.println("4. Delete a payment record");
}


	private static boolean printPaymentTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
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
							System.out.println("Enter Payment ID: \n");
							String ID = keyboard.next();
							int payID = Integer.parseInt(ID);
							System.out.println("Enter Payment Method: \n");
							String payMethod = keyboard.next();
							
							PaymentHandler p = new PaymentHandler(payID, payMethod);
							
							boolean insertResult = dao.insertNewPaymentDetail(p);
							
							if(insertResult == true) 
								System.out.println("Payment Details Entered!");
							else
								System.out.println("ERROR: Please Try Again");
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
							break;
						}
						break;
					default:
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
