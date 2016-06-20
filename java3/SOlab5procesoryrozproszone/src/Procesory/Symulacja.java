package Procesory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Symulacja {

	private ArrayList<Procesory> lprocesow;
	private ArrayList<Proces> kolejka;
	private ArrayList<Proces> kopia;
	private int czas;

	public Symulacja() {

	}

	public void rozpocznij() {
		Scanner in = new Scanner(System.in);
		System.out.println("Ilosc  procesorow");
		int N = in.nextInt();
		System.out.println("max obc jednego procesu 0-100");
		int obc = in.nextInt();
		System.out.println("max czas pozostania procesu na procesorze");
		int maxcz = in.nextInt();
		System.out.println("max czas wygenerowania procesu");
		int generowane = in.nextInt();
		System.out.println("ilosc wygenerowanych procesów");
		int liosc = in.nextInt();

		kolejka = new ArrayList<>();
		lprocesow = new ArrayList<>();
		Random g = new Random();
		for (int i = 0; i < N; i++) {
			lprocesow.add(new Procesory(i));
		}

		for (int i = 0; i < liosc; i++) {
			int procesor = g.nextInt(N);
			kolejka.add(new Proces(obc, maxcz, generowane, procesor));
		}

		for (Proces p : kolejka) {
			System.out.println(p);
		}
		System.out.println();

	}

	void zwiekszczas() {
		czas++;

	}

	void wyswietlprzeciarzenia() {

		for (Procesory p : lprocesow) {
			System.out.print(p.aktualneprzeciarzenie() + "\t");
		}

		System.out.println("");
	}

	public void restart() {
		czas = 0;
		kopia = new ArrayList<>();

		for (Proces p : kolejka) {
			Proces b = new Proces(p);
			kopia.add(b);
		}
		for (Procesory p : lprocesow) {
			p.restart();
		}
	}

	public void strategia2() {
		Scanner in = new Scanner(System.in);
		System.out.println("prug p przyjecia procesu 0-95");
		int p = in.nextInt();
		System.out.println("max z ilosc losowan ");
		int z = in.nextInt();
		int v = 0;
		int iloscwykonanych = 0;
		restart();
		boolean koniec = true;
		int iloscprzeniesien = 0;
		while (koniec) {
			zwiekszczas();
			System.out.println("\nczas " + czas);

			// dodanie nowego procesu
			for (Proces proc : kopia) {

				if (czas == proc.getWygenerowano()) {
					iloscwykonanych++;
					Proces nowy = new Proces(proc);
					boolean przyjety = false;// true jesli przyjety
					int i = 0;
					if (lprocesow.get(nowy.getProcesorO()).aktualneprzeciarzenie() < p) {
						nowy.setProcesorW(nowy.getProcesorO());
						lprocesow.get(nowy.getProcesorO()).przyjmijproces(nowy);
						przyjety = true;
					}
					while (!przyjety && i < (z - 1)) {
						Random gen = new Random();
						int wylosowanyproc = gen.nextInt(lprocesow.size() - 1);
						if (lprocesow.get(wylosowanyproc).aktualneprzeciarzenie() < p) {

							nowy.setProcesorW(wylosowanyproc);
							przyjety = lprocesow.get(wylosowanyproc).przyjmijproces(nowy);

						}
						nowy.setIloscprzeniesien(nowy.getIloscprzeniesien() + 1);
						iloscprzeniesien++;
						i++;
					}

					if (!przyjety) {
						Random gen = new Random();
						int wylosowanyproc = gen.nextInt(lprocesow.size() - 1);
						nowy.setProcesorW(wylosowanyproc);
						lprocesow.get(wylosowanyproc).przyjmijproces(nowy);
					}
					System.out.println(nowy);

				}

			}
			wyswietlprzeciarzenia();
			if (iloscwykonanych == kopia.size())
				koniec = false;
			for (Procesory proc : lprocesow) {
				if (proc.wykonaj())
					koniec = true;
			}

		}
		double[] srednie=new double[lprocesow.size()];
		double sr=0;
		int i=0;
		int ilosczap = 0;
		for (Procesory pr : lprocesow) {
			double n=pr.przeciarzenia();
			sr+=n;
			srednie[i]=n;
			i++;
			ilosczap += pr.ilosczapytan();
		}
		sr=sr/i;
		System.out.println("srednia ogolna" + sr);
		double odc=0;
		for (int j = 0; j < i; j++) {
			odc+=Math.pow((srednie[j]-sr), 2);
		}
		
		System.out.println("odchylenie " + Math.sqrt(odc/i));
		System.out.println("ilosc przeniesien " + iloscprzeniesien);
		System.out.println("ilosc zapytan " + ilosczap);
	}

	public void strategia1() {
		Scanner in = new Scanner(System.in);
		System.out.println("prug p przyjecia procesu 0-95");
		int p = in.nextInt();
		System.out.println("max z ilosc losowan ");
		int z = in.nextInt();
		int v = 0;
		int iloscwykonanych = 0;
		restart();
		boolean koniec = true;
		int iloscprzeniesien = 0;
		while (koniec) {
			zwiekszczas();
			System.out.println("\nczas " + czas);

			// dodanie nowego procesu
			for (Proces proc : kopia) {

				if (czas == proc.getWygenerowano()) {
					iloscwykonanych++;
					Proces nowy = new Proces(proc);
					boolean przyjety = false;// true jesli przyjety
					int i = 0;
					while (!przyjety && i < z) {
						Random gen = new Random();
						int wylosowanyproc = gen.nextInt(lprocesow.size() - 1);
						if (lprocesow.get(wylosowanyproc).aktualneprzeciarzenie() < p) {

							nowy.setProcesorW(wylosowanyproc);
							przyjety = lprocesow.get(wylosowanyproc).przyjmijproces(nowy);

						}
						iloscprzeniesien++;
						nowy.setIloscprzeniesien(nowy.getIloscprzeniesien() + 1);
						i++;
					}

					if (!przyjety) {
						nowy.setProcesorW(nowy.getProcesorO());
						lprocesow.get(nowy.getProcesorO()).przyjmijproces(nowy);
					}
					System.out.println(nowy);

				}

			}
			wyswietlprzeciarzenia();
			if (iloscwykonanych == kopia.size())
				koniec = false;
			for (Procesory proc : lprocesow) {
				if (proc.wykonaj())
					koniec = true;
			}

		}
		double[] srednie=new double[lprocesow.size()];
		double sr=0;
		int i=0;
		int ilosczap = 0;
		for (Procesory pr : lprocesow) {
			double n=pr.przeciarzenia();
			sr+=n;
			srednie[i]=n;
			i++;
			ilosczap += pr.ilosczapytan();
		}
		sr=sr/i;
		System.out.println("srednia ogulna" + sr);
		double odc=0;
		for (int j = 0; j < i; j++) {
			odc+=Math.pow((srednie[j]-sr), 2);
		}
		
		System.out.println("odchylenie " + Math.sqrt(odc/i));
		System.out.println("ilosc przeniesien " + iloscprzeniesien);
		System.out.println("ilosc zapytan " + ilosczap);
	}

	public void strategia3() {
		Scanner in = new Scanner(System.in);
		System.out.println("prug p przyjecia procesu 0-95");
		int p = in.nextInt();
		System.out.println("max z ilosc losowan ");
		int z = in.nextInt();
		System.out.println("min obciarzenie r ");
		int r = in.nextInt();
		int v = 0;
		int iloscwykonanych = 0;
		restart();
		boolean koniec = true;
		int iloscprzeniesien = 0;
		while (koniec) {
			zwiekszczas();
			System.out.println("\nczas " + czas);

			// dodanie nowego procesu
			for (Proces proc : kopia) {

				if (czas == proc.getWygenerowano()) {
					iloscwykonanych++;
					Proces nowy = new Proces(proc);
					boolean przyjety = false;// true jesli przyjety
					int i = 0;
					if (lprocesow.get(nowy.getProcesorO()).aktualneprzeciarzenie() < p) {
						nowy.setProcesorW(nowy.getProcesorO());
						lprocesow.get(nowy.getProcesorO()).przyjmijproces(nowy);
						przyjety = true;
					}
					while (!przyjety && i < (z - 1)) {
						Random gen = new Random();
						int wylosowanyproc = gen.nextInt(lprocesow.size() - 1);
						if (lprocesow.get(wylosowanyproc).aktualneprzeciarzenie() < p) {
							nowy.setProcesorW(wylosowanyproc);
							przyjety = lprocesow.get(wylosowanyproc).przyjmijproces(nowy);

						}
						nowy.setIloscprzeniesien(nowy.getIloscprzeniesien() + 1);
						iloscprzeniesien++;
						i++;
					}

					if (!przyjety) {
						Random gen = new Random();
						int wylosowanyproc = gen.nextInt(lprocesow.size() - 1);
						nowy.setProcesorW(wylosowanyproc);
						lprocesow.get(wylosowanyproc).przyjmijproces(nowy);
					}
					System.out.println(nowy);

				}

			}
			for (Procesory proc : lprocesow) {
				if (proc.aktualneprzeciarzenie() < r) {
					Random gen = new Random();
					int wylosowanyproc = gen.nextInt(lprocesow.size() - 1);
					System.out.println(proc.getnazwa() + " przejmuje  od " + wylosowanyproc);
					Proces pro = lprocesow.get(wylosowanyproc).oddaj();
					if (pro != null) {
						proc.przyjmijproces(pro);
					}
				}

			}
			wyswietlprzeciarzenia();
			if (iloscwykonanych == kopia.size())
				koniec = false;
			for (Procesory proc : lprocesow) {
				if (proc.wykonaj())
					koniec = true;
			}

		}
		double[] srednie=new double[lprocesow.size()];
		double sr=0;
		int i=0;
		int ilosczap = 0;
		for (Procesory pr : lprocesow) {
			double n=pr.przeciarzenia();
			sr+=n;
			srednie[i]=n;
			i++;
			ilosczap += pr.ilosczapytan();
		}
		sr=sr/i;
		System.out.println("\nsrednia ogolna" + sr);
		double odc=0;
		for (int j = 0; j < i; j++) {
			odc+=Math.pow((srednie[j]-sr), 2);
		}
		
		System.out.println("odchylenie " + Math.sqrt(odc/i));
		System.out.println("ilosc przeniesien " + iloscprzeniesien);
		System.out.println("ilosc zapytan " + ilosczap);
	}

}