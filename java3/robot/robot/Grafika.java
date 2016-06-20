package robot;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Paint;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Grafika extends Applet implements KeyListener,Runnable // dziediczy klase
															// Applet i
															// interfejs
															// KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4263058637398320762L;

	static public Applet applet;

	private int dl = 100 + 25 * 20, wys = 250 + 25 * 20; // wielkosc okna

	private Mapa m,ma;
	private int wczytanoMapeArchiwalna;
	Timer timer;

	Image bufor;
	Graphics bg;
	Image[] obrazki;

	private int w1 = 20, w2 = 20; // wielkosci kwadratow w pixelach

	public JSocket sterowanie;
	DatagramSocket dsocket;

	public Scanner czyt;
	public Label etykieta;

	public int zerowanie_sterowania = 0;
	
	Thread odbior;
	
	public void init() {

		super.init();
		applet = this;
		czyt = new Scanner(System.in);
		m = new Mapa();
		System.out.println("wczytac mape? 1-tak 2-nie");
		this.wczytanoMapeArchiwalna = czyt.nextInt();
		
		if(this.wczytanoMapeArchiwalna==1)
		{
			this.ma=new Mapa();
			this.wys=this.dl+25 * 20+50;
			System.out.println("Podaj nazwe");
			String nazwa=czyt.next();
			try {
				ma.wczytaj(nazwa);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		applet.setSize(wys, dl);
		applet.setBackground(Color.BLUE);

		/*
		 * TextField pole; pole = new TextField("tekst",30); add(pole);
		 */

		applet.addKeyListener(this);// nasluchiwanie z klawiatury
		// do buforowania
		bufor = createImage(wys, dl);
		bg = bufor.getGraphics();
		// dzieki podwójnemu buforu podczas wywietlania generuje sie jeden
		// obrazek, który zawiera wszystkie kwardraty
		wczytajObrazki();

		

		System.out.println("podaj port");
		int port = 9035;// czyt.nextInt();
		System.out.println("podaj IP");
		String IP = "192.168.1.136";// czyt.nextLine();
		try {
			sterowanie = new JSocket(port, IP);
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer = new Timer();
		timer.scheduleAtFixedRate(m, 20, 10);
		
		
		odbior = new Thread(this); // NOWE: watek do odbioru danych, 
		 
		odbior.start(); //startuje tutaj
		

	}

	private void wczytajObrazki() { // paleta barw - st¹d pobiera kolory do
									// danych wartosci pól

		obrazki = new Image[15];
		for (int i = 0; i < 15; i++) // bo mamy 14 obrazkow "puzzli"
		{
			obrazki[i] = getImage(getDocumentBase(), "img/" + i + ".jpg"); // tutaj
																			// przechowuje
																			// tablice
																			// obrazkow
																			// we
																			// wszystkich
																			// kolorach
		}

	}

	public void update(Graphics g)// podwojne buforowanie
	{
		bg.clearRect(0, 0, wys, dl); // czysci ekran z ca³ej zawartosci
		paint(bg); // rysuje plansze do bufora w pamieci
		g.drawImage(bufor, 0, 0, applet); // rysowanie z bufora na ekran jako
											// calosc
		
		
	}

	public void paint(Graphics g) // rysowanie planszy kwadratow
	{
		try {
	
			
			for (int y = 0; y < m.tablica_wyswietlana.length; y++) { // rysowanie po
																	// y
																	// (kolejne
																	// wiersze)
				for (int x = 0; x < m.tablica_wyswietlana[0].length; x++) { // rysowanie
																		// po x
																		// ( po
							////////////////////////////////////////////
					if(m.tablica_wyswietlana[x][y]<0)
					{
						switch (m.tablica_wyswietlana[x][y]) {
							case -1://koniec
								g.drawImage(obrazki[14], 50 + x * w1, 50 + y * w2, w1, w2, applet);
								break;
							case -2://gura
								g.drawImage(obrazki[10], 50 + x * w1, 50 + y * w2, w1, w2, applet);
								break;
							case -3://lewo
								g.drawImage(obrazki[12], 50 + x * w1, 50 + y * w2, w1, w2, applet);
								break;
							case -4://prawo
								g.drawImage(obrazki[11], 50 + x * w1, 50 + y * w2, w1, w2, applet);
								break;
							case -5://dol
								g.drawImage(obrazki[13], 50 + x * w1, 50 + y * w2, w1, w2, applet);
								break;
								
						

							default:
								break;
						}
					}
					else
					{
						if(m.tablica_wyswietlana[x][y]<128)
						{
							g.setColor(new Color(0,255-m.tablica_wyswietlana[x][y],0));
							g.fillRect(50 + x * w1, 50 + y * w2, w1, w2);
						}
						else
						{
							g.setColor(new Color(255-((m.tablica_wyswietlana[x][y]-128)*2),255-((m.tablica_wyswietlana[x][y]-128)*2),255-((m.tablica_wyswietlana[x][y]-128)*2)));
							g.fillRect(50 + x * w1, 50 + y * w2, w1, w2);	
						}
					}
								
						//////////////////////////////////////////////////		
					}											// kolejnych
																		// kolumnach)
				//g.drawImage(obrazki[m.tablica_wyswietlana[x][y]], 50 + x * w1, 50 + y * w2, w1, w2, applet); // rysowanie
																							// kolorze
				// g.drawImage(img, x, y, width, height, observer)
				}
		if(this.wczytanoMapeArchiwalna==1)
		{
			ma.rysujplan();
			for (int y = 0; y < ma.tablica_wyswietlana.length; y++) { // rysowanie po
				// y
				// (kolejne
				// wiersze)
				for (int x = 0; x < ma.tablica_wyswietlana[0].length; x++) { // rysowanie
									// po x
									// ( po
				////////////////////////////////////////////
				if(ma.tablica_wyswietlana[x][y]<0)
				{
				switch (ma.tablica_wyswietlana[x][y]) {
				case -1://koniec
				g.drawImage(obrazki[14], 500 + x * w1, 50 + y * w2, w1, w2, applet);
				break;
				case -2://gura
				g.drawImage(obrazki[10], 500 + x * w1, 50 + y * w2, w1, w2, applet);
				break;
				case -3://lewo
				g.drawImage(obrazki[12], 500 + x * w1, 50 + y * w2, w1, w2, applet);
				break;
				case -4://prawo
				g.drawImage(obrazki[11], 500 + x * w1, 50 + y * w2, w1, w2, applet);
				break;
				case -5://dol
				g.drawImage(obrazki[13], 500 + x * w1, 50 + y * w2, w1, w2, applet);
				break;
				default:
				break;
				}
				}
				else
				{
				if(ma.tablica_wyswietlana[x][y]<128)
				{
					
				g.setColor(new Color(0,255-ma.tablica_wyswietlana[x][y],0));
				g.fillRect(500 + x * w1, 50 + y * w2, w1, w2);
				}
				else
				{
				g.setColor(new Color(255-((ma.tablica_wyswietlana[x][y]-128)*2),255-((ma.tablica_wyswietlana[x][y]-128)*2),255-((ma.tablica_wyswietlana[x][y]-128)*2)));
				g.fillRect(500 + x * w1, 50 + y * w2, w1, w2);	
				}
				}
				
				//////////////////////////////////////////////////		
				}											// kolejnych
									// kolumnach)
				//g.drawImage(obrazki[m.tablica_wyswietlana[x][y]], 50 + x * w1, 50 + y * w2, w1, w2, applet); // rysowanie
														// kolorze
				// g.drawImage(img, x, y, width, height, observer)
				}
			
		}
			} 
		catch( Exception e) {
			System.out.print(" ");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int l = 0, f = 0, p = 0, t = 0;
		String command;
		switch (e.getKeyChar()) {
		case 'w':
			/// etykieta = new Label("To jest tekst etykiety");
			// add(etykieta);
			zerowanie_sterowania = 0;
			if (m.ruchzSystemem(1, false, false, 0)) // ruch : prosto,lewo,prawo, w tyl
			{
				
				if(wczytanoMapeArchiwalna==1)ma.ruchBezSystemu(1, false, false, 0);
				/*command = Integer.toString(21) + " " + "0"; // 12 oznacza
															// odleglosc okol 10
															// cm
				try {
					sterowanie.sendPacket(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				command = Integer.toString(25) + " " + "0"; // 12 oznacza
															// odleglosc okol 10
															// cm
				try {
					sterowanie.sendPacket(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				zaladujDane();
*/
			}

			break;

		case 's':
			zerowanie_sterowania = 0;
			if (m.ruchzSystemem(0, false, false, 1)) {
				if(wczytanoMapeArchiwalna==1)ma.ruchBezSystemu(0, false, false, 1);
				/*command = Integer.toString(-21) + " " + "0";
				try {
					sterowanie.sendPacket(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 * l=czyt.nextInt(); f=czyt.nextInt(); p=czyt.nextInt();
				 * t=czyt.nextInt();
				 */
			//	zaladujDane();			
				}
			break;

		case 'a':
			zerowanie_sterowania = 0;
			if (m.ruchzSystemem(0, true, false, 0)) {
				if(wczytanoMapeArchiwalna==1)ma.ruchBezSystemu(0, true, false, 0);
				/*command = "0" + " " + Integer.toString(-25);
				try {
					sterowanie.sendPacket(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 * l=czyt.nextInt(); f=czyt.nextInt(); p=czyt.nextInt();
				 * t=czyt.nextInt();
				 
				System.out.println("S " + command);
				zaladujDane();*/
			}
			break;

		case 'd':
			zerowanie_sterowania = 0;
			if (m.ruchzSystemem(0, false, true, 0)) {
				if(wczytanoMapeArchiwalna==1)ma.ruchBezSystemu(0, false, true, 0);
				/*command = "0" + " " + Integer.toString(25);
				try {
					sterowanie.sendPacket(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("S " + command);
				
				 * l=czyt.nextInt(); f=czyt.nextInt(); p=czyt.nextInt();
				 * t=czyt.nextInt();
				 
				zaladujDane();			*/}
			break;

		case 'z':
			zerowanie_sterowania=0;
			//odbior.stop();
			//timer.purge();
			
			System.out.println("Podaj nazwe");
			String nazwa = czyt.nextLine();
			
			try {
				m.zapisz(nazwa);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.print("");
			}
			//init();
			//timer = new Timer();
			//timer.scheduleAtFixedRate(m, 20, 10);
			
			
			//odbior = new Thread(this); // NOWE: watek do odbioru danych, 
			 
			//odbior.start(); //startuje tutaj
			
			break;
		default:

			break;
		}
	}

	private void zaladujDane() {
		int l;
		int f;
		int p;
		int t;
		int port = 7000;
		/*try {
			dsocket = new DatagramSocket(port);
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			
		}
		byte[] buffer = new byte[2048];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			// Wait to receive a datagram
			try {
				dsocket.receive(packet);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				}

			// Convert the contents to a string, and display them
			String msg = new String(buffer, 0, packet.getLength());
			
			String [] tab = msg.split("\n");
			System.out.println(tab[0].substring(0, 4));
			System.out.println(tab[1].substring(0, 4));			
			System.out.println(tab[2].substring(0, 4));
			System.out.println(tab[3].substring(0, 4));

			//			
		  l=(int)Float.parseFloat(tab[0].substring(0, 4)); 
		  f=(int)Float.parseFloat(tab[1].substring(0, 4));
		  p=(int)Float.parseFloat(tab[2].substring(0, 4));
		  t=(int)Float.parseFloat(tab[3].substring(0, 4));
		  System.out.println(msg);*/

		  
		  l=50; 
		  f=50;
		  p=50;
		  t=50;
		m.odswierzCzujniki(l, f, p, t);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//opoznienie w odbieraniu danych z czujnikow - NOWE
		
		try {
			  Thread.sleep(100); //opznienie = 0,1 sekundy - DO USTAWIENIA!!
			} catch (InterruptedException ie) {
			    //Handle exception
			}
			
		this.zaladujDane();
		
		
		String command = "0 0"; 
		if(zerowanie_sterowania==100){ // opoznnienie nadawania=czas na wykonuwanie ruchu - DO USTAWIENIA
		try {
			sterowanie.sendPacket(command);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("S " + command);
		zerowanie_sterowania=0;
		}
		zerowanie_sterowania++;
		run();
	}

	
}