package ZbioryRozmyte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class linia extends JPanel{
	Image bufor;
	Graphics bg;
	int x1,y1,x2,y2;
	JFrame f;
	
	public linia()
	{
	x1=0;
	x2=0;
	y1=50;
	y2=50;
	//bg.clearRect(25, 25, 100, 50);
	}
	
	public linia(JFrame frame) {
		f=frame;
	}
	public void set(int x,int y,int x2,int y2)
	{
		x1=x;
		y1=y;
		this.x2=x2;
		this.y2=y2;
	}

	public void update(Graphics g)// podwojne buforowanie
	{
		
		bg.clearRect(25, 25, 100, 50); // czysci ekran z ca³ej zawartosci
		paint(bg); // rysuje plansze do bufora w pamieci
		g.drawImage(bufor, 0, 0, null); // rysowanie z bufora na ekran jako
		
		
		
	}

	public void paint(Graphics g) // rysowanie planszy kwadratow
	{
		
		
		
		g.drawLine(y1, x1, x2, y2);
	}
}
