package Kolejka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner odczyt=new Scanner(System.in);
		
		int wielkosc,liczba, menu=0;
		Queue koll = new LinkedList<>();
		koll.clear();
		
		
		System.out.println("Podaj wielkosæ kolejki");
		wielkosc=odczyt.nextInt();
		Kolejka k=new Kolejka(wielkosc);
		
		do{
			System.out.println("1. Dodaj element");
			System.out.println("2. Usun element");
			System.out.println("3. Wyswietl kolejke");
			System.out.println("4. Usun wszystko");
			System.out.println("5. Dodaj element na kolejke stl");
			System.out.println("6. Usun element z kolejki stl");
			System.out.println("7. Wyswietl ostatni element kolejki stl");
			System.out.println("8. Usun wszystko z kolejki stl");
			System.out.println("0. Koniec");
			
			menu=odczyt.nextInt();
			
			switch (menu) {
			case 1:
			{
				System.out.println("podaj liczbe");
				liczba=odczyt.nextInt();
				k.push(liczba);
			}
				break;
				
			case 2:
			{
				k.pop();
			}
				break;
				
			case 3:
			{
				k.wyswietl();
			}
				break;
				
			case 4:
			{
				k.delete();
			}
				break;
				
			case 5:
			{
				System.out.println("podaj liczbe");
				liczba=odczyt.nextInt();
				koll.offer(liczba);
			}
				break;
				
			case 6:
			{
				System.out.println("Usunieto element "+koll.poll());
			}
				break;
				
			case 7:
			{
				System.out.println(koll.peek());
				
			}
				break;
				
			case 8:
			{
				koll.clear();
				System.out.println("Wyczyszczono");
				
			}
				break;

			default:
				break;
			}
			
		}while (menu!=0);
	}
}