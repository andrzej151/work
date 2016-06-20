package Haszowanie;



public class Haszkwadratowe {

	Node _root;
	
	public Haszkwadratowe() {
		// TODO Auto-generated constructor stub
	}
	
    class Node{
      int []value;
      Node []next;
      int ilosc;
      int poziom;
      
      Node(int x)
      { 
    	  value=new int[3];
    	  next=new Node[4];
    	  value[0]=x;
    	  ilosc=1;
    	 
      }
      
      Node()
      { 
    	  value=new int[3];
    	  next=new Node[4];
    	  ilosc=0;
      }
      
     boolean wstaw(int x) throws Exception
      { 
    	  switch (ilosc) {
		case 0:
			value[0]=x;
			return false;
		case 1:
			if(x<value[0])
			{
				value[1]=value[0];
				value[0]=x;
			}
			else
			{
				value[1]=x;
			}
			ilosc++;
			return false;
		case 2:
			if(x<value[0])
			{
				value[2]=value[1];
				value[1]=value[0];
				value[0]=x;
			}
			else
			{
				if(x<value[2])
				{
					value[2]=value[1];
					value[1]=x;
				}
				else
				{
					value[2]=x;
				}
			}
			ilosc++;
			return true;

		}
    	  throw new Exception("blad wstawiania") ;
      }
     
      boolean lisc()
      {
    	  boolean lisc=true;
    	  for (int i = 0; i < next.length; i++) {
    		  if(next[i]!=null)lisc=false;
		}
    	  return lisc;
      }
      
    	public String toString() {
    		String s="["+poziom+"]["+value[0]+"|"+value[1]+"|"+value[2]+"]";
    		
    		return s;
    	}
    }

	public void szukaj(int klucz) {
		// TODO Auto-generated method stub
		
	}

	public int max() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int min() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void usun(int klucz) {
		// TODO Auto-generated method stub
		
	}

	public void wyswietlpoziomami() {
		
		wyswietl(_root);
	}
	
	protected void wyswietl(Node n) {
		for (int i = 0; i < 4; i++) {
			if(n.next[i]!=null)
			{
				wyswietl(n.next[i]);
			}
		}
			System.out.println(n);
		
		
	}

	public void insert(int x)
    {
		if(_root==null)
		{
			_root=new Node(x);
			_root.poziom=1;
			_root.next[0]=new Node();
			_root.next[1]=new Node();
			_root.poziom=0;
			_root.poziom=0;
			
		}
		else
		{
		_root= insert(x,_root); 
		}
	}
    
    protected Node insert(int x, Node t) 
    {
		return t;
      
    }


}

