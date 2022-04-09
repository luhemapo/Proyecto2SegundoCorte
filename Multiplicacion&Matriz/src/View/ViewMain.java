package View;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ViewMain extends JFrame{
	/**
	 * Imagen de fondo de la ventana principal
	 */
	private ImageIcon windowImg;
	/**
	 * Contenedor de la imagen de la ventana principal
	 */
	private JLabel welcome;
	/**
	 * Boton para seleccionar el algoritmo de multiplicacion
	 * de numeros grandes
	 */
	private JButton bt_mult;
	/**
	 * Boton para seleccionar el algoritmo de multiplicacion
	 * Strassen
	 */
	private JButton bt_matriz_Strassen;
	/**
	 * Boton para seleccionar el algoritmo de multiplicacion
	 * tradicional
	 */
	private JButton bt_matriz_mult;
	/**
	 * Boton para salir de la aplicacion
	 */
	private JButton bt_exit;
	/**
	 * Metodo inicializador de la ventana inicial. Define todos sus componentes y ubicaciones
	 * <br>
	 * <b>Pre:</b>
	 * <br>
	 * <b>Post:</b>
	 * <br>
	 * La ventana se encuentra lista para mostrarse
	 */
	public ViewMain() {
		
		setIconImage(new ImageIcon(getClass().getResource("/Img/logo.png")).getImage());
		setTitle("Multiplicacion & Matrices");
		setLayout(null);
		setSize(600, 460);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

		bt_mult = new JButton("Multiplicar");
		bt_mult.setActionCommand("MAIN_MULTIPLICAR");
		bt_mult.setBounds(80, 240, 200, 30);
		bt_mult.setVisible(true);
		add(bt_mult);

		bt_matriz_Strassen = new JButton("Matriz Strassen");
		bt_matriz_Strassen.setActionCommand("MAIN_MATRIZ");
		bt_matriz_Strassen.setBounds(80, 280, 200, 30);
		bt_matriz_Strassen.setVisible(true);
		add(bt_matriz_Strassen);
		
		bt_matriz_mult = new JButton("Matriz Clasico");
		bt_matriz_mult.setActionCommand("MAIN_MATRIZ_MULT");
		bt_matriz_mult.setBounds(80, 320, 200, 30);
		bt_matriz_mult.setVisible(true);
		add(bt_matriz_mult);

		bt_exit = new JButton("Exit");
		bt_exit.setActionCommand("EXIT");
		bt_exit.setBounds(80, 360, 200, 30);
		bt_exit.setVisible(true);
		add(bt_exit);

		Dimension wsize = getSize();
		windowImg = new ImageIcon(getClass().getResource("/Img/img.jpg"));
		welcome = new JLabel(windowImg);
		welcome.setBounds(0, 0, wsize.width, wsize.height);
		add(welcome);

		setResizable(false);
		setVisible(true);
	

	}
	/**
	 * Metodo que se ejecuta para mostrar un mensaje de informacion o de error.
	 * <br>
	 * <b>Pre:</b>
	 * <br>
	 * Muestra mensaje correspondiente
	 * <br>
	 * <b>Post:</b>
	 * <br>
	 * Se le da al usuario un mensaje
	 * @param mensaje String que contiene el mensaje a mostrar
	 * @param type String el tipo de mensaje a mostrar
	 */
	public void showMessage(String message, String type) {
		if (type.equals("Info")) {
			JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
		} else if (type.equals("Error")) {
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Getter de JButton bt_mult, se usa para asignar su respectivo Action Listener
	 * @return Accion del boton
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
	 * Getter de JButton bt_matriz_Strassen, se usa para asignar su respectivo Action Listener
	 * @return Accion del boton
	 */
	public JButton getBt_matriz_Strassen() {
		return bt_matriz_Strassen;
	}
	/**
	 * setter del JButton bt_matriz_Strassen
	 */
	public void setBt_matriz_Strassen(JButton bt_matriz) {
		this.bt_matriz_Strassen = bt_matriz;
	}
	/**
	 * Getter de JButton bt_matriz_mult, se usa para asignar su respectivo Action Listener
	 * @return Accion del boton
	 */
	public JButton getBt_matriz_mult() {
		return bt_matriz_mult;
	}
	/**
	 * setter del JButton bt_matriz_mult
	 */
	public void setBt_matriz_mult(JButton bt_matriz_mult) {
		this.bt_matriz_mult = bt_matriz_mult;
	}
	/**
	 * Getter de JButton bt_exit, se usa para asignar su respectivo Action Listener
	 * @return Accion del boton
	 */
	public JButton getBt_exit() {
		return bt_exit;
	}
	/**
	 * setter del JButton bt_exit
	 */
	public void setBt_exit(JButton bt_exit) {
		this.bt_exit = bt_exit;
	}
	
}
