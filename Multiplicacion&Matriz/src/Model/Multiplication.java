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
	        double d = Double.parseDouble(input);
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
		
		BigInteger w = input1.divide(BigDecimal.valueOf(Math.pow(10, s)).toBigInteger());
		BigInteger x = input1.mod(BigDecimal.valueOf(Math.pow(10, s)).toBigInteger());
		BigInteger y = input2.divide(BigDecimal.valueOf(Math.pow(10, s)).toBigInteger());
		BigInteger z = input2.mod(BigDecimal.valueOf(Math.pow(10, s)).toBigInteger());
	
		BigInteger firtsStep = (w.multiply(y)).multiply(BigDecimal.valueOf(Math.pow(10, (2*s))).toBigInteger());
		BigInteger secondStep = w.multiply(z);
		BigInteger thirdStep =(x.multiply(y)).multiply(BigDecimal.valueOf(Math.pow(10, s)).toBigInteger());
		BigInteger fourthStep = x.multiply(z);
		BigInteger result = firtsStep.add(secondStep).add(thirdStep).add(fourthStep);
		
		return result;
		
	}
}
