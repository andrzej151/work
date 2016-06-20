package Procesory;

import java.util.ArrayList;
import java.util.Random;

public class Procesory {

	private int nazwa;
	private Proces[] aktualneprocesy;
	private int wypelnienie;
	private ArrayList<Proces> archiwum;
	private int[] przeciarzenia;
	private int w;
	private int ilosczapytan;

	public Procesory(int n) {
		nazwa = n;
		restart();

	}

	void restart() {
		aktualneprocesy = new Proces[200];
		archiwum = new ArrayList<Proces>();
		wypelnienie = 0;
		przeciarzenia = new int[200];
		w = 0;
		ilosczapytan = 0;
	}

	public boolean przyjmijproces(Proces p) {
		Proces proc = new Proces(p);
		aktualneprocesy[wypelnienie] = proc;
		wypelnienie++;
		return true;
	}

	public int aktualneprzeciarzenie() {
		int przciarzenie = 0;
		for (int i = 0; i < wypelnienie; i++) {
			if (aktualneprocesy[i].getCzaspozostania() > 0) {
				przciarzenie += aktualneprocesy[i].getObciarzenie();
			}
		}
		ilosczapytan++;
		return przciarzenie;
	}

	private int aktualneprzeciarzenieW() {
		int przciarzenie = 0;
		for (int i = 0; i < wypelnienie; i++) {
			if (aktualneprocesy[i].getCzaspozostania() > 0) {
				przciarzenie += aktualneprocesy[i].getObciarzenie();
			}
		}

		return przciarzenie;
	}

	boolean wykonaj() {
		boolean lampka = false;
		for (int j = 0; j < wypelnienie; j++) {

			if (aktualneprocesy[j].getCzaspozostania() > 0) {
				lampka = true;
				System.out.println("Wykonuje " + aktualneprocesy[j]);
				if (aktualneprocesy[j].wykonaj()) {
					archiwum.add(aktualneprocesy[j]);

				}
			}

		}
		przeciarzenia[w] = aktualneprzeciarzenieW();
		w++;
		return lampka;
	}

	void wyswietlkolejkearchiwum() {
		for (Proces p : archiwum) {

			System.out.println(p);
		}
	}

	public double przeciarzenia() {
		int suma = 0;
		for (int i = 0; i < w; i++) {
			suma += przeciarzenia[i];
		}
		double srednia = suma / w;
		System.out.println("procesor " + nazwa + "\nsrednia " + srednia);
		double s = 0;
		for (int i = 0; i < w; i++) {
			s += Math.pow((przeciarzenia[i] - srednia), 2);
		}
		s = s / w;

		System.out.println("odchylenie " + Math.sqrt(s));
		return srednia;
	}

	public int iloscprzeniesien() {
		int ilo = 0;
		for (Proces p : archiwum) {
			ilo += p.getIloscprzeniesien();
		}
		return ilo;
	}

	public int ilosczapytan() {
		return ilosczapytan;
	}

	public String getnazwa() {
		// TODO Auto-generated method stub
		return nazwa + " ";
	}

	public Proces oddaj() {

		for (int i = 0; i < wypelnienie; i++) {
			if (aktualneprocesy[i].getCzaspozostania() > 0) {
				return aktualneprocesy[i];
			}
		}
		System.out.println(" BLAD ");
		return null;
	}

}
