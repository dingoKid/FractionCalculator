import java.util.Scanner;

/*
 * Calculating with fractions
 */

public class FractionCalculator {
	
	static Scanner input = new Scanner(System.in);	
	static Fraction frac;
	static Fraction frac2;
	static Fraction result;
	static String operation;

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		while(true) {
			result = null;
			operation = getOperation(input);
			if(operation.equals("Q")) {
				input.close();
				System.out.println("Program stopped...");
				System.exit(0);
			}
			frac = getFraction(input);
			frac2 = getFraction(input);
			if(operation.equals("+")) result = frac.add(frac2);					
			if(operation.equals("-")) result = frac.substract(frac2);			
			if(operation.equals("*")) result = frac.multiply(frac2);
			try {
				if(operation.equals("/")) result = frac.divide(frac2);
			} catch (IllegalArgumentException e) {
				System.out.println("The denominator can not be 0!");
				continue;
			}
			if(operation.equals("=")) {
				System.out.println(frac + " " + operation + " " + frac2 + " is " + frac.equals(frac2));
			}
			if(result != null) {
				result.toLowestTerms();
				if(result.getNumerator() % result.getDenominator() == 0) {
					System.out.println(frac + " " + operation + " " + frac2 + " = " + (int) result.toDouble());
				} else {
					System.out.println(frac + " " + operation + " " + frac2 + " = " + result);
				}
			}
		}
	}
	
	private static String getOperation(Scanner input) {
		System.out.println("Enter an operation (+, -, *, /, = or Q to quit): ");
		String op;
		
		while(true) {
			op = input.nextLine();
			op = op.replaceAll("\\s", "");
			if(op.equals("+") || op.equals("+") || op.equals("-") || op.equals("*") || 
					op.equals("/") || op.equals("=") || op.toUpperCase().equals("Q")) {
				return op.toUpperCase();
			} else {
				System.out.println("Wrong operation, try again: ");
			}
		}
	}
	
	private static Fraction getFraction(Scanner input) {
		System.out.println("Enter fraction: ");
		String fractionString;
		int num, denom;
		
		while(true) {		
		fractionString = input.nextLine();
		fractionString = fractionString.replaceAll("\\s", "");
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
			if( isSigned(num) && isSigned(denom) ) {
				return true;
			} else return false;
		} else if( input.indexOf("/") > 0 && input.indexOf("/") != input.lastIndexOf("/") ) { 
			return false;
		} else if(input.indexOf("/") == 0) {
			return false;
		} else return isSigned(input);
	}
	
	private static boolean isSigned(String s) {
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
