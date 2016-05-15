package view;

import java.awt.Color;
import java.awt.Graphics;

import bottom_layer.GameLoop;
import bottom_layer.World;
import bottom_layer.WorldObjectFactory;
import common.Direction;
import common.IWorldObject;
import common.IWorldObjectFactory;
import proto.LevelLoader;
import upper_layer.GameFactory;
import upper_layer.entity.Door;
import upper_layer.entity.Player;
import upper_layer.reactive.Chasm;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

public class ViewMain {
	
	private static View view;
	private static DrawableFactory drawableFactory;
	private static GameLoop gameLoop;
	private static GameFactory gameFactory;
	
	private static boolean loadMap(String map)
	{	
		LevelLoader levelLoader = new LevelLoader();
		levelLoader.load(map, gameFactory);
		return true;
	}
	public static void main(String[] args) {
		
		view = new View();
		drawableFactory = new DrawableFactory(view);
		gameLoop = new GameLoop(new World(), view);
		gameFactory = new GameFactory(gameLoop, drawableFactory);
		
		loadMap("Maps/Map_1");
		
		gameLoop.run();
		
		
		//IWorldObjectFactory wof =IWorldObjectFactor
		/*
		//Oneill megjelemítése
		IWorldObject puszcsy = wof.createObject(40, 40);
		puszcsy.setPosY(50);
		Player Oneill = new Player(1 ,puszcsy);
		Drawable draPla = new Drawable(Oneill.getWorldObject(), Color.CYAN);	
		v.add(draPla);
		
		//StarGate megjelemítése
		
		//2 specwall létrehozása
		puszcsy = wof.createObject(40, 40);
		puszcsy.setPosX(40);
		puszcsy.setPosY(170);
		SpecWall swall1 = new SpecWall(puszcsy);
		
		puszcsy = wof.createObject(40, 40);
		puszcsy.setPosX(40);
		puszcsy.setPosY(40);
		SpecWall swall2 = new SpecWall(puszcsy);
		
		Drawable spec1Dra = new Drawable(swall1.getWorldObject(), Color.DARK_GRAY);
		Drawable spec2Dra = new Drawable(swall2.getWorldObject(), Color.DARK_GRAY);
		
		//féreglyuk beállítása
		WormHole wh = new WormHole();
		wh.setBlue(swall1, Direction.LEFT);
		wh.setYellow(swall2, Direction.RIGHT);
				
		StargateDrawable bdrStar = new StargateDrawable(swall1.getWorldObject(), wh.blueGate, Color.BLUE);
		StargateDrawable ydrStar = new StargateDrawable(swall2.getWorldObject(), wh.yellowGate, Color.YELLOW);
		
		
		//Ajtó megjelenítése
		puszcsy = wof.createObject(40, 40);
		puszcsy.setPosX(80);
		puszcsy.setPosY(100);
		Door d = new Door(puszcsy);
		d.open();
		DoorDrawable drd = new DoorDrawable(puszcsy,d, Color.RED);
		
		//kirajzoláshoz
		v.add(spec1Dra);
		v.add(spec2Dra);
		v.add(bdrStar);
		v.add(ydrStar);
		v.add(drd);
		
		v.render();
		*/
	}

}
