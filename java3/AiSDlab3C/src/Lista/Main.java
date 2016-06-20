package Lista;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		int menu=0;
		Lista l=new Lista();
		
		Scanner odczyt = new Scanner(System.in);
	 
		do
		{
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("1-Dodaj na wskazan¹ pozycjê");
			System.out.println("2-Dodaj na koniec");
			System.out.println("3-Usuñ element ze wskazanej pozycji");
			System.out.println("4-Usuñ pierwsze wyst¹pienie wskazanej wartoœci ");
			System.out.println("5-Usuñ wszystkie elementy");
			System.out.println("6-Zmieñ element na wskazanej pozycji");
			System.out.println("7-Wyswietl");
			System.out.println("8-daj wartoœæ wskazanego elementu");
			System.out.println("9-ZnajdŸ pozycjê podanej wartoœci -1 gdy nie ma");
			System.out.println("10-Czy dana wartoœæ wystêpuje na liœcie");
			System.out.println("11-Liczba elementów na liœcie");
			System.out.println("12-Czy pusta lista");
			System.out.println("13-wyswietl iteratorem");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
				case 1:
			
					System.out.println("1-Dodaj na wskazan¹ pozycjê");
					l.insert();
					break;
			
				case 2:
				
					System.out.println("2-Dodaj na koniec");
					l.add();
					break;
				
				case 3:
					
					System.out.println("3-Usuñ element ze wskazanej pozycji");
					l.deleteIndex();
					break;
					
				case 4:
					
					System.out.println("4-Usuñ pierwsze wyst¹pienie wskazanej wartoœci ");
					l.deleteObj();
					break;
				
				case 5:
					
					System.out.println("5-Usuñ wszystkie elementy");
					l.clear();
					break;
				
				case 6:
					
					System.out.println("6-Zmieñ element na wskazanej pozycji");
					l.zmien();
					break;
					
				case 7:
					
					System.out.println("7-Wyswietl");
					l.wyswietl();
					break;
					
				case 8:
					
					System.out.println("8-daj wartoœæ wskazanego elementu");
					l.pobierz();
					break;
					
				case 9:
					
					System.out.println("9-ZnajdŸ pozycjê podanej wartoœci -1 gdy nie ma");
					l.znajdzIndex();
					break;
					
				case 10:

					System.out.println("10-Czy dana wartoœæ wystêpuje na liœcie");
					l.czyjest();
					break;
					
				case 11:

					System.out.println("11-Liczba elementów na liœcie");
					l.rozmiar();
					break;
					
				case 12:
					
					System.out.println("12-Czy pusta lista");
					l.empty();
					break;
					
				case 13:
					l.wyswietlI();
					break;
					
				default:
					break;
			}
			
		}while(menu!=0);
	}

}
