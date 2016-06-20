package Procesy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu=0;
		Symulacja sym=new Symulacja();
		Scanner odczyt = new Scanner(System.in);
		
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("Symulacja");
			System.out.println("1-Wprowac liste procesow z klawiatury");
			System.out.println("2-Wprowadz plik tekstowy z danymi symulacji");
			System.out.println("3-wylosuj dane do symulacji");
			System.out.println("4-Zapis do pliku");
			System.out.println("5-Wyswietl liste procesow");
			System.out.println("..........................");
			System.out.println("Algorytmy");
			System.out.println("6-Algorytm FCFS");
			System.out.println("7-Algorytm SJF z wywlaszczeniem");
			System.out.println("8-Algorytm SJF bez wywlaszczenia");
			System.out.println("9-Algorytm Rotacyjny");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
				sym.wprowadzProcesyRecznie();
				break;
				
			case 2:
				sym.wczytajplik();
				break;
				
			case 3:
				sym.los();
				break;
				
			case 4:
				sym.zapis();
				break;
				
			case 5:
				sym.wyswietl();
				break;
				
			case 6:
				System.out.println("Algorytm FCFS");
				sym.FCFS();
				break;
				
			case 7:
				System.out.println("Algorytm SJF z wywlaszczeniem");
				sym.SJFzWywlaszczeniem();
				break;
				
			case 8:
				System.out.println("Algorytm SJF bez wywlaszczenia");
				sym.SJFbezWywlaszczenia();
				break;
				
			case 9:
				System.out.println("Algorytm Rotacyjny");
				System.out.println("Podaj kawant danych");
				int n=odczyt.nextInt();
				sym.rotacyjny(n);
				break;
		
			default:
				break;
			}
			
		}while(menu!=0);
		
	}

}
