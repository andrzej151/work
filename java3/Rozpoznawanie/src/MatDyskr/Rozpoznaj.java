package MatDyskr;

public class Rozpoznaj {
	Wykres czerwony;
	Wykres pomaranczowy;
	Wykres zolty;
	Wykres zielony;
	Wykres niebieski;
	Universum kolory;
	
	void clear()
	{
		kolory=new Universum("kolory");
		kolory.ustawNazwyElementow("nazwy");
		czerwony=new Wykres("czerwony");
		czerwony.wstaw(0, 100, "0");
		czerwony.wstaw(100, 255, "x");
	}
}
