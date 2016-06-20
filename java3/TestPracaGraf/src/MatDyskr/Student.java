package MatDyskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Student {
	private String nazwa;
	private ArrayList<Dana> pyt;

	public boolean odpowiedz(Pytania pytania) {
		Scanner in=new Scanner(System.in);
		System.out.println("Jak masz na imie");
		nazwa=in.next();
		pyt=new ArrayList<>();
		for (int i = 0; i < pytania.size(); i++) 
		{
			Dana odp=pytania.zadaj(i);
			Dana o=odp.odpS();
			pyt.add(o);
		}
		
		return true;
	}

	public void zapisz(DataOutputStream out) throws IOException {
		out.writeUTF(nazwa);
		out.writeInt(pyt.size());
		for (Dana pytanie : pyt) {
			out.writeUTF(pytanie.getinstance());
			pytanie.zapisz(out);
		}

	}

	public boolean wczytaj(DataInputStream in) throws IOException, Exception {

		clean();
		nazwa=in.readUTF();
		int w = in.readInt();
		for (int i = 0; i < w; i++) {
			String s = in.readUTF();
			if (s.equals("Z")) {
				Zbior z =new Zbior();
				z.wczytaj(in);
				pyt.add(z);
			}
			if (s.equals("W")) {
				Wykres wy = new Wykres();
				wy.wczytaj(in);
				pyt.add(wy);
			}
		}
		return true;

	}

	public void clean() {
		// TODO Auto-generated method stub
		nazwa="";
		pyt=new ArrayList<>();
	}

	void wyswietl()
	{
		System.out.println("Student "+nazwa);
		for(Dana d:pyt)
		{
			System.out.println(d);
		}
	}
}
