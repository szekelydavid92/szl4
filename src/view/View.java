package view;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import common.IView;

/**
 * Ez az osztaly felel azert, hogy a kapott a Drawable objektumokat kirajzolja, 
 * azok vegigiterealasaval, torolje a removable elemeket, inicializalja a JFrame-t, stb
 */
class View extends JFrame implements IView {

	List<Drawable> drawableList;
	
	/**
	 * Konstruktor- JFrame ablak megnyitasa, ablak konfiguralasa (meret, pozicio, cimke, stb)
	 */
	View(){
		
	}
	
	/**
	 * Ez a fuggveny csomagolja a repaint() metodust
	 */
	@Override
	public void render() {
		// TODO Auto-generated method stub
		repaint();
	}
	
	/**
	 * JFrame-re kirajzolas (repaint() hivasra ) 
	 */
	@Override
	public void paint(Graphics g){
		super.paint(g);
		// TODO
	}
	
	/**
	 * uj megjelenitheto elem hozzzadasa
	 * @param d
	 */
	void add(Drawable d){
		
	}
	
	
	
}