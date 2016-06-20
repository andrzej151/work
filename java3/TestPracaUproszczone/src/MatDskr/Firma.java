package MatDskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Firma extends Pytanie {

	public Firma() {
		clean();

	}

	public boolean odpowiedz() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nazwa firmy");
		nazwa = in.next();
		wynagrodzenie.odpF();
		benefity.odpF();
		srednia_wieku.odpF();
		umiejetnosci.odpF();
		czaspracy.odpF();
		priorytet();
		return true;
	}

	void wyswietl() {
		System.out.println("Firma " + nazwa);
		wynagrodzenie.wyswietl();
		benefity.wyswietl();
		srednia_wieku.wyswietl();
		umiejetnosci.wyswietl();
		czaspracy.wyswietl();

	}

}
