package Model;

import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * Clase que contiene el algoritmo de multiplicacion de numeros grandes
 */
public class Multiplication {
	/**
	 * Variable que almacena el valor de w
	 */
	public String wInp = "";
	/**
	 * Variable que almacena el valor de x
	 */
	public String xInp = "";
	/**
	 * Variable que almacena el valor de y
	 */
	public String yInp = "";
	/**
	 * Variable que almacena el valor de z
	 */
	public String zInp = "";
	/**
	 * Variable que almacena el valor de s
	 */
	public int s = 0;
	/**
	 * Variable que almacena el valor de pow1
	 */
	public int pow1 = 0;
	/**
	 * Variable que almacena el valor de pow2
	 */
	public int pow2 = 0;
	/**
	 * Metodo que crea un objeto de la clase Multiplication <br>
	 * <b>Pre:</b> <br>
	 * Las librerias estan correctamente incluidas en el proyecto <br>
	 * <b>Post:</b> <br>
	 * Se inicializaron las ventanas, clases, botones, checkbox y se muestra window.
	 */
	public Multiplication() {

		
	}
	/**
	 * Metodo que se encarga de comprobar si el input es numerico
	 * <b>Pre:</b> <br>
	 * El usuario ingresa un numero <br>
	 * <b>Post:</b> <br>
	 * Se comprueba si el numero es valido<br>
	 * Y regresa true o false dependiendo del caso <br>
	 */
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
	/**
	 * Metodo que se encarga hacer la multiplicacion de 2 numeros pequeños
	 * <b>Pre:</b> <br>
	 * recibe el input de los 2 inputs del usuario <br>
	 * <b>Post:</b> <br>
	 * Se ejecuta la multiplicacion<br>
	 * Regresa el resultado de la multiplicacion <br>
	 */
	public static BigInteger smallMulti(BigInteger input1, BigInteger input2) {
		BigInteger result =input1.multiply(input2);
		return result;
	}
	/**
	 * Metodo que se encarga hacer la multiplicacion de 2 numeros grandes
	 * <b>Pre:</b> <br>
	 * recibe el input de los 2 inputs del usuario <br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el algoritmo de multiplicacion<br>
	 * Regresa el resultado de la multiplicacion <br>
	 */
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
		
		BigInteger r = (w.add(x)).multiply(y.add(z));
		BigInteger p = w.multiply(y);
		BigInteger q = x.multiply(z);
		
		BigInteger result = p.multiply(pow2).add((r.subtract(p).subtract(q)).multiply(pow1)).add(q);
		
		return result;
		
	}
}
