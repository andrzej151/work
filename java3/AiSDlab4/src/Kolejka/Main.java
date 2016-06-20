package Kolejka;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		int menu=0;
		Lista l=new Lista();
		
		Scanner odczyt = new Scanner(System.in);
	 
		do
		{
			
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........KOLEJKA................");
			System.out.println("1-wstaw do kolejki");
			System.out.println("2-pobierz z kolejki");
			System.out.println("3-usuñ wszystkie elementy");
			System.out.println("4-d³ugoœæ kolejki ");
			System.out.println("5-Czy pusta");
			System.out.println("6-wyswietl");
			System.out.println("..........STOS LISTA................");
			System.out.println("7-od³ó¿ na stos");
			System.out.println("8-pobierz ze stosu");
			System.out.println("9-odczytaj ( nieniszcz¹co ) ze stosu");
			System.out.println("10-czyœæ stos");
			System.out.println("11-wysokoœæ stosu");
			System.out.println("12-true jeœli stos jest pusty");
			System.out.println("13-wyswietl");
			System.out.println("..........STOS TABLICA................");
			System.out.println("14-od³ó¿ na stos");
			System.out.println("15-pobierz ze stosu");
			System.out.println("16-odczytaj ( nieniszcz¹co ) ze stosu");
			System.out.println("17-czyœæ stos");
			System.out.println("18-wysokoœæ stosu");
			System.out.println("19-true jeœli stos jest pusty");
			System.out.println("20-wyswietl");
			System.out.println("21-Nowa wielkosc stosu");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
				case 1:
			
					System.out.println("1-wstaw do kolejki");
					l.pusch1();
					break;
			
				case 2:
				
					System.out.println("2-pobierz z kolejki");
					l.pop2();
					break;
				
				case 3:
					
					System.out.println("3-Usuñ wszystkie elementy");
					l.clear3();
					break;
					
				case 4:
					
					System.out.println("4-Usuñ pierwsze wyst¹pienie wskazanej wartoœci ");
					l.size4();
					break;
				
				case 5:
					
					System.out.println("5-czu pusta");
					l.empty5();
					break;
				
				case 6:
					
					System.out.println("6-wyswietl");
					l.wyswietl6();
					break;
					
				case 7:
					System.out.println("7-od³ó¿ na stos");
				
					l.pusch7();
					break;
					
				case 8:
					
					System.out.println("8-pobierz ze stosu");
					l.pop8();
					
					
					break;
					
				case 9:
					
				System.out.println("9-odczytaj ( nieniszcz¹co ) ze stosu");
					l.perk9();
					
					break;
					
				case 10:

					System.out.println("10-czyœæ stos");
					l.clear10();
					
					break;
					
				case 11:

					System.out.println("11-wysokoœæ stosu");
					l.size11();
					
					break;
					
				case 12:
					
					System.out.println("12-true jeœli stos jest pusty");
					l.pusty12();
					break;
					
				case 13:
					System.out.println("13-wyswietl");
					l.wyswietl13();
					
					break;	
				case 14:
					System.out.println("14-od³ó¿ na stos");
					l.pusch14();
					
					break;
					
				case 15:
					
					System.out.println("15-pobierz ze stosu");
					l.pop15();
					
					
					break;
					
				case 16:
					
				System.out.println("16-odczytaj ( nieniszcz¹co ) ze stosu");
					l.perk16();
					
					break;
					
				case 17:

					System.out.println("17-czyœæ stos");
					l.clear17();
					
					break;
					
				case 18:

					System.out.println("18-wysokoœæ stosu");
					l.size18();
					
					break;
					
				case 19:
					
					System.out.println("19-true jeœli stos jest pusty");
					l.empty19();
					break;
					
				case 20:
					
					System.out.println("20-wyswietl1");
					l.wyswietl20();
					break;
					
				case 21:
					
					System.out.println("21-nowa wielkosc stosu");
					l.nowa21();
					break;
				default:
					break;
			}
			
		}while(menu!=0);
	}

}
