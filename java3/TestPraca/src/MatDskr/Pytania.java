package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pytania {
	private ArrayList<Dana> pyt;

	public Pytania() {
		clean();
	}

	public void clean() {
		if (pyt != null) {
			pyt.clear();
		}
		pyt = new ArrayList<>();

	}

	public int menu() {
		int opcja = 0;
		Scanner odczyt = new Scanner(System.in);

		do {
			System.out.println("1-nowe pytanie");
			System.out.println("2-usun pytanie");
			System.out.println("3-Wyswietl pytania");
			System.out.println("4-Usun wszystko");
			System.out.println("0-cofnij");
			opcja = odczyt.nextInt();
			switch (opcja) {
			case 1:
				System.out.println("1-Zbior IO");
				System.out.println("2-Zbor rozmyty");
				System.out.println("3-Zbior priorytety");
				opcja = odczyt.nextInt();
				switch (opcja) {
				case 1:
					createZbior("I");
					break;
				case 2:
					createZbiorRozmyty();
					break;
				case 3:
					createZbior("P");
					break;

				default:
					break;
				}
				opcja = 1;

				break;

			case 2:
				wyswietl();
				opcja = odczyt.nextInt();
				pyt.remove(opcja);
				opcja = 2;
				break;

			case 3:
				wyswietl();
				break;
			case 4:
				clean();
				break;
			default:
				break;
			}
		} while (opcja != 0);

		if (pyt == null || pyt.size() == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public void wyswietl() {
		int i = 0;
		System.out.println();
		for (Dana d : pyt) {
			System.out.println("Pytanie - " + i);
			System.out.println(d);
			i++;
		}
		System.out.println();
	}

	private void createZbiorRozmyty() {
		if (pyt == null) {
			pyt = new ArrayList<>();
		}
		Wykres w = new Wykres();
		w.pytanie();
		pyt.add(w);

	}

	private void createZbior(String decyzja) {
		if (pyt == null) {
			pyt = new ArrayList<>();
		}

		Universum u = new Universum();
		u.ustawNazwyElementow();
		pyt.add(u);
	}

	public int size() {

		return pyt.size();
	}

	public void zapisz(DataOutputStream out) throws IOException {
		out.writeInt(pyt.size());
		for (Dana pytanie : pyt) {
			out.writeUTF(pytanie.getinstance());
			pytanie.zapisz(out);
		}
	}

	public boolean wczytaj(DataInputStream in) throws Exception {
		clean();
		int w = in.readInt();
		for (int i = 0; i < w; i++) {
			String s = in.readUTF();
			if (s.equals("U")) {
				Universum u = new Universum();
				u.wczytaj(in);
				pyt.add(u);
			}
			if (s.equals("W")) {
				Wykres wy = new Wykres();
				wy.wczytaj(in);
				pyt.add(wy);
			}
		}
		return true;
	}

	public Dana zadaj(int i) {
		return pyt.get(i);
	}
}
