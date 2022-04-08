package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import Model.Multiplication;
import View.ViewMain;
import View.ViewMult;

public class Controller implements ActionListener {
	public ViewMain viewM;
	public ViewMult viewMult;
	public Multiplication mult;
	public String input1 = "";
	public String input2 = "";
	public int s = 0;
	public BigInteger result = new BigInteger("0");
	public Controller() {
		viewM = new ViewMain();
		viewMult = new ViewMult();
		mult = new Multiplication();
		

		viewM.getBt_mult().addActionListener(this);
		viewM.getBt_matriz().addActionListener(this);
		viewM.getBt_exit().addActionListener(this);
		viewMult.getBt_mult().addActionListener(this);
		viewMult.getBt_atras().addActionListener(this);

	}
	public BigInteger runMultiply() {
		
		String wInp = "";
		String xInp = "";
		String yInp = "";
		String zInp = "";
		String input1 = viewMult.getTa_num1().getText();
		String input2 = viewMult.getTa_num2().getText();
		if (lengthEven(input1) == true) {
			s = input1.length()/2;
			wInp = input1.substring(0, s);
			xInp = input1.substring(s,input1.length());

		} else {
			s = input1.length()/2+1;
			wInp = input1.substring(0, s-1);
			xInp = input1.substring(s-1,input1.length());

		}

		if (lengthEven(input2) == true) {
			s = input2.length()/2;
			yInp = input2.substring(0, s);
			zInp = input2.substring(s,input2.length());

		} else {
			s = input2.length()/2+1;
			yInp = input2.substring(0, s-1);
			zInp = input2.substring(s-1,input2.length());

		}
		result = mult.multi(wInp, xInp, yInp, zInp, s);
		System.out.println(result);
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
			viewM.setVisible(true);
		}
		if (e.getActionCommand().equals("MULT_MULTIPLICAR")) {
			if(!viewMult.getTa_num1().getText().equals("")&&!viewMult.getTa_num2().getText().equals("")) {
				if(viewMult.getTa_num1().getText().length()==viewMult.getTa_num2().getText().length()) {
					runMultiply();
					viewMult.getTa_result().setText(result.toString());
				}else {
					viewM.showMessage("Los numeros deben tener la misma longitud", "Error");
				}
			}else {
				viewM.showMessage("Debe ingresar 2 numeros positivos", "Error");
			}
			
			
		}
	}
}
