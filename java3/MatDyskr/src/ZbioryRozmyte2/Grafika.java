package ZbioryRozmyte2;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.Timer;

public class Grafika implements ActionListener{

	private JFrame frame;
	private Wykres w1;
	private Timer tm=new Timer(15, this);
	int x=0,y=0;
	Image bufor;
	Graphics bg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafika window = new Grafika();
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
	public Grafika() {
		initialize();
		tm.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(50, 50, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		w1=new Wykres();
		w1.setBounds(20, 20, 110, 110);
		frame.getContentPane().add(w1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(y==1)
		{
			x++;
			if(x>100)y=2;
		}
		else
		{
			x--;
			if(x<0)y=1;
		}
		
		w1.set(x,x);
		frame.repaint();
	}
	
	public void update(Graphics g)// podwojne buforowanie
	{
		
		bg.clearRect(0, 0, 450, 400); // czysci ekran z ca³ej zawartosci
		w1.paint(bg); // rysuje plansze do bufora w pamieci
		g.drawImage(bufor, 0, 0, null); // rysowanie z bufora na ekran jako
		
		
		
	}
}
