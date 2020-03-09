import java.util.Scanner;

/*
 * Calculates with oneliner input
 */

public class FractionCalculatorAdvanced {
	
	private static Scanner input = new Scanner(System.in);
	private static Fraction frac;
	private static Fraction frac2;
	private static Fraction result;
	private static String operation;
	
	public static void main(String[] args) {		
		start();		
	}
	
	private static void start() {
		String first, second, op;
		String[] array; 
		
		while(true) {
			System.out.println("Enter operation (fraction operation fraction): ");
			array = input.nextLine().split(" ");
			if(array[0].toUpperCase().equals("Q")) {
				input.close();
				System.out.println("Bye-bye");
				System.exit(0);
			}
			
			if(array.length != 3) continue;
			first = array[0];
			op = array[1];
			second = array[2];
						
			try {
				frac = getFraction(first);
				frac2 = getFraction(second);
				operation = getOperation(op);
			} catch (IllegalArgumentException e) {
				continue;
			}
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
	
	private static Fraction getFraction(String fractionString) {
		int num, denom;		
		
		if(validFraction(fractionString)) {
			if(fractionString.indexOf("/") > 0) {
				num = Integer.parseInt( fractionString.substring(0, fractionString.indexOf("/")) );
				denom = Integer.parseInt( fractionString.substring(fractionString.indexOf("/") + 1) );
				if(denom == 0) {
					System.out.println("Denominator can't be 0! Enter another fraction: ");
					throw new IllegalArgumentException();
				}
				return new Fraction(num,denom);
			} else {
				return new Fraction(Integer.parseInt(fractionString));
			}
		}
		throw new IllegalArgumentException();
	}
	
	private static String getOperation(String op) {
		if(op.equals("+") || op.equals("+") || op.equals("-") || op.equals("*") || 
				op.equals("/") || op.equals("=") || op.toUpperCase().equals("Q")) {
			return op.toUpperCase();
		} else {
			throw new IllegalArgumentException();
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
