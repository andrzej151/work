package Strona;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Symulacja {
	private Dysk dysk;
	private ArrayList<Procesy> lprocesow;
	 public Symulacja() {
		}
	 
	 public void rozpocznij()
	 {
		 dysk=new Dysk();
		 Scanner o=new Scanner(System.in);
		 System.out.println("podaj ilosc procesow");
		 int temp=o.nextInt();
		 lprocesow=new ArrayList<Procesy>();
		 System.out.println("podaj ile danych ma przetworzyc proces");
		 int temp2=o.nextInt();
		 for(int i=0;i<temp;i++)
		 {
			 lprocesow.add(new Procesy(i));
			 
		 }
		 for(Procesy p:lprocesow)
		 {
			 System.out.println("czy chcesz ograniczyc z jakieo zakresu los dane 1 tak 0 nie w procesie "+p.getnazwa());
			 int ogr=o.nextInt();
			 if(1==ogr)
			 {
				 p.wylosujlisteodwolanOGRANICZ(dysk.getiloscpamieci(),temp2);
			 }
			 else
			 {
				 p.wylosujlisteodwolan(dysk.getiloscpamieci(),temp2);
			 }
			 p.wyswietl();
		 }
	 }
		 
		public void  wyswietlpotrzebneinf()
		{
			System.out.println(".......Dysk.........");
			dysk.wyswietlhistorie();
			 for(Procesy p:lprocesow)
			 {
				
				 p.wyswietl();
			 }
		}
		
		
//		 int[]pc={0,0,0,1,1,1,1,2,2};
//		 dysk.nowypodzialpamiecifizycznej(pc);
//		 lprocesow.get(0).przydzielramki(0,1,2);
//		 lprocesow.get(1).przydzielramki(3,4,5,6); 
//		 lprocesow.get(2).przydzielramki(7,8);
//		 for(int b=0;b<9;b++){
//		 for(Procesy p:lprocesow)
//		 {
//			 try {
//				 int l=p.LRU(),a=p.getaktualny();
//				dysk.operacjad1(p.getnazwa(),l,a);
//				p.wyswietlramki();
//				dysk.wyswielukladramek();
//				p.next();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			
//			}
//			
//		 }
//		 }
//		 
//		 for(Procesy p:lprocesow)
//		 {
//			
//			 p.wyswietl();
//		 }
//				 dysk.wyswietlhistorie();
//	}

	 
	 public void podzialrowny()
	 {
		 System.out.println(".......Podzial...rowny....");
		 int[] nowypodzial=new int[dysk.getiloscpamiecifizycznej()];
		 int podzial=dysk.getiloscpamiecifizycznej()/lprocesow.size();
		 int ilo=0;
		 
		
		for(Procesy p:lprocesow)
		{
			int[]t=new int[podzial];
			for(int j=0;j<podzial;j++)
			{
				t[j]=ilo;
				nowypodzial[ilo]=p.getnazwa();	
				ilo++;
			}
			p.przydzielramki(t);
			p.zeroj();
			p.wyswietl();
		}
		dysk.nowypodzialpamiecifizycznej(nowypodzial);
		dysk.wyswielukladramek();
		dysk.zeroj();
		boolean zakoncz=true;
		try {
			
			while(zakoncz)
			{
				zakoncz=false;
				for(Procesy p:lprocesow)
				{
					if(!p.zakonczony())
					{
						zakoncz=true;
						int l=p.LRU(),a=p.getaktualny();
						dysk.operacjad1(p.getnazwa(),l,a);
						p.next();
						dysk.wyswielukladramek();
						
					}
				}
			}
			
			for(Procesy p:lprocesow)
			{
				p.wyswietlkoniec();	
			}
			dysk.wyswietlhistorie();
			
			
			System.out.println("zapisac 1 tak");
			Scanner o=new Scanner(System.in);
			int d=o.nextInt();
			if(d==1){
				String n=o.next();
				dysk.zapiszhistorie(n);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	 }
	
	public void podzialproporcjonalny()
	 {
		 System.out.println(".......Podzial...proporcjonalny....");
		 int[] nowypodzial=new int[dysk.getiloscpamiecifizycznej()];
		 int ilo=0;
		 int []tpriorytetow=new int[lprocesow.size()];
		 int ite=0;	
		 Scanner o=new Scanner(System.in);
		 System.out.println("chcesz zmienic priorytet im wyzszy priorytet tym wiecej ramek 1 -tak 0 nie");
		 int dec=o.nextInt();
		 int suma=0;
		for(Procesy p:lprocesow)
		{
			if(dec==1)
			{
				 System.out.println("jaki prorytet ma miec proces "+p.getnazwa());
				 p.setpriorytet(o.nextInt());
			}
			tpriorytetow[ite]=p.getpriorytet();
			suma+=p.getpriorytet();
			ite++;
			
		}
		ilo=0;
		for(Procesy p:lprocesow)
		{
			int[]t=new int[p.getpriorytet()*dysk.getiloscpamiecifizycznej()/suma];
			for(int j=0;j<(p.getpriorytet()*dysk.getiloscpamiecifizycznej()/suma);j++)
			{
				t[j]=ilo;
				nowypodzial[ilo]=p.getnazwa();	
				ilo++;
			}
			
			p.przydzielramki(t);
			p.zeroj();
			p.wyswietl();
		}
		
		dysk.nowypodzialpamiecifizycznej(nowypodzial);
		dysk.wyswielukladramek();
		dysk.zeroj();
		boolean zakoncz=true;
		try {
			
			while(zakoncz)
			{
				zakoncz=false;
				for(Procesy p:lprocesow)
				{
					if(!p.zakonczony())
					{
						zakoncz=true;
						int l=p.LRU(),a=p.getaktualny();
						dysk.operacjad1(p.getnazwa(),l,a);
						p.next();
						dysk.wyswielukladramek();
						
					}
				}
			}
			
			for(Procesy p:lprocesow)
			{
				p.wyswietlkoniec();	
			}
			dysk.wyswietlhistorie();
			
			
			System.out.println("zapisac 1 tak");
		
			int d=o.nextInt();
			if(d==1){
				String n=o.next();
				dysk.zapiszhistorie(n);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	 }
	 
	 public void czestotliwosc()
	 {
		 System.out.println(".......Podzial...z badaniem czestotliwosci....");
		 int[] nowypodzial=new int[dysk.getiloscpamiecifizycznej()];
		 int podzial=dysk.getiloscpamiecifizycznej()/lprocesow.size();
		 int ilo=0;
		
		 Scanner o=new Scanner(System.in);
		 System.out.println("dolna granica obliczane l bledow/l wykonanych");
		 	int dol=o.nextInt();
		 System.out.println("gorna granica obliczane l bledow/l wykonanych");
			int gora=o.nextInt();
			
		for(Procesy p:lprocesow)
		{
			int[]t=new int[podzial];
			for(int j=0;j<podzial;j++)
			{
				t[j]=ilo;
				nowypodzial[ilo]=p.getnazwa();	
				ilo++;
			}
			p.przydzielramki(t);
			p.zeroj();
			p.wyswietl();
		}
		dysk.nowypodzialpamiecifizycznej(nowypodzial);
		dysk.wyswielukladramek();
		dysk.zeroj();
		boolean zakoncz=true;
		try {
			
			while(zakoncz)
			{
				zakoncz=false;
				for(Procesy p:lprocesow)
				{
					if(!p.zakonczony())
					{
						zakoncz=true;
						int l=p.LRU(),a=p.getaktualny();
						dysk.operacjad1(p.getnazwa(),l,a);
						p.next();
						dysk.wyswielukladramek();
					}
				}
			}
			
			for(Procesy p:lprocesow)
			{
				p.wyswietlkoniec();	
			}
			dysk.wyswietlhistorie();
			
			
			System.out.println("zapisac 1 tak");
			int d=o.nextInt();
			if(d==1){
				String n=o.next();
				dysk.zapiszhistorie(n);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	 }
	  private void nowypodzialcz(int getnazwa) {
		System.out.println("proces "+getnazwa+" zglosil potrzebe zmianyilosci pam");
		
	}
	  
	  
		 public void podzialstrefowy()
		 {
			 System.out.println(".......Podzial...rowny....");
			 int[] nowypodzial=new int[dysk.getiloscpamiecifizycznej()];
			 int podzial=dysk.getiloscpamiecifizycznej()/lprocesow.size();
			 int ilo=0;
			 
			
			for(Procesy p:lprocesow)
			{
				int[]t=new int[podzial];
				for(int j=0;j<podzial;j++)
				{
					t[j]=ilo;
					nowypodzial[ilo]=p.getnazwa();	
					ilo++;
				}
				p.przydzielramki(t);
				p.zeroj();
				p.wyswietl();
			}
			dysk.nowypodzialpamiecifizycznej(nowypodzial);
			dysk.wyswielukladramek();
			dysk.zeroj();
			boolean zakoncz=true;
			try {
				
				while(zakoncz)
				{
					zakoncz=false;
					for(Procesy p:lprocesow)
					{
						if(!p.zakonczony())
						{
							zakoncz=true;
							if(dysk.operacjad2(p.getaktualny())==-1)
							{
								int l=p.LRU(),a=p.getaktualny();
								dysk.operacjad1(p.getnazwa(),l,a);
								p.next();
								dysk.wyswielukladramek();
							}
							else
							{
								dysk.operacjad2(p.getnazwa(),dysk.operacjad2(p.getaktualny()),p.getaktualny());
								p.next();
								dysk.wyswielukladramek();
							}
							
						}
					}
				}
				
				for(Procesy p:lprocesow)
				{
					p.wyswietlkoniec();	
				}
				dysk.wyswietlhistorie();
				
				
				System.out.println("zapisac 1 tak");
				Scanner o=new Scanner(System.in);
				int d=o.nextInt();
				if(d==1){
					String n=o.next();
					dysk.zapiszhistorie(n);
				}
			} catch (Exception e) {
				e.getMessage();
			}
			
		 }

}