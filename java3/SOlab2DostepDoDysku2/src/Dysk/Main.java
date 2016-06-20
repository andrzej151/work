package Dysk;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu=0;
		Symulacja sym=new Symulacja();
		Scanner odczyt = new Scanner(System.in);
		String nazwa;
		int decyzja=0;
		
		do
		{
			System.out.println();
			System.out.println("Witaj co chcesz zrobic?");
			System.out.println("..........................");
			System.out.println("Symulacja");
			System.out.println("1-Wprowac kolejke procesow z klawiatury");
			System.out.println("2-Wprowadz plik tekstowy z danymi symulacji");
			System.out.println("3-wylosuj dane do symulacji");
			System.out.println("4-Zapis do pliku");
			System.out.println("5-Wyswietl liste");
			System.out.println("..........................");
			System.out.println("Algorytmy");
			System.out.println("6-Algorytm  FCFS");
			System.out.println("7-Algorytm SSTF");
			System.out.println("8-Algorytm SCAN");
			System.out.println("9-Algorytm C-SCAN");
			System.out.println("10-Algorytm EDF");
			System.out.println("11-Algorytm FD-SCAN");
			System.out.println("12-Automat");
			System.out.println("..........................");
			System.out.println("0-Koniec");
			menu=odczyt.nextInt();
			System.out.println();
			
			switch (menu) {
			case 1:
				sym.WprowacDaneRecznie();
				break;
				
			case 2:
				System.out.println("Podaj nazwe");
				 nazwa=odczyt.next();
				sym.WprowacPlik(nazwa);
				break;
				
			case 3:
				sym.los();
				break;
				
			case 4:
				System.out.println("Podaj nazwe");
				 nazwa=odczyt.next();
				sym.Zapisz(nazwa);;
				break;
				
			case 5:
				sym.Wyswietl();
				break;
				
			case 6:
				System.out.println("Algorytm FCFS");
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				if(decyzja==1)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaFCFSB_"+odczyt.next()+".txt";
					sym.FCFSbezCz(nazwa);
				}
				if(decyzja==2)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaFCFS_"+odczyt.next()+".txt";
					sym.FCFS(nazwa);
				}
				
				break;
				
			case 7:
				System.out.println("Algorytm SSTF");
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				if(decyzja==1)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaSSTFB_"+odczyt.next()+".txt";
					sym.SSTFbezCz(nazwa);
				}
				if(decyzja==2)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaSSTF_"+odczyt.next()+".txt";
					sym.SSTF(nazwa);
				}
				break;
				
			case 8:
				System.out.println("Algorytm SCAN");
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				if(decyzja==1)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaSCANB_"+odczyt.next()+".txt";
					sym.SCANbezcz(nazwa);
				}
				if(decyzja==2)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaSCAN_"+odczyt.next()+".txt";
					sym.SCAN(nazwa);
				}
				break;
				
			case 9:
				System.out.println("Algorytm C-SCAN");
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				if(decyzja==1)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaCSCANB_"+odczyt.next()+".txt";
					sym.C_SCANbezcz(nazwa);
				}
				if(decyzja==2)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaCSCAN_"+odczyt.next()+".txt";
					sym.C_SCAN(nazwa);
				}
				break;
				
			case 10:
				System.out.println("Algorytm EDF");
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				if(decyzja==1)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaEDFB_"+odczyt.next()+".txt";
					sym.EDFbCZ(nazwa);
				}
				if(decyzja==2)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaEDF_"+odczyt.next()+".txt";
					sym.EDF(nazwa);
				}
				break;
				
			case 11:
				System.out.println("Algorytm FD-SCAN");
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				if(decyzja==1)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaFDSCANB_"+odczyt.next()+".txt";
					sym.FDSCANbCZ(nazwa);
				}
				if(decyzja==2)
				{
					System.out.println("Podaj nazwe");
					nazwa="historiaFDSCAN_"+odczyt.next()+".txt";
					sym.FDSCAN(nazwa);
				}
				break;
				
			case 12:
				System.out.println("Automat");
				System.out.println("Wielkosc dysku");
				int d=odczyt.nextInt();
				System.out.println("Czasy dodawania");
				int cz=odczyt.nextInt();
				System.out.println("dedline");
				int ded=odczyt.nextInt();
				System.out.println("ilosc procesow");
				int il=odczyt.nextInt();
				System.out.println("1-Bez Czasu");
				System.out.println("2-Z Czasem");
				decyzja=odczyt.nextInt();
				System.out.println("Podaj nazwe podstawowa");
				String nazwapodstawowa=odczyt.next();
				
				int [] tabela=new int[6];
				String [] t=new String[6];
				t[0]="FCFS ";
				t[1]="SSTF ";
				t[2]="SCAN ";
				t[3]="CSCAN ";
				t[4]="EDF ";
				t[5]="FDSCAN ";
						
				if(decyzja==1)
				{	
					
					
					sym.los(d, cz, ded, il);
					sym.Zapisz("dane_"+nazwapodstawowa+".txt");
					
					nazwa="historiaFCFSB_"+nazwapodstawowa+".txt";
					tabela[0]=sym.FCFSbezCz(nazwa);
					nazwa="historiaSSTFB_"+nazwapodstawowa+".txt";
					tabela[1]=sym.SSTFbezCz(nazwa);
					nazwa="historiaSCANB_"+nazwapodstawowa+".txt";
					tabela[2]=sym.SCANbezcz(nazwa);
					nazwa="historiaCSCANB_"+nazwapodstawowa+".txt";
					tabela[3]=sym.C_SCANbezcz(nazwa);
					nazwa="historiaEDFB_"+nazwapodstawowa+".txt";
					tabela[4]=sym.EDFbCZ(nazwa);
					nazwa="historiaFDSCANB_"+nazwapodstawowa+".txt";
					tabela[5]=sym.FDSCANbCZ(nazwa);
					
					
				}
				if(decyzja==2)
				{
					sym.los(d, cz, ded, il);
					sym.Zapisz("dane_"+nazwapodstawowa+".txt");
					System.out.println("..................");
					nazwa="historiaFCFS_"+nazwapodstawowa+".txt";
					tabela[0]=sym.FCFS(nazwa);
					System.out.println("..................");
					nazwa="historiaSSTF_"+nazwapodstawowa+".txt";
					tabela[1]=sym.SSTF(nazwa);
					System.out.println("..................");
					nazwa="historiaSCAN_"+nazwapodstawowa+".txt";
					tabela[2]=sym.SCAN(nazwa);
					System.out.println("..................");
					nazwa="historiaCSCAN_"+nazwapodstawowa+".txt";
					tabela[3]=sym.C_SCAN(nazwa);
					System.out.println("..................");
					nazwa="historiaEDF_"+nazwapodstawowa+".txt";
					tabela[4]=sym.EDF(nazwa);
					System.out.println("..................");
					nazwa="historiaFDSCAN_"+nazwapodstawowa+".txt";
					tabela[5]=sym.FDSCAN(nazwa);
				}
				
				System.out.println("..................");
				System.out.println("..................");
				for(int i=0;i<6;i++)
				{
					System.out.println(t[i]+tabela[i]);
				}
				System.out.println("..................");
				System.out.println("..................");
				break;
				
				
		
			default:
				break;
			}
			
		}while(menu!=0);
		
	}

}