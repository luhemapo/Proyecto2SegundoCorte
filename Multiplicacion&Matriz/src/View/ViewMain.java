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
	private JButton bt_matriz;
	private JButton bt_exit;
	private int width;
	private int height;

	public ViewMain() {
		
		setIconImage(new ImageIcon(getClass().getResource("/Img/logo.png")).getImage());
		setTitle("Multiplicacion & Matrices");
		width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setLayout(null);
		setSize(600, 460);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

		bt_mult = new JButton("Multiplicar");
		bt_mult.setActionCommand("MAIN_MULTIPLICAR");
		bt_mult.setBounds(80, 240, 200, 30);
		bt_mult.setVisible(true);
		add(bt_mult);

		bt_matriz = new JButton("Matriz");
		bt_matriz.setActionCommand("MAIN_MATRIZ");
		bt_matriz.setBounds(80, 280, 200, 30);
		bt_matriz.setVisible(true);
		add(bt_matriz);

		bt_exit = new JButton("Exit");
		bt_exit.setActionCommand("EXIT");
		bt_exit.setBounds(80, 320, 200, 30);
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

	public JButton getBt_matriz() {
		return bt_matriz;
	}

	public void setBt_matriz(JButton bt_matriz) {
		this.bt_matriz = bt_matriz;
	}

	public JButton getBt_exit() {
		return bt_exit;
	}

	public void setBt_exit(JButton bt_exit) {
		this.bt_exit = bt_exit;
	}
	
}
