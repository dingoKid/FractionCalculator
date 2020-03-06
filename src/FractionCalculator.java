import java.util.Scanner;

public class FractionCalculator {
	
	static Scanner input = new Scanner(System.in);
	static Fraction frac;
	static Fraction frac2;
	static int validFunctions = 0;

	public static void main(String[] args) {
						
		start();	
		
	}
	
	public static void start() {
		while(true) {
			String operation = getOperation(input);
			if(operation.equals("Q")) {
				input.close();
				System.out.println("Program quitting...");
				System.exit(0);
			}
			frac = getFraction(input);
			frac2 = getFraction(input);
		}
	}
	
	private static String getOperation(Scanner input) {
		System.out.println("Enter an operation (+, -, *, /, = or Q to quit): ");
		String op;
		
		while(true) {
			op = input.next();
			if(op.equals("+") || op.equals("+") || op.equals("-") || op.equals("*") || 
					op.equals("/") || op.equals("=") || op.toUpperCase().equals("Q")) {
				return op.toUpperCase();
			}
			System.out.println("Wrong operation, try again: ");			
		}
	}
	
	private static Fraction getFraction(Scanner input) {
		System.out.println("Enter fraction: ");
		String fractionString;
		int num, denom;
		
		while(true) {		
		fractionString = input.next();
		if(validFraction(fractionString)) {
			if(fractionString.indexOf("/") > 0) {
				num = Integer.parseInt( fractionString.substring(0, fractionString.indexOf("/")) );
				denom = Integer.parseInt( fractionString.substring(fractionString.indexOf("/") + 1) );
				return new Fraction(num,denom);
			} else {
				return new Fraction(Integer.parseInt(fractionString));
			}
		}
		System.out.println("Invalid fraction, try again:");
		}
	}
	
	private static boolean validFraction(String input) {
		
		return true;
	}
	
	private static boolean isNumber(String s) {
		
		return false;
	}

}
