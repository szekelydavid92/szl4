package view;

import java.awt.Color;
import java.awt.Graphics;

import bottom_layer.World;
import bottom_layer.WorldObjectFactory;
import common.Direction;
import upper_layer.entity.Player;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

public class ViewMain {

	public static void main(String[] args) {

		View v = new View();
		
		World world = new World();
		WorldObjectFactory wof = new WorldObjectFactory(world);
		
		//Oneill megjelemítése
		wof.createObject(10, 10);
		Player Oneill = new Player(1 ,world.getWorldObject(0));
		Drawable draPla = new Drawable(Oneill.getWorldObject(), Color.CYAN);	
		v.add(draPla);
		
		//StarGate megjelemítése
		
		//2 specwall létrehozása
		wof.createObject(10, 10);
		world.getWorldObject(0).setPosX(30);
		SpecWall swall1 = new SpecWall(world.getWorldObject(1));
		
		wof.createObject(10, 10);
		world.getWorldObject(0).setPosX(60);
		SpecWall swall2 = new SpecWall(world.getWorldObject(2));
		
		//féreglyuk beállítása
		WormHole wh = new WormHole();
		wh.setBlue(swall1, Direction.DOWN);
		wh.setYellow(swall2, Direction.RIGHT);
		
		Drawable spec1Dra = new Drawable(swall1.getWorldObject(), Color.DARK_GRAY);
		Drawable spec2Dra = new Drawable(swall2.getWorldObject(), Color.DARK_GRAY);
		StargateDrawable bdrStar = new StargateDrawable(wh.blueGate.getMasked().getWorldObject(), Color.BLUE);
		StargateDrawable ydrStar = new StargateDrawable(wh.yellowGate.getMasked().getWorldObject(), Color.YELLOW);

		v.add(spec1Dra);
		v.add(spec2Dra);
		v.add(bdrStar);
		v.add(ydrStar);
		
		v.repaint();
	}

}
