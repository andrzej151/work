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
			System.out.println("1-Dodaj na wskazan� pozycj�");
			System.out.println("2-Dodaj na koniec");
			System.out.println("3-Usu� element ze wskazanej pozycji");
			System.out.println("4-Usu� pierwsze wyst�pienie wskazanej warto�ci ");
			System.out.println("5-Usu� wszystkie elementy");
			System.out.println("6-Zmie� element na wskazanej pozycji");
			System.out.println("7-Wyswietl");
			System.out.println("8-daj warto�� wskazanego elementu");
			System.out.println("9-Znajd� pozycj� podanej warto�ci -1 gdy nie ma");
			System.out.println("10-Czy dana warto�� wyst�puje na li�cie");
			System.out.println("11-Liczba element�w na li�cie");
			System.out.println("12-Czy pusta lista");
			System.out.println("13-wyswietl iteratorem");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			
			switch (menu) {
				case 1:
			
					System.out.println("1-Dodaj na wskazan� pozycj�");
					l.insert();
					break;
			
				case 2:
				
					System.out.println("2-Dodaj na koniec");
					l.add();
					break;
				
				case 3:
					
					System.out.println("3-Usu� element ze wskazanej pozycji");
					l.deleteIndex();
					break;
					
				case 4:
					
					System.out.println("4-Usu� pierwsze wyst�pienie wskazanej warto�ci ");
					l.deleteObj();
					break;
				
				case 5:
					
					System.out.println("5-Usu� wszystkie elementy");
					l.clear();
					break;
				
				case 6:
					
					System.out.println("6-Zmie� element na wskazanej pozycji");
					l.zmien();
					break;
					
				case 7:
					
					System.out.println("7-Wyswietl");
					l.wyswietl();
					break;
					
				case 8:
					
					System.out.println("8-daj warto�� wskazanego elementu");
					l.pobierz();
					break;
					
				case 9:
					
					System.out.println("9-Znajd� pozycj� podanej warto�ci -1 gdy nie ma");
					l.znajdzIndex();
					break;
					
				case 10:

					System.out.println("10-Czy dana warto�� wyst�puje na li�cie");
					l.czyjest();
					break;
					
				case 11:

					System.out.println("11-Liczba element�w na li�cie");
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
