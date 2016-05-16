package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import common.IView;

/**
 * Ez az osztaly felel azert, hogy a kapott a Drawable objektumokat kirajzolja, 
 * azok vegigiterealasaval, torolje a removable elemeket, inicializalja a JFrame-t, stb
 */
class View extends JFrame implements IView {
	
	/*
	 * Itt eltértünk a specifikációtól, ez kell ahhoz, hogy
	 * a teljes pálya megjelenjen.
	 */
	class Canvas extends JPanel {
		LinkedList<Drawable> drawableList = new LinkedList<Drawable>();
		
		/**
		 * JFrame-re kirajzolas (repaint() hivasra ) 
		 */
		@Override
		public void paint(Graphics g){
			super.paint(g);
			for(int i=0; i<drawableList.size(); i++){
				drawableList.get(i).draw(g);
			}
			g.setColor(Color.WHITE);
			if(controller.oneill == null || controller.jaffa ==null){
				
			}
			else{
				g.drawString("O'neill ZPM's:"+controller.oneill.getNumZPM()+" Jaffa ZPM's:"+controller.jaffa.getNumZPM(), 30, 260);
			}
			
		}

	}

	//LinkedList<Drawable> drawableList = new LinkedList<Drawable>();
	Canvas canvas = new Canvas();
	
	/*
	 * Itt eltérünk a specifikációtól, és jó randa dolog ez.
	 */
	ControllerWhiteBoard controller;
	
	/**
	 * Konstruktor- JFrame ablak megnyitasa, ablak konfiguralasa (meret, pozicio, cimke, stb)
	 */
	View(ControllerWhiteBoard controller){
		super("Sivatagi_Lotunderek_presents...");
		
		this.controller = controller;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(640, 480);
		this.setLocation(50, 50);
		
		this.add(canvas);
		canvas.setBackground(new Color(255,255,255));
		canvas.setPreferredSize(new Dimension(750, 270));
		
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Ez a fuggveny csomagolja a repaint() metodust
	 */
	@Override
	public void render() {
		/*
		 * Na, amit MOST csinálok, az RANDA!!!
		 */
		Point mousePos = canvas.getMousePosition();
		if(mousePos != null) {
			controller.setMousePos(mousePos.getX(),mousePos.getY());
		}
		
		/*
		 * Itt jön a függvény tényleges funkcionalitása.
		 */
		repaint();
	}
	
	/**
	 * JFrame-re kirajzolas (repaint() hivasra ) 
	 */
	/*@Override
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0; i<drawableList.size(); i++){
			drawableList.get(i).draw(g);
		}
	}*/
	
	/**
	 * uj megjelenitheto elem hozzzadasa
	 * @param d
	 */
	void add(Drawable d){
		//drawableList.add(d);
		canvas.drawableList.add(d);
	}
	
	
	
}