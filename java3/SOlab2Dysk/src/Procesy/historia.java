package Procesy;

public class historia {

	int[] czasstartu;
	int[] czasstopu;
	int[] czastrwania;
	int[] czasopuznien;
	
	int[][]procesypodzial; //index procesu czas startu czas trwania czas stopu
	int licznik;
	
	public historia()
	{
		procesypodzial=new int[4][1000];
		licznik=0;
	}
	
	public void dodajproces(int index,int czasstartu)
	{
				procesypodzial[0][licznik]=index;
				procesypodzial[1][licznik]=czasstartu;
	}
	
	public void zakonczproces(int czasstopu)
	{
		procesypodzial[2][licznik]=czasstopu-procesypodzial[1][licznik];
		procesypodzial[3][licznik]=czasstopu;
		if(procesypodzial[2][licznik]>0)
		{
			licznik++;
		}
	}
	
	public void podsumowanie(Lista listazgoszen)
	{
		 czasstartu=new int[licznik];
		 czasstopu = new int[licznik];
		
		 
		 int iloscpelnychprocesow=0;
		 int opuznienie;
		 int sumaopuznien=0;
		 
		 listazgoszen.wyswietl();
		System.out.println("Historia podzialu szczegulowa"+licznik);
		
		 for(int i = 0;i<licznik;i++)
		{
			if(czasstartu[procesypodzial[0][i]]==0)
			{
				czasstartu[procesypodzial[0][i]]=procesypodzial[1][i];
				iloscpelnychprocesow++;
			}
			if(czasstopu[procesypodzial[0][i]]<procesypodzial[3][i])
			{
				czasstopu[procesypodzial[0][i]]=procesypodzial[3][i];
			}
			
			System.out.println("proces "+procesypodzial[0][i]+
					" rozpoczol wykonanie "+procesypodzial[1][i]+
					" trwal "+procesypodzial[2][i]);
		}
		 System.out.println(".................................");
		 System.out.println();
		 System.out.println("Historia podzialu ");
		
		for(int i = 0;i<iloscpelnychprocesow;i++)
		{
			opuznienie=czasstopu[i]-listazgoszen.getczastrwania(i)-listazgoszen.getczaszg�oszenia(i);
			sumaopuznien=sumaopuznien+opuznienie;
			System.out.println("proces "+i+"zg�oszony "+listazgoszen.getczaszg�oszenia(i)+
					" rozpoczol wykonanie "+czasstartu[i]+
					" trwal "+listazgoszen.getczastrwania(i)+
					" zakonczony "+czasstopu[i]+
					" opuznienie wynosi "+opuznienie);
		} 
		System.out.println();
		System.out.println(".................................");
		System.out.println();
		System.out.println("srednie opuznienie wynosi "+sumaopuznien+"/"+iloscpelnychprocesow+"="+
		(double)(sumaopuznien/iloscpelnychprocesow));
		 System.out.println(".................................");
		 System.out.println();
		
		
	}
}
