import java.util.Scanner;

public class PaymentMenu {

	public PaymentMenu() {
		
	}

	public static void DefaultMenu() {
		// TODO Auto-generated method stub
		System.out.println("--- This is the payment console | Choose an option from the below ---");
		System.out.println("1. Create a new payment record");
		System.out.println("2. Read an existing payment record");
		System.out.println("3. Update an existing payment record");
		System.out.println("4. Delete an existing payment record");
		System.out.println("5. Return to the previous menu");
		System.out.println("--- Waiting for input ---");
		
		Scanner input = new Scanner(System.in);  //Destroy scanner obj. or add warning [TEMP]
		String data = input.nextLine();
		
		if(Integer.parseInt(data)<1||Integer.parseInt(data)>5) {
			System.out.println("Expected input from 1 to 5");
			DefaultMenu();  //Ideally replace with while loop [LATER]
		}
		else {
			switch(Integer.parseInt(data)) {  //Further refinement depending on data flow [LATER]
			case 1: System.out.println("Okay! Passing Control to PaymentHandler Class Create Method!");
			break;
			case 2: System.out.println("Okay! Passing Control to PaymentHandler Class Read Method!");
			break;
			case 3: System.out.println("Okay! Passing Control to PaymentHandler Class Update Method!");
			break;
			case 4: System.out.println("Okay! Passing Control to PaymentHandler Class Delete Method!");
			break;
			case 5: System.out.println("Okay! Passing Control to LandingPage Class!");
			LandingPage.main(null);
			break;
			default: System.out.println("Illegal argument! This message must not be invokeable!");
			break;
			}
		}
		
	}
	


}
