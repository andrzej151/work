package Kolejka;

import java.util.Scanner;

public class Lista {

	Kolejka k;
	Stos s;
	StosArray sa;
	Scanner odczyt2;
	
	public Lista()
	{
		k=new Kolejka();
		s=new Stos();
		sa=new StosArray(10);
		odczyt2=new Scanner(System.in);
	}

	public void pusch1() {
		System.out.println("co odlorzyc");
		String value=odczyt2.next();
		k.enqueue(value);
		wyswietl6();
		
	}

	public void pop2() {
		System.out.println(k.dequeue());
		
	}

	public void clear3() {
		k.clear();
		System.out.println("wyczyszczono");
		
	}

	public void size4() {
		System.out.println("wielkosc wynosi: "+k.size());
	}

	public void empty5() {
		System.out.println(k.isEmpty());
		
	}

	public void wyswietl6() {
		k.wyswietl();
		
	}
	
	public void pusch7(){
		System.out.println("co odlorzyc");
		String value=odczyt2.next();
		s.push(value);
		wyswietl13();
	}
	
	public void pop8()
	{
		System.out.println("Sciagnieto "+s.pop());
		wyswietl13();
	}
	
	public void perk9()
	{
		System.out.println("Wartosc: "+s.peek());
		wyswietl13();
	}

	public void wyswietl13() {
		
		s.wyswietl();
		
	}

	public void pusty12() {
		System.out.println(s.isEmpty());
		
	}

	public void size11() {
		System.out.println(s.size());
		
	}

	public void clear10() {
		s.clear();
		
	}

	public void pusch14() {
		System.out.println("co odlorzyc");
		String value=odczyt2.next();
		sa.Push(value);
		sa.wyswietl();
		
	}

	public void pop15() {
		System.out.println("Sciagnieto "+sa.Pop());
		sa.wyswietl();
		
	}

	public void perk16() {
		System.out.println("Wartosc "+sa.peek());
		sa.wyswietl();
		
	}

	public void clear17() {
		sa.clear();
		System.out.println("wyczyszczono");
		
	}

	public void size18() {
		System.out.println(sa.size());
		
	}

	public void empty19() {
		System.out.println(sa.isEmpty());
		
	}

	public void wyswietl20() {
		sa.wyswietl();
		
	}

	public void nowa21() {
		System.out.println("Podaj nowa wielkosc stosu");
		int value=odczyt2.nextInt();
		sa=new StosArray(value);
		
	}
	

}
