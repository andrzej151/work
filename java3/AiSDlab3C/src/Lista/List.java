package Lista;

public interface List 
{
    // dodaj na wskazan� pozycj�
    public void insert(int index, Object value) throws IndexOutOfBoundsException;

    // dodaj na koniec
    public void add(Object value);

    //usu� element ze wskazanej pozycji
    public Object delete(int index) throws IndexOutOfBoundsException;

    // usu� pierwsze wyst�pienie wskazanej warto�ci
    public boolean delete(Object value);

    // usu� wszystkie elementy
    public void clear();

    // zmie� element na wskazanej pozycji
    public Object set(int index, Object value) throws IndexOutOfBoundsException;
    
    // daj warto�� wskazanego elementu
    public Object get(int index) throws IndexOutOfBoundsException;

    // znajd� pozycj� podanej warto�ci; -1 gdy nie ma
    public int indexOf(Object value);

    // czy dana warto�� wyst�puje na li�cie
    public boolean contains(Object value);

    // liczba element�w na li�cie
    public int size();

    // czy pusta lista
    public boolean isEmpty();
}
