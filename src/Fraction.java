
public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int num, int denom) {
		if(denom == 0) throw new IllegalArgumentException();
		this.numerator = denom < 0 ? num*(-1) : num;
		this.denominator = denom < 0 ? denom*(-1) : denom;
		System.out.println("Created fraction: " + this.toString());
	}
	
	public Fraction(int num) {
		this(num, 1);
	}
	
	public Fraction() {
		this(0);
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public double toDouble() {
		return numerator / (double)denominator;
	}
	
	public Fraction add(Fraction other) {
		int num = this.numerator*other.denominator + this.denominator*other.numerator;
		int denom = this.denominator*other.denominator;
		return new Fraction(num, denom);
	}
	
	public Fraction substract(Fraction other) {
		int num = this.numerator*other.denominator - this.denominator*other.numerator;
		int denom = this.denominator*other.denominator;
		return new Fraction(num, denom);
	}
	
	public Fraction multiply(Fraction other) {
		int num = this.numerator*other.numerator;
		int denom = this.denominator*other.denominator;
		return new Fraction(num, denom);
	}
		
	public Fraction divide(Fraction other) throws IllegalArgumentException {		
		if(other.toDouble() == 0) throw new IllegalArgumentException("The denominator can not be 0!");			
		int num = this.numerator*other.denominator;
		int denom = this.denominator*other.numerator;
		return new Fraction(num, denom);
	}
	

}
