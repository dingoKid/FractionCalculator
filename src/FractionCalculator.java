import java.util.Scanner;

public class FractionCalculator {
	
	static Scanner input = new Scanner(System.in);
	static Fraction frac;
	static Fraction frac2;
	static String operation;

	public static void main(String[] args) {
						
		//start();
		frac = new Fraction(105,147);
		frac.toLowestTerms();
		System.out.println(frac.toString());
		
	}
	
	public static void start() {
		while(true) {
			operation = getOperation(input);
			if(operation.equals("Q")) {
				input.close();
				System.out.println("Program stopped...");
				System.exit(0);
			}
			frac = getFraction(input);
			frac2 = getFraction(input);
			if(operation.equals("+")) System.out.println(frac.add(frac2).toString());
			if(operation.equals("-")) System.out.println(frac.substract(frac2).toString());
			if(operation.equals("*")) System.out.println(frac.multiply(frac2).toString());
			if(operation.equals("/")) System.out.println(frac.divide(frac2).toString());
			if(operation.equals("=")) System.out.println(frac.equals(frac2));
			
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
				if(denom == 0) {
					System.out.println("Denominator can't be 0! Enter another fraction: ");
					continue;
				}
				return new Fraction(num,denom);
			} else {
				return new Fraction(Integer.parseInt(fractionString));
			}
		}
		System.out.println("Invalid fraction, try again: ");
		}
	}
	
	private static boolean validFraction(String input) {
		String num;
		String denom;
		if( input.indexOf("/") > 0 && input.indexOf("/") == input.lastIndexOf("/") ) {
			num = input.substring(0, input.indexOf("/"));
			denom = input.substring(input.indexOf("/") + 1);
			if( signed(num) && signed(denom) ) {
				return true;
			} else return false;
		} else if( input.indexOf("/") > 0 && input.indexOf("/") != input.lastIndexOf("/") ) { 
			return false;
		} else if(input.indexOf("/") == 0) {
			return false;
		} else return signed(input);
	}
	
	private static boolean signed(String s) {
		if( s.indexOf("-") == 0 ) {
			return isNumber(s.substring(1));
		} else if( s.indexOf("-") > 0 ) {
			return false;
		} else return isNumber(s);
	}
	
	private static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Not a number!");
			return false;
		}
	}
}
