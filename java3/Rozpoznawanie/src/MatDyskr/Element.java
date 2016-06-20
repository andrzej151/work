package MatDyskr;

public class Element {
	private int r,g,b,x,y;
	
	private double rg,rb,gb,rgb;
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public Element(int x, int y, int r,int g, int b) {
		setX(x);
		setY(y);
		setR(r);
		setG(g);
		setB(b);
		rg=r/(g+1);
		rb=r/(b+1);
		gb=g/(b+1);
		rgb=(r/(g+1))/(b+1);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int torgb()
	{
		return r*65536+g*256+b;
	}
	@Override
	public String toString() {
		return "Element [r=" + r + ", g=" + g + ", b=" + b + ", x=" + x + ", y=" + y + ", rg=" + rg + ", rb=" + rb
				+ ", gb=" + gb + ", rgb=" + rgb + "]";
	}
	public void usunnajmniejszaskladowa() {
		if(r<g)
		{
			if(b<r)
			{
				r=r-b;
				g=g-b;
				b=0;
			}
			else
			{
				g=g-r;
				b=b-r;
				r=r-r;
			}
		}
		else
		{
			if(b<g)
			{
				r=r-b;
				g=g-b;
				b=0;
			}
			else
			{
				r=r-g;
				b=b-g;
				g=g-g;

			}
		}
		
	}
	
	double podobienstwo(Element d)
	{
		ZbiorI A=new ZbiorI();
		A.ustawWartosciElementow(this.r,this.g,this.b);
		ZbiorI B=new ZbiorI();
		B.ustawWartosciElementow(d.r,d.g,d.b);
		try {
			return ZbiorI.dice2(A, B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
				
	}
	
}
