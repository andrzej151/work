package MatDyskr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Dana {
	public double wynik(Dana d) throws Exception;

	public boolean zapisz(DataOutputStream out) throws IOException;

	public boolean wczytaj(DataInputStream in) throws IOException, Exception;

	public void clean();

	public Dana odpF();

	public Dana odpS();

	public String getinstance();

	

	
}
