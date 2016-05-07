package view;

import java.awt.Color;
import java.awt.Graphics;

import common.IWorldObject;

/**
 * Ez az osztály felel azért, hogy a különböző játékbeli objektumoktol megkapja azok 
 * megjelenítéséért szolgáló adatokat (pozicio, méret, stb), majd a View osztályból hívva 
 * megrajzolja az elemeket a JFrame-re.
 */
public class Drawable {

	protected IWorldObject worldObject;
	protected Color color;
	
	/**
	 * kirajzolás a JFrame-re
	 * @param worldObject
	 * @param c
	 */
	Drawable(IWorldObject worldObject, Color c){
		this.worldObject = worldObject;
		this.color = c;
	}
	void draw(Graphics graphics){
		graphics.setColor(color);
		graphics.fillRect((int)worldObject.getPosX(),(int)worldObject.getPosY(),(int)worldObject.getWidth(),(int)worldObject.getHeight());
	}
}