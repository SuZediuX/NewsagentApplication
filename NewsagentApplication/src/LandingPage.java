import java.util.Scanner;

public class LandingPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--- NewsAgent's Menu ---");
		System.out.println("1. Customers");
		System.out.println("2. Subscriptions");
		System.out.println("3. Deliveries");
		System.out.println("4. Payments");
		System.out.println("--- Waiting for input ---");
		
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		
		if(Integer.parseInt(data)<1||Integer.parseInt(data)>4) {
			System.out.println("Expected input from 1 to 4");
			LandingPage.main(args);
		}
		else {
			switch(Integer.parseInt(data)) {
			case 1: System.out.println("Okay! Passing Control to Customer Class!");
			break;
			case 2: System.out.println("Okay! Passing Control to Subscription Class!");
			break;
			case 3: System.out.println("Okay! Passing Control to Delivery Class!");
			break;
			case 4: System.out.println("Okay! Passing Control to Payment Class!");
			break;
			default: System.out.println("Illegal argument! This message must not be invokeable!");
			break;
			}
		}
		
	}

}
