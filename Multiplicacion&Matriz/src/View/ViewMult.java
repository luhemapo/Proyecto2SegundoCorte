package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ViewMult extends JFrame{
	
	private ImageIcon windowImg;
	private JLabel lb_welcome;
	private JLabel lb_num1;
	private JLabel lb_num2;
	private JTextArea ta_result;
	private JTextArea ta_num1;
	private JTextArea ta_num2;
	private JButton bt_mult;
	private JButton bt_BM;
	private JButton bt_atras;
	private int width;
	private int height;
	
	public ViewMult() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Img/img.jpg")).getImage());
		setTitle("Multiplicar");
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
		
		lb_num1 = new JLabel("Primer numero");
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
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollnum1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollnum1.setBounds(950, 100, 350, 100);
		scrollnum1.setOpaque(true);
		scrollnum1.setBorder(null);
		add(scrollnum1);
		
		lb_num2 = new JLabel("Segundo numero");
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
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollnum2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollnum2.setBounds(950, 300, 350, 100);
		scrollnum2.setOpaque(true);
		scrollnum2.setBorder(null);
		add(scrollnum2);
		
		JScrollPane scroll = new JScrollPane(ta_result);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(45, 30, 882, 480);
		scroll.setOpaque(true);
		scroll.setBorder(null);
		add(scroll);

		bt_mult = new JButton("Multiplicar");
		bt_mult.setActionCommand("MULT_MULTIPLICAR");
		bt_mult.setBounds(1030, 450, 200, 30);
		bt_mult.setVisible(true);
		add(bt_mult);

		bt_atras = new JButton("Atras");
		bt_atras.setActionCommand("MULT_ATRAS");
		bt_atras.setBounds(80, 550, 200, 30);
		bt_atras.setVisible(true);
		add(bt_atras);

		Dimension wsize = getSize();
		windowImg = new ImageIcon(getClass().getResource("/Img/multBack.jpg"));
		lb_welcome = new JLabel(windowImg);
		lb_welcome.setBounds(0, 0, wsize.width, wsize.height);
		add(lb_welcome);

		setResizable(false);
		setVisible(false);
	

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
	
	
}