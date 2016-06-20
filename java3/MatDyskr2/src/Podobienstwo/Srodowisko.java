package Podobienstwo;

import java.util.ArrayList;

public class Srodowisko {
	private ArrayList<String> teksty;
	private ArrayList<String> klucze;
	
	public void Srodowisko()
	{
		teksty=new ArrayList<String>();
		klucze=new ArrayList<String>();
	}
	
	public void wstawtext(String nazwa) {
		
		teksty.add(nazwa);
		
	}
	

	public void wstawslowoklucz(String nazwa) {
		klucze.add(nazwa);
		
	}

}
