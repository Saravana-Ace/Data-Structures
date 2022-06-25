package chapter1;


public class GCDFinder {
	
	
	
	/**
	 * This method takes two positive integers and finds their gcd using 
	 * Euclid's algorithm
	 * @param a
	 * @param b
	 * @return
	 */
	public int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}	
	
	public static void main(String[] args) {
		GCDFinder thing = new GCDFinder();
		System.out.println(thing.gcd(25, 10)); // should print 5
	}
}
