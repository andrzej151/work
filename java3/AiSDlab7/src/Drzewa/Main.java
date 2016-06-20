package Drzewa;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		int menu=0;
		SrodowiskoDrzew d=new SrodowiskoDrzew();
		Scanner odczyt = new Scanner(System.in);
		
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("............Drzewa..............");
			System.out.println("1-Wstawianie klucza");
			System.out.println("2-wyswietlanie kluczy in order ");
			System.out.println("3-wyswietlanie kluczy pre order");
			System.out.println("4-wyswietlanie kluczy post order");
			System.out.println("5-wyswietlanie kluczy poziomami");
			System.out.println("6-wysokosc");
			System.out.println("7-liczba lisci");
			System.out.println("8-liczba wezlow wew");
			System.out.println("9-liczba wezlow zew");
			System.out.println("10-element min");
			System.out.println("11-element max");
			System.out.println("12-wyszukiwanie wskazanego klucza");
			System.out.println("..........................");
			System.out.println("13-znalezienie nastepnika wskazaego wezla");
			System.out.println("14-znalezienie poprzednika wskazaego wezla");
			System.out.println("15-usuniecie wskazaego wezla");
			System.out.println("16-narysowanie drzewa w trybie znakowym");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			String nazwa;
			int klucz;
			switch (menu) {
			case 1:
				System.out.println("1-Wstawianie klucza");
				d.wstaw();
				break;
			case 2:
				System.out.println("2-wyswietlanie kluczy in order ");
				d.wyswietlINOrder();
				break;
			case 3:
				System.out.println("3-wyswietlanie kluczy pre order");
				d.wyswietlPREOrder();
				break;
			case 4:
				System.out.println("4-wyswietlanie kluczy post order");
				d.wyswietlPOSTOrder();
				break;
			case 5:
				System.out.println("5-wyswietlanie kluczy poziomami");
				d.wyswietlPozioami();
				break;
			case 6:
				System.out.println("6-wysokosc");
				d.wysokosc();
				break;
			case 7:
				System.out.println("7-liczba lisci");
				d.liczbalisci();
				break;
			case 8:
				System.out.println("8-liczba wezlow wew");
				d.liczbawezlowWEW();
				break;
			case 9:
				System.out.println("9-liczba wezlow zew");
				d.liczbawezlowZEW();
				break;
			case 10:
				System.out.println("10-element min");
				d.min();
				break;
			case 11:
				System.out.println("11-element max");
				d.max();
				break;
			case 12:
				System.out.println("12-wyszukiwanie wskazanego klucza");
				System.out.println("podaj klucz");
				klucz=odczyt.nextInt();
				d.znajdz(klucz);
				break;
			case 13:	
				System.out.println("13-znalezienie nastepnika wskazaego wezla");
				d.znajdznext();
				break;
			case 14:
				System.out.println("14-znalezienie poprzednika wskazaego wezla");
				d.znajdzpop();
				break;
			case 15:
				System.out.println("15-usuniecie wskazaego wezla");
				System.out.println("podaj klucz");
				klucz=odczyt.nextInt();
				d.usun(klucz);
				break;
			case 16:
				System.out.println("16-narysowanie drzewa w trybie znakowym");
				d.rysuj();
				break;
			case 17:
				System.out.println("16-narysowanie drzewa w trybie znakowym");
				d.a();
				break;
			
			default:
				break;
			}
			
		}while(menu!=0);
	}

}
