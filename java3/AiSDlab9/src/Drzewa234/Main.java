package Drzewa234;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		int menu = 0;
		SrodowiskoDrzew d = new SrodowiskoDrzew();
		Scanner odczyt = new Scanner(System.in);

		do {
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("............Drzewa.234.............");
			System.out.println("1-Wstawianie klucza");
			System.out.println("2-znalezienie wezla o wskazanym kluczu");
			System.out.println("3-wyswietlanie kluczy poziomami");
			System.out.println("4-min");
			System.out.println("5-max");
			System.out.println("6-usuwanie");
			System.out.println("7-wstaw wszystko");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu = odczyt.nextInt();
			String nazwa;
			int klucz;
			switch (menu) {
			case 1:
				System.out.println("1-Wstawianie klucza");
				d.wstaw();
				break;
			case 2:
				System.out.println("2-szukanie ");
				d.szukaj();
				break;
			case 3:
				System.out.println("3-wyswietlanie kluczy poziomami");
				d.wyswietl();
				break;
			case 4:
				System.out.println("4-wyswietlanie kluczy post order");
				d.min();
				break;
			case 5:
				System.out.println("5-wyswietlanie kluczy poziomami");
				d.max();
				break;
			case 6:
				System.out.println("usuwwanie");

				break;
			case 7:
				System.out.println("7-wstaw wiele");
				d.a();
				break;

			default:
				break;
			}

		} while (menu != 0);
	}

}
