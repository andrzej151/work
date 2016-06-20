package Kolejka;

import java.util.Arrays;

public class StosArray implements Stack{
	
	private String[]  _Array;
	private int _size;

	 
	    
	    
	    public  StosArray(int MaxRozmiar) {
	        _Array = new String[MaxRozmiar];
	        _size = 0;
	    }
	 
	   
	   
	    public boolean isEmpty() 
	    {
	        return _size == 0;
	    }
	 
	    
	    public int size() 
	    {
	        return _size;
	    }
	 
	    
	  public  void Push(String E) 
	    {
	        if (_size < _Array.length) 
	        {
	            _Array[_size] = E;
	            _size++;
	 
	        } 
	        else 
	        {
	            System.out.println("Przepe³nienie stosu");
	        }
	    }
	 
	   
	    public String Pop() 
	    {
	        if (_size <= 0) {
	            System.out.println("Stos jest pusty");
	            return null;
	        }
	        else
	        {
		        String pom = _Array[_size - 1];
		        _size--;
		        return pom;
	        }
	    }
	 
	    
	    public void wyswietl()
	    {
	        if (_size == 0) {
	        	System.out.println("Stos jest pusty");
	        }
	 
	        else
	        {
		        int pom = _size - 1;
		        do {
		            System.out.println(_Array[pom]);
		            pom--;
		        } while (pom > -1);
	        }
	    }
	 
	   
	 
	   
	    public void clear() {
	        for (int i = 0; i < _size; i++) {
	            _Array[i] = null;
	 
	        }
	 
	        _size = 0;
	    }



		public Object peek() {

	        if (_size <= 0) {
	            System.out.println("Stos jest pusty");
	            return null;
	        }
	        else
	        {
		        String pom = _Array[_size - 1];
		       
		        return pom;
	        }
		}



		@Override
		public void enqueue(Object value) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public Object dequeue() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public void push(Object value) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public Object pop() {
			// TODO Auto-generated method stub
			return null;
		}
	



}
