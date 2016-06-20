package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Pytanie {
	protected String nazwa;
	protected Wykres wynagrodzenie;
	protected Zbior benefity;
	protected Wykres srednia_wieku;
	protected Zbior umiejetnosci;
	protected Wykres czaspracy;
	protected int[] priorytet;
	public String[] nazwy = { "wynagrodzenie:", "pakiet socialny", "srednia wieku", "umiejetnosci", "czas pracy" };

	public Pytanie() {
		clean();
	}

	public void clean() {

		wynagrodzenie = new Wykres("Wynagrodzenie");
		Universum Ubenefity = new Universum("Pakiet_Socialny");
		Ubenefity.ustawNazwyElementow("Multisport", "Opieka_medyczna", "Doplaty_do_posilkow", "sluzowy_samochud",
				"Sluzbowe_wyjazdy");
		benefity = new Zbior(Ubenefity, "Pakiet_Socialny");
		benefity.ustawzakresyIO();
		czaspracy = new Wykres("Sredni_czas_pracy");
		srednia_wieku = new Wykres("Srednia_wieku");
		Universum Uumiejetnosci = new Universum("Umiejetnosci");
		Uumiejetnosci.ustawNazwyElementow("Komunikacyjne", "Praca_w_zespole", "Radzenie_ze_stresem",
				"Analityczne_myslenie", "Praca_monotonna", "zdolnosci_programistyczne");
		umiejetnosci = new Zbior(Uumiejetnosci, "Umiejetnosci");
		umiejetnosci.ustawzakresyG(10, 10, 10, 10, 10, 10);
		priorytet = new int[5];
		for (int i = 0; i < priorytet.length; i++) {
			priorytet[i] = 1;
		}
	}
	/*
	 * wynik[0] suma wynikow reszta wyników
	 */

	public void priorytet() {
		try {

			int menu = 0;
			do {
				System.out.println("do czego chcesz dodac priorytet");
				System.out.println("1-wynagrodzenie");
				System.out.println("2-Pakiet socialny");
				System.out.println("3-srednia wieku");
				System.out.println("4-umiejetnosci");
				System.out.println("5-czas pracy");
				System.out.println("0-zakoncz");
				Scanner in = new Scanner(System.in);
				menu = in.nextInt();
				if (menu != 0) {
					System.out.println("wartosc");
					priorytet[menu - 1] = in.nextInt();
				}
			} while (menu != 0);
		} catch (Exception e) {
			System.out.println("blad");
			priorytet();
		}

	}

	public void zapisz(DataOutputStream out) throws IOException {
		out.writeUTF(nazwa);
		wynagrodzenie.zapisz(out);
		benefity.zapisz(out);
		srednia_wieku.zapisz(out);
		umiejetnosci.zapisz(out);
		czaspracy.zapisz(out);
		out.writeInt(priorytet.length);
		for (int i = 0; i < priorytet.length; i++) {
			out.writeInt(priorytet[i]);

		}

	}

	public void wczytaj(DataInputStream in) throws Exception {
		clean();
		nazwa = in.readUTF();
		wynagrodzenie.wczytaj(in);
		benefity.wczytaj(in);
		srednia_wieku.wczytaj(in);
		umiejetnosci.wczytaj(in);
		czaspracy.wczytaj(in);
		int w = in.readInt();
		priorytet = new int[w];
		for (int i = 0; i < w; i++) {
			priorytet[i] = in.readInt();
		}

	}

}
