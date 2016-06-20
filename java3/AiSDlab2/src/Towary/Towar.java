package Towary;

import java.text.NumberFormat;
import java.util.Scanner;

public class Towar {
	
	public String nazwa;
	public Double ilosc;
	public Double cena;
	public Double wartosc;
	
public Towar()
{
	
	//0 nazwa
	//1 ilosc
	//2 cena
	//3 wartosc
}
public Towar(String nazwa,Double ilosc,Double cena,Double wartosc)
{
	this.nazwa=nazwa;
	this.ilosc=ilosc;
	this.cena=cena;
	this.wartosc=wartosc;
}


public String toString()
{
	NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(2);
    
	return nazwa+"\t"+nf.format(ilosc)+"\t"+nf.format(cena)+"\t"+nf.format(wartosc);
}



}