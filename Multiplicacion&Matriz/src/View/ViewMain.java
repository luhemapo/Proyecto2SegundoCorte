package View;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ViewMain extends JFrame{
	
	private ImageIcon windowImg;
	private JLabel welcome;
	private JButton bt_mult;
	private JButton bt_matriz_Strassen;
	private JButton bt_matriz_mult;
	private JButton bt_exit;


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

	public void showMessage(String message, String type) {
		if (type.equals("Info")) {
			JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
		} else if (type.equals("Error")) {
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JButton getBt_mult() {
		return bt_mult;
	}

	public void setBt_mult(JButton bt_mult) {
		this.bt_mult = bt_mult;
	}

	public JButton getBt_matriz_Strassen() {
		return bt_matriz_Strassen;
	}

	public void setBt_matriz_Strassen(JButton bt_matriz) {
		this.bt_matriz_Strassen = bt_matriz;
	}
	
	public JButton getBt_matriz_mult() {
		return bt_matriz_mult;
	}

	public void setBt_matriz_mult(JButton bt_matriz_mult) {
		this.bt_matriz_mult = bt_matriz_mult;
	}

	public JButton getBt_exit() {
		return bt_exit;
	}

	public void setBt_exit(JButton bt_exit) {
		this.bt_exit = bt_exit;
	}
	
}
