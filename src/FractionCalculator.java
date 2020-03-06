import java.util.Scanner;

public class FractionCalculator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Fraction frac;
		Fraction frac2;
		int validFunctions = 0;
		
		
		/*
		frac = new Fraction(-5, 0);
		frac2 = new Fraction(3, 2);
		*/
		
		/*
		System.out.print("Enter first fraction numerator: ");
		int i = input.nextInt();
		System.out.print("Enter first fraction denominator: ");
		int j = input.nextInt();
		
		try {
			frac = new Fraction(i, j);
		} catch(IllegalArgumentException e) {
			System.out.println("szopogép");
		}
		*/
		
		/*
		System.out.println(frac.getNumerator());
		System.out.println(frac.getDenominator());
		System.out.println(frac.toString());
		System.out.println(frac.toDouble());
		System.out.println(frac.add(frac2));
		System.out.println(frac.substract(frac2));
		*/
	}
	
	private String getOperation(Scanner input) {
		System.out.println("Enter an operation (+, -, *, /, =, Q): ");
		String op = input.next();
		if(op == "+" || op == "-" || op == "*" || op == "/" || op == "=" || op == "q" || op == "Q") {
			return op;
		}
		return "";
	}
	
	private Fraction getFraction(Scanner input) {
		System.out.println("Enter fraction: ");
		String fractionString = input.next();
		if(validFraction(fractionString)) {
			
		}
		
	}
	
	private boolean validFraction(String input) {
		
	}

}
