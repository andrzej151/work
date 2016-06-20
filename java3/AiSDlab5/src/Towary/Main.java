package Towary;

import java.io.FileNotFoundException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		int menu=0;
		Listatowarow l=new Listatowarow();
		Scanner odczyt = new Scanner(System.in);
		
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("1-Wprowac liste towarow z klawiatury");
			System.out.println("2-Wprowadz plik tekstowy z lista towarow");
			System.out.println("3-Wyswietl liste towarow");
			System.out.println("...........QuickSort...............");
			System.out.println("4-Po nazwie");
			System.out.println("5-Po cenie");
			System.out.println("6-po klasie nazwie cenie ilosci");
			System.out.println("...........ShakerSort...............");
			System.out.println("7-Po nazwie");
			System.out.println("8-Po cenie");
			System.out.println("9-po klasie nazwie cenie ilosci");
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
				l.wyswietl();
				break;
				
			case 4:
				l.QuickPoNazwie();
				break;
				
			case 5:
				l.QuickPoCenie();
				break;
				
			case 6:
				l.QuickPoKilku();
				break;
				
			case 7:
				l.ShakerPoNazwie();
				break;
			case 8:
				l.ShakerPoCenie();
				break;
			case 9:
				l.ShakerPoKilku();
				break;
			default:
				break;
			}
			
		}while(menu!=0);
	}

}
