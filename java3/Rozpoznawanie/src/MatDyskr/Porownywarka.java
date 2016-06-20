package MatDyskr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Porownywarka {
	private Element[][] wzor;
	private Element[][] szukaj;
	private double[][] wynik;
	
	public void wczytaj(String wzor, String szuk) {
		// TODO Auto-generated method stub
		this.wzor=Grafika.WczytajT("img/wzor/"+wzor);
		this.szukaj=Grafika.WczytajT("img/szukanie/"+szuk);
	}

	public void przeszukaj() {
		int wx=szukaj.length-wzor.length;
		int wy=szukaj[0].length-wzor[0].length;
		double max=0;
		int x=0,y=0;
		if(wx>0&&wy>0)
		{
			wynik=new double[wx][wy];
			for (int i = 0; i < wx; i++) {
				for (int j = 0; j < wy; j++) {
					wynik[i][j]=porownaj(i,j);
					System.out.printf("%0$6.4f ",wynik[i][j]);
					if (max<wynik[i][j]) {
						max=wynik[i][j];
						x=i;
						y=j;
					}
					
				}
				System.out.println();
			}
		zapisz(x,y,wzor.length,wzor[0].length);
		}
		
	}
	
	private void zapisz(int x, int y, int length, int length2) {
		try {
			 File plik = new File("img/wynik/k"+x+y+".png");
		BufferedImage obr = new BufferedImage(szukaj.length,szukaj[0].length, 1);
		
		for (int i = 0; i < szukaj.length; i++) {
			for (int j = 0; j < szukaj[0].length; j++) {
				obr.setRGB(i, j, szukaj[i][j].torgb());
			}
		}
		
		for (int i = x; i < length; i++) {
			obr.setRGB(i, y,0*65536+255*256 );
		}
			
		
			System.out.println(ImageIO.write(obr,"png",plik));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void wyswietl()
	{
		//for (int i = 0; i < wx; i++) {
			//for (int j = 0; j < wy; j++) {
	}

	private double porownaj(int x, int y) {
		double suma=0;
		int iloraz=1;
		for (int  i= 0; i < wzor.length; i++) {
			for (int j = 0; j < wzor[0].length; j++) {
				suma+=szukaj[i+x][j+y].podobienstwo(wzor[i][j]);
				iloraz++;
				//System.out.print(" v"+suma+"n ");
			}
		}
		
		return suma/iloraz;
	}

	public void zapisz() {
		// TODO Auto-generated method stub
		
	}

	public void wczytajCz(String wzor, String szuk) {
		this.wzor=Grafika.WczytajTC("img/wzor/"+wzor);
		this.szukaj=Grafika.WczytajTC("img/szukanie/"+szuk);
		
	}
	
}
