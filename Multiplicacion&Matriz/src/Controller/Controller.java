package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import Model.Matrices;
import Model.Multiplication;
import View.ViewMain;
import View.ViewMat;
import View.ViewMult;

public class Controller implements ActionListener {
	public ViewMain viewM;
	public ViewMult viewMult;
	public ViewMat viewMat;
	public Matrices mat;
	public Multiplication mult;
	public BigInteger input1 = new BigInteger("0");
	public BigInteger input2 = new BigInteger("0");
	public int n = 0;
	public BigInteger result = new BigInteger("0");
	public static int tam1=0;
	public static int tam12=0;
	public static int tam2=0;
	public static int tam21=0;
	public static int mayor =0;

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
