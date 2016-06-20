package Drzewa234;

public class Drzewo234 {

	Node root;

	public Drzewo234() {
		// TODO Auto-generated constructor stub
	}

	public void insert(int x) {
		if(root==null)
		{
			root=new Node(x);
		}
		else
		{
			Node pom=root;
			if(pom==root&&pom.pelny())
			{
				Node newroot=new Node(pom.getvalue(1));
				Node newR =new Node(pom.getvalue(2));
				newroot.setnext(pom, 0);
				newroot.setnext(newR, 1);
				pom.delete();
				pom.delete();
				root=newroot;
				pom=root;
			}
			while (pom.getnext(x)!=null) {
				if(pom.getnext(x).pelny()){
					Node n=pom.getnext(x);
					int p=pom.addvalue(n.getvalue(1));
					Node newR=new Node(n.getvalue(2));
					for (int i = pom.getSize()-1; i > 0; i--) {
						pom.next[i+1]=pom.next[i];
					}
					pom.setnext(newR, p+1);
					n.delete();
					n.delete();
				}
				pom=pom.getnext(x);
				
			}
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

		///wyswietl(_root);
	}

	protected void wyswietl(Node n) {
		for (int i = 0; i < 4; i++) {
			if (n.next[i] != null) {
				wyswietl(n.next[i]);
			}
		}
		System.out.println(n);

	}

	private class Node {
		int[] value;
		Node[] next;
		int ilosc;
		int poziom;
		int size;

		Node(int x) {
			value = new int[3];
			next = new Node[4];
			size = 0;
			addvalue(x);

		}

		public void delete() {
			value[size-1]=0;
			size--;
		}

		public int getSize() {
			return size;
		}

		public int addvalue(int x) {
			int i = size;
			while (i > 0 && x > value[i - 1]) {
				value[i] = value[i - 1];
				i--;
			}
			value[i] = value[i - 1];
			size++;
			return i;
		}

		public int getvalue(int n) {

			return value[n];
		}

		public Node getnext(int x) {
			for (int i = 0; i < size; i++) {
				if (value[i] < x) {
					return next[i];
				}
			}
			return next[size];
		}

		public void setnext(Node node, int n) {
			next[n] = node;
		}

		public boolean pelny() {
			return size == 3;
		}
	}
}
