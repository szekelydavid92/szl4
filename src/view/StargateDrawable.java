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
	
	StargateDrawable(IWorldObject worldObject, Color c) {
		super(worldObject, c);
	}
	
	/**
	 * Elkéri a releváns infókat, majd lehívja a drawGate-et. A releváns infók elkérését a 
	 * StargateDrawable-hez készített szekvenciadiagramok vázolják fel.
	 */
	void draw(Graphics graphics){
		IWorldObject w = stargate.getMasked().getWorldObject();
		this.drawGate(w.getPosX(), w.getPosY(), w.getWidth(), w.getHeight(), stargate.getTeleportDirection(), graphics);
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
		
	}
	
	
}