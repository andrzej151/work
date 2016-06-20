package Slownik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Listatowarow  {

	Slownik s;
	
	
	
	public Listatowarow()
	{
		s=new Slownik();
	}
	
	
	
	
	
	public void wyswietl() {
		s.wyswietl();
	}

	

	

	public void wczytajplik(String n) throws FileNotFoundException {
//		Towar t=new Towar();
//		Scanner odczyt;
//		String nazwa;
//		Double ilosc;
//		Double cena;
//		String klasa;
//		
//		
//			odczyt = new Scanner(new File(n));
//			int ilo=odczyt.nextInt();
//			lista= new Towar[ilo];
//			for(int i=0;i<ilo;i++){
//
//				nazwa=odczyt.next();
//				ilosc=odczyt.nextDouble();
//				cena=odczyt.nextDouble();
//				klasa=odczyt.next();
//				lista[i]=new Towar(nazwa,ilosc,cena,klasa);
//		}
//		System.out.println("Wczytano");
		
		
	}



	public void QuickPoNazwie() {
//		Comparator comparator=new Compar(1);
//		QuickSort sort=new QuickSort(comparator);
//		sort.sort(lista);
//		wyswietl();
		
	}

	
	public void szukanie(String nazwa) {
		System.out.println(s.szukaj(nazwa));
		
	}

	public void scal() {
		s.scal();
		
	}

	public void sortuj() {
		s.sortuj();
		
	}

	public void wstaw(String nazwa) {
		s.wstaw(nazwa);
		
	}





	public void szukanie2(String nazwa) {
		System.out.println(s.szukaj2(nazwa));

		
	}

	
	
	
}
