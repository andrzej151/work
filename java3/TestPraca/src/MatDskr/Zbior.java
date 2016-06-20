package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zbior implements Dana {

	private String nazwa;
	private String nazwaUniwersum;
	private int[] elementy;
	protected String[] nazwyelementow;

	//////////////////////////////////////// konstruktory
	public Zbior() {
		clean();
	}

	public void clean() {
		nazwa = null;
		nazwaUniwersum = null;
		elementy = null;
		nazwyelementow = null;

	}

	public Zbior(String nazwa) {
		clean();
		setnazwa(nazwa);
	}

	public Zbior(Universum u, String nazwa) {
		setnazwa(nazwa);
		nazwaUniwersum = u.getnazwa();
		nazwyelementow = new String[u.nazwyelementow.length];
		for (int i = 0; i < u.nazwyelementow.length; i++) {
			nazwyelementow[i] = u.nazwyelementow[i];
		}
	}
	public Zbior(Universum u) {
		nazwaUniwersum = u.getnazwa();
		nazwyelementow = new String[u.nazwyelementow.length];
		for (int i = 0; i < u.nazwyelementow.length; i++) {
			nazwyelementow[i] = u.nazwyelementow[i];
		}
	}

	public Zbior(Zbior A) {

		setnazwa(A.getnazwa());
		nazwaUniwersum = A.nazwaUniwersum;

		this.nazwyelementow = new String[A.nazwyelementow.length];
		this.elementy = new int[A.nazwyelementow.length];
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
			nazwyelementow[i] = nazwyelementow[i]+" ["+o.nextInt();
			System.out.println("Zakres odpowiedzi gorny");
			nazwyelementow[i] = nazwyelementow[i]+" "+o.nextInt()+"]";
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
		elementy = new int[wartosci.length];
		for (int i = 0; i < wartosci.length; i++) {
			elementy[i] = wartosci[i];
		}

	}

	public void ustawWartosciElementow()// z palca
	{
		Scanner o = new Scanner(System.in);
		System.out.println("Pytanie glowne"+getnazwa());
		elementy = new int[nazwyelementow.length];
		
		for (int i = 0; i < nazwyelementow.length; i++) {
			System.out.println("podaj wartosc " + nazwyelementow[i]);
			elementy[i] = o.nextInt();
		}
		
	}

	public void ustawWartosciElementow(Scanner o, boolean trybNapisowy) {
		elementy = new int[nazwyelementow.length];
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

	public Zbior copy(Zbior A) {

		return new Zbior(A);

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
		elementy = new int[w];
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
	static boolean sprawdzrozmiar(Zbior A, Zbior B) {
		return A.elementy.length == B.elementy.length;
	}// &&A.nazwaUniwersum.equals(B.nazwaUniwersum);}

	static double suma(Zbior A, Zbior B) throws Exception {
		if (!Zbior.sprawdzrozmiar(A, B))
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

	static double iloczyn(Zbior A, Zbior B) throws Exception {
		if (!Zbior.sprawdzrozmiar(A, B))
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

	static Zbior ZbiorAminusB(Zbior A, Zbior B) throws Exception {
		if (!Zbior.sprawdzrozmiar(A, B)) {
			throw new Exception("Zly rozmiar");
		}
		Zbior Z = new Zbior(A);

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
	

	static double AminusB(Zbior A, Zbior B) {
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

	static double jacard(Zbior A, Zbior B) throws Exception {

		double p = iloczyn(A, B);
		double q = AminusB(A, B);
		double n = AminusB(B, A);
		return p / (p + q + n);
	}

	static double dice2(Zbior A, Zbior B) throws Exception {
		double p = iloczyn(A, B);
		double q = AminusB(A, B);
		double n = AminusB(B, A);
		return 2 * p / (2 * p + q + n);
	}

	static double sumasymetryczna(Zbior A, Zbior B) throws Exception {

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
	
	public void wyswietl()
	{
		System.out.println();
		System.out.println("Pytanie glowne "+getnazwa());
		for (int i = 0; i < nazwyelementow.length - 1; i++) {
			System.out.println(nazwyelementow[i] +" odp "+elementy[i]);
		}
		System.out.println();
	}

	@Override
	public double wynik(Dana A) throws Exception {
		Zbior B=(Zbior)A;
		int i=0;
		while(i<B.elementy.length&&B.elementy[i]<=1)
		{i++;}
		if(i<B.elementy.length)
		{
			return sumasymetryczna(this, B);
		}
		else
		{
			return dice2(this, B);
		}
		
	}

	@Override
	public boolean zapisz(DataOutputStream out) throws IOException {
		out.writeUTF("<Z>");
		out.writeUTF(getnazwa());
		out.writeUTF(nazwaUniwersum);
		out.writeInt(elementy.length);
		for (int i = 0; i < elementy.length; i++) {
			out.writeUTF(nazwyelementow[i]);
			out.writeInt(elementy[i]);
		}
		out.writeUTF("<KZ>");
		return true;
	}

	@Override
	public boolean wczytaj(DataInputStream in) throws IOException, Exception {
		if (!in.readUTF().equals("<Z>"))
			throw new Exception("zly znacznik");
		clean();
		setnazwa(in.readUTF());
		nazwaUniwersum = (in.readUTF());
		int w = in.readInt();
		elementy = new int[w];
		nazwyelementow = new String[w];
		for (int i = 0; i < w; i++) {
			nazwyelementow[i] = in.readUTF();
			elementy[i] = in.readInt();
		}
		if (!in.readUTF().equals("<KZ>"))
			throw new Exception("zly znacznik");
		return true;
	}

	@Override
	public Dana odpF() {
		Zbior z=new Zbior(this);
		z.ustawWartosciElementow();
		return z;
	}

	@Override
	public Dana odpS() {
		Zbior z=new Zbior((Universum)this);
		z.ustawWartosciElementow();
		return z;

	}

	

	public String getinstance() {
		// TODO Auto-generated method stub
		return "Z";
	}

}
