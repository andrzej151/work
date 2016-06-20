package Lista;



public class LinkedList implements List {
    private Element _head = new Element(null); // wartownik 
    private int _size;    // dlugość listy

    public LinkedList() 
      { clear();}

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(index<0 || index>_size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        if(_size==0)
        {
        	_head.setNext(null);
        	_head.setValue(value);
        }
        else
        {
	        Element e=getElement(index-1);
	        Element e2=getElement(index);
	        e.setNext(element);
	        element.setNext(e2);
        }
        ++_size;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element;
        if(index==0)
        {
        	element=_head;
        	_head=getElement(1);
        }       
        else
       {
	         element = getElement(index);
	        Element e1=getElement(index-1);
	        Element e2=getElement(index+1);
	        e1.setNext(e2);
       }
        --_size;
        if(_size==0)clear();
        	
        return element.getValue();
    }
    public boolean delete(Object value) {
        Element e=null;
        int index=0;
        while (index<size()){
               
        if (get(index).equals(value)) {
                 delete(index);
                 return true;
            }
        index++;
        
        }
         return false;
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
    	 Element e=null;
         int index=0;
         while (index<size()){
                
         if (get(index).equals(value)) {
                  return index;
                  
             }
         index++;
         
         }
         return -1;
    	
    	
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
        Element element = _head; 
 
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
        
        public Element(Object value, Element n)
        {
        	setNext(n);
        	setValue(value);
        }
        public Element(Object value)
        { setValue(value); setNext(null);}

        public void setValue(Object value)
        { _value = value;  }

        public Object getValue()
        { return _value;   }

        
        public Element getNext()
        { return _next; }

        public void setNext(Element next)
        { _next = next; }

       
        
    }    
    // iterator po wartościach elementów listy
    // bardziej efektywny od zwykłej pętli po indeksach
    private final class ValueIterator implements Iterator{
        private Element _current = _head;
        
        public void first() 
        { _current = _head; }

       public void last() {
			first();
			
			while(_current.getNext()!=null)
			{
				;
			}
			
		}

        public boolean isDone() 
        { return _current==null; }

        public void next() 
        { _current = _current.getNext(); }

        public void previous() //w liscie jednokierunkowej nie ma mozliwosciłatwego cofania
        { 
        	Element e=_current;
        	first();
        	Element przed=null;
        	Element po=(Element)current();
        	while(po.equals(e))
        	{
        		next();
        		przed=po;
        		po=(Element)current();
        	}
        	_current=przed;
        	
        	
        }//_current = _current.getPrevious(); }

        public Object current() throws IndexOutOfBoundsException {
            if (isDone())
                throw new IndexOutOfBoundsException();
            return _current.getValue();
        }



		
		

		

		
    }
}
