package Drzewa234;

import java.util.Scanner;

public class SrodowiskoDrzew {

	Drzewo234 drb;
	int klucz;

	public SrodowiskoDrzew() {

		drb = new Drzewo234();
	}

	public void wstaw() {
		Scanner o = new Scanner(System.in);
		System.out.println("Co wstawic");
		klucz = o.nextInt();
		drb.insert(klucz);

	}

	public void wyswietl() {
		drb.wyswietlpoziomami();
	}

	public void max() {
		System.out.println(drb.max());
	}

	public void min() {
		System.out.println(drb.min());
	}

	public void usun(int klucz) {
		drb.usun(klucz);
	}

	public void a() {
		drb.insert(20);
		drb.insert(10);
		drb.insert(15);
		drb.insert(18);
		drb.insert(25);
		drb.insert(16);
		drb.insert(12);
	}

	public void szukaj() {
		// TODO Auto-generated method stub

	}

}
