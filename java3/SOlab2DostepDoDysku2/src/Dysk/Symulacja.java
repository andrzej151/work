package Dysk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Symulacja implements Symulacje{

	ArrayList listaDanych;//niezmienna podzczas algorytmu
	ArrayList  listaWykonywanych;//wykonwane dane dysk je widzi
	ArrayList listaOczekujacych;//kolejka oczekujacych jescze nie ich czas dodania
	ArrayList  listaZROBIONYCH;//wykonwane potrzebne do historii
	int [] dysk;
	int czas_sym;
	
	
	public Symulacja() {
		
		
	}
	
	
	public void WprowacDaneRecznie() {
		
		Scanner odczyt = new Scanner(System.in);
		System.out.println("Wielkosc dysku");
		int wielkosc=odczyt.nextInt();
		//System.out.println("Modywikowaæ 1 tak 0 nie");
		//int zmiany=odczyt.nextInt();
		dysk=new int[wielkosc];
		for(int i=0;i<dysk.length;i++)
		{
			dysk[i]=i*2;
		}
		System.out.println("ilosc procesow");
		wielkosc=odczyt.nextInt();
		Proces p=new Proces(3, 2);
		System.out.println(p);
		for(int i=0;i<wielkosc;i++)
		{
			
			p.los(dysk.length, 50, 0);
			listaDanych.add(p);
		}
		
		for(int i=0;i<listaDanych.size();i++)
		{
			System.out.println(listaDanych.get(i));
		}
		
	}

	
	public void WprowacPlik(String nazwa) {
		try {
			Scanner odczyt = new Scanner(new File(nazwa));
			dysk=new int[odczyt.nextInt()];
			for(int i=0;i<dysk.length;i++)
			{
				dysk[i]=i;
						
			}
			int ilosc=odczyt.nextInt();
			listaDanych=new ArrayList();
			int adres,czas,dedlin;
			for(int i=0;i<ilosc;i++)
			{
				adres=odczyt.nextInt();
				czas=odczyt.nextInt();
				dedlin=odczyt.nextInt();
				listaDanych.add(new Proces(adres,czas,dedlin));
						
			}
			if(ilosc==listaDanych.size())
			{
				System.out.println("Wczytano");
				System.out.println();
				for(int i=0;i<listaDanych.size();i++)
				{
					
					System.out.println(listaDanych.get(i));
							
				}
				
			}
			else
			{
				System.out.print("NIE Wczytano");
			}
				
				
			odczyt.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	public void Zapisz(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			zapis.println(dysk.length);
			zapis.println(listaDanych.size());
			for(int i=0;i<listaDanych.size();i++)
			{
				zapis.println(((Proces)listaDanych.get(i)).zapis());
			}
			zapis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


	public void Wyswietl() {
		System.out.println();
		for(int i=0;i<listaDanych.size();i++)
		{
			
			System.out.println(listaDanych.get(i));
					
		}
		System.out.println();
		
	}

	
	public void Podsumowanie() {
		// TODO Auto-generated method stub
		
	}



	public void los() {
		
			Scanner odczyt = new Scanner(System.in);
			
			System.out.println("podaj max wielkosc dysku");
			int wielkosc_dysku=odczyt.nextInt();
			
			dysk=new int[wielkosc_dysku];
			for(int i=0;i<dysk.length;i++)
			{
				dysk[i]=i;
						
			}
			System.out.println("Do jakiej liczby ograniczyc losowanie dodawania procesow");
			int ogranic_czas=odczyt.nextInt();
			System.out.println("Do jakiej liczby ograniczyc losowanie dedlinow");
			int ded=odczyt.nextInt();
			System.out.println("Ile procesow wylosowac");
			int ilosc=odczyt.nextInt();
			
			listaDanych=new ArrayList();
			Proces p;
			for(int i=0;i<ilosc;i++)
			{
				p=new Proces();
				p.los(wielkosc_dysku, ogranic_czas, ded);
				listaDanych.add(p);
						
			}
			
				System.out.println("Wylosowano");
				Wyswietl();
				
				
	}
	
	public void los(int wielkosc_dysku,int ogranic_czas,int ded,int ilosc) {
		
		
		dysk=new int[wielkosc_dysku];
		for(int i=0;i<dysk.length;i++)
		{
			dysk[i]=i;
					
		}

		
		listaDanych=new ArrayList();
		Proces p;
		for(int i=0;i<ilosc;i++)
		{
			p=new Proces();
			p.los(wielkosc_dysku, ogranic_czas, ded);
			listaDanych.add(p);
					
		}
		
			System.out.println("Wylosowano");
			Wyswietl();
			
			
}
	public void zwieksz_czas()
	{
		czas_sym++;
	
		for(int i=0;i<listaOczekujacych.size();i++)
		{
			if(((Proces)listaOczekujacych.get(i)).getCzasDodaia()==czas_sym)
			{
				Proces p=(Proces)listaOczekujacych.delete(i);
				listaWykonywanych.add(p);
				System.out.println("DODANO "+p);
			
			}
		}
	}

	public int FCFSbezCz(String nazwa) {
		//przygotowanie bez czasow
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
		listaWykonywanych=new ArrayList();
		listaZROBIONYCH=new ArrayList();
		int sumaprzesuniec=0;
		
		for(int i=0;i<listaDanych.size();i++)
		{
			listaWykonywanych.add(((Proces)listaDanych.get(i)));
		}
		
		//Algorytm
		Proces aktualny=new Proces(1, 1);
		Proces nastepny;
		
			while(!listaWykonywanych.isEmpty())
			{
				nastepny=(Proces)listaWykonywanych.delete(0);
				nastepny.wykonaj(czas_sym);
				listaZROBIONYCH.add(nastepny);
				sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
				System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
				zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
				aktualny=nastepny;
			}
			zapis.println("Suma przesuniec: "+sumaprzesuniec);
		System.out.println("Suma przesuniec: "+sumaprzesuniec);
		zapis.close();
		return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}


	public int SSTFbezCz(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaWykonywanych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
				
			int najblizszy_adres;
			int nrNaLiscie;
				while(!listaWykonywanych.isEmpty())
				{
					nrNaLiscie=0;
					nastepny=(Proces)listaWykonywanych.get(nrNaLiscie);
					najblizszy_adres=Math.abs(aktualny.getadres()-nastepny.getadres());
					for(int i=1;i<listaWykonywanych.size();i++)
					{
						nastepny=(Proces)listaWykonywanych.get(i);
						if(Math.abs(aktualny.getadres()-nastepny.getadres())<najblizszy_adres)
						{
							nrNaLiscie=i;
							najblizszy_adres=aktualny.getadres()-nastepny.getadres();
						}
					}
					nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
					nastepny.wykonaj(czas_sym);
					listaZROBIONYCH.add(nastepny);
					sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
					System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					aktualny=nastepny;
				}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}


	public int C_SCANbezcz(String nazwa) {
		
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaWykonywanych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
			int winda;
			int nrNaLiscie;
			boolean znaleziono;
			
			while(!listaWykonywanych.isEmpty())
			{
				nrNaLiscie=0;
				winda=0;
				System.out.println("........POCZATEK..........");				
				while(winda<dysk.length)
				{
					nrNaLiscie=0;
					Iterator it=listaWykonywanych.iterator();
					it.first();
					znaleziono=false;
					while(!it.isDone()&&!znaleziono)
					{
						znaleziono=((Proces)it.current()).getadres()==winda;
						if(!znaleziono){
						nrNaLiscie++;
						it.next();}
					}
						
					if(znaleziono){
						nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
						nastepny.wykonaj(czas_sym);
						listaZROBIONYCH.add(nastepny);
						sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
						System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
						zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
						aktualny=nastepny;
						}
						winda++;
					}
				}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	public int SCANbezcz(String nazwa) {
		
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaWykonywanych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
			int winda=0;
			int nrNaLiscie;
			boolean znaleziono;
			
				while(!listaWykonywanych.isEmpty())
				{
					
					nrNaLiscie=0;
					while(winda<dysk.length)
					{
						nrNaLiscie=0;
						Iterator it=listaWykonywanych.iterator();
						it.first();
						znaleziono=false;
						while(!it.isDone()&&!znaleziono)
						{
							znaleziono=((Proces)it.current()).getadres()==winda;
							if(!znaleziono){
							nrNaLiscie++;
							it.next();}
						}
						//wgore
						if(znaleziono)
						{
							nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
							nastepny.wykonaj(czas_sym);
							listaZROBIONYCH.add(nastepny);
							sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
							System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
							zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
							aktualny=nastepny;
						}
						winda++;
					}
				
				//w dol
					while(winda>-1)
					{
						nrNaLiscie=0;
						Iterator it=listaWykonywanych.iterator();
						it.first();
						znaleziono=false;
						while(!it.isDone()&&!znaleziono)
						{
							znaleziono=((Proces)it.current()).getadres()==winda;
							if(!znaleziono){
							nrNaLiscie++;
							it.next();}
						}
						
						if(znaleziono)
						{
							nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
							nastepny.wykonaj(czas_sym);
							listaZROBIONYCH.add(nastepny);
							sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
							System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
							zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
							aktualny=nastepny;
						}
						winda--;
					}
				
				}
				
				
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int FCFS(String nazwa) {
		//przygotowanie bez czasow
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
		listaWykonywanych=new ArrayList();
		listaOczekujacych=new ArrayList();
		listaZROBIONYCH=new ArrayList();
		int sumaprzesuniec=0;
		
		for(int i=0;i<listaDanych.size();i++)
		{
			listaOczekujacych.add(((Proces)listaDanych.get(i)));
		}
		
		//Algorytm
		Proces aktualny=new Proces(1, 1);
		Proces nastepny;
		
		boolean czasNiewzrosl=true;
		czas_sym=0;
		while(!listaOczekujacych.isEmpty())
		{
			czasNiewzrosl=true;
		
		
			while(!listaWykonywanych.isEmpty())
			{
				
				zwieksz_czas();
				czasNiewzrosl=false;
				
				nastepny=(Proces)listaWykonywanych.delete(0);
				nastepny.wykonaj(czas_sym);
				listaZROBIONYCH.add(nastepny);
				sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
				System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres()+" wykonano w "+czas_sym);
				zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
				aktualny=nastepny;
			}
			if(czasNiewzrosl)
			{
				zwieksz_czas();
				
			}
			}
			zapis.println("Suma przesuniec: "+sumaprzesuniec);
		System.out.println("Suma przesuniec: "+sumaprzesuniec);
		zapis.close();
		return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}


	public int SSTF(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaOczekujacych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaOczekujacych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
				
			int najblizszy_adres;
			int nrNaLiscie;
			
			boolean czasNiewzrosl=true;
			czas_sym=0;
			while(!listaOczekujacych.isEmpty())
			{
				czasNiewzrosl=true;
			
				while(!listaWykonywanych.isEmpty())
				{
					nrNaLiscie=0;
					nastepny=(Proces)listaWykonywanych.get(nrNaLiscie);
					najblizszy_adres=Math.abs(aktualny.getadres()-nastepny.getadres());
					for(int i=1;i<listaWykonywanych.size();i++)
					{
						nastepny=(Proces)listaWykonywanych.get(i);
						if(Math.abs(aktualny.getadres()-nastepny.getadres())<najblizszy_adres)
						{
							nrNaLiscie=i;
							najblizszy_adres=aktualny.getadres()-nastepny.getadres();
						}
					}
					
					zwieksz_czas();
					czasNiewzrosl=false;
					
					nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
					nastepny.wykonaj(czas_sym);
					listaZROBIONYCH.add(nastepny);
					sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
					System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres()+" wykonano w "+czas_sym);
					zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					aktualny=nastepny;
				}
				
				if(czasNiewzrosl)
				{
					zwieksz_czas();
					
				}
				}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}


	public int C_SCAN(String nazwa) {
		
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaOczekujacych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaOczekujacych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
			int winda;
			int nrNaLiscie;
			boolean znaleziono;
			
			boolean czasNiewzrosl=true;
			czas_sym=0;
			while(!listaOczekujacych.isEmpty())
			{
				czasNiewzrosl=true;
			
			while(!listaWykonywanych.isEmpty())
			{
				nrNaLiscie=0;
				winda=0;
				System.out.println(".......Poczatek...........");			
				while(winda<dysk.length)
				{
					nrNaLiscie=0;
					Iterator it=listaWykonywanych.iterator();
					it.first();
					znaleziono=false;
					while(!it.isDone()&&!znaleziono)
					{
						
						znaleziono=((Proces)it.current()).getadres()==winda;
						if(!znaleziono){
						nrNaLiscie++;
						it.next();}
					}
						
					if(znaleziono){
						nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
						nastepny.wykonaj(czas_sym);
						listaZROBIONYCH.add(nastepny);
						sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
						System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres()+" wykonano w "+czas_sym);
						zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
						aktualny=nastepny;
						}
						winda++;
					}
				}
			if(czasNiewzrosl)
			{
				zwieksz_czas();
				
			}
			}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	public int SCAN(String nazwa) {
		
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaOczekujacych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaOczekujacych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
			int winda=0;
			int nrNaLiscie;
			boolean znaleziono;
			
			boolean czasNiewzrosl=true;
			czas_sym=0;
			while(!listaOczekujacych.isEmpty())
			{
				czasNiewzrosl=true;
			
				while(!listaWykonywanych.isEmpty())
				{
					
					nrNaLiscie=0;
					while(winda<dysk.length)
					{
						nrNaLiscie=0;
						Iterator it=listaWykonywanych.iterator();
						it.first();
						znaleziono=false;
						while(!it.isDone()&&!znaleziono)
						{
							znaleziono=((Proces)it.current()).getadres()==winda;
							if(!znaleziono){
							nrNaLiscie++;
							it.next();}
						}
						//wgore
						if(znaleziono)
						{
							zwieksz_czas();
							czasNiewzrosl=false;
							
							nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
							nastepny.wykonaj(czas_sym);
							listaZROBIONYCH.add(nastepny);
							sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
							System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres()+" wykonano w "+czas_sym);
							zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
							aktualny=nastepny;
						}
						winda++;
					}
				
				//w dol
					while(winda>-1)
					{
						nrNaLiscie=0;
						Iterator it=listaWykonywanych.iterator();
						it.first();
						znaleziono=false;
						while(!it.isDone()&&!znaleziono)
						{
							znaleziono=((Proces)it.current()).getadres()==winda;
							if(!znaleziono){
							nrNaLiscie++;
							it.next();}
						}
						
						if(znaleziono)
						{
							zwieksz_czas();
							czasNiewzrosl=false;
							
							nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
							nastepny.wykonaj(czas_sym);
							listaZROBIONYCH.add(nastepny);
							sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
							System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres()+" wykonano w "+czas_sym);
							zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
							aktualny=nastepny;
						}
						winda--;
					}
				
				}
			if(czasNiewzrosl)
			{
				zwieksz_czas();
				
			}
			}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

	
	
	public int EDF(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			listaOczekujacych=new ArrayList();
			
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaOczekujacych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
				
			int najblizszyDedlin;
			int nrNaLiscie;
			
			boolean czasNiewzrosl=true;
			czas_sym=0;
			while(!listaOczekujacych.isEmpty())
			{
				czasNiewzrosl=true;
			
				while(!listaWykonywanych.isEmpty())
				{
					nrNaLiscie=0;
					nastepny=(Proces)listaWykonywanych.get(nrNaLiscie);
					najblizszyDedlin=nastepny.getdedline();
					for(int i=1;i<listaWykonywanych.size();i++)
					{
						nastepny=(Proces)listaWykonywanych.get(i);
						if(nastepny.getdedline()<najblizszyDedlin)
						{
							nrNaLiscie=i;
							najblizszyDedlin=nastepny.getdedline();
						}
					}
					
					zwieksz_czas();
					czasNiewzrosl=false;
					
					nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
					nastepny.wykonaj(czas_sym);
					listaZROBIONYCH.add(nastepny);
					sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
					System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					aktualny=nastepny;
				}
				if(czasNiewzrosl)
				{
					zwieksz_czas();
					
				}
				}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int EDFbCZ(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaWykonywanych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
				
			int najblizszyDedlin;
			int nrNaLiscie;
				while(!listaWykonywanych.isEmpty())
				{
					nrNaLiscie=0;
					nastepny=(Proces)listaWykonywanych.get(nrNaLiscie);
					najblizszyDedlin=nastepny.getdedline();
					for(int i=1;i<listaWykonywanych.size();i++)
					{
						nastepny=(Proces)listaWykonywanych.get(i);
						if(nastepny.getdedline()<najblizszyDedlin)
						{
							nrNaLiscie=i;
							najblizszyDedlin=nastepny.getdedline();
						}
					}
					nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
					nastepny.wykonaj(czas_sym);
					listaZROBIONYCH.add(nastepny);
					sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
					System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
					aktualny=nastepny;
				}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
public int FDSCANbCZ(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			
			for(int i=0;i<listaDanych.size();i++)
			{
				listaWykonywanych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
			Proces docelowy;
			
			int najblizszyDedlin;
			int nrNaLiscie;
			int DarzonynrNaLiscie;
			
			boolean znaleziono;
			boolean kierunekwgore;
			int winda=0;
			int adresdodarzenia=1;
			
				
			while(!listaWykonywanych.isEmpty())
				{
					DarzonynrNaLiscie=0;
					docelowy=(Proces)listaWykonywanych.get(DarzonynrNaLiscie);
					najblizszyDedlin=docelowy.getdedline();
					for(int i=0;i<listaWykonywanych.size();i++)
					{
						docelowy=(Proces)listaWykonywanych.get(i);
						if(docelowy.getdedline()<najblizszyDedlin)
						{
							docelowy=(Proces)listaWykonywanych.get(i);
							najblizszyDedlin=docelowy.getdedline();
							DarzonynrNaLiscie=i;
							
						}
					}
					//////
					docelowy=(Proces)listaWykonywanych.delete(DarzonynrNaLiscie);
					System.out.println("Wybrano "+docelowy);
					winda=aktualny.getadres();
					
					
						kierunekwgore=docelowy.getadres()>aktualny.getadres();
						while(winda!=docelowy.getadres())
						{
							
								nrNaLiscie=0;
								Iterator it=listaWykonywanych.iterator();
								it.first();
								znaleziono=false;
								while(!it.isDone()&&!znaleziono)
								{
									
									znaleziono=((Proces)it.current()).getadres()==winda;
									if(!znaleziono){
									nrNaLiscie++;
									it.next();}
								}
									
								if(znaleziono){
									nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
									nastepny.wykonaj(czas_sym);
									listaZROBIONYCH.add(nastepny);
									sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
									System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
									zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
									aktualny=nastepny;
									
									}
							if(kierunekwgore){	
							winda++;}
							else
							{winda--;}
							System.out.println(winda+" darzy "+docelowy.getadres());
								
						}
						
						if(winda==docelowy.getadres())
					{
						
						listaZROBIONYCH.add(docelowy);
						sumaprzesuniec+=Math.abs(aktualny.getadres()-docelowy.getadres());
						System.out.println("Z "+aktualny.getadres()+" DO "+docelowy.getadres());
						zapis.println("Z "+aktualny.getadres()+" DO "+docelowy.getadres());
						aktualny=docelowy;
						
						
					}
					
				
				}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}


public int FDSCAN(String nazwa) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(nazwa);
			listaWykonywanych=new ArrayList();
			listaOczekujacych=new ArrayList();
			listaZROBIONYCH=new ArrayList();
			int sumaprzesuniec=0;
			czas_sym=0;
			for(int i=0;i<listaDanych.size();i++)
			{
				listaOczekujacych.add(((Proces)listaDanych.get(i)));
			}
			
			//Algorytm
			Proces aktualny=new Proces(1, 1);
			Proces nastepny;
			Proces docelowy;
			
			int najblizszyDedlin;
			int nrNaLiscie;
			int DarzonynrNaLiscie;
			
			boolean znaleziono;
			boolean kierunekwgore;
			int winda=0;
			int adresdodarzenia=1;
			
			
			boolean czasNiewzrosl=true;
			czas_sym=0;
			while(!listaOczekujacych.isEmpty())
			{
				czasNiewzrosl=true;
			
			while(!listaWykonywanych.isEmpty())
				{
					DarzonynrNaLiscie=0;
					docelowy=(Proces)listaWykonywanych.get(DarzonynrNaLiscie);
					najblizszyDedlin=docelowy.getdedline();
					for(int i=0;i<listaWykonywanych.size();i++)
					{
						docelowy=(Proces)listaWykonywanych.get(i);
						if(docelowy.getdedline()<najblizszyDedlin)
						{
							docelowy=(Proces)listaWykonywanych.get(i);
							najblizszyDedlin=docelowy.getdedline();
							DarzonynrNaLiscie=i;
							
						}
					}
					//////
					docelowy=(Proces)listaWykonywanych.delete(DarzonynrNaLiscie);
					System.out.println("Wybrano "+docelowy);
					winda=aktualny.getadres();
					
					
						kierunekwgore=docelowy.getadres()>aktualny.getadres();
						while(winda!=docelowy.getadres())
						{
							
								nrNaLiscie=0;
								Iterator it=listaWykonywanych.iterator();
								it.first();
								znaleziono=false;
								while(!it.isDone()&&!znaleziono)
								{
									
									znaleziono=((Proces)it.current()).getadres()==winda;
									if(!znaleziono){
									nrNaLiscie++;
									it.next();}
								}
									
								if(znaleziono){
									zwieksz_czas();
									czasNiewzrosl=false;
									
									nastepny=(Proces)listaWykonywanych.delete(nrNaLiscie);
									nastepny.wykonaj(czas_sym);
									listaZROBIONYCH.add(nastepny);
									sumaprzesuniec+=Math.abs(aktualny.getadres()-nastepny.getadres());
									System.out.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
									zapis.println("Z "+aktualny.getadres()+" DO "+nastepny.getadres());
									aktualny=nastepny;
									
									}
							if(kierunekwgore){	
							winda++;}
							else
							{winda--;}
							System.out.println(winda+" darzy "+docelowy.getadres());
								
						}
						
						if(winda==docelowy.getadres())
					{
						
							zwieksz_czas();
							czasNiewzrosl=false;
						listaZROBIONYCH.add(docelowy);
						sumaprzesuniec+=Math.abs(aktualny.getadres()-docelowy.getadres());
						System.out.println("Z "+aktualny.getadres()+" DO "+docelowy.getadres());
						zapis.println("Z "+aktualny.getadres()+" DO "+docelowy.getadres());
						aktualny=docelowy;
						
						
					}
					
				
				}
			if(czasNiewzrosl)
			{
				zwieksz_czas();
				
			}
			}
				zapis.println("Suma przesuniec: "+sumaprzesuniec);
				System.out.println("Suma przesuniec: "+sumaprzesuniec);
				zapis.close();
				return sumaprzesuniec;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
}
