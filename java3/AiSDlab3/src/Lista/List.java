package Lista;

public interface List 
{
    // dodaj na wskazan¹ pozycjê
    public void insert(int index, Object value) throws IndexOutOfBoundsException;

    // dodaj na koniec
    public void add(Object value);

    //usuñ element ze wskazanej pozycji
    public Object delete(int index) throws IndexOutOfBoundsException;

    // usuñ pierwsze wyst¹pienie wskazanej wartoœci
    public boolean delete(Object value);

    // usuñ wszystkie elementy
    public void clear();

    // zmieñ element na wskazanej pozycji
    public Object set(int index, Object value) throws IndexOutOfBoundsException;
    
    // daj wartoœæ wskazanego elementu
    public Object get(int index) throws IndexOutOfBoundsException;

    // znajdŸ pozycjê podanej wartoœci; -1 gdy nie ma
    public int indexOf(Object value);

    // czy dana wartoœæ wystêpuje na liœcie
    public boolean contains(Object value);

    // liczba elementów na liœcie
    public int size();

    // czy pusta lista
    public boolean isEmpty();
}
