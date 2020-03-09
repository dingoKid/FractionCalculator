
public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int num, int denom) {
		this.numerator = denom < 0 ? num*(-1) : num;
		this.denominator = denom < 0 ? denom*(-1) : denom;
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
		
	public Fraction divide(Fraction other) {
		if(other.toDouble() == 0) {
			throw new IllegalArgumentException();
		}
		int num = this.numerator*other.denominator;
		int denom = this.denominator*other.numerator;
		return new Fraction(num, denom);		
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Fraction)) {
			return false;
		}
		Fraction temp = (Fraction) other;
		if(temp.toDouble() == this.toDouble()) {
			return true;
		}
		return false;
	}
	
	public void toLowestTerms() {
		int gcd = gcd(this.numerator, this.denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
	}
	
	private static int gcd(int num, int denom) {
		return euclidean(num, denom, 0);
	}
	
	private static int euclidean(int a, int b, int gcd) {
		if(b == 0) return a;
		gcd = a % b;
		a = b;
		b = gcd;
		return euclidean(a, b, gcd);
	}
}
