package Dysk;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu=0;
		Symulacja sym=new Symulacja();
		Scanner odczyt = new Scanner(System.in);
		String nazwa;

		
		do
		{
			System.out.println();
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("Symulacja");
			System.out.println("1-Wprowac kolejke procesow z klawiatury");
			System.out.println("2-Wprowadz plik tekstowy z danymi symulacji");
			System.out.println("3-wylosuj dane do symulacji");
			System.out.println("4-Zapis do pliku");
			System.out.println("5-Wyswietl liste");
			System.out.println("..........................");
			System.out.println("Algorytmy");
			System.out.println("6-Algorytm  FCFS");
			System.out.println("7-Algorytm SSTF");
			System.out.println("8-Algorytm SCAN");
			System.out.println("9-Algorytm C-SCAN");
			System.out.println("10-Algorytm EDF");
			System.out.println("11-Algorytm FD-SCAN");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			System.out.println();
			
			switch (menu) {
			case 1:
				sym.WprowacDaneRecznie();
				break;
				
			case 2:
				System.out.println("Podaj nazwe");
				 nazwa=odczyt.next();
				sym.WprowacPlik(nazwa);
				break;
				
			case 3:
				sym.los();
				break;
				
			case 4:
				System.out.println("Podaj nazwe");
				 nazwa=odczyt.next();
				sym.Zapisz(nazwa);;
				break;
				
			case 5:
				sym.Wyswietl();
				break;
				
			case 6:
				System.out.println("Algorytm FCFS");
				sym.FCFS();
				break;
				
			case 7:
				System.out.println("Algorytm SSTF");
				//sym.SJFzWywlaszczeniem();
				break;
				
			case 8:
				System.out.println("Algorytm SCAN");
				//sym.SJFbezWywlaszczenia();
				break;
				
			case 9:
				System.out.println("Algorytm C-SCAN");
				
				//int n=odczyt.nextInt();
			//	sym.rotacyjny(n);
				break;
				
			case 10:
				System.out.println("Algorytm EDF");
				//sym.SJFbezWywlaszczenia();
				break;
				
			case 11:
				System.out.println("Algorytm FD-SCAN");
				//sym.SJFbezWywlaszczenia();
				break;
		
			default:
				break;
			}
			
		}while(menu!=0);
		
	}

}