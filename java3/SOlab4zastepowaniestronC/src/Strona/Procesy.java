package Strona;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Procesy {
	private int nazwa;
	private int[] nrramek;
	private int[] dane;
	private int aktualny;
	private int[] przyszle;
	private int priorytet;
	int iloscbledow;

	
	public Procesy(int nazwa) {
		this.nazwa=nazwa;
		iloscbledow=0;
	}
	
	
	public void wylosujlisteodwolan(int iloscpamieci,int dlkolejki) {
		
		
		przyszle=new int[dlkolejki];
		Random generator=new Random();
		for(int i=0;i<przyszle.length;i++)
		{
			przyszle[i]=generator.nextInt(iloscpamieci-1)+1;
		}
		aktualny=0;
		priorytet=iloscpamieci;
	}
	public void wylosujlisteodwolanOGRANICZ(int iloscpamieci,int dlkolejki) {
		
		Scanner o=new Scanner(System.in);
		int gora,dol;
		System.out.println("ogranicz losowane dane od dolu od 1 do "+(iloscpamieci-1));
		dol=o.nextInt();
		System.out.println("ogranicz losowane dane od gory od "+dol+" do "+(iloscpamieci-1));
		gora=o.nextInt();

		przyszle=new int[dlkolejki];
		Random generator=new Random();
		for(int i=0;i<przyszle.length;i++)
		{
			przyszle[i]=generator.nextInt(gora-dol)+dol;
		}
		priorytet=gora-dol;
		aktualny=0;
	}
	public void zeroj()
	{
		iloscbledow=0;
		aktualny=0;
	}
	public boolean zakonczony()//true jesli koniec procesu
	{
		return aktualny>przyszle.length-2;
	}
	
	public int getnazwa()
	{return nazwa;}
	
	public void przydzielramki(int  ... ramki)
	{
		nrramek=new int[ramki.length];
		for(int i=0;i<ramki.length;i++)
		{
		nrramek[i]=ramki[i];
		}
		dane=new int[ramki.length];
	}
	
	public void next() throws Exception
	{
		if(aktualny<przyszle.length)
		aktualny++;	
		else
			throw new Exception("proces jest zakonczony");
	}
	public void setpriorytet(int p)
	{
		priorytet=p+priorytet;
	}
	public int getpriorytet()
	{
		return priorytet;
	}
	public double getczestotliwosc()
	{
		return iloscbledow/aktualny;
	}
	public int LRU()//zwraca nr globalnej ramki na ktorym ma byæ dodany proces 
	{
		
		//sprawdzam czy sa dane w ramce
		for(int i=0;i<dane.length;i++)
		{
			if(dane[i]==przyszle[aktualny])
			{
				System.out.println("ik");
				return nrramek[i];
			}
		}
		//sprawdzam czy jest pusta nie wykorzystana ramka
		for(int i=0;i<dane.length;i++)
		{
			if(dane[i]==0)
			{
				
				dane[i]=przyszle[aktualny];
				iloscbledow++;
				System.out.println("pier "+dane[i]);
				return nrramek[i];
			}
		}
		
		int []lru=new int[dane.length];
		for(int i=0;i<dane.length;i++)
		{
			lru[i]=dane[i];
		}
		int ilo=0,ramka=0;
		int przeszlosc=aktualny-1;
		
		while(ilo<dane.length)
		{
			while(przeszlosc>=0)
			{
				for(int i=0;i<dane.length;i++)
				{
					if(przyszle[przeszlosc]==lru[i])
					{
						ramka=i;
						lru[i]=-1;
						ilo++;
					}
				}
				
				przeszlosc--;
			}
		}
		
		
		dane[ramka]=przyszle[aktualny];
		iloscbledow++;
		return nrramek[ramka];
	}
	
	public int getaktualny()//pobieranie danuch po LUR
	{
		return przyszle[aktualny];
	}
	
	public void wyswietlramki()
	{
		System.out.println("Proces "+nazwa);
		for(int i=0;i<nrramek.length;i++){System.out.print(nrramek[i]+"\t");}
		System.out.println();
		for(int i=0;i<dane.length;i++){System.out.print(dane[i]+"\t");}
		System.out.println("\n");
		
	}

	public void wyswietl()
	{
		System.out.println("\nProces "+nazwa);
		System.out.print("Historia ");
		for(int i=0;i<aktualny;i++){System.out.print(przyszle[i]+" ");}
		System.out.println();
		System.out.println("Aktualny "+przyszle[aktualny]);
		for(int i=aktualny+1;i<przyszle.length;i++){System.out.print(przyszle[i]+" ");}
		System.out.println();
		System.out.println("ilosc bledow "+iloscbledow);
		System.out.println();
		
		
	}
	

	public void wyswietlkoniec()
	{
		System.out.println("\nProces "+nazwa);
		System.out.print("Historia ");
		for(int i=0;i<przyszle.length;i++){System.out.print(przyszle[i]+" ");}
		System.out.println();
		System.out.println("ilosc bledow "+iloscbledow);
		System.out.println();
		
		
	}

	

}
