package Podobienstwo;


import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Srodowisko s=new Srodowisko();
		int menu=0;
		Scanner odczyt = new Scanner(System.in);
		String nazwa;
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println(".........................");
			System.out.println("1-Dodaj text");
			System.out.println("2-Dodaj slowo klucz ");
			System.out.println("3-wyczysc slownik");
			System.out.println("4-wyczysc texty ");
			System.out.println("5-wyczysc");
			System.out.println("..........................");
			System.out.println("6-2dice");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("Podaj nazwe tekstu.");
				nazwa=odczyt.next();
				s.wstawtext(nazwa);
				break;
				
			case 2:
				System.out.println("Podaj slowo klucz");
				nazwa=odczyt.next();
				s.wstawslowoklucz(nazwa);
				break;
				
			case 3:
				s.slownik();
				break;
				
			case 4:
				s.terminy();
				s.przeksztalc();
				s.d2();
				//l.szukanie(nazwa);
				break;
				
			case 5:
				//l.wyswietl();
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