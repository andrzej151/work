package Slownik;

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
			System.out.println("............Slownik..............");
			System.out.println("1-Wstawianie");
			System.out.println("2-Sortowanie Isert");
			System.out.println("3-Scalanie");
			System.out.println("4-szukanie");
			System.out.println("5-wyswietl");
			System.out.println("6-szukanie2");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			String nazwa;
			switch (menu) {
			case 1:
				System.out.println("Co wstawic");
				nazwa=odczyt.next();
				l.wstaw(nazwa);
				break;
				
			case 2:
				l.sortuj();
				break;
				
			case 3:
				l.scal();
				break;
				
			case 4:
				System.out.println("Co znalesc");
				nazwa=odczyt.next();
				l.szukanie(nazwa);
				break;
				
			case 5:
				l.wyswietl();
				break;
				
			case 6:
				System.out.println("Co znalesc");
				nazwa=odczyt.next();
				l.szukanie2(nazwa);
				break;
				
//			case 6:
//				l.QuickPoKilku();
//				break;
//				
//			case 7:
//				l.ShakerPoNazwie();
//				break;
//			case 8:
//				l.ShakerPoCenie();
//				break;
//			case 9:
//				l.ShakerPoKilku();
//				break;
			default:
				break;
			}
			
		}while(menu!=0);
	}

}
