package view;

import java.awt.Color;
import java.awt.Graphics;
import common.IDoor;
import common.IWorldObject;

/**
 * Ez az osztály felelős az ajtó kirajzolásáért.
 */
public class DoorDrawable extends Drawable{
	
	public IDoor door;

	DoorDrawable(IWorldObject worldObject,IDoor d, Color c) {
		super(worldObject, c);
		this.door = d;
	}
	
	/**
	 * @brief Ez a függvény felelős azért, hogy kirajzolja az ajtót a JFrame-re.
	 * 
	 * @param graphics a java által nyújtott rajzoló objektum
	 */
	void draw(Graphics graphics){		
		//ha nyitva a kapu nem rajzolunk
		if(door.isOpen()){
			
		}
		else {
			//zárt ajtó esetén rajzolunk
			super.draw(graphics);
		}
		
	}

}
