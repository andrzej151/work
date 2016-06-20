package net;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.Timer;

public class Grafika extends Applet implements KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Applet applet;
	Timer  timer;
	Map m;
	
	Image bufor;
	Graphics bg;
	private int dl = 200 + 25 * 20, wys = 250 + 25 * 20; // wielkosc okna

	public void init() {

		super.init();
		applet = this;
		applet.setSize(wys, dl);
		applet.setBackground(Color.BLUE);
		bufor = createImage(wys, dl);
		bg = bufor.getGraphics();
		m=new Map();

		applet.addKeyListener(this);
		timer = new Timer();
		timer.scheduleAtFixedRate(m, 10, 10);
		
		
		
	}
	
	public void update(Graphics g)// podwojne buforowanie
	{
		
		bg.clearRect(0, 0, wys, dl); // czysci ekran z ca³ej zawartosci
		paint(bg); // rysuje plansze do bufora w pamieci
		g.drawImage(bufor, 0, 0, applet); // rysowanie z bufora na ekran jako
		
		
		
	}

	public void paint(Graphics g) // rysowanie planszy kwadratow
	{
		for(int i=0;i<m.wielkosc;i++){
			for(int j=0;j<m.wielkosc;j++)
				{
					switch (m.tab[j][i]) {
					case 0:
						g.setColor(new Color(0,222,222));
						g.fillRect(50 + i *20, 50 + j * 20, 20, 20);	
						
						break;
						
					case 1:
						g.setColor(new Color(255,222,222));
						g.fillRect(50 + i *20, 50 + j * 20, 20, 20);	
						
						break;
						
					case 3:
						g.setColor(new Color(0,222,0));
						g.fillRect(50 + i *20, 50 + j * 20, 20, 20);	
						
						break;
					case 4:
						g.setColor(new Color(222,0,0));
						g.fillRect(50 + i *20, 50 + j * 20, 20, 20);	
						
						break;
					case 5:
						g.setColor(new Color(222,222,0));
						g.fillRect(50 + i *20, 50 + j * 20, 20, 20);	
						
						break;
					case 7:
						g.setColor(new Color(0,0,0));
						g.fillRect(50 + i *20, 50 + j * 20, 20, 20);	
						
						break;

					default:
						break;
					}
					g.setColor(new Color(0,0,0));
					g.drawRect(50 + i *20, 50 + j * 20, 20, 20);
				}
			g.setColor(new Color(0,0,0));
			g.fillRect(50 + m.zy *20, 50 + m.zx * 20, 20, 20);
			}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getKeyChar()) {
		case 'w':
			m.ruch(3);
			break;
		case 's':
			m.ruch(2);
			break;
		case 'a':
			m.ruch(1);
			break;
		case 'd':
			m.ruch(4);
			break;
		case 'q':
			m.zatwierdc();
			break;
		case 'r':
			m.nowarunda();
			break;
		case 'g':
			m.rozwiaz();
			break;
		case 'c':
			m.zer();;
			break;
		case 'z':
			try {
				m.zapisz();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			



		default:
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
