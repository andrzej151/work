package Kolejka;



public class Kolejka implements Queue{
	
	private Element _first;
	private int _size;
	
	public Kolejka()
	{
		clear();
		
	}
	
	
	public void enqueue(Object value) {
		if(_size==0)
		{
			_first=new Element(value);
			
		}
		else
		{
			Element e=_first;
			while (e.getNext()!=null) {
				e=e.getNext();
			}
			e.setNext(new Element(value));
		}
		_size++;
	}
	
	public void wyswietl() 
	{
		Element e=_first;
		if(isEmpty())
		{
			System.out.println("pusta");
		}
		else
		{
			while (e!=null) {
				System.out.println(e.getValue());
				e=e.getNext();
			}
		}
	}
	
	public Object dequeue() {
		
		if(isEmpty())
		{
			System.out.println("pusta");
			return null;
		}
		else
		{
			Element e=_first;
			_first=_first.getNext();
			_size--;
			return e.getValue();
			
		}
	}

	
	public void clear() {
		_first=new Element();
		_size=0;
	}

	
	public int size() {
		
		return _size;
	}

	
	public boolean isEmpty() {
		return _size==0;
	}
	
	 // pomocnicza klasa definiuj¹ca element listy   
    private static final class Element {
        private Object _value;
        private Element _next;
        
        public Element()
        {
        	setNext(null);
        	
        }
        
       
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

}
