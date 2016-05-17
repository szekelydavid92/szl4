package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	}
	
	/**
	 * @brief Elkéri a releváns infókat, majd lehívja a drawGate-et. A releváns infók elkérését a 
	 * StargateDrawable-hez készített szekvenciadiagramok vázolják fel.
	 * 
	 * @param graphics a java által nyújtott rajzoló objektum
	 */
	void draw(Graphics graphics){
		/*
		 * Itt eltértünk a specifikációtól, csak akkor rajzoljuk ki, ha
		 * ki van lőve.
		 */
		if(stargate.getMasked() == null) {
			return;
		}
		else {
			worldObject = stargate.getMasked().getWorldObject();
		}
		
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
				
		int LineWidth = 10;
        int lineWidthHalf = LineWidth/2;
		
		Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(LineWidth));
		
		switch (direction){
		case UP:
			g2.setColor(color);
			g2.drawLine(x1+lineWidthHalf, y1+lineWidthHalf, x2-lineWidthHalf, y1+lineWidthHalf);
			break;
		case DOWN: 
			g2.setColor(color);
			g2.drawLine(x1+lineWidthHalf, y2-lineWidthHalf, x2-lineWidthHalf, y2-lineWidthHalf);			
			break;
		case RIGHT:
			g2.setColor(color);
			g2.drawLine(x2-lineWidthHalf, y1+lineWidthHalf, x2-lineWidthHalf, y2-lineWidthHalf);
			break;
		case LEFT: 
			g2.setColor(color);
			g2.drawLine(x1+lineWidthHalf, y1+lineWidthHalf, x1+lineWidthHalf, y2-lineWidthHalf);
			break;
		default:
			System.out.println("Nincs megadva irány a StarGate-re!");
			break;
		}
	}

}
