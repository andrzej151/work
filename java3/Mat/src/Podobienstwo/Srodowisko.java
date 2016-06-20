package Podobienstwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Srodowisko {
	private ArrayList<String> teksty;
	private ArrayList<String> klucze;
	private Zbior[] pozycje;
	private Zbior terminy;
	private double[] wyniki;
	
	public Srodowisko()
	{
		teksty=new ArrayList<String>();
		klucze=new ArrayList<String>();
		
		
	}
	
	public void wstawtext(String nazwa) {
		teksty.add(nazwa);
	}
	
	
	public void wstawslowoklucz(String nazwa) {
		klucze.add(nazwa);
	}
	public void wyswietlklucze()
	{
		int i=0;
		System.out.println(".............................");
		System.out.println("........Klucze...............");
		for(String klucz:klucze)
		{
			System.out.println("T"+i+" - "+klucz);
			i++;
		}
		System.out.println("T"+i+" - inne");
		System.out.println(".............................");
	}
	
	public void wyswietlpliki()
	{
		int i=0;
		System.out.println(".............................");
		System.out.println("........Pliki...............");
		for(String klucz:teksty)
		{
			System.out.println("U"+i+" - "+klucz);
			i++;
		}
		System.out.println(".............................");
	}
	
	public void przerobklucze()
	{
		
	}
	
	public void slownik()
	{
		Scanner o;
		try {
			o = new Scanner(new File("w1.txt"));
			while(o.hasNext())
			{
				String s=o.next();
				
				//Character S=String.valueOf((s.toUpperCase()));
				s.toUpperCase();
//				for (Character c : S) {
//					if(Character.isLetter(c))
//					{
//						S+=c;
//					}
//					
//				}
				wstawslowoklucz(s);
			}
			wyswietlklucze();
			
			o.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void d2()
	{
		wyniki=new double[teksty.size()];
		for(int i=0;i<wyniki.length;i++)
		{
			System.out.println(i);
			wyniki[i]=Zbior.dice2(pozycje[0], pozycje[i]);
		}
		System.out.println("............Wyniki...........");
		for(int i=0;i<wyniki.length;i++)
		{
			System.out.println(i+" "+wyniki[i]);
		}
	}
	
	
	
	public void przeksztalc()
	{
		Scanner o;
		try {
			int i=0;
			pozycje=new Zbior[teksty.size()];
			for(String text:teksty)
			{
				o = new Scanner(new File(text));
				pozycje[i]=new Zbior("U"+i, klucze.size());
				
				while(o.hasNext())
				{
					String s=o.next();
					s.toUpperCase();
					int j=0;
					for(String slowo:klucze)
					{
						if(s.equals(slowo))
						{
							pozycje[i].dodajElement(j);
						}
						j++;
					}
				}
				o.close();
				System.out.println(pozycje[i]);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void terminy()
	{
		
			for(int i=1;i<7;i++){
		//	o = new Scanner(new File("w"+i+".txt"));
			//while(o.hasNext())
		//	{
				String s="w"+i+".txt";//o.next();
				
				
				//s.toUpperCase();

				wstawtext(s);
			}
			wyswietlpliki();
			
			//o.close();
			
		
		
		
	}
	
	
}
