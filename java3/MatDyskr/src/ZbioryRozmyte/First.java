package ZbioryRozmyte;

import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class First {

	private JFrame frame;
	private JTextField x22;
	private linia panel;
	private JTextField x1;
	private JTextField y1;
	private JTextField y22;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
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
	public First() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new linia();
		panel.setBackground(Color.MAGENTA);
		panel.setBounds(25, 25, 200, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		x22 = new JTextField();
		x22.setBounds(235, 97, 86, 20);
		frame.getContentPane().add(x22);
		x22.setColumns(10);
		
		JButton btnLinia = new JButton("linia");
		btnLinia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=Integer.valueOf(x22.getText());
				int y=Integer.valueOf(x1.getText());
				int x2=Integer.valueOf(y1.getText());
				int y2=Integer.valueOf(y22.getText());
				panel.set(x, y, x2, y2);
				frame.repaint();
			}
		});
		btnLinia.setBounds(235, 159, 89, 23);
		frame.getContentPane().add(btnLinia);
		
		x1 = new JTextField();
		x1.setBounds(235, 35, 86, 20);
		frame.getContentPane().add(x1);
		x1.setColumns(10);
		
		y1 = new JTextField();
		y1.setBounds(235, 66, 86, 20);
		frame.getContentPane().add(y1);
		y1.setColumns(10);
		
		y22 = new JTextField();
		y22.setBounds(235, 128, 86, 20);
		frame.getContentPane().add(y22);
		y22.setColumns(10);
		
		JLabel lblX = new JLabel("x1");
		lblX.setBounds(328, 38, 46, 14);
		frame.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("y1");
		lblY.setBounds(328, 66, 46, 14);
		frame.getContentPane().add(lblY);
		
		JLabel lblX_1 = new JLabel("x2");
		lblX_1.setBounds(328, 100, 46, 14);
		frame.getContentPane().add(lblX_1);
		
		JLabel lblY_1 = new JLabel("y2");
		lblY_1.setBounds(328, 128, 46, 14);
		frame.getContentPane().add(lblY_1);
	}
}
