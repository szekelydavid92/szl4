package view;

import java.awt.Color;
import java.awt.Graphics;

import bottom_layer.World;
import bottom_layer.WorldObjectFactory;
import upper_layer.entity.Player;

public class ViewMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		View v = new View();
		
		World world = new World();
		WorldObjectFactory wof = new WorldObjectFactory(world);
		
		//Oneill megjelemítése
		wof.createObject(10, 10);
		Player Oneill = new Player(1 ,world.getWorldObject(0));
		Drawable draPla = new Drawable(Oneill.getWorldObject(), Color.CYAN);	
		v.add(draPla);
		
		v.repaint();
	}

}
