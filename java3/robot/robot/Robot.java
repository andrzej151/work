package robot;


import java.util.Scanner;

public class Robot {
	private int [] pozycja; //XYV
	private int [] czujnikLewo;//XY
	private int [] czujnikPrawo;
	private int [] czujnikTyl;
	private int [] czujnikPrzud;
	
	
	
	public Robot()
	{
		pozycja=new int[3];//x y V
		setpozycja(50,50,-2);
		
		
		czujnikLewo=new int[2];
		czujnikPrawo=new int[2];
		czujnikTyl=new int[2];
		czujnikPrzud=new int[2];
		
		
		//System.out.println(this.p.V());
		//Scanner o=new Scanner(System.in);
		//o.next();
		
				
	}
	
	void setpozycja(int x, int y, int v) {
		
		this.pozycja[0]=x;
		this.pozycja[1]=y;
		this.pozycja[2]=v;
	}
	
	public int X()
	{
		return this.pozycja[0];
	}	
	public int Y()
	{
		return this.pozycja[1];
	}
	public int V()
	{
		return this.pozycja[2];
	}
	
	private  void sV(int i)
	{
		this.pozycja[2]=i;
	}
	
	public void ruchPrzud(int ilekratek) //[0]=x [1]=y
	{
		switch (this.V()) {
		case -2:
			pozycja[1]=pozycja[1]-ilekratek; // ruch do przodu 
			break;

		case -3:
			pozycja[0]=pozycja[0]+ilekratek;// ruch w prawo
			break;
			
		case -5:
			pozycja[1]=pozycja[1]+ilekratek; // ruch do tylu
			break;

		case -4:
			pozycja[0]=pozycja[0]-ilekratek; // ruch w lewo
			break;
		}
	}
	
	public void ruchTyl(int ilekratek)
	{
		switch (this.V()) {
		case -2:
			pozycja[1]=pozycja[1]+ilekratek;
			break;

		case -3:
			pozycja[0]=pozycja[0]-ilekratek;
			break;
			
		case -5:
			pozycja[1]=pozycja[1]-ilekratek;
			break;

		case -4:
			pozycja[0]=pozycja[0]+ilekratek;
			break;
		}
	}

	public void ruchOlewo() //przciw wskazowka zegara
	{
		switch (this.V()) {
		case -2:
			sV(-4);
			break;

		case -3:
			sV(-2);
			break;
			
		case -4:
			sV(-5);
			break;	
			
		case -5:
			sV(-3);
			break;
		}
	}
	
	public void ruchOprawo() // wskazowka zegara ok
	{
		switch (this.V()) {
		case -2:
			sV(-3);
			break;

		case -3:
			sV(-5);
			break;
			
		case -4:
			sV(-2);
			break;	
			
		case -5:
			sV(-4);
			break;

	
		}
	}
	
	public void odbierz(int sprzedni,int slewy, int sprawy, int stylni,int ruch)
	{
		
		
	}
	
	
	

	public int [] getCzujnikPrzud() {
		return czujnikPrzud;
	}
	public int [] getCzujnikLewo() {
		return czujnikLewo;
	}
	public int [] getCzujnikTyl() {
		return czujnikTyl;
	}
	public int [] getCzujnikPrawo() {
		
		return czujnikPrawo;
	}
	
	
	public void setCzujnikPrzud(int  infPrzud) {
		if(infPrzud>=20&&infPrzud<=90)
		{
			infPrzud=infPrzud/10;
			czujnikPrzud=new int[2];
			switch (this.V()) {
			case -2:
				this.czujnikPrzud[0]=0;
				this.czujnikPrzud[1]=-infPrzud;
				break;
			case -3:
				this.czujnikPrzud[0]=infPrzud;
				this.czujnikPrzud[1]=0;
				break;
			case -4:
				this.czujnikPrzud[0]=-infPrzud;
				this.czujnikPrzud[1]=0;
				break;
			case -5:
				this.czujnikPrzud[0]=0;
				this.czujnikPrzud[1]=infPrzud;
				break;
	
			default:
				System.out.println("nie mozesz");
				break;
			}
			
			
		}
		else
		{
			System.out.println("Z�a dana");
		}
	}
	



	public void setCzujnikLewo(int  infLewo) {
		if(infLewo>=20&&infLewo<=90)
		{
			
		//for(int i=15;i<90;i++){
			int x=(int)(((infLewo*0.5)/10));	// sin 30 stopni
			int y=(int)((infLewo*0.86603/10)); //cos 30 stopni
		/*
			System.out.println(i+" "+x+" "+y);
			}
		
			Scanner o=new Scanner(System.in);
			o.nextLine();
			*/
			czujnikLewo=new int[2];
			switch (this.V()) {
			case -2:
				this.czujnikLewo[0]=-x;
				this.czujnikLewo[1]=-y;
				break;
			case -3:
				this.czujnikLewo[0]=y;
				this.czujnikLewo[1]=-x;
				break;
			case -4:
				this.czujnikLewo[0]=-y;
				this.czujnikLewo[1]=x;
				break;
			case -5:
				this.czujnikLewo[0]=x;
				this.czujnikLewo[1]=y;
				break;
	
			default:
				System.out.println("nie mozesz");
				break;
			}
			
			
		}
		else
		{
			System.out.println("Z�a dana");
		}
	}



	public void setCzujnikPrawo(int infPrawo) {
		if(infPrawo>=20&&infPrawo<=90)
		{
			
	
			//for(int i=15;i<90;i++){
			int x=(int)(infPrawo*0.5/10);
			int y=(int)((infPrawo*0.86603)/10);
			/*
			System.out.println(i+" "+x+" "+y);
			}
			Scanner o=new Scanner(System.in);
			o.nextLine();
			*/
			czujnikPrawo=new int[2];
			switch (this.V()) {
			case -2:
				this.czujnikPrawo[0]=x;
				this.czujnikPrawo[1]=-y;
				break;
			case -3:
				this.czujnikPrawo[0]=y;
				this.czujnikPrawo[1]=x;
				break;
			case -4:
				this.czujnikPrawo[0]=-y;
				this.czujnikPrawo[1]=-x;
				break;
			case -5:
				this.czujnikPrawo[0]=-x;
				this.czujnikPrawo[1]=y;
				break;
	
			default:
				System.out.println("nie mozesz");
				break;
			}
			
			
		}
		else
		{
			System.out.println("Z�a dana");
		}
	}


	public void setCzujnikTyl(int  infTyl) {
		if(infTyl>=20&&infTyl<=90)
		{
			infTyl=infTyl/10;
			czujnikTyl=new int[2];
			switch (this.V()) {
			case -2:
				this.czujnikTyl[0]=0;
				this.czujnikTyl[1]=infTyl;
				break;
			case -3:
				this.czujnikTyl[0]=-infTyl;
				this.czujnikTyl[1]=0;
				break;
			case -4:
				this.czujnikTyl[0]=infTyl;
				this.czujnikTyl[1]=0;
				break;
			case -5:
				this.czujnikTyl[0]=0;
				this.czujnikTyl[1]=-infTyl;
				break;
	
			default:
				System.out.println("nie mozesz");
				break;
			}
			
			
		}
		else
		{
			System.out.println("Z�a dana");
		}
	}
	

}
