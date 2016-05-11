package view;

import java.awt.Color;
import java.awt.Graphics;
import common.IDoor;
import common.IWorldObject;

/**
 * Ez az osztály felelős az ajtó kirajzolásáért.
 */
public class DoorDrawable extends Drawable{
	
	protected IDoor door;

	DoorDrawable(IWorldObject worldObject, Color c) {
		super(worldObject, c);
		this.drawableType = "DoorDrawable";
	}
	
	/**
	 * Ez a függvény felelős azért, hogy kirajzolja az ajtót a JFrame-re.
	 */
	void draw(Graphics graphics){		
		//ha nyitva a kapu nem rajzolunk
		if(door.isOpen()){
			return;
		}
		else {
			//zárt ajtó esetén rajzolunk
			super.draw(graphics);
		}
		
	}

}
