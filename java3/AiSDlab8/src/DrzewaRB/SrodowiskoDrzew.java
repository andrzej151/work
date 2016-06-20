package DrzewaRB;

import java.util.Scanner;

public class SrodowiskoDrzew  {

	Drzewo d;
	DrzewoRB drb;
	int klucz;
	
	public SrodowiskoDrzew() {
		d=new Drzewo();
		drb=new DrzewoRB();
	}
	public void wstaw() {
		Scanner o=new Scanner(System.in);
		System.out.println("Co wstawic");
		klucz=o.nextInt();
		drb.insert(klucz);
		
	}

	public void wyswietlINOrder() {
		
		d.wyswietlin();
	}

	public void wyswietlPREOrder() {
		
		d.wyswietlpre();
	}

	public void wyswietlPOSTOrder() {
		d.wyswietlpost();
		
	}

	public void wyswietlPozioami() {
		drb.wyswietlpoziomami();
		
	}

	public void wysokosc() {
		System.out.println("wysokosc "+d.wysokosc());
		
	}

	public void liczbalisci() {
		System.out.println("liczba lisci "+d.liscie());
		
	}

	public void liczbawezlowWEW() {
		System.out.println("liczba wezlow wewnetrznych  "+d.wezlywew());
		
	}

	public void liczbawezlowZEW() {
		System.out.println("liczba wezlow zewnetrznych  "+d.wezlyzewnetrzne());
		
	}

	public void min() {
		System.out.println("min "+d.min());
		
	}

	public void max() {
		System.out.println("max "+d.max());
		
	}



	public void znajdznext() {
		Scanner o=new Scanner(System.in);
		System.out.println("podaj klucz");
		klucz=o.nextInt();
		d.findnext(klucz);
		
	}

	public void znajdzpop() {
		Scanner o=new Scanner(System.in);
		System.out.println("podaj klucz");
		klucz=o.nextInt();
		System.out.println("przed kluczem "+klucz+" jest "+d.findpop(klucz));
	}

	public void usun(int x) {
		d.delete(x);
		
	}

	public void rysuj() {
		d.rysunek();
		
	}
	public void znajdz(int klucz) {
		System.out.println(d.find(klucz));
		
	}
	public void a() {
		drb.insert(20);
		drb.insert(10);
		drb.insert(15);
		drb.insert(18);
		drb.insert(25);
		drb.insert(16);
		drb.insert(12);
	}
	
	
}
