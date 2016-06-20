package Kolejka;

import java.util.Scanner;

public class Kolejka 
{
	
	private int []dane;
	private int ilosc;//ilosc pelnych pol
	private int glowa; //index glowy
	private int ogon; //index ogona
	Scanner odczyt;
	
	//konstruktor potrzebna wielkosc kolejki
	Kolejka(int wielkosc)
	{
		dane=new int[wielkosc];
		ilosc=0;
		
	}
	
	public void wyswietl()//wyswietla kolejke
	{
		System.out.println("zawartosc kolejki");
		
		if(ilosc==0)//jesli pusta
		{
			System.out.println("pusta");
		}
		else
		{
			int index;
			
			for(int i=0; i<ilosc;i++)
			{
				index=glowa+i;
				if(glowa+i>=dane.length)
				index=glowa+i-dane.length;
				System.out.print(dane[index]+" ");
				
			}
			System.out.println();
		}
	}
		//dodaje element na koniec kolejki
	public void push(int value)
		{
			
			if (ilosc>=dane.length)
			{
				System.out.println("Kolejka pelna!");
			}
			else if (ilosc==0)
			{
				dane[ogon]=value;
				ogon++;
				ilosc++;
			}
			else
			{
				dane[ogon]=value;
				ogon=(ogon+1)%dane.length;
				ilosc++;
			}
		}

	//usuwa element z poczatku kolejki
		public void pop()
			{
				if (ilosc==0)
				{
					System.out.println("kolejka jest pusta!");
				}
				else
				{
					System.out.println("usunieto z kolejki liczbe "+dane[glowa]);
					glowa=(glowa+1)%dane.length;
					ilosc--;
				}
				
			}
		
		public void popo()
		{
			if (ilosc==0)
			{
				System.out.println("kolejka jest pusta!");
			}
			else
			{
				System.out.println("usunieto z kolejki liczbe "+dane[ogon]);
				ogon=(ogon-1)%dane.length;
				ilosc--;
			}
			
		}
		
		//czysci kolejke a tak naprawde ustawia wartosci na 0
		public void delete()
		{
			glowa=0;
			ogon=0;
			ilosc=0;
					
		}
}