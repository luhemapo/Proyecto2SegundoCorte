package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ViewMat extends JFrame{
	
	private ImageIcon windowImg;
	private JLabel lb_welcome;
	private JLabel lb_num1;
	private JLabel lb_num2;
	private JTextArea ta_result;
	private JTextArea ta_num1;
	private JTextArea ta_num2;
	private JButton bt_mult;
	private JButton bt_atras;
	private JButton bt_nuevo;
	private int width;
	private int height;
	
	public ViewMat() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Img/img.jpg")).getImage());
		setTitle("Multiplicar matrices");
		width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setLayout(null);
		setSize(1350, 676);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		ta_result = new JTextArea();
		ta_result.setBounds(45, 30, 882, 480);
		ta_result.setVisible(true);
		ta_result.setEditable(false);
		ta_result.setLineWrap(true);
		ta_result.setWrapStyleWord(true);
		add(ta_result);
		
		lb_num1 = new JLabel("Matriz A(_x_):");
		lb_num1.setBounds(950, 30, 350, 100);
		lb_num1.setForeground(Color.BLACK);
		add(lb_num1);
		
		ta_num1 = new JTextArea("");
		ta_num1.setBounds(950, 100, 350, 100);
		ta_num1.setVisible(true);
		ta_num1.setEditable(true);
		ta_num1.setLineWrap(true);
		ta_num1.setWrapStyleWord(true);
		add(ta_num1);
		JScrollPane scrollnum1 = new JScrollPane(ta_num1);
		scrollnum1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollnum1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollnum1.setBounds(950, 100, 350, 100);
		scrollnum1.setOpaque(true);
		scrollnum1.setBorder(null);
		add(scrollnum1);
		
		lb_num2 = new JLabel("Matriz B(_x_):");
		lb_num2.setBounds(950, 230, 350, 100);
		lb_num2.setForeground(Color.BLACK);
		add(lb_num2);
		ta_num2 = new JTextArea();
		ta_num2.setBounds(950, 300, 350, 100);
		ta_num2.setVisible(true);
		ta_num2.setEditable(true);
		ta_num2.setLineWrap(true);
		ta_num2.setWrapStyleWord(true);
		add(ta_num2);
		JScrollPane scrollnum2 = new JScrollPane(ta_num2);
		scrollnum2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollnum2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollnum2.setBounds(950, 300, 350, 100);
		scrollnum2.setOpaque(true);
		scrollnum2.setBorder(null);
		add(scrollnum2);
		
		JScrollPane scroll = new JScrollPane(ta_result);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(45, 30, 882, 480);
		scroll.setOpaque(true);
		scroll.setBorder(null);
		add(scroll);

		bt_mult = new JButton("Multiplicar");
		bt_mult.setActionCommand("MULT_MULTIPLICAR_STRASSEN");
		bt_mult.setBounds(1030, 450, 200, 30);
		bt_mult.setVisible(true);
		add(bt_mult);

		bt_atras = new JButton("Atras");
		bt_atras.setActionCommand("MULT_ATRAS");
		bt_atras.setBounds(80, 550, 200, 30);
		bt_atras.setVisible(true);
		add(bt_atras);
		
		bt_nuevo = new JButton("Nueva operacion");
		bt_nuevo.setActionCommand("MULT_NUE");
		bt_nuevo.setBounds(1030, 550, 200, 30);
		bt_nuevo.setVisible(true);
		add(bt_nuevo);

		Dimension wsize = getSize();
		windowImg = new ImageIcon(getClass().getResource("/Img/multBack.jpg"));
		lb_welcome = new JLabel(windowImg);
		lb_welcome.setBounds(0, 0, wsize.width, wsize.height);
		add(lb_welcome);

		setResizable(false);
		setVisible(false);
	
	}
	
	public int inputData(String mensaje) {
		boolean error=true;
		int resul =0;
		while(error) {
			try {
			String dato = JOptionPane.showInputDialog(null,mensaje,"Multiplicacion de  Matrices",JOptionPane.QUESTION_MESSAGE);
			if (dato != null) {
				resul = Integer.parseInt(dato);
				error=false;
			}
			}catch(NumberFormatException e) {
				error=true;
			} 
			
		}
		return resul;
	}

	public JButton getBt_mult() {
		return bt_mult;
	}

	public void setBt_mult(JButton bt_mult) {
		this.bt_mult = bt_mult;
	}

	public JButton getBt_atras() {
		return bt_atras;
	}

	public void setBt_atras(JButton bt_atras) {
		this.bt_atras = bt_atras;
	}

	public JTextArea getTa_result() {
		return ta_result;
	}

	public void setTa_result(JTextArea ta_result) {
		this.ta_result = ta_result;
	}

	public JTextArea getTa_num1() {
		return ta_num1;
	}

	public void setTa_num1(JTextArea ta_num1) {
		this.ta_num1 = ta_num1;
	}

	public JTextArea getTa_num2() {
		return ta_num2;
	}

	public void setTa_num2(JTextArea ta_num2) {
		this.ta_num2 = ta_num2;
	}

	public JLabel getLb_num1() {
		return lb_num1;
	}

	public void setLb_num1(JLabel lb_num1) {
		this.lb_num1 = lb_num1;
	}

	public JLabel getLb_num2() {
		return lb_num2;
	}

	public void setLb_num2(JLabel lb_num2) {
		this.lb_num2 = lb_num2;
	}

	public JButton getBt_nuevo() {
		return bt_nuevo;
	}

	public void setBt_nuevo(JButton bt_nuevo) {
		this.bt_nuevo = bt_nuevo;
	}
	
	
	
}