package Dysk;

import java.util.Random;

public class Proces {

	private int adres;//miejsce w pamieci 
	private int czasDodania;//czas pojawienia widzenia w systemie >0
	private int Dedline;//w w algorytmach czasu rzeczywistego -1 prekroczono 0 brak >
	private int czasWykonania; 
	
	 public Proces() 
	 {
		;
	 }
	 
	 public int getCzasDodaia()
	 {return czasDodania;}
	 public int getadres()
	 {return adres;}
	 public int getdedline()
	 {return Dedline;}
	 
	 public Proces(int adres,int czas,int dedline)
	 {
		 if(adres>0&&czas>0&&dedline>-1)
		 {
			 this.adres=adres;
			 this.czasDodania=czas;
			 this.Dedline=dedline;
			 czasWykonania=-1;
		 }
		 else
		 {
			 System.out.println("Zle dane");
		 }
	 }
	 
	 public Proces(int adres,int czas)
	 {
		 if(adres>0&&czas>0)
		 {
			 this.adres=adres;
			 this.czasDodania=czas;
			 this.Dedline=0;
			 czasWykonania=-1;
		 }
		 else
		 {
			 System.out.println("Zle dane");
		 }
	 }
	 
	public String toString() {
		String s="adresDanych "+adres+" dodany "+czasDodania+" DEDLINE ";
		if(Dedline==-1)
		{
			s+="PRZEKROCZONO ";
		}
		if(Dedline==0)
		{
			s+="BRAK ";
		}
		if(Dedline>0)
		{
			s+=Dedline+" ";
		}
		
		return s;
	}
	public boolean czy_wykonac()
	{
		if(Dedline==-1)
		{
			return false;
		}
		else
		{
			if(czasWykonania==-1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	public void obniz_dedline()
	{
		if(Dedline>0)
		{
			Dedline--;
		}
		else
		{
			Dedline=-1;
		}
	}
	public void wykonaj(int czas)
	{
		if(czy_wykonac())
		{
			czasWykonania=czas;
		}
	}
	public boolean czy_wykonano()
	{
		return czasWykonania==-1?false:true;
	}
	
	public int Opuznienie()
	{
		return czasWykonania-czasDodania;
	}
	/* adresy od 1 do wielkosc dysku
	 * 
	 */
	public void los(int wielkosc_dysku,int ogranic_czas,int ded)
	{
		Random generator= new Random();
		adres=generator.nextInt(wielkosc_dysku-1)+1;
		czasDodania=generator.nextInt(ogranic_czas)+1;
	
		if(ded==0)
		{
			Dedline=0;
		}
		else
		{
			Dedline=generator.nextInt(ded+1)+5;
		}
		czasWykonania=-1;
		
	}

	public boolean equals(Proces proces)
	{
		System.out.println("porownam");
		return(proces.adres==this.adres);
	}
	
	public String zapis()
	{
		return adres+" "+czasDodania+" "+Dedline;
	}
	
}
