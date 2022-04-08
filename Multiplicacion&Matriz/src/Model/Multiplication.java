package Model;

import java.math.BigInteger;

public class Multiplication {
	public String wInp = "";
	public String xInp = "";
	public String yInp = "";
	public String zInp = "";
	public int s = 0;
	public int pow1 = 0;
	public int pow2 = 0;
	
	public Multiplication() {

		
	}
	public static BigInteger multi(String wInp, String xInp, String yInp, String zInp, int s) {
		BigInteger w = new BigInteger(wInp);
		BigInteger x = new BigInteger(xInp);
		BigInteger y = new BigInteger(yInp);
		BigInteger z = new BigInteger(zInp);
		BigInteger firstPow = new BigInteger("10");
		BigInteger SecondtPow = new BigInteger("10");
		BigInteger wy = w.multiply(y);
		BigInteger wz = w.multiply(z);
		BigInteger xy = x.multiply(y);
		BigInteger xz = x.multiply(z);
		firstPow = firstPow.pow(s*2);
		SecondtPow = SecondtPow.pow(s);
		BigInteger one = firstPow.multiply(wy);
		BigInteger tw = wz.add(xy);
		BigInteger two = SecondtPow.multiply(tw);
		BigInteger result = one.add(two).add(xz);
		
		return result;
		
	}
	
	public static boolean lengthEven(String input) {
		int even = input.length() % 2;
		if (even == 1) {
			return false;
		} else {
			return true;
		}

	}
}
