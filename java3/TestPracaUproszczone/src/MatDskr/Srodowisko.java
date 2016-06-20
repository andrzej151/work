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
	 * 0-po wlaczeniu proramu pytanie student pracodawca wczytaj 2-po wczytaniu
	 * studenta i pytan pytanie student pracodawca wczytaj zapisz 3-po wczytaniu
	 * firmy i pytan pytanie student pracodawca wczytaj zapisz 4-po wczytaniu
	 * wszystkiego pytanie student pracodawca wczytaj zapisz wynik
	 */
	private ArrayList<Student> student;
	private ArrayList<Firma> firma;

	public Srodowisko() {
		clean();
	}

	public boolean clean() {
		stan = 0;
		if (student != null)
			student.clear();
		if (firma != null)
			firma.clear();
		student = new ArrayList<>();
		firma = new ArrayList<>();
		return true;
	}

	public void menu() {
		Scanner odczyt = new Scanner(System.in);
		int opcja = 0;
		do {
			System.out.println("\nWitaj co chcesz zrobic");
			System.out.println("1 - Wczytaj");
			if (stan != 0)
				System.out.println("2 - Zapisz");
			System.out.println("3 - Wyczysc");
			System.out.println("4 - Info");
			System.out.println("....................");
			System.out.println("6 - Student");
			System.out.println("7 - Firma");
			if (stan == 4)
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

			case 6:
				do {
					System.out.println("Student");
					System.out.println("1-odopwiedz");
					System.out.println("0-cofnij");
					opcja = odczyt.nextInt();
					switch (opcja) {
					case 1:
						Student stud = new Student();
						if (stud.odpowiedz()) {
							if (student == null) {
								student = new ArrayList<>();
							}
							student.add(stud);
							if (stan != 4) {
								if (stan == 3) {
									stan = 4;
								} else {
									stan = 2;
								}
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

				break;

			case 7:
				do {
					System.out.println("Firma");
					System.out.println("1-odopwiedz");
					System.out.println("0-cofnij");
					opcja = odczyt.nextInt();
					switch (opcja) {
					case 1:
						Firma firm = new Firma();
						if (firm.odpowiedz()) {
							if (firma == null) {
								firma = new ArrayList<>();
							}
							firma.add(firm);
							if (stan != 4) {
								if (stan == 2) {
									stan = 4;
								} else {
									stan = 3;
								}
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

				break;

			case 8:
				if (stan == 4) {
					System.out.println("Wynik");
					wynik();
				} else {
					System.out.println("Musisz miec odpowiedzi firm i studentow");
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

	public void wynik() {
		double wyniki[];

		for (Firma f : firma) {
			for (Student s : student) {
				wyniki = s.wyniki(f);
				System.out.println("\nFirma " + f.nazwa + " Student " + s.nazwa);
				System.out.printf("Wynik ogolny %0$#5.2f \n", wyniki[0]);
				System.out.println("\nWynik szczegolny");
				for (int i = 1; i < wyniki.length; i++) {
					System.out.print(s.nazwy[i - 1] + "\t");
					System.out.printf("%0$#5.2f \n", wyniki[i]);
				}
				System.out.println();
			}
		}

	}

	private char[] info() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean zapisz(String nazwa) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(nazwa)));
			out.writeUTF("PYT3");
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
			if (!in.readUTF().equals("PYT3"))
				throw new Exception("Zly numer magiczny");
			clean();
			int w = in.readInt();
			if (w > 0) {
				if (stan == 3) {
					stan = 4;
				} else {
					stan = 2;
				}
			}
			for (int i = 0; i < w; i++) {
				Student s = new Student();
				s.wczytaj(in);
				student.add(s);
			}
			w = in.readInt();
			if (w > 0) {
				if (stan == 2) {
					stan = 4;
				} else {
					stan = 3;
				}
			}
			for (int i = 0; i < w; i++) {
				Firma f = new Firma();
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
		System.out.println(".........................");
		System.out.println("Student");
		for (Student s : student) {
			System.out.println("____________________________");
			s.wyswietl();
		}
		System.out.println(".........................");
		System.out.println("Firma");
		for (Firma f : firma) {
			System.out.println("_______________________");
			f.wyswietl();
		}
		System.out.println(".........................");
		System.out.println();
	}

}
