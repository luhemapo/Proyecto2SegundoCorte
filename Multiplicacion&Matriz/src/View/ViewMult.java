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
	/**
	 * Imagen de fondo de la ventana
	 */
	private ImageIcon windowImg;
	/**
	 * Contenedor de la imagen de fondo de la ventana
	 */
	private JLabel lb_welcome;
	/**
	 * JLabel para indicar al usuario que escriba
	 */
	private JLabel lb_num1;
	/**
	 * JLabel para indicar al usuario que escriba
	 */
	private JLabel lb_num2;
	/**
	 * JTextArea que muestra la solucion
	 */
	private JTextArea ta_result;
	/**
	 * JTextArea obtiene el input1
	 */
	private JTextArea ta_num1;
	/**
	 * JTextArea obtiene el input1
	 */
	private JTextArea ta_num2;
	/**
	 * Boton que ejecuta el algoritmo
	 */
	private JButton bt_mult;
	/**
	 * Boton que regresa a la ventana principal
	 */
	private JButton bt_atras;
	/**
	 * Metodo inicializador de la ventana multiplicacion. Define todos sus componentes y ubicaciones
	 * <br>
	 * <b>Pre:</b>
	 * <br>
	 * <b>Post:</b>
	 * <br>
	 * La ventana se encuentra lista para mostrarse
	 */
	
	public ViewMult() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Img/img.jpg")).getImage());
		setTitle("Multiplicar");
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
		scrollnum2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollnum2.setBounds(950, 300, 350, 100);
		scrollnum2.setOpaque(true);
		scrollnum2.setBorder(null);
		add(scrollnum2);
		
		JScrollPane scroll = new JScrollPane(ta_result);
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
	/**
	 * Getter de JButton bt_mult, se usa para asignar su Action Listener
	 * @return Accion del JButton
	 */
	public JButton getBt_mult() {
		return bt_mult;
	}
	/**
	 * setter del JButton bt_mult
	 */
	public void setBt_mult(JButton bt_mult) {
		this.bt_mult = bt_mult;
	}
	/**
	 * Getter de JButton bt_atras, se usa para asignar su Action Listener
	 * @return Accion del JButton
	 */
	public JButton getBt_atras() {
		return bt_atras;
	}
	/**
	 * setter del JButton bt_atras
	 */
	public void setBt_atras(JButton bt_atras) {
		this.bt_atras = bt_atras;
	}
	/**
	 * Getter de JTextArea ta_result, se usa para mostrar el resultado de la operacion
	 * @return Resultado
	 */
	public JTextArea getTa_result() {
		return ta_result;
	}
	/**
	 * setter del JTextArea ta_result
	 */
	public void setTa_result(JTextArea ta_result) {
		this.ta_result = ta_result;
	}
	/**
	 * Getter de JTextArea ta_num1, se usa para obtener el input1
	 * @return input1
	 */
	public JTextArea getTa_num1() {
		return ta_num1;
	}
	/**
	 * setter del JTextArea ta_num1
	 */
	public void setTa_num1(JTextArea ta_num1) {
		this.ta_num1 = ta_num1;
	}
	/**
	 * Getter de JTextArea ta_num2, se usa para obtener el input2
	 * @return input2
	 */
	public JTextArea getTa_num2() {
		return ta_num2;
	}
	/**
	 * setter del JTextArea ta_num2
	 */
	public void setTa_num2(JTextArea ta_num2) {
		this.ta_num2 = ta_num2;
	}
	
	
}