package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import Model.Matrices;
import Model.Multiplication;
import View.ViewMain;
import View.ViewMat;
import View.ViewMult;
/**
 * Clase que maneja el ciclo de ejecucion de la aplicacion
 */
public class Controller implements ActionListener {
	/**
	 * Objeto de la ventana ViewMain
	 */
	public ViewMain viewM;
	/**
	 * Objeto de la ventana ViewMult
	 */
	public ViewMult viewMult;
	/**
	 * Objeto de la ventana ViewMat
	 */
	public ViewMat viewMat;
	/**
	 * Objeto de la clase Matrices que contiene los algoritmos a ejecutar
	 */
	public Matrices mat;
	/**
	 * Objeto de la clase Multiplication que contiene los algoritmos a ejecutar
	 */
	public Multiplication mult;
	/**
	 * Variable que almacena el input1
	 */
	public BigInteger input1 = new BigInteger("0");
	/**
	 * Variable que almacena el input2
	 */
	public BigInteger input2 = new BigInteger("0");
	/**
	 * Variable que almacena el valor de n
	 */
	public int n = 0;
	/**
	 * Variable que almacena el resultado
	 */
	public BigInteger result = new BigInteger("0");
	/**
	 * Variable que almacena el tamaño 1 de la matriz A
	 */
	public static int tam1=0;
	/**
	 * Variable que almacena el tamaño 2 de la matriz A
	 */
	public static int tam12=0;
	/**
	 * Variable que almacena el tamaño 1 de la matriz B
	 */
	public static int tam2=0;
	/**
	 * Variable que almacena el tamaño 2 de la matriz B
	 */
	public static int tam21=0;
	/**
	 * Variable que almacena el tamaño mayor de las dos matrices
	 */
	public static int mayor =0;
	/**
	 * Metodo que crea un objeto de la clase controlador <br>
	 * <b>Pre:</b> <br>
	 * Las librerias estan correctamente incluidas en el proyecto <br>
	 * <b>Post:</b> <br>
	 * Se inicializaron las ventanas, clases, botones, checkbox y se muestra window.
	 */
	public Controller() {
		viewM = new ViewMain();
		viewMult = new ViewMult();
		viewMat = new ViewMat();
		mult = new Multiplication();
		mat = new Matrices();

		viewM.getBt_mult().addActionListener(this);
		viewM.getBt_matriz_Strassen().addActionListener(this);
		viewM.getBt_matriz_mult().addActionListener(this);
		viewM.getBt_exit().addActionListener(this);
		viewMult.getBt_mult().addActionListener(this);
		viewMult.getBt_atras().addActionListener(this);
		viewMat.getBt_mult().addActionListener(this);
		viewMat.getBt_atras().addActionListener(this);
		viewMat.getBt_nuevo().addActionListener(this);

	}
	/**
	 * Metodo que ejecuta la multiplicacion de dos numeros <br>
	 * <b>Pre:</b> <br>
	 * El usuario se encuentra en la ventana multiplicar <br>
	 * El usuario ingresa los numeros a multiplicar <br>
	 * El usuario oprimie el boton Multiplicar<br>
	 * <b>Post:</b> <br>
	 * Se se muestra el resultado <br>
	 * Se le informa al usuario en caso exista algun error
	 */
	public BigInteger runMultiply() {
		String in1 = viewMult.getTa_num1().getText();
		String in2 = viewMult.getTa_num2().getText();
		input1 = new BigInteger(in1);
		input2 = new BigInteger(in2);
		n = Math.max(input1.bitLength(), input2.bitLength());
		
		if (n < 6) {
			result = mult.smallMulti(input1, input2);
		} else {
			result = mult.multi(input1, input2, n);

		}
		return result;

	}
	/**
	 * Metodo que ejecuta la multiplicacion de dos matrices por el metodo Strassen<br>
	 * <b>Pre:</b> <br>
	 * El usuario se encuentra en la ventana multiplicar Strassen<br>
	 * El usuario ingresa el tamaño de las dos marices <br>
	 * El usuario ingresa los valores de las dos matrices <br>
	 * El usuario oprimie el boton Multiplicar<br>
	 * <b>Post:</b> <br>
	 * Se se muestra el resultado <br>
	 * Se le informa al usuario en caso exista algun error
	 */
	public void runStrassenMatriz() {
		mayor=mat.biggerStrassen(tam1, tam12, tam2, tam21);
		mat.inicializarArr(mayor);
		String[] filasA=viewMat.getTa_num1().getText().split("\n");
		String[] filasB=viewMat.getTa_num2().getText().split("\n");
		if(filasA.length==tam1&&filasA[0].split(" ").length==tam12 && filasB.length==tam2&&filasB[0].split(" ").length==tam21) {
			if(mat.asignar(tam1, tam12, tam2, tam21, viewMat.getTa_num1().getText(), viewMat.getTa_num2().getText())) {
				mat.setC(mat.multiplyStrassen(mat.getA(), mat.getB()));
				String texto=mat.mostrarMatriz(tam1, tam12, tam2, tam21);
				viewMat.getTa_result().setText(texto);
			}else {
				viewM.showMessage("Por favor solo ingrese numeros en sus matrices","Error");
			}
		}else {
			viewM.showMessage("revise las dimenciones de su matriz o el formato de ingreso","Error");
		}
	}
	/**
	 * Metodo que ejecuta la multiplicacion de dos matrices por el metodo Strassen<br>
	 * <b>Pre:</b> <br>
	 * El usuario se encuentra en la ventana multiplicacion clasica<br>
	 * El usuario ingresa el tamaño de las dos marices <br>
	 * El usuario ingresa los valores de las dos matrices <br>
	 * El usuario oprimie el boton Multiplicar<br>
	 * <b>Post:</b> <br>
	 * Se se muestra el resultado <br>
	 * Se le informa al usuario en caso exista algun error
	 */
	public void runClasicMatriz() {
		if(tam1>tam2 &&tam1>tam21) {
			mayor=tam1;
		}else if(tam2>tam1&&tam2>tam21) {
			mayor=tam2;
		}else {
			mayor=tam21;
		}
		mat.inicializarArr(mayor);
		String[] filasA=viewMat.getTa_num1().getText().split("\n");
		String[] filasB=viewMat.getTa_num2().getText().split("\n");
		if(filasA.length==tam1&&filasA[0].split(" ").length==tam12 && filasB.length==tam2&&filasB[0].split(" ").length==tam21) {
			if(mat.asignar(tam1, tam12, tam2, tam21, viewMat.getTa_num1().getText(), viewMat.getTa_num2().getText())) {
				mat.setC(mat.multiplyClasic(mayor));
				String texto=mat.mostrarMatriz(tam1, tam12, tam2, tam21);
				viewMat.getTa_result().setText(texto);
			}else {
				viewM.showMessage("Por favor solo ingrese numeros en sus matrices","Error");
			}
		}else {
			viewM.showMessage("revise las dimenciones de su matriz o el formato de ingreso","Error");
		}
	}
	/**
	 * Metodo encargado de leer el tamaño de las dos matrices<br>
	 * <b>Pre:</b> <br>
	 * El usuario se encuentra en la ventana multiplicacion clasica<br>
	 * El usuario ingresa el tamaño de las dos marices <br>
	 * <b>Post:</b> <br>
	 * Se muestra el tamaño de las matrices ingresadas <br>
	 * Se le informa al usuario en caso exista algun error
	 */
	public void readMatrix() {
		boolean flag=false;
		while(!flag) {
			tam1=viewMat.inputData("Por favor ingrese el tamaño de filas de su matriz A :");
			tam12=viewMat.inputData("Por favor ingrese el tamaño de columnas de su matriz A :");
			tam2=viewMat.inputData("Por favor ingrese el tamaño de filas de su matriz B :");
			tam21=viewMat.inputData("Por favor ingrese el tamaño de columnas de su matriz B :");
			if(tam12==tam2) {
				flag=true;
			}else {
				viewM.showMessage("Recuerde que el tamaño de las columnas de la matriz A debe coincidir con el tamaño de las filas de la matriz B\n intentelo nuevamente","Error");
			}
		}
		viewM.showMessage("Por favor ingres sus matrices en los espacios correspondientes con el siguente formato."
				+ "\nSegun el tamaño que desee..\n\n"
				+ "0 0 0 0\n"
				+ "0 0 0 0\n"
				+ "0 0 0 0\n", "Info");
		viewMat.getLb_num1().setText("Matriz A("+tam1+"x"+tam12+"):");
		viewMat.getLb_num2().setText("Matriz B("+tam2+"x"+tam21+"):");
	}
	/**
	 * Contiene la logica de los eventos que vienen de las ventanas <br>
	 * <b>Pre:</b> <br>
	 * El usuario ejecuto una evento y espera una respuesta <br>
	 * <b>Post:</b> <br>
	 * Se ejecuta la accion correspondiente al evento lanzado por el usuario
	 * 
	 * @param e Evento que ejecuta el usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("MAIN_MULTIPLICAR")) {
			viewM.setVisible(false);
			viewMult.setVisible(true);
		}
		if (e.getActionCommand().equals("EXIT")) {
			viewM.showMessage("Hasta luego!", "Info");
			System.exit(1);
		}
		if (e.getActionCommand().equals("MULT_ATRAS")) {
			viewMult.setVisible(false);
			viewMat.setVisible(false);
			viewM.setVisible(true);
			viewMat.getTa_num1().setText("");
			viewMat.getTa_num2().setText("");
			viewMat.getTa_result().setText("");
			viewMult.getTa_num1().setText("");
			viewMult.getTa_num2().setText("");
			viewMult.getTa_result().setText("");
			
		}
		if (e.getActionCommand().equals("MULT_MULTIPLICAR")) {
			if (!viewMult.getTa_num1().getText().equals("") && !viewMult.getTa_num2().getText().equals("")) {
				if (mult.isNumeric(viewMult.getTa_num1().getText()) == false
						|| mult.isNumeric(viewMult.getTa_num2().getText()) == false) {
					viewM.showMessage("Input no valido, ingrese numeros unicamente", "Error");
				} else {
					String in1 = viewMult.getTa_num1().getText();
					String in2 = viewMult.getTa_num2().getText();
					input1 = new BigInteger(in1);
					input2 = new BigInteger(in2);
					if(input1.compareTo(BigInteger.ZERO) == 1 && input2.compareTo(BigInteger.ZERO)== 1){
						runMultiply();
						viewMult.getTa_result().setText(result.toString());
					}else {
						viewM.showMessage("Debe ingresar 2 numeros positivos", "Error");
					}
				}

			} else {
				viewM.showMessage("Debe ingresar 2 numeros positivos", "Error");
			}
		}
		if (e.getActionCommand().equals("MAIN_MATRIZ")) {
			viewM.setVisible(false);
			viewMat.setVisible(true);
			viewMat.getBt_mult().setActionCommand("MULT_MULTIPLICAR_STRASSEN");
			readMatrix();
		}
		if (e.getActionCommand().equals("MULT_MULTIPLICAR_STRASSEN")) {
			runStrassenMatriz();
		}
		if (e.getActionCommand().equals("MAIN_MATRIZ_MULT")) {
			viewM.setVisible(false);
			viewMat.setVisible(true);
			viewMat.getBt_mult().setActionCommand("MULT_MULTIPLICAR_CLASIC");
			readMatrix();
		}
		if (e.getActionCommand().equals("MULT_MULTIPLICAR_CLASIC")) {
			runClasicMatriz();
		}
		if (e.getActionCommand().equals("MULT_NUE")) {
			viewMat.getTa_num1().setText("");
			viewMat.getTa_num2().setText("");
			viewMat.getTa_result().setText("");
			readMatrix();
		}
	}
}
