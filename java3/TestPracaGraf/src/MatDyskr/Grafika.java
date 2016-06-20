package MatDyskr;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Grafika extends JFrame implements KeyListener{

	static private JPanel glowne;
	static private JTextField wyswietl;
	static private JLabel wpisz;
	private Srodowisko srodowisko;
	private int stan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafika frame = new Grafika();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grafika() {
		srodowisko=new Srodowisko();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		glowne = new JPanel();
		glowne.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(glowne);
		glowne.setLayout(null);
		
		JButton btnWczytaj = new JButton("Wczytaj");
		btnWczytaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stan=1;
				stan=srodowisko.wczytaj(wpisz,wyswietl,stan);
				
			}
		});
		btnWczytaj.setBounds(323, 13, 97, 25);
		glowne.add(btnWczytaj);
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.setBounds(323, 44, 97, 25);
		glowne.add(btnZapisz);
		
		JButton btnPytania = new JButton("Pytania");
		btnPytania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srodowisko.ustawpytania(wpisz);
			}
		});
		btnPytania.setBounds(323, 92, 97, 25);
		glowne.add(btnPytania);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.setBounds(323, 126, 97, 25);
		glowne.add(btnStudent);
		
		JButton btnFirma = new JButton("Firma");
		btnFirma.setBounds(323, 155, 97, 25);
		glowne.add(btnFirma);
		
		JButton btnWyniki = new JButton("Wyniki");
		btnWyniki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wyniki w=new Wyniki();
				w.wyniki();
			}
		});
		btnWyniki.setBounds(323, 204, 97, 25);
		glowne.add(btnWyniki);
		
		JLabel lblSekcja = new JLabel("Sekcja");
		lblSekcja.setHorizontalAlignment(SwingConstants.CENTER);
		lblSekcja.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSekcja.setBounds(99, 17, 130, 21);
		glowne.add(lblSekcja);
		
		wpisz = new JLabel("Co masz zrobic");
		wpisz.setBounds(12, 44, 259, 75);
		glowne.add(wpisz);
		
		wyswietl = new JTextField();
		wyswietl.setBounds(12, 138, 259, 57);
		glowne.add(wyswietl);
		wyswietl.setColumns(10);
		
		JButton btnNastepny = new JButton("Nastepny");
		btnNastepny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stan=srodowisko.wczytaj(wpisz, wyswietl, stan);
			}
		});
		btnNastepny.setBounds(99, 204, 97, 25);
		glowne.add(btnNastepny);
		
		glowne.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar()+"ji");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar()+"ji");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
