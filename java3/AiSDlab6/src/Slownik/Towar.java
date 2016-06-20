package Slownik;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Towar {
	
		public String nazwa;
		public String klasa;
		public Double ilosc;
		public Double cena;
		public Double wartosc;
		
	public Towar()
	{
		
		
	}
	public Towar(String nazwa,Double ilosc,Double cena,Double wartosc)
	{
		this.nazwa=nazwa;
		this.ilosc=ilosc;
		this.cena=cena;
		this.wartosc=wartosc;
	}

	public Towar(String nazwa,Double ilosc,Double cena, String klasa)
	{
		this.nazwa=nazwa;
		this.ilosc=ilosc;
		this.cena=cena;
		this.wartosc=0.0;
		this.klasa=klasa;
	}
	public String toString()
	{
		NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        
		return nazwa+"\t"+nf.format(ilosc)+"\t"+nf.format(cena)+"\t"+klasa;
	}
	
	public int PoCenie(Object other) {
		return (int)(this.cena-((Towar)other).cena);
		
	}
	public int PoIlosci(Object other) {
		return (int)(this.ilosc-((Towar)other).ilosc);
		
	}
	
	public int PoNazwie(Object other) {
		
		return (this.nazwa.compareTo(((Towar)other).nazwa));
	}
	
	public int PoKlasie(Object other) {
		
		return (this.klasa.compareTo(((Towar)other).klasa));
	}
	
}
