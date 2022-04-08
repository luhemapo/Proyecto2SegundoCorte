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
	public int n = 0;
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
		String in1 = viewMult.getTa_num1().getText();
		String in2 = viewMult.getTa_num2().getText();
		BigInteger input1 = new BigInteger(in1);
		BigInteger input2 = new BigInteger(in2);
		n = Math.max(input1.bitLength(), input2.bitLength());
		if (n < 6) {
			result = mult.smallMulti(input1, input2);
		} else {
			result = mult.multi(input1, input2, n);

		}
		return result;

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
			if (!viewMult.getTa_num1().getText().equals("") && !viewMult.getTa_num2().getText().equals("")) {
				if (mult.isNumeric(viewMult.getTa_num1().getText()) == false
						|| mult.isNumeric(viewMult.getTa_num2().getText()) == false) {
					viewM.showMessage("Input no valido, ingrese numeros unicamente", "Error");
				} else {
					if (Integer.parseInt(viewMult.getTa_num1().getText()) > 0
							&& Integer.parseInt(viewMult.getTa_num2().getText()) > 0) {
						runMultiply();
						viewMult.getTa_result().setText(result.toString());
					} else {
						viewM.showMessage("Debe ingresar 2 numeros positivos", "Error");
					}
				}

			} else {
				viewM.showMessage("Debe ingresar 2 numeros positivos", "Error");
			}
		}
	}
}
