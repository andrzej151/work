package robot;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;
import static java.lang.Math.*;

public class Mapa extends TimerTask{
	
	int wielkosc = 100;
	
	private int [][] tablica_robocza; // tablica glowna (robocza), przechowuje dane o wszytkich polach
	public int [][] tablica_wyswietlana; //z tego program rysuje nasza tablice 20*20 wypelniona bloczkami
	private int haczykx,haczyky;// punkty odniesienia polozone centralnie na mapie 20*20
	
	private Robot robot;
	
	
	
	//Random gen;
	
	
	
	public Mapa()
	{
		//gen = new Random();
		
		robot=new Robot();
		//m=this;
		
		tablica_robocza = new int [wielkosc][wielkosc];
		for(int j=0;j<wielkosc;j++){
			tablica_robocza[0][j]=-1;//gen.nextInt(11);
		}
		
		for(int i=1;i<wielkosc-1;i++){
			tablica_robocza[i][0]=-1;
		
			for(int j=1;j<wielkosc-1;j++){
				tablica_robocza[i][j]=0;//gen.nextInt(11);
			}
			
			tablica_robocza[i][wielkosc-1]=-1;
		}
		
		for(int j=0;j<wielkosc;j++){
			tablica_robocza[wielkosc-1][j]=-1;//gen.nextInt(11);
		}
		
		tablica_robocza[robot.X()][robot.Y()]=robot.V();
		haczykx=50;
		haczyky=50;
		
		
		//wyswietl();
		//Scanner wczytaj= new Scanner(System.in);
		
		//odswierzCzujniki();
		//wczytaj.nextLine();
	}
	

	
	boolean ruchzSystemem(int prosto,Boolean lewo, Boolean prawo,int tyl)
	{
		//1 prosto 0-10 2 lewo t/f 3 prawo t f 4 ty� 
		int r=0;
		
		if((prosto==tyl)&&(prosto==0))
		{
			if((lewo==prawo)&&(lewo=false))
			{
				r=5;//zla dana podano 0 f f 0
			}
			else
			{
				if(lewo==true)
				{
					r=2; //podano 0 t f 0
				}
				else
				{
					r=3; //podano 0 f t 0
				}
			}
		}
		else
		{
			if(prosto>0)
			{
				tablica_robocza[robot.X()][robot.Y()]=0;
				robot.ruchPrzud(prosto);
				if(tablica_robocza[robot.X()][robot.Y()]<128)
				{
					if(((robot.X())<3)||(robot.X()>96)||((robot.Y())<3)||(robot.Y()>96))
					{
						r=7;//koniec mapy
						robot.ruchTyl(prosto);
					}
					else
					{
						r=1;//prosto o prosto
					}
				}
				else 
				{
					
					robot.ruchTyl(prosto);
					r=6;//kolizja
				}
			}
			else
			{
				if(tyl>0)
				{
					
					tablica_robocza[robot.X()][robot.Y()]=0;
					robot.ruchTyl(tyl);
					if(tablica_robocza[robot.X()][robot.Y()]<128)
					{
						if(((robot.X())<3)||(robot.X()>96)||((robot.Y())<3)||(robot.Y()>96))

						{
							r=7;
							robot.ruchPrzud(tyl);	//koniec mapy
						}
						else
						{
							r=4;//tyl o tyl
						}
					}
					else 
					{
						robot.ruchPrzud(tyl); //kolizja
						r=6;
					}
				}
				else
				{
					r=5;
				}
			}
			
		}
		
		switch (r) {
		case 1:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
			
		case 2:
			tablica_robocza[robot.X()][robot.Y()]=0;
			robot.ruchOlewo();
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
		case 3:
			tablica_robocza[robot.X()][robot.Y()]=0;
			robot.ruchOprawo();
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
		case 4:
			
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
		case 5:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			System.out.println("Zly format");
			return false;
			
		case 6:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			System.out.println("Kolizja aaaaaa!!!!!");
			return false;
			
		case 7:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			System.out.println("Dalej nie pojade koniec mapy");
			return false;

		default:
			
			return false;
		}
	}
	
	boolean ruchBezSystemu(int prosto,Boolean lewo, Boolean prawo,int tyl)
	{
		//1 prosto 0-10 2 lewo t/f 3 prawo t f 4 ty� 
		int r=0;
		
		if((prosto==tyl)&&(prosto==0))
		{
			if((lewo==prawo)&&(lewo=false))
			{
				r=5;//zla dana podano 0 f f 0
			}
			else
			{
				if(lewo==true)
				{
					r=2; //podano 0 t f 0
				}
				else
				{
					r=3; //podano 0 f t 0
				}
			}
		}
		else
		{
			if(prosto>0)
			{
				tablica_robocza[robot.X()][robot.Y()]=0;
				robot.ruchPrzud(prosto);
				
					if(((robot.X())<3)||(robot.X()>96)||((robot.Y())<3)||(robot.Y()>96))
					{
						r=7;//koniec mapy
						robot.ruchTyl(prosto);
					}
					else
					{
						r=1;//prosto o prosto
					}
				
			}
			else
			{
				if(tyl>0)
				{
					
					tablica_robocza[robot.X()][robot.Y()]=0;
					robot.ruchTyl(tyl);
					
						if(((robot.X())<3)||(robot.X()>96)||((robot.Y())<3)||(robot.Y()>96))

						{
							r=7;
							robot.ruchPrzud(tyl);	//koniec mapy
						}
						else
						{
							r=4;//tyl o tyl
						}
					
				}
				else
				{
					r=5;
				}
			}
			
		}
		
		switch (r) {
		case 1:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
			
		case 2:
			tablica_robocza[robot.X()][robot.Y()]=0;
			robot.ruchOlewo();
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
		case 3:
			tablica_robocza[robot.X()][robot.Y()]=0;
			robot.ruchOprawo();
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
		case 4:
			
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			return true;
			
		case 5:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			System.out.println("Zly format");
			return false;
			
		case 6:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			System.out.println("Kolizja aaaaaa!!!!!");
			return false;
			
		case 7:
			tablica_robocza[robot.X()][robot.Y()]=robot.V();
			System.out.println("Dalej nie pojade koniec mapy");
			return false;

		default:
			
			return false;
		}
	}
	
	//int poz1=50,poz2=50,kier=1,u=0,z=0;
	
	public void odswierzCzujniki(int lewo,int front ,int prawo, int tyl)
	{
		int[] tab=new int[2];
		robot.setCzujnikLewo(lewo);
		tab=robot.getCzujnikLewo();
			if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]!=-1){
				if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]<255)
				{
					tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]=tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]+1;
				}
			}
		tab=new int[2];
		robot.setCzujnikPrawo(prawo);
		tab=robot.getCzujnikPrawo();
			if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]!=-1){
				if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]<255)
				{
					tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]=tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]+1;
				}
			}
		
		tab=new int[2];
		robot.setCzujnikPrzud(front);
		tab=robot.getCzujnikPrzud();
			if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]!=-1){
				if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]<255)
				{
					tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]=tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]+1;
				}
			}
			
			
		tab=new int[2];
		robot.setCzujnikTyl(tyl);
		tab=robot.getCzujnikTyl();
			if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]!=-1){
				if(tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]<255)
				{
					tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]=tablica_robocza[robot.X()+tab[0]][robot.Y()+tab[1]]+1;
				}
			}
		
	}
	
	public void zapisz(String nazwa) throws FileNotFoundException // zapisywanie tablicy roboczej to pliku
	{
		
		PrintWriter zapis = new PrintWriter(nazwa);
		
		for(int i=0;i<wielkosc;i++){
			for(int j=0;j<wielkosc;j++){
				zapis.print(tablica_robocza[j][i]+" "); 
			}
			zapis.println();
		}
		zapis.close();
	}
	
	
	public void rysujplan() // z tablicy roboczej przekazuje dane do rysowanej tablicy 20*20
	{
		tablica_wyswietlana = new int [20][20];
//		Random r =new Random();
		for(int i=0;i<tablica_wyswietlana.length;i++){
			for(int j=0;j<tablica_wyswietlana.length;j++){
					tablica_wyswietlana[i][j] =tablica_robocza[i+haczykx-10][j+haczyky-10];
			}
		}
//		if(abs(robot.X()-haczykx)>7||abs(robot.Y()-haczyky)>7) // sprawdzenie czy robot nie jest poza dozwolonym obszarem (pole 7*7)
//		{
//			haczykx=robot.X();
//			haczyky=robot.Y();
//		}
//		
//		for(int i=0;i<tablica_wyswietlana.length;i++){
//			for(int j=0;j<tablica_wyswietlana.length;j++){
//					tablica_wyswietlana[i][j] = tablica_robocza[i+haczykx-10][j+haczyky-10];
//			}
//		}
	}
	
	public void wczytaj(String nazwa) throws FileNotFoundException
	{
		Scanner odczyt = new Scanner(new File(nazwa));
		
		for(int i=0;i<wielkosc;i++){
			for(int j=0;j<wielkosc;j++){
				tablica_robocza[i][j]=odczyt.nextInt();
				if(tablica_robocza[i][j]<-1){
					tablica_robocza[i][j]=0;
				}
			}
		}
		tablica_robocza[robot.X()][robot.Y()]=robot.V();
		odczyt.close();
		System.out.println("wczytano");
		
	}
	
	

	

	public void run() {
		//generuj();
		/*
		if(z==20)  //
		{
		if(kier==1){
			
			ruch(1);
			//
			odswierzCzujniki(50,50,50,50);
			u++;
			if(u>15)
				{ruch(2);
				
				u=0;
				}
			
		}
	
		
		z=0;
		}?*/
		//generuj();
		rysujplan();
		Grafika.applet.repaint();
	
		//z++;
		
	}
/*  kolory obraz do testowania grafiki aplikacji
	private void generuj() {
		for(int i=0;i<wielkosc;i++){
			for(int j=0;j<wielkosc;j++){
				plan[i][j]= gen.nextInt(10);
			}
		}	
	}*/





}
