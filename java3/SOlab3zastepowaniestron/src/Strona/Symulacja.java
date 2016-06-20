package Strona;

import java.util.Random;
import java.util.Scanner;

public class Symulacja {
	
	private Odwolania[] lista_danych;
	private Odwolania[] lista_odwolan ;// dane do symulacji pamiec wirtualna
	private Odwolania[][] pamiec_fizyczna;
	private Odwolania[][] pamiec_zewnetrzna;
	private int wirtualna;
	private int fizyczna;
	private int zewetrzna;
	private int zewnetrzna;
	private int los;
	private int chwila;
	private int bledy_Strony;
	
	public Symulacja() {
		// TODO Auto-generated constructor stub
	}


	public void wprowadzRecznie() {
		// TODO Auto-generated method stub
		
	}

	public void wczytajplik() {
		// TODO Auto-generated method stub
		
	}

	public void los() {
		Scanner odczyt=new Scanner(System.in);
		System.out.println("podaj wielkoœc pamiei wirtualnej (ilosc odwolan)");
		wirtualna=odczyt.nextInt();
		System.out.println("jak wielki ci¹g wylosowaæ (ilosc ramek)");
		los=odczyt.nextInt();
		System.out.println("podaj wielkoœc pamiei fiycznej (ilosc ramek)");
		fizyczna=odczyt.nextInt();
		System.out.println("podaj wielkoœc pamiei zewnetrznej (ilosc blokow)");
		zewetrzna=odczyt.nextInt();
		
		lista_danych=new Odwolania[los];
		lista_odwolan=new Odwolania[los];
		pamiec_fizyczna=new Odwolania[los][fizyczna];
		pamiec_zewnetrzna=new Odwolania[los][zewetrzna];
		
		for(int i=0;i<los;i++)
		{
			lista_danych[i]=new Odwolania(wirtualna);
			lista_odwolan[i]=lista_danych[i];
		}
		
		
	}

	public void zapis() {
		// TODO Auto-generated method stub
		
	}
	public void przepisz()
	{
		
		for(int i=0;i<lista_odwolan.length;i++)
		{
			lista_odwolan[i]=lista_danych[i];
			
		}
		
	}

	public void wyswietl() {
		System.out.println("nastepujacy ciag odwolan do ston");
		for(int i=0;i<lista_danych.length;i++)
		{
			System.out.println("strona "+lista_danych[i].getMiejsce());	
		}
		
		for(int i=0;i<lista_odwolan.length;i++)
		{
			System.out.print("ch "+i+"\t"+lista_odwolan[i].getMiejsce()+"\t|f|\t");
			for(int j=0;j<pamiec_fizyczna[0].length;j++)
			{
				if(pamiec_fizyczna[i][j]==null)
				{
					System.out.print("null\t");
				}
				else
				{
				 System.out.print((pamiec_fizyczna[i][j].getMiejsce())+"\t");
				}
			}
//			System.out.print("|z|\t");			
//			for(int j=1;j<pamiec_zewnetrzna.length;j++)
//			{
//				System.out.print(pamiec_zewnetrzna[i][j]+"\t");
//			}
			System.out.println();
			
		}
		
	}
	public boolean decyzja(int ramka) //true gdy jest blad strony
	{
		Boolean bylo=false;
		Boolean zwracane=false;
		for(int i=0;i<pamiec_fizyczna[0].length;i++)
		{
				
			pamiec_fizyczna[chwila][i]=pamiec_fizyczna[chwila-1][i];
			if(pamiec_fizyczna[chwila][i].getMiejsce()==lista_odwolan[chwila].getMiejsce())
			{
				bylo=true;
			}
				
		}
		if(!bylo)
		{
			if(pamiec_fizyczna[chwila][ramka].getMiejsce()==-2)
			{
				bledy_Strony++;
				pamiec_fizyczna[chwila][ramka]=lista_odwolan[chwila];
				zwracane=true;
				
			}
			if(pamiec_fizyczna[chwila][ramka].getMiejsce()!=lista_odwolan[chwila].getMiejsce())
			{
				bledy_Strony++;
				pamiec_fizyczna[chwila][ramka]=lista_odwolan[chwila];
				zwracane=true;
				
			}
		}
		
		chwila++;
		return zwracane;
		
	}

	public void FIFO() {
		przepisz();
		pamiec_fizyczna=new Odwolania[los][fizyczna];
		pamiec_zewnetrzna=new Odwolania[los][zewetrzna];
		chwila=1;
		for(int i=0;i<pamiec_fizyczna.length;i++){
			for(int j=0;j<pamiec_fizyczna[0].length;j++){
				pamiec_fizyczna[i][j]=new Odwolania();
				pamiec_fizyczna[i][j].setMiejsce(-2);
			}
		}
		pamiec_fizyczna[0][0]=lista_danych[0];
		bledy_Strony=1;
		int ramka=1;
		for(int i=1;i<lista_odwolan.length;i++)
		{
			if(decyzja(ramka)){
			if(ramka>fizyczna-2)
			ramka=0;
			else
			ramka++;}
				
		}
		wyswietl();
		System.out.println("Ilosc bledow strony: "+bledy_Strony);
		
	}

	public void OPT() {
		przepisz();
		pamiec_fizyczna=new Odwolania[los][fizyczna];
		pamiec_zewnetrzna=new Odwolania[los][zewetrzna];
		chwila=1;
		for(int i=0;i<pamiec_fizyczna.length;i++){
			for(int j=0;j<pamiec_fizyczna[0].length;j++){
				pamiec_fizyczna[i][j]=new Odwolania();
				pamiec_fizyczna[i][j].setMiejsce(-2);
			}
		}
		int pocz=1;
		bledy_Strony=1;
		pamiec_fizyczna[0][0]=lista_odwolan[0];
		//bledy_Strony-=3;
		while(pocz<fizyczna)
		{
			if(decyzja(pocz))pocz++;
				
		}
		int ramka=0;
		int przeszukane=0;
		int[][] poszukiwanie=new int[fizyczna][2];//0-odwolanie 1czas od teraz do pierwszego wystapienia
		if(pocz>lista_odwolan.length){
		while(chwila<lista_odwolan.length)
		{
			for(int i=0;i<poszukiwanie.length;i++)
			{
				poszukiwanie[i][0]=pamiec_fizyczna[chwila-1][i].getMiejsce();
				poszukiwanie[i][1]=0;
			}
			int i=0;
			while(przeszukane<poszukiwanie.length&&(i+1+chwila<lista_odwolan.length))
			{
				int j=0;
				while(j<poszukiwanie.length)
				{
					if(poszukiwanie[j][0]==lista_odwolan[i+1+chwila].getMiejsce())
					{
						if(poszukiwanie[j][1]==0)
						{
							poszukiwanie[j][1]=i;
							ramka=j;
						}
					}
					j++;
				}
				i++;
			}
			if(!(przeszukane<poszukiwanie.length))
			{
				int max=0;
				for(int f=0;f<poszukiwanie.length;f++)
				{
					System.out.println(poszukiwanie[f][0]+" "+poszukiwanie[f][1]);
					if(max<poszukiwanie[f][1])
					{
						max=poszukiwanie[f][1];
						ramka=f;
					}
				}
			}
			
			decyzja(ramka);
		}}
		wyswietl();
		System.out.println("Ilosc bledow strony: "+bledy_Strony);
		
	}

	public void LRU() {
		przepisz();
		pamiec_fizyczna=new Odwolania[los][fizyczna];
		pamiec_zewnetrzna=new Odwolania[los][zewetrzna];
		chwila=1;
		for(int i=0;i<pamiec_fizyczna.length;i++){
			for(int j=0;j<pamiec_fizyczna[0].length;j++){
				pamiec_fizyczna[i][j]=new Odwolania();
				pamiec_fizyczna[i][j].setMiejsce(-2);
			}
		}
		int pocz=1;
		bledy_Strony=1;
		pamiec_fizyczna[0][0]=lista_odwolan[0];
		
		while(pocz<fizyczna)
		{
			if(decyzja(pocz))pocz++;
				
		}
		int ramka=0;
		int przeszukane=0;
		int[][] poszukiwanie=new int[fizyczna][2];//0-odwolanie 1czas od teraz do pierwszego wystapienia
		
		while(chwila<lista_odwolan.length)
		{
			for(int i=0;i<poszukiwanie.length;i++)
			{
				poszukiwanie[i][0]=pamiec_fizyczna[chwila-1][i].getMiejsce();
				poszukiwanie[i][1]=0;
			}
			int i=chwila-1;
			while(przeszukane<poszukiwanie.length&&(i>0))
			{
				int j=0;
				while(j<poszukiwanie.length)
				{
					if(poszukiwanie[j][0]==lista_odwolan[i].getMiejsce())
					{
						if(poszukiwanie[j][1]==0)
						{
							poszukiwanie[j][1]=i;
							ramka=j;
						}
					}
					j++;
				}
				i--;
			}
			if(!(przeszukane<poszukiwanie.length))
			{
				int max=0;
				for(int f=0;f<poszukiwanie.length;f++)
				{
					System.out.println(poszukiwanie[f][0]+" "+poszukiwanie[f][1]);
					if(max<poszukiwanie[f][1])
					{
						max=poszukiwanie[f][1];
						ramka=f;
					}
				}
			}
			
			decyzja(ramka);
		}
		wyswietl();
		System.out.println("Ilosc bledow strony: "+bledy_Strony);
		
	}

	public void LRUDS() {
		przepisz();
		pamiec_fizyczna=new Odwolania[los][fizyczna];
		pamiec_zewnetrzna=new Odwolania[los][zewetrzna];
		chwila=1;
		for(int i=0;i<pamiec_fizyczna.length;i++){
			for(int j=0;j<pamiec_fizyczna[0].length;j++){
				pamiec_fizyczna[i][j]=new Odwolania();
				pamiec_fizyczna[i][j].setMiejsce(-2);
			}
		}
		pamiec_fizyczna[0][0]=lista_danych[0];
		bledy_Strony=1;
		int pocz=1;
		Kolejka poszukiwane=new Kolejka();
		Aproksumowany ramkablad=new Aproksumowany(0, 1);
		poszukiwane.enqueue(new Aproksumowany(0, 1));
		bledy_Strony=1;
		pamiec_fizyczna[0][0]=lista_odwolan[0];
		
		while(pocz<fizyczna)
		{
			if(decyzja(pocz))
				{
				poszukiwane.enqueue(new Aproksumowany(pocz, 1));
				pocz++;
				System.out.println("-----xxxxx------");
				poszukiwane.wyswietl();
				}
				
		}
		
		while(pocz<lista_odwolan.length)
		{
			boolean obslurzono=true;
			while(obslurzono)
			{
				System.out.println("-----xxxxx------");
				poszukiwane.wyswietl();
				ramkablad=(Aproksumowany)poszukiwane.dequeue();
				
				if(ramkablad.bit==0)
				{
					
					int ramka=ramkablad.ramka;	
					System.out.println("wstawiam na "+ramka);
					decyzja(ramka);	
					obslurzono=false; 
					poszukiwane.enqueue(new Aproksumowany(ramka, 1));
					pocz++;
				}
				else
				{
					ramkablad.bit=0;
					poszukiwane.enqueue(ramkablad);
				}
			
			}
			
		}
		wyswietl();
		System.out.println("Ilosc bledow strony: "+bledy_Strony);
		
		
	}
	
	public void RAND() {
		przepisz();
		pamiec_fizyczna=new Odwolania[los][fizyczna];
		pamiec_zewnetrzna=new Odwolania[los][zewetrzna];
		chwila=1;
		for(int i=0;i<pamiec_fizyczna.length;i++){
			for(int j=0;j<pamiec_fizyczna[0].length;j++){
				pamiec_fizyczna[i][j]=new Odwolania();
				pamiec_fizyczna[i][j].setMiejsce(-2);
			}
		}
		Random generator=new Random();
		bledy_Strony=1;
		pamiec_fizyczna[0][generator.nextInt(fizyczna)]=lista_odwolan[0];
		for(int i=1;i<lista_odwolan.length;i++)
		{
			
			decyzja(generator.nextInt(fizyczna));
				
		}
		wyswietl();
		System.out.println("Ilosc bledow strony: "+bledy_Strony);
		
	}
}
