package lab1;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;

public class FormAir {

	private JFrame frame;
	private JPanel panel;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonCreate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAir window = new FormAir();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public FormAir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel = new PanelAir();
		panel.setBounds(0, 0, 885, 461);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		buttonRight = new JButton("");
		buttonRight
				.setIcon(new ImageIcon(
						"C:\\Users\\Mr.Cookie\\Documents\\EclipseProject\\��\\right.png"));
		buttonRight.setBounds(814, 386, 50, 50);
		panel.add(buttonRight);
		buttonRight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelAir.initialization) {
					PanelAir.air.MoveTransport(Direction.Right);
				}
				RedrawUI();
			}
		});
		buttonDown = new JButton("");
		buttonDown
				.setIcon(new ImageIcon(
						"C:\\Users\\Mr.Cookie\\Documents\\EclipseProject\\��\\down.png"));
		buttonDown.setBounds(751, 386, 50, 50);
		panel.add(buttonDown);
		buttonDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelAir.initialization) {
					PanelAir.air.MoveTransport(Direction.Down);
				}
				RedrawUI();
			}
		});
		buttonLeft = new JButton("");
		buttonLeft
				.setIcon(new ImageIcon(
						"C:\\Users\\Mr.Cookie\\Documents\\EclipseProject\\��\\left.png"));
		buttonLeft.setBounds(689, 386, 50, 50);
		panel.add(buttonLeft);
		buttonLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelAir.initialization) {
					PanelAir.air.MoveTransport(Direction.Left);
				}
				RedrawUI();
			}
		});
		buttonUp = new JButton("");
		buttonUp.setIcon(new ImageIcon(
				"C:\\Users\\Mr.Cookie\\Documents\\EclipseProject\\��\\up.png"));
		buttonUp.setBounds(751, 323, 50, 50);
		panel.add(buttonUp);
		buttonUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelAir.initialization) {
					PanelAir.air.MoveTransport(Direction.Up);
				}
				RedrawUI();
			}
		});
		buttonCreate = new JButton("�������� ������");
		buttonCreate.setBounds(0, 0, 188, 25);
		panel.add(buttonCreate);
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rnd = new Random();
				PanelAir.air = new Air(rnd.nextInt(200) + 100, rnd
						.nextInt(1000) + 1000, Color.GRAY, Color.BLUE);
				PanelAir.initialization = true;
				PanelAir.air.SetPosition(rnd.nextInt(90) + 10,
						rnd.nextInt(90) + 10, panel.getWidth(),
						panel.getHeight());
				RedrawUI();
			}
		});
	}

	private void RedrawUI() {
		panel.updateUI();
	}
}
