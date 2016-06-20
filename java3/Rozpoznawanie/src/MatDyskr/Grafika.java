package MatDyskr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Grafika {

static	public ArrayList<Element> Wczytaj(String nazwa) {
		ArrayList<Element> ele = new ArrayList<Element>();
		File plik = new File(nazwa);
		BufferedImage obrazek;
		try {
			obrazek = ImageIO.read(plik);

			int x = obrazek.getWidth();
			int y = obrazek.getHeight();

			// -----TABLICOWANIE-----------------------------------
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					int o = obrazek.getRGB(i, j);

					int r = (o & 0xff0000) >> 16;
					int g = (o & 0x00ff00) >> 8;
					int b = (o & 0x0000ff);
					ele.add(new Element(i, j, r, g, b));
					// System.out.println(r+" "+g+" "+b);
					// int z=255*65536+0*256+255;
					// obrazek.setRGB(i, j, z);

				}
			}
			
			return ele;
			// System.out.println(ImageIO.write(obrazek,"jpg",plik));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}


static	public int[][] WczytajCzb(String nazwa) {
		int[][] ele = null ;
		File plik = new File(nazwa);
		BufferedImage obrazek;
		try {
			obrazek = ImageIO.read(plik);

			int x = obrazek.getWidth();
			int y = obrazek.getHeight();
			ele =new int[x][y];
			// -----TABLICOWANIE-----------------------------------
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					int o = obrazek.getRGB(i, j);

					int r = (o & 0xff0000) >> 16;
					int g = (o & 0x00ff00) >> 8;
					int b = (o & 0x0000ff);
					ele[i][j]=(r+g+b)/3;
					//System.out.println(r+" "+g+" "+b);
					// int z=255*65536+0*256+255;
					// obrazek.setRGB(i, j, z);

				}
			}
			System.out.println(ele[4][4]);
			return ele;
			// System.out.println(ImageIO.write(obrazek,"jpg",plik));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele;
	}

public static void konturowanie(int [][]t){
	for (int i = 0; i < t.length-1; i++) {
		for (int j = 0; j < t[0].length-1; j++) {
			t[i][j]=Math.abs(t[i+1][j]-t[i][j]) + Math.abs(t[i][j+1] - t[i][j]);
		}
	}
}
public static void negatyw(int [][]t){
	for (int i = 0; i < t.length-1; i++) {
		for (int j = 0; j < t[0].length-1; j++) {
			t[i][j]=256-t[i][j];
		}
	}
}
public static void progowanie(int [][]t,int prog){
	for (int i = 0; i < t.length-1; i++) {
		for (int j = 0; j < t[0].length-1; j++) {
			if(t[i][j]<prog)
			{
			t[i][j]=0;
			}else
			{
				t[i][j]=255;
			}
		}
	}
}

public static void Zapisz(String nazwa, int[][]t) {
	 try {
		 File plik = new File(nazwa);
	BufferedImage obr = new BufferedImage(t.length,t[0].length, 1);
	
	for (int i = 0; i < t.length; i++) {
		for (int j = 0; j < t[0].length; j++) {
			obr.setRGB(i, j, t[i][j]*65536+t[i][j]*256+t[i][j]);
		}
	}
	
		System.out.println(ImageIO.write(obr,"png",plik));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public static void Zapisz(String nazwa, ArrayList<Element> obrazek) {
	 try {
		 File plik = new File(nazwa);
		 System.out.println(obrazek.get(obrazek.size()-1).getX()+" "+obrazek.get(obrazek.size()-1).getY());
	BufferedImage obr = new BufferedImage(obrazek.get(obrazek.size()-1).getX()+1, obrazek.get(obrazek.size()-1).getY()+1, 1);
	
	for(Element el:obrazek){
			obr.setRGB(el.getX(), el.getY(), el.torgb());
	}
	
		System.out.println(ImageIO.write(obr,"png",plik));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static Element[][] WczytajT(String nazwa) {
	Element[][] ele = null ;
	File plik = new File(nazwa);
	BufferedImage obrazek;
	try {
		obrazek = ImageIO.read(plik);

		int x = obrazek.getWidth();
		int y = obrazek.getHeight();
		ele=new Element[x][y];
		
		// -----TABLICOWANIE-----------------------------------
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int o = obrazek.getRGB(i, j);

				int r = (o & 0xff0000) >> 16;
				int g = (o & 0x00ff00) >> 8;
				int b = (o & 0x0000ff);
				ele[i][j]=new Element(i, j, r, g, b);
				// System.out.println(r+" "+g+" "+b);
				// int z=255*65536+0*256+255;
				// obrazek.setRGB(i, j, z);

			}
		}
		
		return ele;
		// System.out.println(ImageIO.write(obrazek,"jpg",plik));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ele;
}


public static Element[][] WczytajTC(String nazwa) {
	Element[][] ele = null ;
	File plik = new File(nazwa);
	BufferedImage obrazek;
	try {
		obrazek = ImageIO.read(plik);

		int x = obrazek.getWidth();
		int y = obrazek.getHeight();
		ele=new Element[x][y];
		
		// -----TABLICOWANIE-----------------------------------
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int o = obrazek.getRGB(i, j);

				int r = (o & 0xff0000) >> 16;
				int g = (o & 0x00ff00) >> 8;
				int b = (o & 0x0000ff);
				int s=(r+g+b)/3;
				ele[i][j]=new Element(i, j, s, s, s);
				// System.out.println(r+" "+g+" "+b);
				// int z=255*65536+0*256+255;
				// obrazek.setRGB(i, j, z);

			}
		}
		
		return ele;
		// System.out.println(ImageIO.write(obrazek,"jpg",plik));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ele;
}
}
