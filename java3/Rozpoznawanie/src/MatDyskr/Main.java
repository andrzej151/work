package MatDyskr;

import java.io.File;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Porownywarka p=new Porownywarka();
		 
		File wzorPlik = new File("./img/wzor/"); // "./" oznacza bie¿¹cy katalog
		 String [] wzory = wzorPlik.list();
		 File szukPlik = new File("./img/szukanie/"); // "./" oznacza bie¿¹cy katalog
		 String [] szukanie = szukPlik.list();
		 
		 for (int i=0; i<szukanie.length; i++) {
		  System.out.println(szukanie[i]);
		  
		  
		  for (int j=0; j<wzory.length; j++) {
			  System.out.println(wzory[j]);
			  p.wczytajCz(wzory[j],szukanie[i]);
			  p.przeszukaj();
			  p.zapisz();
			  
		  }
		 }
//		  obrazek.clear();
//		  h.clear();
//		  obrazek=Grafika.Wczytaj("img/k/a.png");//+dirList[i]);
//		  h=Grafika.Wczytaj("img/k/b.png");//+dirList[i]);
//		  Zbior A=new Zbior();
//		  A.convert(obrazek,h);
//		 for(Element f:obrazek)
//		 {
//			 f.usunnajmniejszaskladowa();
//		 }
//		 Grafika.Zapisz("img/k/bk"+dirList[i], obrazek);
//		   t=Grafika.WczytajCzb("img/k/"+dirList[i]);
//		 // System.out.println(t[4][4]);
//		  Grafika.konturowanie(t);
//		  Grafika.progowanie(t, 50);
////		  System.out.println(t[4][4]);
//		  Grafika.Zapisz("img/k/"+dirList[i],t);
//		 int n=0,d=0;
//		int x, y,z=0;
//		for (int b = 0; b <255; b+=5) {
//		  y=0;
//		  for (int g = 0; g<255; g+=1){
//		 x=0;
//			for (int r = 0; r <255; r+=1) {
//			  
//			  
//				  Element v=new Element( x,y, r, g, b);
//				  h.add(v);
//				//  System.out.println(v);
//				  x++;
//			  }
//			  y++;
//			 }
//		  Grafika.Zapisz("img/xrygzb/r"+b+".jpg",h);
//		 z++;
//	}
		 //}
	}
	

}
