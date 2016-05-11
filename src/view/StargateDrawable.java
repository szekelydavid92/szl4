package view;

import java.awt.Color;
import java.awt.Graphics;
import common.Direction;
import common.IStargate;
import common.IWorldObject;

/**
 * Ez az osztály felelős a csillagkapu kirajzolásáért.
 */
public class StargateDrawable extends Drawable{

	protected IStargate stargate;
	
	StargateDrawable(IWorldObject worldObject, IStargate stargate, Color c) {
		super(worldObject, c);
		this.stargate = stargate;
		this.drawableType = "StarGateDrawable";
	}
	
	/**
	 * Elkéri a releváns infókat, majd lehívja a drawGate-et. A releváns infók elkérését a 
	 * StargateDrawable-hez készített szekvenciadiagramok vázolják fel.
	 */
	void draw(Graphics graphics){
		this.drawGate(
				this.worldObject.getPosX(),
				this.worldObject.getPosY(),
				this.worldObject.getWidth(),
				this.worldObject.getHeight(),
				stargate.getTeleportDirection(),
				graphics);
	}
	
	/**
	 * kirajzolás a JFrame-re
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param direction
	 * @param graphics
	 */
	void drawGate(double x,double y,double width,double height,Direction direction,Graphics graphics){
				
		int x1 = (int)worldObject.getPosX();
		int x2 = (int)worldObject.getPosX()+(int)worldObject.getWidth();
		int y1 = (int)worldObject.getPosY();
		int y2 = (int)worldObject.getPosY()+(int)worldObject.getHeight();
		
		/*
		graphics.setColor(Color.BLACK);
		graphics.fillRect((int)worldObject.getPosX(),(int)worldObject.getPosY(),(int)worldObject.getWidth(),(int)worldObject.getHeight());
		*/
		
		switch (direction){
		case UP:
			graphics.setColor(color);
			graphics.drawLine(x1, y1, x2, y1);
			break;
		case DOWN: 
			graphics.setColor(color);
			graphics.drawLine(x1, y2, x2, y2);			
			break;
		case RIGHT:
			graphics.setColor(color);
			graphics.drawLine(x2, y1, x2, y2);
			break;
		case LEFT: 
			graphics.setColor(color);
			graphics.drawLine(x1, y1, x1, y2);
			break;
		default:
			System.out.println("Nincs megadva irány a StarGate-re!");
			break;
		}
	}

}
