package Model;

import java.math.BigDecimal;
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
	public boolean isNumeric(String input) {
	    if (input == null) {
	        return false;
	    }
	    try {
	        BigInteger d = new BigInteger(input);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static BigInteger smallMulti(BigInteger input1, BigInteger input2) {
		BigInteger result =input1.multiply(input2);
		return result;
	}
	public static BigInteger multi(BigInteger input1, BigInteger input2, int n) {
		int s = n/2;
		BigInteger pow1 = new BigInteger("10");
		BigInteger pow2 = new BigInteger("10");
		pow1 = pow1.pow(s);
		pow2 = pow2.pow(2*s);
		BigInteger w = input1.divide(pow1);
		BigInteger x = input1.mod(pow1);
		BigInteger y = input2.divide(pow1);
		BigInteger z = input2.mod(pow1);
	
		BigInteger firtsStep = (w.multiply(y)).multiply(pow2);
		BigInteger secondStep = w.multiply(z);
		BigInteger thirdStep =(x.multiply(y)).multiply(pow1);
		BigInteger fourthStep = x.multiply(z);
		BigInteger result = firtsStep.add(secondStep).add(thirdStep).add(fourthStep);
		
		return result;
		
	}
}
