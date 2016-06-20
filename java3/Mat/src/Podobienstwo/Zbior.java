package Podobienstwo;

import java.util.ArrayList;
import java.util.Scanner;

public class Zbior {
	
	private int wielkosc;
	private int []elementy;
	private String nazwa;
	
	
	
	public Zbior()
	{
	
	}
	public Zbior(String nazwa,int w)
	{
		wielkosc=w;
		elementy=new int[wielkosc];
		this.nazwa=nazwa;
	}
	
	
	public void dodajElement(int nrelementu)
	{
		elementy[nrelementu]++;
	}

	
	static double suma(Zbior A,Zbior B)
	{
		double suma=0;
		for(int i=0;i<A.elementy.length;i++)
		{
			if(A.elementy[i]<B.elementy[i])
			{
				suma+=B.elementy[i];
			}
			else
			{
				suma+=A.elementy[i];
			}
			
		}
		return suma;
	}
	
	static double iloczyn(Zbior A,Zbior B)
	{
		double iloczyn=0;
		for(int i=0;i<A.elementy.length;i++)
		{
			if(A.elementy[i]<B.elementy[i])
			{
				iloczyn+=A.elementy[i];
			}
			else
			{
				iloczyn+=B.elementy[i];
			}
			
		}
		return iloczyn;
	}
	
	static Zbior ZAminusB(Zbior A,Zbior B)
	{
		Zbior R=new Zbior(A.nazwa+"-"+B.nazwa, B.wielkosc);
		for(int i=0;i<A.elementy.length;i++)
		{
			if((A.elementy[i]-B.elementy[i])<0)
			{
				R.elementy[i]=0;
			}
			else
			{
				R.elementy[i]=A.elementy[i]-B.elementy[i];
			}
			
		}
		return R;
	}
	
	
	
	static double AminusB(Zbior A,Zbior B)
	{
		double roznica=0;
		for(int i=0;i<A.elementy.length;i++)
		{
			if((A.elementy[i]-B.elementy[i])<0)
			{
				roznica+=0;
			}
			else
			{
				roznica+=A.elementy[i]-B.elementy[i];
			}
			
		}
		return roznica;
	}
	
	
	
	
	
	static double jacard(Zbior A,Zbior B)
	{
		double p=iloczyn(A,B);
		double q=AminusB(A,B);
		double n=AminusB(B,A);
		return p/(p+q+n);
	}
	
	static double dice2(Zbior A,Zbior B)
	{
		double p=iloczyn(A,B);
		double q=AminusB(A,B);
		double n=AminusB(B,A);
		return 2*p/(2*p+q+n);
	}
	static double sumasymetryczna(Zbior A,Zbior B)
	{
	
		return suma(ZAminusB(A, B), ZAminusB(B, A));
	}
	
	
	public String toString()
	{
		String nazwa="{";
		for(int i=0;i<wielkosc;i++)
		{
			
				nazwa=nazwa+elementy[i]+" "+i+",";
			
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
