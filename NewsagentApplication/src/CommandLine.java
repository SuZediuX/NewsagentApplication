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


	private static boolean printCustomerTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("custname");
			String addr = rs.getString("custaddr");
			String phone = rs.getString("custphone");
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", addr);
			System.out.printf("%30s", phone);
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
			String functionNumber = "-99";
			boolean keepAppOpen = true;
			
			while(keepAppOpen == true) {
				listMainMenu();
				functionNumber = keyboard.next();
				
				switch(functionNumber){
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
						switch(functionNumber) {
						case "1":
							System.out.println("Enter Payment ID: \n");
							String ID = keyboard.next();
							int payID = Integer.parseInt(ID);
							System.out.println("Enter Payment Method: \n");
							String payMethod = keyboard.next();
							break;
						case "2":
							break;
						case "3":
							break;
						case "4":
							break;
						default:
							break;
						}
						break;
					default:
						break;
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE: " + e.getMessage());
		}
	}

}
