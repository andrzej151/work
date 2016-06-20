package Drzewa;

public class Drzewo {
	private Node _root;
	private int liscie, wz, ww,wysokosc;
	private int[][] tab;
	private int[][] rys;
	
	public Drzewo()
	{
		
	}
	/////////////////////insert
	public void insert(int x)
    {
		System.out.println(x);
		_root= insert(x,_root); 
	}
    
    protected Node insert(int x, Node t) {
      if(t== null) t=new Node(x);
      else 
      { 
    	 
             if(x<t.value) t.left=insert(x,t.left);
             else if(x>t.value) t.right=insert(x,t.right);
			else
				try {
					throw new Exception("jest juz taki klucz");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }       
      return t;
  }

    //////////////////////////////
    public Object find(int x)
    {
    	Node t = search(x);
    	return t !=null ? t.value : null;
    }
    
    public void findnext(int klucz) {
    	Node t = search(klucz);
    	System.out.println("po kluczu "+(t!=null ? t.value : null)+" jest "+(t.left!=null ? t.left.value : null)+" i "+(t.right!=null ? t.right.value : null));
		
	}
    
    public Object findpop(int x)
    {
    	Node t = searchpop(x);
    	return t !=null ? t.value : null;
    }
    
    private Node search(int value) {
        Node node = _root;
        int cmp=0;
        while (node != null &&(cmp = value-node.value)!=0)
           node = cmp < 0 ? node.left : node.right;
         return node;
    }
 private Node searchpop(int value) {
        Node node = _root;
        Node nodepop = null;
        int cmp=0;
        while (node != null &&(cmp = value-node.value)!=0)
        {
        	nodepop=node;
           node = cmp < 0 ? node.left : node.right;
           
        }
         return nodepop;
    }
 
 /////////////////////////////////////////////
    public void wyswietlin()
    {
    	wyswietlin(_root);
    }
    private void wyswietlin(Node n) {
       if(n.left!=null)
    	wyswietlin(n.left);
    	System.out.println(n.value);
    	if(n.right!=null)
    	wyswietlin(n.right);
    }
   
    
    public void wyswietlpre()
    {
    	wyswietlpre(_root);
    }
    private void wyswietlpre(Node n) {
    	if(n!=null)System.out.println(n.value); 
      	if(n.left!=null)
    	wyswietlpre(n.left);
    	if(n.right!=null)
    	wyswietlpre(n.right);
    }
    
    public void wyswietlpost()
    {
    	wyswietlpost(_root);
    }
    private void wyswietlpost(Node n) {
    	
      	if(n.left!=null)
    	wyswietlpost(n.left);
    	if(n.right!=null)
    	wyswietlpost(n.right);
    	if(n!=null)System.out.println(n.value); 
    }
    
    
    /////////////////////////////
    
    public void dodajpoziomy()
    {
    	dodajpoziomy(0,_root);
    }
    
    private void dodajpoziomy(int p,Node n) {
    	if(n!=null)
    	{
    		n.poziom=p;
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
    	for(int i=0;i<tab.length;i++)
    	{
    		if(tab[i][0]!=0)
    		System.out.print(tab[i][0]+" ");
    	}
    	System.out.println();
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
    
    public void rysunek()
    {
    	rys=new int[(int) (2*Math.pow(2, wysokosc()+1))][2];
    	int it=0;
    	int p=0;
    	while(p<wysokosc+1)
    	{
    		int z=0;
    		while(z<Math.pow(2, p))
    		{
    			rys[it][1]=p;
    			it++;
    			z++;
    		}
    		p++;
    	}
    	przepiszr(_root,0);
    	for(int i=0;i<rys.length;i++)
    	{
    		
    		System.out.print(rys[i][0]+" ");
    	}
    	System.out.println();
    	for(int i=0;i<rys.length;i++)
    	{
    		System.out.print(rys[i][1]+" ");
    	}
    	System.out.println("poziomy");
    }
    
    private void przepiszr(Node n,int l)
    {
    	rys[l][0]=(n!=null?n.value:0);
    	if(n.left!=null)
    	{
    		
        przepiszr(n.left,l+1);
    	}
        if(n.right!=null)
        {
        przepiszr(n.right,l+2);
        }
        
    }
    /////////////////////////////////////////////
    public int liscie()
    {
    	liscie=0;
    	liscie(_root);
    	return liscie;
    }
    private void liscie(Node n) {
    	if(n.left==null&&n.right==null)liscie++;
      	if(n.left!=null)
    	liscie(n.left);
    	if(n.right!=null)
    	liscie(n.right);
    }
    
    public int wezlyzewnetrzne()
    {
    	wz=0;
    	wezlyzewnetrzne(_root);
    	return wz;
    }
    private void wezlyzewnetrzne(Node n) {
    	if(n.left==null)wz++;
    	if(n.right==null)wz++;
      	if(n.left!=null)
    	wezlyzewnetrzne(n.left);
    	if(n.right!=null)
    	wezlyzewnetrzne(n.right);
    }
    
    public int wezlywew()
    {
    	ww=0;
    	wezlywew(_root);
    	return ww;
    }
    private void wezlywew(Node n) {
    	if(!(n.left==null&&n.right==null))ww++;
      	if(n.left!=null)
    	wezlywew(n.left);
    	if(n.right!=null)
    	wezlywew(n.right);
    }
    
    public int min()
    {
    	Node n=_root;
    	
    	while(n.left!=null)
    	{
    		n=n.left;
    	}
    	return n.value;
    }
    public int max()
    {
    	Node n=_root;
    	
    	while(n.right!=null)
    	{
    		n=n.right;
    	}
    	return n.value;
    }
        
   
   

    public void delete(int x)
    {_root=delete(x,_root); }
    
    protected Node delete(int x, Node t) {
      if(t==null)
		try {
			throw new Exception("blad");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else { 
             if(x<t.value) t.left=delete(x,t.left);
             else if(x>t.value) t.right=delete(x,t.right);
                  else if(t.left!=null &&t.right!=null)
                            t.right=detachMin(t.right,t); 
                       else  t = (t.left != null) ? t.left : t.right;
            }           
      return t;
    }  
   
//zast�p usuwany element jego nast�pnikiem i usu� nast�pnik
  
    protected Node detachMin(Node t, Node del) {
      if(t.left!=null) t.left=detachMin(t.left,del);   
      else {del.value=t.value; t=t.right;}
      return t;
    }  

    
    
    //pomocnicza klasa node
     class Node
     {
    	 private int value;
    	 private Node left;
    	 private Node right;
    	 private int poziom;
		
		public Node(int x)
    	 { value=x; left = right = null; poziom=0; } 
  
    	   
     }

    

}
