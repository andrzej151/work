package Towary;

public class Compar implements Comparator {
	int ustawienia;//1 po nazwie 2 po cenie 3 po wielu
	public  Compar(int ustawienia) {
		this.ustawienia=ustawienia;
	}
	@Override
	public int compare(Object left, Object right) throws ClassCastException {
		
		switch (ustawienia) {
		case 1:
			return ((Towar)left).PoNazwie(right);
			
		case 2:
			return ((Towar)left).PoCenie(right);
			
		case 3:
			if(((Towar)left).PoKlasie(right)==0)
			{
				if(((Towar)left).PoNazwie(right)==0)
				{
					if(((Towar)left).PoCenie(right)==0)
					{
						
							return ((Towar)left).PoIlosci(right);
						
					}
					else
					{
						return ((Towar)left).PoCenie(right);
					}
				}
				else
				{
					return ((Towar)left).PoNazwie(right);
				}
			}
			else
			{
				return ((Towar)left).PoKlasie(right);
			}
			
		default:
			
			break;
		}
		
		return 0;
		
	}

	
}