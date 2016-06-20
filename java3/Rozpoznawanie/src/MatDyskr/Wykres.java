package MatDyskr;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Wykres extends JFrame {
	private String nazwa = "test pyt";
	private ArrayList<Przedzial> wzory;
	private double odp;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void rysuj() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					narysuj();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	private void narysuj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel tytul = new JLabel(nazwa);
		tytul.setBounds(70, 10, 100, 20);
		contentPane.add(tytul);

		// textField = new JTextField();
		// textField.setBounds(80, 96, 116, 22);
		// contentPane.add(textField);
		// textField.setColumns(10);

	}

	/**
	 * Create the frame.
	 */
	public Wykres() {
		super();
		clean();
	}

	public Wykres(String nazwa) {
		clean();
		setnazw(nazwa);
	}

	public void pytanie() {
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj nazwe pytanie");
		setnazw(in.next());

	}

	public void setpojedynczaodp(double o) {
		odp = o;
	}

	public double getpojedynczaodp() {
		return odp;
	}

	public void wstaw() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println(nazwa + "\n1-dowolny wzor\n2-wzor liniowy");
			int d = in.nextInt();
			if (d == 1) {
				System.out.println("Ile przedzialow");
				int w = in.nextInt();
				for (int i = 0; i < w; i++) {
					System.out.println("podaj WZOR x,X to argumenty mozesz wykozystac funkcje js");
					String n = in.next();
					System.out.println("podaj poczatek przedzialu");
					int s = in.nextInt();
					System.out.println("podaj koniec przedzialu");
					int k = in.nextInt();
					wstaw(s, k, n);
				}
			} else {
				wstawlinowo();
			}

		} catch (Exception e) {
			System.out.println("blad jeszcze raz " + e.getMessage());
			clean();
			wstaw();
		}

	}

	public void wstawlinowo() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Ile przedzialow");
			int w = in.nextInt();
			for (int i = 0; i < w; i++) {
				System.out.println("podaj poczatek przedzialu");
				int s = in.nextInt();
				System.out.println("podaj koniec przedzialu");
				int k = in.nextInt();
				if (k < s) {
					int tmp = k;
					k = s;
					s = tmp;
				}

				System.out.println("1-rosnaco");
				System.out.println("2-malejaco");
				System.out.println("3-stale");
				int m = in.nextInt();

				String n;
				switch (m) {
				case 1:
					n = "1/" + (k - s + 1) + "*x-" + (s / (k - s));
					break;
				case 2:
					n = "1-1/" + (k - s + 1) + "*x+" + (s / (k - s));
					break;
				case 3:
					System.out.println("wartosc");
					double war = in.nextDouble();
					n = "" + war;
					break;
				default:
					n = "0";
					break;
				}
				wstaw(s, k, n);
			}
		} catch (Exception e) {
			System.out.println("blad jeszcze raz " + e.getMessage());
			clean();
			wstaw();
		}
	}

	public void wstaw(double x1, double x2, String wzor) {
		wzory.add(new Przedzial(wzor, x1, x2));
	}

	public void setnazw(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getnazw() {
		return nazwa;
	}

	public void clean() {
		wzory = new ArrayList<>();

	}

	public double oblicz(double x) throws Exception {
		for (Przedzial p : wzory) {
			if (p.czyjestwprzedziale(x)) {
				return p.oblicz(x);
			}
		}
		throw new Exception("brak zakresu");
	}

	public double wynik(Wykres firma) throws Exception {
		double wynik = oblicz(firma.getpojedynczaodp());
		return wynik < 0 ? 0 : wynik > 1 ? 1 : wynik;
	}

	public boolean wczytaj(Scanner in) throws Exception {
		if (!in.hasNextLine())
			throw new Exception("Nie ma nastepnej lini");
		if (!in.nextLine().equals("WykresS"))
			throw new Exception("nie ma znacznika");
		clean();
		setnazw(in.next());
		String wzor;
		int w = in.nextInt();
		double x1, x2;
		for (int i = 0; i < w; i++) {

			x1 = in.nextDouble();
			x2 = in.nextDouble();

			wzor = in.next();
			System.out.println(wzor);
			wstaw(x1, x2, wzor);

		}
		in.nextLine();
		if (!in.nextLine().equals("WykresK"))
			throw new Exception("nie ma znacznika");
		return true;
	}

	private class Przedzial {
		String wzor;
		double xs, xk;

		public Przedzial(String wzor, double x1, double x2) {
			this.wzor = wzor;
			if (x1 < x2) {
				xs = x1;
				xk = x2;
			} else {
				xs = x2;
				xk = x1;
			}
		}

		public boolean czyjestwprzedziale(double x) {
			return x >= xs && x <= xk;
		}

		public double oblicz(double x) throws Exception {
			if (!czyjestwprzedziale(x))
				throw new Exception(x + "  nie nalezy do przedzialu");
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			String foo = wzor.replaceAll("X", String.valueOf(x));
			foo = foo.replaceAll("x", String.valueOf(x));

			return Double.valueOf(String.valueOf(engine.eval(foo)));

		}

		public String toString() {
			return +xs + " " + xk + " " + wzor;
		}
	}

	public boolean zapisz(DataOutputStream out) throws IOException {
		out.writeUTF("<W>");
		out.writeUTF(nazwa);
		out.writeDouble(odp);
		out.writeInt(wzory.size());
		for (Przedzial p : wzory) {
			out.writeDouble(p.xs);
			out.writeDouble(p.xk);
			out.writeUTF(p.wzor);
		}
		out.writeUTF("<EW>");
		return true;
	}

	public boolean wczytaj(DataInputStream in) throws Exception {

		if (!in.readUTF().equals("<W>"))
			throw new Exception("zly znacznik  S");
		clean();
		nazwa = in.readUTF();
		odp = in.readDouble();
		int w = in.readInt();
		for (int i = 0; i < w; i++) {
			Double x = in.readDouble();
			Double y = in.readDouble();
			String s = in.readUTF();
			wstaw(x, y, s);
		}
		if (!in.readUTF().equals("<EW>"))
			throw new Exception("zly znacznik K");
		return true;
	}

	public void odpF() {

		System.out.println(nazwa);
		Scanner o = new Scanner(System.in);
		odp = o.nextDouble();

	}

	public void odpS() {
		// rysuj();
		wstaw();

	}

	public String getinstance() {
		// TODO Auto-generated method stub
		return "W";
	}

	public void wyswietl() {
		System.out.println(nazwa);

		for (Przedzial p : wzory) {
			System.out.println(p);
		}
		System.out.println("Odpowiedz firmy " + odp);

	}
}
