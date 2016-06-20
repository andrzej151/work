package Procesory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		Symulacja sym = new Symulacja();
		Scanner odczyt = new Scanner(System.in);

		do {
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("Symulacja");
			System.out.println("1-Rozpocznij");
			System.out.println("2-strategia 1");
			System.out.println("3-strategia 2");
			System.out.println("4-strategia 3");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu = odczyt.nextInt();

			switch (menu) {
			case 1:
				sym.rozpocznij();
				break;

			case 2:
				sym.strategia1();
				break;

			case 3:
				sym.strategia2();
				break;

			case 4:
				sym.strategia3();
				break;

			case 5:

				break;

			default:
				break;
			}

		} while (menu != 0);

	}

}
