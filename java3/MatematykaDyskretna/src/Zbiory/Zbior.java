package Zbiory;

import java.util.Scanner;

public class Zbior {
	
	int wielkosc;
	int []elementy;
	String [] nazwy={"a","b","c","d","e","f","g","h","i","j"};
	
	public Zbior()
	{
		System.out.println("Podaj wielkosc");
		Scanner odczyt=new Scanner(System.in);
		wielkosc=odczyt.nextInt();
		elementy=new int[wielkosc];
		for(int i=0;i<wielkosc;i++)
		{
			System.out.println("Podaj ilosc elementu: "+nazwy[i]);
			elementy[i]=odczyt.nextInt();
		}
	}
	public Zbior(int w)
	{
		wielkosc=w;
		elementy=new int[wielkosc];
	}

	
	double suma(Zbior B)
	{
		double suma=0;
		for(int i=0;i<elementy.length;i++)
		{
			if(this.elementy[i]<B.elementy[i])
			{
				suma+=B.elementy[i];
			}
			else
			{
				suma+=this.elementy[i];
			}
			
		}
		return suma;
	}
	
	double iloczyn(Zbior B)
	{
		double iloczyn=0;
		for(int i=0;i<elementy.length;i++)
		{
			if(this.elementy[i]<B.elementy[i])
			{
				iloczyn+=this.elementy[i];
			}
			else
			{
				iloczyn+=B.elementy[i];
			}
			
		}
		return iloczyn;
	}
	
	Zbior ZAminusB(Zbior B)
	{
		Zbior ZP=new Zbior(B.wielkosc);
		for(int i=0;i<elementy.length;i++)
		{
			if((this.elementy[i]-B.elementy[i])<0)
			{
				ZP.elementy[i]=0;
			}
			else
			{
				ZP.elementy[i]=this.elementy[i]-B.elementy[i];
			}
			
		}
		return ZP;
	}
	
	Zbior ZBminusA(Zbior B)
	{
		Zbior ZP =new Zbior(B.wielkosc);
		for(int i=0;i<elementy.length;i++)
		{
			if((B.elementy[i]-this.elementy[i])<0)
			{
				ZP.elementy[i]=0;
			}
			else
			{
				ZP.elementy[i]=B.elementy[i]-this.elementy[i];
			}
			
		}
		return ZP;
	}
	
	double AminusB(Zbior B)
	{
		double roznica=0;
		for(int i=0;i<elementy.length;i++)
		{
			if((this.elementy[i]-B.elementy[i])<0)
			{
				roznica+=0;
			}
			else
			{
				roznica+=this.elementy[i]-B.elementy[i];
			}
			
		}
		return roznica;
	}
	
	double BminusA(Zbior B)
	{
		double roznica=0;
		for(int i=0;i<elementy.length;i++)
		{
			if((B.elementy[i]-this.elementy[i])<0)
			{
				roznica+=0;
			}
			else
			{
				roznica+=B.elementy[i]-this.elementy[i];
			}
			
		}
		return roznica;
	}
	
	
	
	double jacard(Zbior B)
	{
		double p=this.iloczyn(B);
		double q=this.AminusB(B);
		double n=this.BminusA(B);
		return p/(p+q+n);
	}
	
	double dice2(Zbior B)
	{
		double p=this.iloczyn(B);
		double q=this.AminusB(B);
		double n=this.BminusA(B);
		return 2*p/(2*p+q+n);
	}
	double sumasymetryczna(Zbior B)
	{
		
		
		
		return (this.ZAminusB(B)).suma(this.ZBminusA(B));
	}
	
	
	public String toString()
	{
		String nazwa="{";
		for(int i=0;i<wielkosc;i++)
		{
			if(elementy[i]!=0)
			{
				nazwa=nazwa+elementy[i]+nazwy[i]+",";
			}
		}
		if(nazwa.equals("{"))
		{
			nazwa=nazwa+"0}";
		}
		else
		{
			nazwa=nazwa+"}";
		}
		return nazwa;
		
	}

}
