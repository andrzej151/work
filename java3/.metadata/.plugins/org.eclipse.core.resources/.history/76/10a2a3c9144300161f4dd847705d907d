package MatDskr;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File plik = new File("o.png");
	    BufferedImage obrazek;
		try {
			obrazek = ImageIO.read(plik);
			 
			int x=obrazek.getWidth();
		    int y=obrazek.getHeight();
		    int[][]tab_pix=new int[x+1][y+1];
		 
		    //-----TABLICOWANIE-----------------------------------
		    for(int i=0; i<x;i++)
		    {
		        for(int j=0; j<y;j++){
		        	tab_pix[i][j]=obrazek.getRGB(i,j);
		        	
		        	int r=(tab_pix[i][j] & 0xff0000) >> 16;
		        	int g=(tab_pix[i][j] & 0x00ff00)>> 8;
		        	int b=(tab_pix[i][j] & 0x0000ff);
		        	System.out.println(r+" "+g+" "+b);
		        	int z=255*65536+0*256+255;
		        	obrazek.setRGB(i, j, z);
		        	
		        	
		      
		        }
		    }
		    System.out.println(ImageIO.write(obrazek,"jpg",plik));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	  
//		try {
//			Srodowisko s = new Srodowisko();
//			s.menu();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// DataInputStream strumieñWejœciowy = new DataInputStream(new
		// FileInputStream(plik));

		// w.wstaw();

		// System.out.println(w);
		// "./" oznacza bie¿¹cy katalog

		//
		// u.ustawNazwyElementow(o,true);
		// A=new Zbior(u,"A");
		// A.ustawWartosciElementow(o,true);
		// B=new Zbior(u,"B");
		// B.ustawWartosciElementow(o,true);
		// try {
		// A=Zbior.ZbiorAminusB(A, B);
		// System.out.println(A);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// System.out.println("ok"+e.getMessage());
		// }

	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}

}
