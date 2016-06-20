package Lista;



public class LinkedList implements List {
    private final Element _head = new Element(null); // wartownik 
    private int _size;    // dlugość listy

    public LinkedList() 
      { clear();}

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(index<0 || index>_size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        element.attachBefore(getElement(index));
        ++_size;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElement(index);
       
        --_size;
        return element.getValue();
    }
    public boolean delete(Object value) {
        Element e = _head.getNext();
        while (e != _head && ! value.equals(e.getValue()))
               e = e.getNext();
        if (e != _head) {
                 --_size; return true;
            }
        else return false;
    }

    public void add(Object value) 
    { insert(size(), value); }

    public boolean contains(Object value)
    { return indexOf(value) != -1; }

    public boolean isEmpty() 
    { return _size == 0; }

    public void clear() {
        
        _head.setNext(null);
        _size = 0;
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    public Iterator iterator()
    {  return new ValueIterator(); }

    public int indexOf(Object value) {
        int index = 0;
        Element e = _head.getNext();
        while( value.equals(e.getValue()))
            { e = e.getNext(); ++index; }
        return e!=_head ? index : -1;
    }

    public int size() {
        return _size;
    }
    
    // wybór kierunku przeszukiwania przyspiesza działanie
    // zapamiętanie ostatnio odczytywanego elementu i jego indeksu daje większe przyspieszenie
    private Element getElement(int index) 
     {return getElementForwards(index);  }

    // dojście do podanej pozycji w przód
    private Element getElementForwards(int index) {
        Element element = _head.getNext(); 
 
        for (int i = 0; index > i; i++)
            element = element.getNext();
        return element;
    }

    
    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
    }
    // pomocnicza klasa definiująca element listy   
    private static final class Element {
        private Object _value;
        private Element _next;

        public Element(Object value)
        { setValue(value); }

        public void setValue(Object value)
        { _value = value;  }

        public Object getValue()
        { return _value;   }

        
        public Element getNext()
        { return _next; }

        public void setNext(Element next)
        { _next = next; }

        // wstaw dany (this) element przed element next
        public void attachBefore(Element next) {
            setNext(next);
            
        }
        
    }    
    // iterator po wartościach elementów listy
    // bardziej efektywny od zwykłej pętli po indeksach
    private final class ValueIterator implements Iterator{
        private Element _current = _head;
        public void first() 
        { _current = _head.getNext(); }

       public void last() 
       { _current = _head.getNext(); }

        public boolean isDone() 
        { return _current == _head; }

        public void next() 
        { _current = _current.getNext(); }

       public void previous() 
        { _current = _current.getNext(); }

        public Object current() throws IndexOutOfBoundsException {
            if (isDone())
                throw new IndexOutOfBoundsException();
            return _current.getValue();
        }

		

		
    }
}
