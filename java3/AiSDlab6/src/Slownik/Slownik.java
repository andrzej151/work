package Slownik;

public class Slownik {
	
	private String[] slownik; 
	private String[] pom;
	private int index;
	
	public Slownik() {
		pom=new String[5];
		index=0;
		slownik=null;
	}
	public boolean czyPelnaPom()
	{
		return !(index==pom.length);
	}
	
	public Object szukaj2(String nazwa)
	{
		int i=0;
		while(i<slownik.length)
		{
			if(slownik[i].equals(nazwa))
		{
			System.out.println("znaleziono na poz "+i);
			return slownik[i];
		}
			i++;
		}
		
		return -1;
	}
	
	public void wyswietl() {
		System.out.println("pom");
		for(int i=0;i<pom.length;i++)
		{
			System.out.println(i+" "+pom[i]);
		}
		System.out.println("slownik");
		if(slownik!=null)
		{
			for(int i=0;i<slownik.length;i++)
			{
				System.out.println(i+" "+slownik[i]);
			}
		}
		
		
	}
//	public Object szukaj(String nazwa) {
//		int lower = 0;
//	    int upper = slownik.length - 1;
//	    int index=0,cmp=0;
//	    while (lower <= upper && 
//	          (cmp = _comparator.compare(value, list.get(index=(lower + upper)/2)))!=0)
//	      if (cmp < 0) upper = index - 1;
//	      else lower = index + 1;
//	    return lower<=upper && cmp==0 ? index : -(lower+1);
//	    } 
//}
	public Object szukaj(String nazwa) {
		int a=0,b=slownik.length-1;
		int srodek;
		while(b-a>2)
		{
			System.out.println(a+" "+b+" "+b/2);
			if(slownik[b/2].equals(nazwa))
			{
				System.out.println("Znaleziono na pozycji "+b/2);
				return slownik[b/2];
			}
			else
			{
				if(slownik[a].equals(nazwa))
				{
					System.out.println("Znaleziono na pozycji "+a);
					return slownik[a];
				}
				if(slownik[b].equals(nazwa))
				{
					System.out.println("Znaleziono na pozycji "+b);
					return slownik[b];
				}
				
				if(slownik[b/2].compareTo(nazwa)<0)
				{
					a=(a+b)/2;
				}
				else
				{
					b=(a+b)/2;
				}
			}
		}
		
		
		return -1;
	}
	
	
	
	public void scal() {
		
		
		if(slownik==null)
		{
			slownik=pom;
			pom=new String[5];
		}
		else
		{
			String[] nowyslownik=new String[slownik.length+index];
			int ipom=0,isl=0;
			for(int i=0;i<nowyslownik.length;i++)
			{
				if(isl>slownik.length-1)
				{
					nowyslownik[i]=pom[ipom];
					ipom++;
				}
				else
				{
					if(ipom>index-1)
					{
						nowyslownik[i]=slownik[isl];
						isl++;
					}
					else
					{
						if(pom[ipom].compareTo(slownik[isl])<=0)
						{
							nowyslownik[i]=pom[ipom];
							ipom++;
						}
						else
						{
								nowyslownik[i]=slownik[isl];
								isl++;
						}
					}
				}
				//System.out.println(nowyslownik[i]+" "+i+" g "+isl+" p "+ipom);
			}
			pom= new String[5];
			slownik=nowyslownik;
		}
		index=0;
		
	}

	public void sortuj() {
		Comparator comparator=new Compar();
		//QuickSort sort=new QuickSort(comparator);
		InsertSort sort=new InsertSort(comparator);
		sort.sort(pom);
		wyswietl();
		
	}

	public void wstaw(String nazwa) {
		if(czyPelnaPom())
		{//wstawianie na pom
			pom[index]=nazwa;
			index++;
		}
		else 
		{//wstawianie do slownika
			System.out.println("przesun na slownik");
			sortuj();
			scal();
			pom[index]=nazwa;
			index++;
		}
		wyswietl();
		
	}

}
