package Zbiory;

import java.util.Scanner;

public class Obliczeniowe {
	Zbior[] zbiory;
	Zbior[] profile;
	Zbior uniwersum;
	double[][] obliczenia;
	Scanner odczyt2;
	
	public Obliczeniowe() {
		odczyt2=new Scanner(System.in);
		ZdefiniujUniwersum();
		Zdefiniujzbiory();
		ZdefiniujProfile();
		Stworzsrodowisko();
		
		
	}
	public void ZdefiniujUniwersum()
	{
		System.out.println("Uniwersum");
		uniwersum=new Zbior();
	}
	public void Zdefiniujzbiory()
	{
		System.out.println("ile bedzie zbiorow?" );
		int w=odczyt2.nextInt();
		zbiory=new Zbior[w];
		for(int i=0;i<w;i++)
		{
			zbiory[i]=new Zbior(); 
		}
		
		
	}
	public void ZdefiniujProfile()
	{
		System.out.println("ile bedzie profilow?" );
		int w=odczyt2.nextInt();
		profile=new Zbior[w];
		for(int i=0;i<w;i++)
		{
			profile[i]=new Zbior(); 
		}
		
		
	}
	public void Stworzsrodowisko()
	{
		obliczenia=new double[zbiory.length][profile.length];
	}
	
	public void wyswietl()
	{
		System.out.println("Uniwersum "+uniwersum);
		System.out.println("Zbiory");
		for(int i=0;i<zbiory.length;i++)
		{
			System.out.println("Z"+i+" "+zbiory[i]);
		}
		System.out.println("Profile");
		for(int i=0;i<profile.length;i++)
		{
			System.out.println("P"+i+" "+profile[i]);
		}
		System.out.println("..........................");
		System.out.print("\\ |");
		
		for(int i=0;i<zbiory.length;i++)
		{
			System.out.print("|  Z"+i);
		}
		System.out.println();
		for(int j=0;j<profile.length;j++)
			{
		for(int i=0;i<zbiory.length;i++)
		{
			System.out.print("P"+i+"|");
			
				System.out.print("| "+obliczenia[i][j]);
			}
			System.out.println();
		}
		
	}
	public void jacard() {
		for(int i=0;i<zbiory.length;i++)
		{
			
			for(int j=0;j<profile.length;j++)
			{
				obliczenia[i][j]=zbiory[i].jacard(profile[j]);
			}
			
		}
		
	}
	public void dice2() {
		for(int i=0;i<zbiory.length;i++)
		{
			
			for(int j=0;j<profile.length;j++)
			{
				obliczenia[i][j]=zbiory[i].dice2(profile[j]);
			}
			
		}
		
	}
	public void sumsym() {
		for(int i=0;i<zbiory.length;i++)
		{
			
			for(int j=0;j<profile.length;j++)
			{
				obliczenia[i][j]=zbiory[i].sumasymetryczna(profile[j]);
			}
			
		}
		
	}
	
	

}
