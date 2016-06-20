package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Wykres implements Dana {
	private String nazwa;
	private ArrayList<Przedzial> wzory;
	private double odp;

	public Wykres() {
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
		Scanner in = new Scanner(System.in);
		System.out.println(nazwa);
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

	public boolean zapisz(PrintWriter out) {
		out.println("WykresS");
		out.println(nazwa);
		out.println(wzory.size());
		for (Przedzial p : wzory) {
			out.println(p.toString().replace('.', ','));
		}
		out.println("WykresK");
		return true;
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

	public String toString() {
		String ret = "\nWykres " + getnazw() + "\n";
		for (Przedzial p : wzory) {
			ret += p + "\n";
		}
		return ret;
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

	@Override
	public double wynik(Dana d) throws Exception {
		return 0;
	}

	@Override
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

	@Override
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

	@Override
	public Dana odpF() {
		Wykres w = new Wykres();
		System.out.println(nazwa);
		w.setnazw(nazwa);
		Scanner o = new Scanner(System.in);
		w.odp = o.nextDouble();
		return w;
	}

	@Override
	public Dana odpS() {
		Wykres w = new Wykres();
		w.setnazw(nazwa);
		w.wstaw();
		return w;
	}

	public String getinstance() {
		// TODO Auto-generated method stub
		return "W";
	}
}
