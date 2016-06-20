package Strona;

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
			System.out.println("1-Wprowac liste odwolan z klawiatury");
			System.out.println("2-Wprowadz plik tekstowy z danymi symulacji");
			System.out.println("3-wylosuj dane do symulacji");
			System.out.println("4-Zapis do pliku");
			System.out.println("5-Wyswietl");
			System.out.println("..........................");
			System.out.println("Algorytmy");
			System.out.println("6-Algorytm FIFO");
			System.out.println("7-Algorytm OPT");
			System.out.println("8-Algorytm LRU");
			System.out.println("9-Algorytm Drugiej Szansy");
			System.out.println("10-Algorytm RAND");
			System.out.println("11-Automat");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
				sym.wprowadzRecznie();
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
				System.out.println("Algorytm FIFO");
				sym.FIFO();
				break;
				
			case 7:
				System.out.println("Algorytm OPT");
				sym.OPT();
				break;
				
			case 8:
				System.out.println("Algorytm LRU");
				sym.LRU();
				break;
				
			case 9:
				System.out.println("Algorytm Drugiej szansy");
				sym.LRUDS();
				break;
				
			case 10:
				System.out.println("Algorytm RAND");
				sym.RAND();
				break;
			case 11:
				System.out.println("Automat");
				sym.los();
				System.out.println(".............FIFO.................");
				sym.FIFO();
				System.out.println(".............OPT..................");
				sym.OPT();
				System.out.println("..............LRU.................");
				sym.LRU();
				System.out.println(".........Alg drug szansy............");
				sym.LRUDS();
				System.out.println("..............Rand1.................");
				sym.RAND();
				System.out.println("..............Rand2.................");
				sym.RAND();
				System.out.println("..............Rand3.................");
				sym.RAND();
				break;
		
			default:
				break;
			}
			
		}while(menu!=0);
		
	}

}
