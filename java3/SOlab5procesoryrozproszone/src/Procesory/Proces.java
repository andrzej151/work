package Procesory;

import java.util.Random;

class Proces {
	private int obciarzenie;
	private int czaspozostania;
	private int wygenerowano;
	private int iloscprzeniesien;
	private int procesorO;
	private int procesorW;

	public Proces() {

	}

	public int getObciarzenie() {
		return obciarzenie;
	}

	public void setObciarzenie(int obciarzenie) {
		this.obciarzenie = obciarzenie;
	}

	public int getCzaspozostania() {
		return czaspozostania;
	}

	public void setCzaspozostania(int czaspozostania) {
		this.czaspozostania = czaspozostania;
	}

	public int getWygenerowano() {
		return wygenerowano;
	}

	public void setWygenerowano(int wygenerowano) {
		this.wygenerowano = wygenerowano;
	}

	public int getIloscprzeniesien() {
		return iloscprzeniesien;
	}

	public void setIloscprzeniesien(int iloscprzeniesien) {
		this.iloscprzeniesien = iloscprzeniesien;
	}

	public int getProcesorO() {
		return procesorO;
	}

	public void setProcesorO(int procesorO) {
		this.procesorO = procesorO;
	}

	public int getProcesorW() {
		return procesorW;
	}

	public void setProcesorW(int procesorW) {
		this.procesorW = procesorW;
	}

	public Proces(int obc, int maxcz, int generowane, int procesor) {
		Random g = new Random();
		czaspozostania = g.nextInt(maxcz);
		obciarzenie = g.nextInt(obc);
		wygenerowano = g.nextInt(generowane) + 1;
		procesorO = procesor;
		iloscprzeniesien = 0;
	}

	public Proces(Proces p) {
		// TODO Auto-generated constructor stub

		this.iloscprzeniesien = p.iloscprzeniesien;
		this.procesorW = p.procesorW;
		this.obciarzenie = p.obciarzenie;
		this.czaspozostania = p.czaspozostania;
		this.wygenerowano = p.wygenerowano;
		this.procesorO = p.procesorO;
	}

	public boolean wykonaj() // true gdy proces sie skonczyl
	{
		czaspozostania--;
		return czaspozostania == 0;
	}

	public boolean czywygenerowano(int czas) {
		return czas == wygenerowano;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Obciazenie " + obciarzenie + "\tpozostanie " + czaspozostania + "\tpowstal " + wygenerowano
				+ "\tna procesorze " + procesorO + "\tprzeniesiomo " + iloscprzeniesien + "\tWyk " + procesorW;

	}
}
