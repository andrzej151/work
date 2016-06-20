package Dysk;



class Filtry implements Predicate
{ 
	int wskaz;
	int czas;
	public Filtry()
	{
		wskaz=0;
	}
	public void setCzas(int czas)
	{
		wskaz=1;
		this.czas=czas;
	}
	public boolean accept(Object ob) {
		switch (wskaz) {
		case 1:
			return ((Proces)ob).getCzasDodaia()==czas;
			

		default:
			break;
		}
		return false;
		}
} 
