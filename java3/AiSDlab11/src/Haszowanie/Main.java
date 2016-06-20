package Haszowanie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		int menu=0;
		Hasz h=new Hasz();
		Scanner odczyt = new Scanner(System.in);
		
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("............Haszowanie liniowe.............");
			System.out.println("1-Wstawianie klucza");
			System.out.println("2-usun klucz");
			System.out.println("3-size");
			System.out.println("4-szukaj");
			System.out.println("5-resize");
			System.out.println("6-dump");
			System.out.println("7-wyswietl");
			System.out.println("............Haszowanie kwadratowe.............");
			System.out.println("1-Wstawianie klucza");
			System.out.println("2-usun klucz");
			System.out.println("3-size");
			System.out.println("4-szukaj");
			System.out.println("5-resize");
			System.out.println("6-dump");
			System.out.println("7-wyswietl");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			String nazwa;
			int klucz;
			switch (menu) {
			case 1:
				System.out.println("1-Wstawianie klucza");
				nazwa=odczyt.next();
				
				System.out.println(nazwa.hashCode());
				h.wstawl(nazwa.hashCode());
				break;
//			case 2:
//				System.out.println("2-wyswietlanie kluczy in order ");
//				d.wyswietlINOrder();
//				break;
			case 3:
				System.out.println("3-wyswietlanie kluczy poziomami");
				//d.wyswietl();
				break;
//			case 4:
//				System.out.println("4-wyswietlanie kluczy post order");
//				d.wyswietlPOSTOrder();
//				break;
//			case 5:
//				System.out.println("5-wyswietlanie kluczy poziomami");
//				d.wyswietlPozioami();
//				break;
//			case 6:
//				System.out.println("6-wysokosc");
//				d.wysokosc();
//				break;
//			case 7:
//				System.out.println("7-liczba lisci");
//				d.liczbalisci();
//				break;
//			case 8:
//				System.out.println("8-liczba wezlow wew");
//				d.liczbawezlowWEW();
//				break;
//			case 9:
//				System.out.println("9-liczba wezlow zew");
//				d.liczbawezlowZEW();
//				break;
//			case 10:
//				System.out.println("10-element min");
//				d.min();
//				break;
//			case 11:
//				System.out.println("11-element max");
//				d.max();
//				break;
//			case 12:
//				System.out.println("12-wyszukiwanie wskazanego klucza");
//				System.out.println("podaj klucz");
//				klucz=odczyt.nextInt();
//				d.znajdz(klucz);
//				break;
//			case 13:	
//				System.out.println("13-znalezienie nastepnika wskazaego wezla");
//				d.znajdznext();
//				break;
//			case 14:
//				System.out.println("14-znalezienie poprzednika wskazaego wezla");
//				d.znajdzpop();
//				break;
//			case 15:
//				System.out.println("15-usuniecie wskazaego wezla");
//				System.out.println("podaj klucz");
//				klucz=odczyt.nextInt();
//				d.usun(klucz);
//				break;
//			case 16:
//				System.out.println("16-narysowanie drzewa w trybie znakowym");
//				d.rysuj();
//				break;
			case 7:
				System.out.println("16-narysowanie drzewa w trybie znakowym");
				//d.a();
				break;
			
			default:
				break;
			}
			
		}while(menu!=0);
	}

}
