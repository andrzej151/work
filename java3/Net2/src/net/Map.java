package net;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TimerTask;



public class Map extends TimerTask{
	public int [][] tab;
	int[]u;
	int r;
	String[][] zap;
	
	
	int zx,zy,p,hx,hy;
	
	int wielkosc=30;
	
	
	public  Map() {
		// TODO Auto-generated constructor stub
		tab=new int[wielkosc][wielkosc];
		for(int i=0;i<wielkosc;i++){
			for(int j=0;j<wielkosc;j++){
				if(j==i){tab[i][j]=1;}
				if(i<j){tab[i][j]=3;}
				if(j<i){tab[i][j]=0;}
			
			}
			
		}
		u=new int[wielkosc];
		r=0;
		
		zap=new String [wielkosc*2][wielkosc/2];

		zx=0;
		zy=0;
		p=tab[zx][zy];
		
		hx=0;hy=0;
	}
	public void nowarunda()
	{
		hx=0;
		hy++;
		for(int i=0;i<wielkosc;i++){
			u[i]=1+i;
		}
		r++;
		wyczysc();
	}
	
	private void wyczysc() {
		// TODO Auto-generated method stub
		for(int i=0;i<wielkosc;i++){
			for(int j=0;j<wielkosc;j++){
				
			if(tab[i][j]==5){
				if(j==i){tab[i][j]=1;}
				if(i<j){tab[i][j]=3;}
				if(j<i){tab[i][j]=0;}
			}}}
	}
	public boolean ruch(int r)
	{
		switch (r) {
		case 1:
			
			if(zy>0)
				{
				zy--;
				return true;
				}
			else
			{
				return false;
			}
			
			
		
			
	case 2:
			
			
			if(zx<wielkosc-1)
				{
				zx++;
				return true;
				}
			else
			{
				return false;
			}
						
			
	case 3:
		
		
		if(zx>0)
		{
			zx--;
			return true;
			}
		else
		{
			return false;
		}
		
		
	
	case 4:
		
		
		if(zy<wielkosc-1)
		{
			zy++;
			return true;
			}
		else
		{
			return false;
		}
	

		default:
			break;
		}
		return false;
	}

	
		
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Grafika.applet.repaint();
	}
	public void zatwierdc() {
		// TODO Auto-generated method stub
		if(tab[zx][zy]==3){
			
			tab[zx][zy]=4;
			 if(zx<9){
				 zx++;
			 zap[hy][hx]="0"+zx+" ";
			 	zx--;
			 }
			 else{
				 zx++;
				 zap[hy][hx]=zx+" ";
				 	zx--;
			 }
				
			 if(zy<9){
				 zy++;
				 zap[hy][hx]=zap[hy][hx]+"0"+zy;
				 zy--;
				 }
				 else{
					 zy++;
					 zap[hy][hx]=zap[hy][hx]+zy;
					 zy--;
				 }
			 hx++;
			
					for(int j=0;j<wielkosc;j++){
						if(tab[zx][j]!=4){
						tab[zx][j]=5;}
					}
					for(int j=0;j<wielkosc;j++){
						if(tab[j][zx]!=4){
						tab[j][zx]=5;}
					}
					for(int j=0;j<wielkosc;j++){
						if(tab[zy][j]!=4){
						tab[zy][j]=5;}
					}
					for(int j=0;j<wielkosc;j++){
						if(tab[j][zy]!=4){
						tab[j][zy]=5;}
					}
	}
		
		
	}
	public void zapisz() throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter zapis = new PrintWriter("kombinacja"+wielkosc+".txt");
	
		for(int i=0;i<wielkosc*2;i++){
			for(int j=0;j<wielkosc/2;j++){
				if(zap[i][j]!=null){
				zapis.print(zap[i][j]+"  ");
				}
				else
				{
					zapis.print("00 00  ");	
				}
			}
			zapis.println();
			}
		zapis.close();
			
		
	}
	public void zer()
	{
		zy=0;
		zx=0;
	}
	public void rozwiaz() {
		// TODO Auto-generated method stub
		
		boolean pion=true,poziom=true;
		
		while(pion)
		{
			poziom=true;
			while(poziom)
			{
				
				zatwierdc();
				poziom=ruch(2);
				
			}
			poziom=true;
			pion=ruch(4);
			while(poziom)
			{
				
				zatwierdc();
				poziom=ruch(3);
				
				
			}
		}
		
	}
		
}
