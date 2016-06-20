package Towary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Listatowarow  {

	
	public Towar[] lista;
	
	
	public Listatowarow()
	{
		
	}
	
	public void zapisz(String n) 
	{
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(n);
		
		zapis.println(lista.length);
		String s;
		for(Towar t:lista){
			
			zapis.println(t.nazwa);
			s= t.ilosc.toString();
			s=s.replace(".", ",");
			zapis.println(s);
			s=t.cena.toString();
			s=s.replace(".", ",");
			zapis.println(s);
			zapis.println(t.klasa);
		}
		zapis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void wyswietl() {
		System.out.println();
		System.out.println("nazwa \t  ilosc \t cena \t klasa");
		for(Towar t:lista)
		{
			System.out.println(t);
		}
		System.out.println("..............................");
	}

	

	

	public void wczytajplik(String n) throws FileNotFoundException {
		Towar t=new Towar();
		Scanner odczyt;
		String nazwa;
		Double ilosc;
		Double cena;
		String klasa;
		
		
			odczyt = new Scanner(new File(n));
			int ilo=odczyt.nextInt();
			lista= new Towar[ilo];
			for(int i=0;i<ilo;i++){

				nazwa=odczyt.next();
				ilosc=odczyt.nextDouble();
				cena=odczyt.nextDouble();
				klasa=odczyt.next();
				lista[i]=new Towar(nazwa,ilosc,cena,klasa);
		}
		System.out.println("Wczytano");
		
		
	}

	public void wczytaj() {
		// TODO Auto-generated method stub
		Towar t=new Towar();
		String nazwa;
		Double ilosc;
		Double cena;
		String klasa;
		Scanner odczyt=new Scanner(System.in);
		System.out.println("Ile towarow chcesz dodac");
		int n=odczyt.nextInt();
		lista=new Towar[n];
		
		for(int i=0;i<n;i++){
			System.out.println("Podaj nazwe");
			nazwa=odczyt.next();			 
			System.out.println("Podaj ilosc");
			ilosc=odczyt.nextDouble();			 
			System.out.println("Podaj cene");
			cena=odczyt.nextDouble();			 
			System.out.println("Podaj klase");
			klasa=odczyt.next();
			t=new Towar(nazwa,ilosc,cena,klasa);
			lista[i]=t;
		}
		System.out.println("Podaj nazwe gdzie zapiac");
		nazwa=odczyt.next();
		wyswietl();
		zapisz(nazwa);
		
	}
	




	public void QuickPoNazwie() {
		Comparator comparator=new Compar(1);
		QuickSort sort=new QuickSort(comparator);
		sort.sort(lista);
		wyswietl();
		
	}

	public void QuickPoCenie() {
		Comparator comparator=new Compar(2);
		QuickSort sort=new QuickSort(comparator);
		sort.sort(lista);
		wyswietl();
		
	}

	public void QuickPoKilku() {
		Comparator comparator=new Compar(3);
		QuickSort sort=new QuickSort(comparator);
		sort.sort(lista);
		wyswietl();
		
	}

	public void ShakerPoNazwie() {
		Comparator comparator=new Compar(1);
		ShakerSort sort=new ShakerSort(comparator);
		sort.sort(lista);
		wyswietl();
		
	}

	public void ShakerPoCenie() {
		Comparator comparator=new Compar(2);
		ShakerSort sort=new ShakerSort(comparator);
		sort.sort(lista);
		wyswietl();
		
	}

	public void ShakerPoKilku() {
		Comparator comparator=new Compar(3);
		ShakerSort sort=new ShakerSort(comparator);
		sort.sort(lista);
		wyswietl();
		
	}

	
	
	
}
