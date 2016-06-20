package MatDyskr;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class Wyniki extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public  void wyniki() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wyniki frame = new Wyniki();
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
	public Wyniki() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		PersonTableModel m=new PersonTableModel();
		table = new JTable(m);
		contentPane.add(table, BorderLayout.CENTER);
	}

	public class PersonTableModel extends AbstractTableModel {
		 
	    private List<String> persons = null;
	    private final Object[] columnNames = {"", "Imiê", "Nazwisko", "P³eæ",
	        "Ulica","Nr. d/m", "Miasto", "Kod pocztowy", "Województwo",
	        "Tel. kom", "Tel. dom", "Email"};
	     
	    private final static int HIDDEN_IDX = 0;
	    private final static int NAME_IDX = 1;
	    private final static int SURNAME_IDX = 2;
	    private final static int GENDER_IDX = 3;
	    private final static int STREET_IDX = 4;
	    private final static int APARTMENT_IDX = 5;
	    private final static int CITY_IDX = 6;
	    private final static int ZIPCODE_IDX = 7;
	    private final static int PROVINCE_IDX = 8;
	    private final static int CELL_IDX = 9;
	    private final static int PHONE_IDX = 10;
	    private final static int EMAIL_IDX = 11;
	 
	    public PersonTableModel() {}
	     
	    @Override
	    public int getRowCount() {
	        
	        return 3;
	    }
	 
	    @Override
	    public int getColumnCount() {
	        return 4;
	    }
	     
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	 
	      return "jak";
	    }
	 
	    @Override
	    public String getColumnName(int column) {
	        return "ok";
	    }
	 
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	     
	    public void setModelData(List<String> persons) {
	       this.persons =  persons;
	    }
	  
	  
	}
}
