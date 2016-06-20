package ZbioryRozmyte2;

import java.awt.Color;
import java.awt.Graphics;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JPanel;

public class Wykres extends JPanel {
	int xMAX=105,xMIN=5;
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(5, 5, 105, 5);
		g.drawLine(5, 105, 105, 105);
		g.drawLine(5, 5, 5, 105);
		g.drawLine(105, 105, 105, 5);
		int x1=0,y1=0,x2=0,y2=0;
		
		for(int i=0;i<100;i++)
			{
				x1=i;x2=i+1;
				
				y1=oblicz("x+2", x1);
				y2=oblicz("x2", x2);
				//g.drawLine(x1-100, y1-100, x2-100, y2-100);
				g.drawLine(5+x1, 105-y1, 5+x2, 105-y2);
			}
		
	}
	public int oblicz(String wzor,int x)
	{
		String s=String.valueOf(x);
		String nwzor=wzor.replaceAll("x",s );
		ScriptEngineManager mgr =new ScriptEngineManager();
		ScriptEngine engine=mgr.getEngineByName("JavaScript");
		String foo=nwzor;
		System.out.println(foo);
		
		try {
			return Integer.valueOf( String.valueOf( engine.eval(foo)));
		} catch (ScriptException e) {
			System.out.println("bledne dane");
		}
		return 0;
	}


	public void set(int x, int y) {
		xMAX=x;xMIN=y;
		
	}
	
}
