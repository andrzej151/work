package Towary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Listatowarow  {

	public ArrayList<Towar> lista;
	
	
	
	public Listatowarow()
	{
		lista=new ArrayList<Towar>();
	}
	
	public void zapisz(String n) throws FileNotFoundException
	{
		PrintWriter zapis = new PrintWriter(n);
		zapis.println(lista.size());
		String s;
		for(Towar t:lista){
			
			zapis.println(t.nazwa);
			s= t.ilosc.toString();
			s=s.replace(".", ",");
			zapis.println(s);
			s=t.cena.toString();
			s=s.replace(".", ",");
			zapis.println(s);
			s=t.wartosc.toString();
			s=s.replace(".", ",");
			zapis.println(s);
		}
		zapis.close();
		
	}
	
	
	
	public void wyswietl() {
		System.out.println();
		System.out.println("nazwa \t ilosc \t cena \t wartosc");
		for(Towar t:lista)
		{
			System.out.println(t);
		}
		System.out.println("..............................");
	}

	

	public void suma() {
		double suma=0;
		
        
		for(Towar t:lista)
		{
			t.wartosc=t.cena*t.ilosc;
			suma+=t.wartosc;
		}
		wyswietl();
		
		NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        
		System.out.println("Suma wszstkic towarow to: "+ nf.format(suma));
	}

	public void obliczWartosc() {
		for(Towar t:lista)
		{
			t.wartosc=t.cena*t.ilosc;
		}
		wyswietl();
		
	}

	public void zmienCene() {
		Scanner odczyt=new Scanner(System.in);
		System.out.println("Podaj nazwe");
		String nazwa=odczyt.next();
		int index=-1;
		Towar towar = null;
		
		for(Towar t:lista)
		{
			
			if(t.nazwa.equals(nazwa))
			{
				index=lista.indexOf(t);
				towar=t;
			}
		}
		if(index==-1)
		{
			System.out.println("nie ma takiego towaru");
		}
		else
		{
			System.out.println("podaj nowa cene");
			double cena=odczyt.nextDouble();
			towar.cena=cena;
			lista.set(index, towar);
			
			wyswietl();
		}
		
		
	}

	public void wczytajplik(String n) throws FileNotFoundException {
		Towar t=new Towar();
		Scanner odczyt;
		String nazwa;
		Double ilosc;
		Double cena;
		Double wartosc;
		
		
			odczyt = new Scanner(new File(n));
			int ilo=odczyt.nextInt();
			
			lista=new ArrayList<Towar>(ilo);
			
			for(int i=0;i<ilo;i++){
				nazwa=odczyt.next();
				ilosc=odczyt.nextDouble();
				cena=odczyt.nextDouble();
				wartosc=odczyt.nextDouble();
				t=new Towar(nazwa,ilosc,cena,wartosc);
				lista.add(t);
		}
		System.out.println("Wczytano");
		
		
	}

	public void wczytaj() {
		// TODO Auto-generated method stub
		Towar t=new Towar();
		String nazwa;
		Double ilosc;
		Double cena;
		Double wartosc;
		Scanner odczyt=new Scanner(System.in);
		System.out.println("Ile towarow chcesz dodac");
		int n=odczyt.nextInt();
		lista=new ArrayList<Towar>(n);
		
		for(int i=0;i<n;i++){
			System.out.println("Podaj nazwe");
			nazwa=odczyt.next();			 
			System.out.println("Podaj ilosc");
			ilosc=odczyt.nextDouble();			 
			System.out.println("Podaj cene");
			cena=odczyt.nextDouble();			 
			System.out.println("Podaj wartosc");
			wartosc=odczyt.nextDouble();
			t=new Towar(nazwa,ilosc,cena,wartosc);
			lista.add(t);
	}
		
		
	}
	
	
}
