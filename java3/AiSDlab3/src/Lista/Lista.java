package Lista;

import java.util.Scanner;

public class Lista {

	private LinkedList lista;
	private Scanner odczyt;
	
	public Lista()
	{
		odczyt=new Scanner(System.in);
		lista=new LinkedList();
	}
	public void insert() {
		String value=null;
		int index=-1;
		
		do{
		System.out.println("Wstaw");
		 value=odczyt.next();
		}while(value==null);
		
		do{
		System.out.println("Na pozycje");
		index=odczyt.nextInt();
		}while(index<0);
		
		lista.insert(index, value);
		wyswietl();
	}

	public void add() {
		String value=null;
		
		do{
		System.out.println("Wstaw");
		 value=odczyt.next();
		}while(value==null);
		
		lista.add(value);
		wyswietl();
		
	}

	public void deleteIndex() {
		int index=-1;
		do{
			System.out.println("Usun z pozycji");
			index=odczyt.nextInt();
			}while(index<0);
		System.out.println("Usuniento: "+lista.delete(index));
		
	}

	public void deleteObj() {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		lista.clear();
		System.out.println("Wyczyszczono");
		
	}

	public void zmien() {
		String value=null;
		int index=-1;
		
		do{
		System.out.println("Wstaw");
		 value=odczyt.next();
		}while(value==null);
		
		do{
		System.out.println("Na pozycje");
		index=odczyt.nextInt();
		}while(index<0);
		
		System.out.println("Byl: "+lista.set(index, value));
	}

	public void wyswietl() {
		int i=0;
		if(lista.isEmpty())
		{
			System.out.println("Pusta");
		}
		else
		{
			while(i<lista.size())
			{
				System.out.println(i+"-"+lista.get(i));
				i++;
			}
		}
	}

	
	public void pobierz() {
		int index=-1;
		do{
			System.out.println("Na pozycji");
			index=odczyt.nextInt();
			}while(index<0);
		System.out.println("Jest: "+lista.get(index));
		
	}

	public void znajdzIndex() {
		
		String value=null;
		
		do{
		System.out.println("Co szukac?");
		 value=odczyt.next();
		}while(value==null);
		
		System.out.println("Jest na pozycji: "+lista.indexOf(value));
		
	}

	public void czyjest() {
		
		String value=null;
				
			do{
			System.out.println("Co szukac?");
			 value=odczyt.next();
			}while(value==null);
		if(lista.contains(value))
		{
			System.out.println("Jest");
		}
		else
		{
			System.out.println("Nie ma");
		}
	}

	public void rozmiar() {
		
		System.out.println("Rozmiar listy wynosi: "+lista.size());
		
	}

	public void empty() {
		
		if(lista.isEmpty())
		{
			System.out.println("Pusta");
		}
		else
		{
			System.out.println("NIE Pusta");
		}
		
	}
	
	public void wyswietlIteratorem() {
		Iterator it= lista.iterator();
	    it.first();
	     while(!it.isDone())
	      { String t=(String)it.current();
	        System.out.println();
	        it.next();
	      }
	     
		
	}

}
