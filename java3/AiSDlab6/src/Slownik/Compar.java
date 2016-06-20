package Slownik;

public class Compar implements Comparator {
	
	public  Compar() {
		
	}
	@Override
	public int compare(Object left, Object right) throws ClassCastException {
		
		
			return ((String)(left)).compareTo((String)right);
			
		
		
	}

	
}