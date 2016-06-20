package Towary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int menu=0;
		Listatowarow l=new Listatowarow();
		Scanner odczyt = new Scanner(System.in);
		
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("1-Wprowac liste towarow z klawiatury");
			System.out.println("2-Wprowadz plik tekstowy z lista towarow");
			System.out.println("3-zmiana ceny wskazanego towaru");
			System.out.println("4-Wyswietl towary o cenie mniejszej niz");
			System.out.println("5-Wyswietl liste towarow");
			System.out.println("6-Skopiowanie do nowej tablicy towary dla których ilosc = 0 ");
			System.out.println("7-Zapis do pliku");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
				l.wczytaj();
				break;
				
			case 2:
				System.out.println("Podaj nazwe");
				String na=odczyt.next();
				l.wczytajplik(na);
				break;
				
			case 3:
				l.zmienCene();
				break;
				
			case 4:
				System.out.println("Podaj cene");
				double cena=odczyt.nextDouble();
				l.cenaMniejszaNiz(cena);
				break;
				
			case 5:
				l.wyswietl();
				break;
				
			case 6:
				l.kopia();
				break;
				
			case 7:
				System.out.println("Podaj nazwe");
				String n=odczyt.next();
				l.zapisz(n);
				break;
	
		
			default:
				break;
			}
			
		}while(menu!=0);
	}

}
