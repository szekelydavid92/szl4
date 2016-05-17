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
	private static ControllerWhiteBoard controller;
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

		controller = new ControllerWhiteBoard();
		view = new View(controller);
		
		view.addMouseListener(controller);
		view.addKeyListener(controller);
		
		drawableFactory = new DrawableFactory(view);
		gameLoop = new GameLoop(new World(), view);
		gameFactory = new GameFactory(gameLoop, drawableFactory, controller);
				
		loadMap("Maps/Map_1");
		
		gameLoop.run();
		
	}

}
