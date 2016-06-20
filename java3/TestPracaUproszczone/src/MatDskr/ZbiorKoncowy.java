package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ZbiorKoncowy {

	private String nazwa;
	private String nazwaUniwersum;
	private double[] elementy;
	protected String[] nazwyelementow;
	private int sum;

	//////////////////////////////////////// konstruktory
	public ZbiorKoncowy() {
		clean();
	}

	public void clean() {
		nazwa = null;
		nazwaUniwersum = null;
		elementy = null;
		nazwyelementow = null;

	}

	public ZbiorKoncowy(String nazwa) {
		clean();
		setnazwa(nazwa);
	}

	public ZbiorKoncowy(Universum u, String nazwa) {
		clean();
		nazwaUniwersum = u.getnazwa();
		nazwyelementow = new String[u.nazwyelementow.length];
		for (int i = 0; i < u.nazwyelementow.length; i++) {
			nazwyelementow[i] = u.nazwyelementow[i];
		}
		setnazwa(nazwa);
	}

	public ZbiorKoncowy(Universum u) {
		clean();
		nazwaUniwersum = u.getnazwa();
		nazwa = getnazwa();
		nazwyelementow = new String[u.nazwyelementow.length];
		for (int i = 0; i < u.nazwyelementow.length; i++) {
			nazwyelementow[i] = u.nazwyelementow[i];
		}
	}

	public ZbiorKoncowy(ZbiorKoncowy A) {
		clean();
		setnazwa(A.getnazwa());
		nazwaUniwersum = A.nazwaUniwersum;

		this.nazwyelementow = new String[A.nazwyelementow.length];
		this.elementy = new double[A.nazwyelementow.length];
		for (int i = 0; i < A.nazwyelementow.length; i++) {
			this.nazwyelementow[i] = A.nazwyelementow[i];
			this.elementy[i] = A.elementy[i];
		}

	}

	//////////////////////////////////////// get i set
	public void setnazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getnazwa() {
		return nazwa;
	}

	/////////////////////////// ustawienia
	public void ustawNazwyElementow(String... nazwy)// z tablicy
	{
		nazwyelementow = new String[nazwy.length];
		for (int i = 0; i < nazwy.length; i++) {
			nazwyelementow[i] = nazwy[i];
		}

	}

	public void ustawzakresyIO()//
	{
		sum = 0;
		int tmp[] = new int[nazwyelementow.length * 2];
		for (int i = 0; i < nazwyelementow.length; i++) {
			nazwyelementow[i] += " [" + 0 + "-" + 1 + "]";
			sum += 1;
		}

	}

	public void ustawzakresy(int... zakresy)// z tablicy dolny gorny
	{
		sum = 0;
		for (int i = 0; i < nazwyelementow.length; i++) {
			nazwyelementow[i] += " [" + zakresy[i * 2] + "-" + zakresy[i * 2 + 1] + "]";
			sum += zakresy[i * 2 + 1];
		}

	}

	public void ustawzakresyG(int... zakresyG) {
		sum = 0;
		for (int i = 0; i < nazwyelementow.length; i++) {
			nazwyelementow[i] += " [0-" + zakresyG[i] + "]";
			sum += zakresyG[i];
		}

	}

	public void ustawNazwyElementow()// z palca
	{
		Scanner o = new Scanner(System.in);
		while (getnazwa() == null) {
			System.out.println("Nazwa danej grupy/pytanie glowne");
			setnazwa(o.nextLine());
		}

		System.out.println("podaj wielkosc ");
		int ilosc = o.nextInt();
		nazwyelementow = new String[ilosc];

		for (int i = 0; i < ilosc; i++) {
			System.out.println("podaj nazwe elementu pytania " + i);
			nazwyelementow[i] = o.next();
			System.out.println("Zakres odpowiedzi dolny");
			int d = o.nextInt();
			System.out.println("Zakres odpowiedzi gorny");
			int g = o.nextInt();
			if (g < d) {
				int tmp = g;
				g = d;
				d = tmp;
			}
			sum += g;
			nazwyelementow[i] = nazwyelementow[i] + " [" + d;
			nazwyelementow[i] = nazwyelementow[i] + " " + g + "]";
		}
	}

	public void ustawNazwyElementow(Scanner o, boolean trybNapisowy) {
		while (getnazwa() == null) {
			if (trybNapisowy)
				System.out.println("podaj nazwe");
			setnazwa(o.next());
		}

		if (trybNapisowy)
			System.out.println("podaj wielkosc ");
		int ilosc = o.nextInt();
		nazwyelementow = new String[ilosc];

		for (int i = 0; i < ilosc; i++) {
			if (trybNapisowy)
				System.out.println("podaj nazwe elementu " + i);
			nazwyelementow[i] = o.next();
		}

	}

	public void ustawWartosciElementow(int... wartosci)// z tablicy
	{
		elementy = new double[wartosci.length];
		for (int i = 0; i < wartosci.length; i++) {
			elementy[i] = wartosci[i];
		}

	}

	public void ustawWartosciElementow()// z palca
	{
		Scanner o = new Scanner(System.in);
		System.out.println("Pytanie glowne" + getnazwa());
		elementy = new double[nazwyelementow.length];

		for (int i = 0; i < nazwyelementow.length; i++) {
			System.out.println("podaj wartosc " + nazwyelementow[i]);
			elementy[i] = o.nextInt();
		}

	}

	public void ustawWartosciElementow(Scanner o, boolean trybNapisowy) {
		elementy = new double[nazwyelementow.length];
		for (int i = 0; i < nazwyelementow.length; i++) {
			if (trybNapisowy)
				System.out.println("podaj wartosc elementu " + nazwyelementow[i]);
			elementy[i] = o.nextInt();
		}
	}

	public void wstawelement(String element, int wartosc) {
		for (int i = 0; i < elementy.length; i++) {
			if (nazwyelementow[i].equals(element)) {
				elementy[i] = wartosc;
			}
		}
	}

	public void wstawelement(int element, int wartosc) {
		elementy[element] = wartosc;
	}

	public ZbiorKoncowy copy(ZbiorKoncowy A) {

		return new ZbiorKoncowy(A);

	}

	public boolean wczytaj(Scanner in) throws Exception {
		if (!in.hasNextLine())
			throw new Exception("Nie ma nastepnej lini");
		if (!in.nextLine().equals("ZbiorS"))
			throw new Exception("nie ma znacznika");
		if (!in.next().equals("U"))
			throw new Exception("blad uniwersum");
		nazwaUniwersum = in.next();
		setnazwa(in.next());
		int w = in.nextInt();
		elementy = new double[w];
		nazwyelementow = new String[w];
		for (int i = 0; i < w; i++) {
			nazwyelementow[i] = in.next();
			elementy[i] = in.nextInt();
		}
		if (!in.nextLine().equals("ZbiorK"))
			throw new Exception("nie ma znacznika");
		return true;
	}

	///////////////////////// dzialania
	static boolean sprawdzrozmiar(ZbiorKoncowy A, ZbiorKoncowy B) {
		return A.elementy.length == B.elementy.length;
	}// &&A.nazwaUniwersum.equals(B.nazwaUniwersum);}

	static double suma(ZbiorKoncowy A, ZbiorKoncowy B) throws Exception {
		if (!ZbiorKoncowy.sprawdzrozmiar(A, B))
			throw new Exception("Zly rozmiar");
		double suma = 0;
		for (int i = 0; i < A.elementy.length; i++) {
			if (A.elementy[i] < B.elementy[i]) {
				suma += B.elementy[i];
			} else {
				suma += A.elementy[i];
			}

		}
		return suma;
	}

	static double iloczyn(ZbiorKoncowy A, ZbiorKoncowy B) throws Exception {
		if (!ZbiorKoncowy.sprawdzrozmiar(A, B))
			throw new Exception("Zly rozmiar");
		double iloczyn = 0;
		for (int i = 0; i < A.elementy.length; i++) {
			if (A.elementy[i] < B.elementy[i]) {
				iloczyn += A.elementy[i];
			} else {
				iloczyn += B.elementy[i];
			}

		}
		return iloczyn;
	}

	static ZbiorKoncowy ZbiorAminusB(ZbiorKoncowy A, ZbiorKoncowy B) throws Exception {
		if (!ZbiorKoncowy.sprawdzrozmiar(A, B)) {
			throw new Exception("Zly rozmiar");
		}
		ZbiorKoncowy Z = new ZbiorKoncowy(A);

		Z.setnazwa(A.getnazwa() + "-" + B.getnazwa());
		for (int i = 0; i < A.elementy.length; i++) {
			if ((A.elementy[i] - B.elementy[i]) < 0) {
				Z.elementy[i] = 0;
			} else {
				Z.elementy[i] = A.elementy[i] - B.elementy[i];
			}

		}
		return Z;
	}

	static double AminusB(ZbiorKoncowy A, ZbiorKoncowy B) {
		double roznica = 0;
		for (int i = 0; i < A.elementy.length; i++) {
			if ((A.elementy[i] - B.elementy[i]) < 0) {
				roznica += 0;
			} else {
				roznica += A.elementy[i] - B.elementy[i];
			}

		}
		return roznica;
	}

	static double jacard(ZbiorKoncowy A, ZbiorKoncowy B) throws Exception {

		double p = iloczyn(A, B);
		double q = AminusB(A, B);
		double n = AminusB(B, A);
		return p / (p + q + n);
	}

	static double dice2(ZbiorKoncowy A, ZbiorKoncowy B) throws Exception {
		double p = iloczyn(A, B);
		double q = AminusB(A, B);
		double n = AminusB(B, A);
		return 2 * p / (2 * p + q + n);
	}

	static double sumasymetryczna(ZbiorKoncowy A, ZbiorKoncowy B) throws Exception {

		return suma(ZbiorAminusB(A, B), ZbiorAminusB(B, A));
	}

	public String toString() {
		String ret = "Zbior : " + getnazwa() + "\n{";
		for (int i = 0; i < nazwyelementow.length - 1; i++) {
			ret += nazwyelementow[i] + "|" + elementy[i] + "|, ";
		}
		ret += nazwyelementow[nazwyelementow.length - 1] + "|" + elementy[elementy.length - 1] + "|}\n";

		return ret;
	}

	public void wyswietl() {
		System.out.println();
		System.out.println("Pytanie glowne " + getnazwa());
		for (int i = 0; i < nazwyelementow.length - 1; i++) {
			System.out.println(nazwyelementow[i] + " odp " + elementy[i]);
		}
		System.out.println();
	}

	public double wynik(ZbiorKoncowy firma) throws Exception {

	
			return dice2(this, firma);
		

	}


}
