package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Universum extends Zbior {

	public Universum() {
		clean();
	}

	public Universum(String nazwa) {
		super(nazwa);

	}
	
	public void wyswietl()
	{
		System.out.println();
		System.out.println("Pytanie glowne "+getnazwa());
		for (int i = 0; i < nazwyelementow.length - 1; i++) {
			System.out.println(nazwyelementow[i]);
		}
		System.out.println();
	}

	@Override
	public String toString() {
		String ret;
		ret = "\nUniwersum: " + getnazwa() + "\n";
		ret += "{";
		for (int i = 0; i < nazwyelementow.length - 1; i++) {
			ret += nazwyelementow[i] + ", ";
		}
		ret += nazwyelementow[nazwyelementow.length - 1] + "}\n";

		return ret;
	}

	public boolean zapisz(DataOutputStream out) throws IOException {

		out.writeUTF("<U>");
		out.writeUTF(getnazwa());
		out.writeInt(nazwyelementow.length);
		for (int i = 0; i < nazwyelementow.length; i++) {
			out.writeUTF(nazwyelementow[i]);
		}
		out.writeUTF("<KU>");
		return true;
	}

	public boolean wczytaj(DataInputStream in) throws IOException, Exception {
		if (!in.readUTF().equals("<U>"))
			throw new Exception("zly znacznik");
		clean();
		setnazwa(in.readUTF());
		int w = in.readInt();
		nazwyelementow = new String[w];
		for (int i = 0; i < w; i++) {
			nazwyelementow[i] = in.readUTF();
		}
		if (!in.readUTF().equals("<KU>"))
			throw new Exception("zly znacznik");
		return true;
	}

	public String getinstance() {
		// TODO Auto-generated method stub
		return "U";
	}

	

}
