package Zbiory;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		int menu=0;
		Obliczeniowe o=new Obliczeniowe();
		
		Scanner odczyt = new Scanner(System.in);
	 
		do
		{
			o.wyswietl();
			System.out.println("Witaj co chcesz zrobic?");
			
			System.out.println("1-Zdefiniuj UNIWERSUM");
			System.out.println("2-dodaj ZBIOR");
			System.out.println("3-dodaj PROFIL");
			System.out.println("4-Jacard ");
			System.out.println("5-Dice2");
			System.out.println("6-suma sym");
//			System.out.println("..........STOS LISTA................");
//			System.out.println("7-od�� na stos");
//			System.out.println("8-pobierz ze stosu");
//			System.out.println("9-odczytaj ( nieniszcz�co ) ze stosu");
//			System.out.println("10-czy�� stos");
//			System.out.println("11-wysoko�� stosu");
//			System.out.println("12-true je�li stos jest pusty");
//			System.out.println("13-wyswietl");
//			System.out.println("..........STOS TABLICA................");
//			System.out.println("14-od�� na stos");
//			System.out.println("15-pobierz ze stosu");
//			System.out.println("16-odczytaj ( nieniszcz�co ) ze stosu");
//			System.out.println("17-czy�� stos");
//			System.out.println("18-wysoko�� stosu");
//			System.out.println("19-true je�li stos jest pusty");
//			System.out.println("20-wyswietl");
//			System.out.println("21-Nowa wielkosc stosu");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
				case 1:
			
					System.out.println("1-uniwersum");
					o.ZdefiniujUniwersum();
					break;
			
				case 2:
				
					System.out.println("2-Zbiory");
					o.Zdefiniujzbiory();
					break;
				
				case 3:
					
					System.out.println("3-Profile");
					o.ZdefiniujProfile();
					break;
					
				case 4:
					
					System.out.println("4-jacard ");
					o.jacard();
					break;
				
				case 5:
					
					System.out.println("5-dice2");
					o.dice2();
					
					break;
				
				case 6:
					
					System.out.println("6-sumasym");
					o.sumsym();
					
					break;
					
				case 7:
					System.out.println("7-od�� na stos");
				
					
					break;
					
				case 8:
					
					System.out.println("8-pobierz ze stosu");
				
					
					
					break;
					
				case 9:
					
				System.out.println("9-odczytaj ( nieniszcz�co ) ze stosu");
				
					
					break;
					
				case 10:

					System.out.println("10-czy�� stos");
					
					
					break;
					
				case 11:

					System.out.println("11-wysoko�� stosu");
					
					
					break;
					
				case 12:
					
					System.out.println("12-true je�li stos jest pusty");
					
					break;
					
				case 13:
					System.out.println("13-wyswietl");
					
					
					break;	
				case 14:
					System.out.println("14-od�� na stos");
					
					
					break;
					
				case 15:
					
					System.out.println("15-pobierz ze stosu");
					
					
					
					break;
					
				case 16:
					
				System.out.println("16-odczytaj ( nieniszcz�co ) ze stosu");
					
					
					break;
					
				case 17:

					System.out.println("17-czy�� stos");
					
					
					break;
					
				case 18:

					System.out.println("18-wysoko�� stosu");
					
					
					break;
					
				case 19:
					
					System.out.println("19-true je�li stos jest pusty");
					
					break;
					
				case 20:
					
					System.out.println("20-wyswietl1");
					
					break;
					
				case 21:
					
					System.out.println("21-nowa wielkosc stosu");
					
					break;
				default:
					break;
			}
			
		}while(menu!=0);
	}

}
