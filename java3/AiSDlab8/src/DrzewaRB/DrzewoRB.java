package DrzewaRB;

import DrzewaRB.Drzewo.Node;

public class DrzewoRB {
    static final boolean RED=true;
    static final boolean BLACK =false;

    private Node _root;
    private int [][]tab;
    int wysokosc;

    public  DrzewoRB() 
    { _root=null;}
    
    private boolean isRed( Node x)
    {return x!= null && x.color==RED;}

    public int find(int x)
    {Node t = search(x);
     return t !=null ? t.value : null;
    }
        
    private Node search(int value) {
        Node node = _root;
        int cmp=0;
        while (node != null &&(value!=node.value))
           node = cmp < 0 ? node.left : node.right;
         return node;
    }
    

    private Node rotateL(Node t)
    { Node x=t.right;
      t.right=x.left;
      x.left=t;
      x.color=t.color;
      t.color=RED;
      return x; }
      
      private Node rotateR(Node t)
    { Node x=t.left;
      t.left=x.right;
      x.right=t;
      x.color=t.color;
      t.color=RED;
      return x; }
      
      private void colorFlip(Node t)
{t.color=!t.color; t.left.color=!t.left.color; t.right.color=!t.right.color; }
      

      public void insert(int x)
      { _root= insert(x,_root); _root.color=BLACK;}
      
      protected Node insert(int x, Node t) {
        if(t== null) t=new Node(x);
        else { 
          if(isRed(t.left) && isRed(t.right))
             colorFlip(t);
          if(t.value<x) t.left=insert(x,t.left);
             else if(t.value>x) t.right=insert(x,t.right);
else throw new RuntimeException("Duplicate     ");
            t=fixUp(t);  
              }       
        return t;
    }

    private Node fixUp(Node t)
    {   if(isRed(t.right))
              t=rotateL(t);
        if(isRed(t.left) && isRed(t.left.left))
            t=rotateR(t);
        if(isRed(t.left) && isRed(t.right))
            colorFlip(t);
        return t; }    
    
   private Node moveRedR( Node t)
   { colorFlip(t);
     if(isRed(t.left.left))
      { t=rotateR(t); colorFlip(t); }
     return t; }
     
   private Node moveRedL( Node t)
   { colorFlip(t);
     if(isRed(t.right.left))
       { t.right=rotateR(t.right); t=rotateL(t); colorFlip(t);}
     return t;}
   

  
   public void delete(int x)
    {_root=delete(x,_root);
      if(_root!=null) _root.color=BLACK;}
    
    protected Node delete(int x, Node t) {
      if(t==null) throw new RuntimeException("Not found  ");
      else { 
             if(t.value<x) 
                { if(!isRed(t.left) && !isRed(t.left.left))
                            t=moveRedL(t);
                  t.left=delete(x,t.left);
                }
             else{if( isRed(t.left)) t=rotateR(t);
                  if(x==t.value&&t.right == null) return null;
                    else { if(!isRed(t.right) && !isRed(t.right.left))
                               t=moveRedR(t);
                           if(t.value>x)
                                t.right=delete(x,t.right);
                           else t.right=detachMin(t.right, t);
                       }  
                  }     
            }           
      return fixUp(t);
    }  
     
    protected Node detachMin(Node t, Node del) {
      if(t.left==null) {del.value=t.value; t=null;}   
      else { if(!isRed(t.left) && !isRed(t.left.left))
               t=moveRedL(t);
             t.left=detachMin(t.left,del);
             t=fixUp(t); }
      return t;
    }  
  
    public String toString() 
     {return toString(_root,0);}
     
    private String toString(Node t,int pos) {   
    String result="";
    String spaces="                                                                                                                                                                                                     ";
    if(t!=null) result=result+toString(t.right,pos+4)+spaces.substring(0,pos)
                +String.format("%s%s",t.value,(t.color ? "/R" :"/B"))+toString(t.left,pos+4);
    else result=result+String.format("%n");
    return result;
    }  
    
    public void dodajpoziomy()
    {
    	dodajpoziomy(0,_root);
    }
    
    private void dodajpoziomy(int p,Node n) {
    	if(n!=null)
    	{
    		n.poziom=p;
    		System.out.println(n);
    		if(p>wysokosc)wysokosc=p;
    	}
      	if(n.left!=null)
    	dodajpoziomy(p+1,n.left);
    	if(n.right!=null)
    	dodajpoziomy(p+1,n.right);
    }
    
    public int wysokosc()
    {
    	wysokosc=0;
    	dodajpoziomy(0,_root);
    	return wysokosc;
    }
    public void wyswietlpoziomami()
    {
    	tab=new int[(int) (2*Math.pow(2, wysokosc()+5))][2];
    	przepisz(_root);
    
//    	for(int i=0;i<tab.length;i++)
//    	{
//    		System.out.print(tab[i][1]+" ");
//    	}
//    	System.out.println("poziomy");
    }
    
    private void przepisz(Node n)
    {
    	if(n.left!=null)
        przepisz(n.left);
        if(n.right!=null)
        przepisz(n.right);
        if(n!=null)
        {
        	int i=(int) (2*Math.pow(2, n.poziom)-1);
        	while(tab[i][1]!=0)i++;
        	tab[i][0]=n.value;
        	tab[i][1]=n.poziom;
        	
        }
    }
    
    class Node{
      int value;
      Node left;
      Node right;
      boolean color;
      int poziom;
      Node(int x)
      { value=x; left = right = null; color = RED;}
      
      @Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return " "+value+" ("+(color?"R)":"B)")+" P "+poziom;
    	}
    }  
    


}

