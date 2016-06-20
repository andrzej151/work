package Dysk;

public class ArrayList implements List
{   // domyœlna wielkoœæ pocz¹tkowa tablicy
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // bie¿¹ca wielkoœæ tablicy
    private final int _initialCapacity;
    private Object[] _array;
    // d³ugoœæ listy 
    private int _size;

    public ArrayList() 
    { this(DEFAULT_INITIAL_CAPACITY); }

    public ArrayList(int initialCapacity) {
       _initialCapacity = initialCapacity;
        clear(); // tworzy pust¹ tablicê o podanym rozmiarze
    }

    public ArrayList(Object[] array) {
        _initialCapacity = array.length;
        clear();
        System.arraycopy(array, 0, _array, 0, array.length);
        _size = array.length;
    }

    //jeœli trzeba powiêksz tablicê; value nie mo¿e byæ null
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(index<0 || index>_size) throw new IndexOutOfBoundsException();
        ensureCapacity(_size + 1);
        System.arraycopy(_array, index, _array, index + 1, _size - index);
        _array[index] = value;
        ++_size;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Object value = _array[index];
        int copyFrom = index + 1;
        if (copyFrom < _size)
            System.arraycopy(_array, copyFrom, _array, index, _size - copyFrom);
        --_size;
        return value;
    }

    public boolean delete(Object value) {
        int index = indexOf(value);
        if (index != -1)
            delete(index);
        return index != -1;
    }

    public void add(Object value) {
        insert(size(), value);
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public void clear() {
        _array = new Object[_initialCapacity];
        _size = 0;
    }
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Object oldValue = _array[index];
        _array[index] = value;
        return oldValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return _array[index];
    }

    public int indexOf(Object value) {
        int i =0; 
        while(i < _size && value.equals(_array[i]))
              ++i;
        return i<_size ? i : -1;
    }

    public Iterator iterator() {
        return new ArrayIterator(_array, 0, _size);
    }

    public int size() {
        return _size;
    }
    
// wykorzystywana przy wstawianiu; 
    private void ensureCapacity(int capacity) {
          if (_array.length < capacity) {
            Object[] copy = new Object[capacity + capacity / 2];
            System.arraycopy(_array, 0, copy, 0, _size);
            _array = copy;
        }
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
        {  System.out.println("blad"+index);
        throw new IndexOutOfBoundsException();}
        }
}
