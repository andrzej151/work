package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Srodowisko {
	private int stan;
	/*
	 * 0-po wlaczeniu proramu pytanie student pracodawca wczytaj 1-po wczytaniu
	 * pytan pytanie student pracodawca wczytaj zapisz 2-po wczytaniu studenta i
	 * pytan pytanie student pracodawca wczytaj zapisz 3-po wczytaniu firmy i
	 * pytan pytanie student pracodawca wczytaj zapisz 4-po wczytaniu
	 * wszystkiego pytanie student pracodawca wczytaj zapisz wynik
	 */
	private Pytania pytania;
	private ArrayList<Student> student;
	private ArrayList<Firma> firma;

	public Srodowisko() {
		clean();
	}

	public boolean clean() {
		stan = 0;

		if (pytania != null)
			pytania.clean();
		if (student != null)
			student.clear();
		if (firma != null)
			firma.clear();
		pytania = new Pytania();
		student = new ArrayList<>();
		firma = new ArrayList<>();
		return true;
	}

	public void menu() {
		Scanner odczyt = new Scanner(System.in);
		int opcja = 0;
		do {
			Main.clearConsole();
			System.out.println("\nWitaj co chcesz zrobic");
			System.out.println("1 - Wczytaj");
			if (stan != 0)
				System.out.println("2 - Zapisz");
			System.out.println("3 - Wyczysc");
			System.out.println("4 - Info");
			System.out.println("....................");
			System.out.println("5 - Pytania");
			if (stan != 0)
				System.out.println("6 - Student");
			if (stan != 0)
				System.out.println("7 - Firma");
			if (stan == 5)
				System.out.println("8 - wynik");
			System.out.println("9 - Wyswietl");
			System.out.println("...................");
			System.out.println("0 - Koniec");
			opcja = odczyt.nextInt();
			switch (opcja) {
			case 1:
				System.out.println("Wczytaj");
				System.out.println("Podaj nazwe pliku");
				String n = odczyt.next();
				System.out.println(wczytaj(n) ? "Wczytano" : "Blad");
				break;

			case 2:
				if (stan != 0) {
					System.out.println("Zapisz");
					System.out.println("Podaj nazwe pliku");
					String na = odczyt.next();
					System.out.println(zapisz(na) ? "Zapisano" : "Blad");
				}
				break;

			case 3:
				System.out.println("Wyczysc");
				System.out.println(clean() ? "Wyczyszczono" : "Blad");
				break;

			case 4:
				System.out.println("Info");
				System.out.println(info());
				break;
			case 5:
				System.out.println("Pytania");
				pytania = new Pytania();
				stan = pytania.menu();
				break;

			case 6:
				if (stan != 0) {
					do {
						System.out.println("Student");
						System.out.println("1-odopwiedz");
						System.out.println("0-cofnij");
						opcja = odczyt.nextInt();
						switch (opcja) {
						case 1:
							Student stud = new Student();
							if (stud.odpowiedz(pytania)) {
								if (student == null) {
									student = new ArrayList<>();
								}
								student.add(stud);
								if (stan == 3) {
									stan = 4;
								} else {
									stan = 2;
								}
							} else {
								System.out.println("B³ad");
							}
							break;

						default:
							break;
						}
					} while (opcja != 0);
					opcja = 6;
				} else {
					System.out.println("Dodaj pytania");
				}
				break;

			case 7:
				if (stan != 0) {
					do {
						System.out.println("Firma");
						System.out.println("1-odopwiedz");
						System.out.println("0-cofnij");
						opcja = odczyt.nextInt();
						switch (opcja) {
						case 1:
							Firma firm = new Firma();
							if (firm.odpowiedz(pytania)) {
								if (firma == null) {
									firma = new ArrayList<>();
								}
								firma.add(firm);
								if (stan == 2) {
									stan = 4;
								} else {
									stan = 3;
								}
							} else {
								System.out.println("B³ad");
							}
							break;

						default:
							break;
						}
					} while (opcja != 0);
					opcja = 7;
				} else {
					System.out.println("Dodaj pytania");
				}
				break;

			case 8:
				if (stan == 4) {
					System.out.println("Wynik");
					wynik();
				} else {
					System.out.println("Musisz miec Pytania odp firm i studentow");
				}
				break;

			case 9:
				wyswietl();
				break;
			default:
				break;
			}

		} while (opcja != 0);

	}

	private void wynik() {
		// TODO Auto-generated method stub

	}

	private char[] info() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean zapisz(String nazwa) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(nazwa)));
			pytania.zapisz(out);
			out.writeInt(student.size());
			if (student != null && student.size() > 0) {
				for (Student s : student) {
					s.zapisz(out);
				}
			}
			out.writeInt(firma.size());
			if (firma != null && firma.size() > 0) {
				for (Firma f : firma) {
					f.zapisz(out);
				}
			}
			out.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return true;
	}

	public boolean wczytaj(String n) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(new File(n)));
			clean();
			if (pytania.wczytaj(in))
				stan = 1;
			 int w=in.readInt();
			 System.out.println(w);
			 for (int i = 0; i < w; i++) {
			 Student s=new Student();
			 s.wczytaj(in);
			 student.add(s);
			 }
			 w=in.readInt();
			 System.out.println(w);
			 for (int i = 0; i < w; i++) {
			 Firma f=new Firma();
			 f.wczytaj(in);
			 firma.add(f);
			 }
			in.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return true;

	}

	public void wyswietl() {
		System.out.println();
		System.out.println("Stan" + stan);
		System.out.println("Pytania");
		pytania.wyswietl();
		System.out.println("Student");
		student.get(0).wyswietl();
		System.out.println("Firma");
	}

}
