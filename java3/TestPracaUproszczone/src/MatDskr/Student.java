package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Student extends Pytanie{




	public Student() {
		super();
		
		
	}
	public boolean odpowiedz() {
		Scanner in=new Scanner(System.in);
		System.out.println("Imie");
		nazwa=in.next();
		wynagrodzenie.odpS();
		benefity.odpS();
		srednia_wieku.odpS();
		umiejetnosci.odpS();
		czaspracy.odpS();
		priorytet();
		return true;
	}


	void wyswietl()
	{
		System.out.println("Student "+nazwa);
		wynagrodzenie.wyswietl();
		benefity.wyswietl();
		srednia_wieku.wyswietl();
		umiejetnosci.wyswietl();
		czaspracy.wyswietl();
		
	}
	
	
	public double[] wyniki(Firma f) {
		double[] wynik = new double[6];
		try {
			wynik[1] = wynagrodzenie.wynik(f.wynagrodzenie);
			wynik[2] = benefity.wynik(f.benefity);
			wynik[3] = srednia_wieku.wynik(f.srednia_wieku);
			wynik[4] = umiejetnosci.wynik(f.umiejetnosci);
			wynik[5] = czaspracy.wynik(f.czaspracy);
			
			int suma=0;
			for (int i = 0; i < priorytet.length; i++) {
				suma+=priorytet[i];
			}
			double waga=100/suma;
			for (int i = 1; i < wynik.length; i++) {
				wynik[0]+=priorytet[i-1]*waga*wynik[i];
			}
			
		} catch (Exception e) {
			System.out.println("Blad\n"+e.getMessage());
		}

		return wynik;
	}
	
}
