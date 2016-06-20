package Towary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Listatowarow {
	
	ArrayIterator lista;
	Towar []t;
	
	private class MniejszaCena implements Predicate
    { 
		double cena;
		public void setCena(double cena)
        {this.cena=cena;}

	public boolean accept(Object ob) {
		// TODO Auto-generated method stub
		return  (((Towar)ob).cena<cena);
	}
    } 


	public void wczytaj() {
		Towar t=new Towar();
		String nazwa;
		Double ilosc;
		Double cena;
		Double wartosc;
		Scanner odczyt=new Scanner(System.in);
		System.out.println("Ile towarow chcesz dodac");
		int n=odczyt.nextInt();
		this.t=new Towar[n];
		
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
			this.t[i]=t;
		}
		lista=new ArrayIterator(this.t);
		
	}

	public void wczytajplik(String n) {
		
		Scanner odczyt;
		String nazwa;
		Double ilosc;
		Double cena;
		Double wartosc;
	
		try {
			odczyt = new Scanner(new File(n));
			int ilo=odczyt.nextInt();
			Towar []t=new Towar[ilo];
			
			
			for(int i=0;i<ilo;i++){
				nazwa=odczyt.next();
				ilosc=odczyt.nextDouble();
				cena=odczyt.nextDouble();
				wartosc=odczyt.nextDouble();
				Towar tow = new Towar(nazwa,ilosc,cena,wartosc);
				t[i]=tow;
			}
			lista=new ArrayIterator(t);
			
		System.out.println("Wczytano");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	public void zmienCene() {
		Scanner odczyt=new Scanner(System.in);
		System.out.println("Podaj nazwe");
		String nazwa=odczyt.next();
		Towar towar = null;
		
		Iterator it = lista;
		it.first();  
		
		while(!it.isDone())
		{ 
			
			if(((Towar)it.current()).nazwa.equals(nazwa))
			{
				System.out.println("podaj nowa cene");
				((Towar)it.current()).cena=odczyt.nextDouble();
			}
			
				it.next();
			
		}
		
			wyswietl();
		
		
	}

	public void wyswietl() {
		Iterator it = lista;
		it.first();  //lub it.last()
		while(!it.isDone())
		{ 
			System.out.println(it.current());
			it.next();  
		}

		
	}

	public void cenaMniejszaNiz(double cena) {
		 MniejszaCena c=new MniejszaCena();
		 c.setCena(cena);
	     Iterator fit= new FilterIterator(lista,c);
	     fit.first();
	     while(!fit.isDone())
	     
	     {Towar t=(Towar)fit.current();
	      System.out.println(t);
	      fit.next();
	     }

		
		
	}

	public Towar[] kopia() {
		
		Iterator it = lista;
		it.first();  
		int i=0;
		Towar []t=null;
		while(!it.isDone())
		{ 
			
			if(((Towar)it.current()).ilosc==0)
			{
				i++;
			}
			
				it.next();
		}
		t=new Towar[i];
		it.first();  
		i=0;
		while(!it.isDone())
		{ 
			
			if(((Towar)it.current()).ilosc==0)
			{
				t[i]=(Towar)it.current();
				System.out.println(t[i]);
				i++;
			}
			
				it.next();
		}
		
		return t;
	}

	public void zapisz(String n)  
	{
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(n);
			zapis.println(lista._current);
			String s;
			Towar t;
			Iterator it = lista;
			it.first();  //lub it.last()
			while(!it.isDone())
			{ 
				t=(Towar)it.current();
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
				it.next();
			}
			zapis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
