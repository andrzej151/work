package Strona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.spi.TransactionalWriter;

public class Dysk 
{
	private int[] pamiecfizyczna;
	private int[] podzialnaprocesy;
	private int[] pamieczewnetrzna;
	int iloscbledow;
	private ArrayList<Operacjadyskowa> historia;
	
	
	public Dysk() {
		utworz();
	}
	
	

	private void utworz() {
		Scanner odczyt=new Scanner(System.in);
		int f;
		System.out.println("podaj wielkosc pamieci zewnetrznej ilosc danych");
		f=odczyt.nextInt();
		pamieczewnetrzna=new int[f];
		
		for(int i=0;i<pamieczewnetrzna.length;i++)
		{
			pamieczewnetrzna[i]=1;
			
		}
		
		System.out.println("podaj wielkosc pamieci fizycznej ilosc ramek");
		do{
		f=odczyt.nextInt();
		if(f>=pamieczewnetrzna.length)
		{
			System.out.println("pamiec fizyczna musi byc mniejsza od zew"+pamieczewnetrzna.length);
		}
		}
		while(f>=pamieczewnetrzna.length);
		
		pamiecfizyczna=new int[f];
		iloscbledow=0;
		historia=new ArrayList<>();
	}
	
	public boolean operacjad1(int proces,int ramka,int dane) throws Exception //true jesli blad strony
	{
		if(pamiecfizyczna[ramka]==dane)
		{
			historia.add(new Operacjadyskowa(proces, dane, false));
			return false;
		}
		else
		{
			if(proces==podzialnaprocesy[ramka])
			{
				pamieczewnetrzna[pamiecfizyczna[ramka]]=1;
				pamiecfizyczna[ramka]=dane;
				pamieczewnetrzna[dane]=0;
				historia.add(new Operacjadyskowa(proces, dane, true));
				iloscbledow++;
				return true;
			}
			else
			{
				throw new Exception("proces"+proces+"nie ma dostepu do ramki "+ramka);
			}
		}
	}
	
	public boolean operacjad2(int proces,int ramka,int dane)
	{
		if(pamiecfizyczna[ramka]==dane)
		{
			historia.add(new Operacjadyskowa(proces, dane, false));
			return false;
		}
		else
		{
			
				pamieczewnetrzna[pamiecfizyczna[ramka]]=1;
				pamiecfizyczna[ramka]=dane;
				pamieczewnetrzna[dane]=0;
				historia.add(new Operacjadyskowa(proces, dane, true));
				iloscbledow++;
				return true;
			
		}
	}
	public int operacjad2(int dane) //podaje ramke -1 gdy nie ma
	{
		for(int i =0;i<pamiecfizyczna.length;i++)
		{
		if(pamiecfizyczna[i]==dane)
		{
			return i;
		}
		
		}
		
		return -1;
	}
	
	void wyswietlhistorie()
	{
		System.out.println("\nPelna historia operacji dyskowych");
		for(Operacjadyskowa o:historia)
		{
			System.out.println(o);
		}
		System.out.println("ilosc bledow: "+iloscbledow);
		System.out.println();
	}
	void zapiszhistorie(String n)
	{
		try {
			PrintWriter plik=new PrintWriter(new File(n));
		
			plik.println("\nPelna historia operacji dyskowych");
			for(Operacjadyskowa o:historia)
			{
				plik.println(o);
			}
			plik.println("ilosc bledow: "+iloscbledow);
			
			plik.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	int getiloscpamieci()
	{
		return pamieczewnetrzna.length;
	}
	int getiloscpamiecifizycznej()
	{
		return pamiecfizyczna.length;
	}
	
	void nowypodzialpamiecifizycznej(int ... podzial)
	{
		podzialnaprocesy=new int[podzial.length];
		for(int i=0;i<podzial.length;i++)			
		{podzialnaprocesy[i]=podzial[i];pamiecfizyczna[i]=0;}
		for(int i=0;i<podzial.length;i++)			
		{}
	}
	
	public void wyswielukladramek() {
		System.out.println("ramki ogolnie");
		for(int i=0;i<podzialnaprocesy.length;i++)System.out.print(podzialnaprocesy[i]+"\t");
		System.out.println();
		for(int i=0;i<pamiecfizyczna.length;i++)System.out.print(pamiecfizyczna[i]+"\t");
		System.out.println("\n");
	}
	
	private class Operacjadyskowa
	{
		int proces,zasob;
		boolean blodstrony;
		
		public Operacjadyskowa(int proces,int zasob,boolean blad) {
			this.proces=proces;
			this.zasob=zasob;
			blodstrony=blad;
		}
		@Override
		public String toString() {
			
			return "proces "+proces+" zasob "+zasob+" blad strony "+blodstrony;
		}
	}

	public void zeroj() {
		iloscbledow=0;
		
	}
	
	
}
