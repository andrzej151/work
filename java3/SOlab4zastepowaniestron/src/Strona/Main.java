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
			System.out.println("1-Rozpocznij");
			System.out.println("2-podzial rowny");
			System.out.println("3-podzial proporcjonalny");
			System.out.println("4-z badaniem czestotliwosci");
			System.out.println("5- model strefowy");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
				sym.rozpocznij();
				break;
				
			case 2:
				sym.podzialrowny();
				break;
				
			case 3:
				sym.podzialproporcjonalny();
				break;
				
			case 4:
				sym.czestotliwosc();
				break;
				
			case 5:
				sym.podzialstrefowy();
				break;
				
		
			default:
				break;
			}
			
		}while(menu!=0);
		
	}

}
