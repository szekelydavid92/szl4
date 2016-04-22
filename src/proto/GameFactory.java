package proto;

import bottom_layer.*;
import common.IWorldObject;
import common.IWorldObjectFactory;
import upper_layer.wormhole.SpecWall;

class GameFactory {
	
	/*
	 * Attributumok
	 */
	private World world;
	private IWorldObjectFactory worldObjectFactory;
	//Itt elterunk a specifikaciotol, de ez kell ide.
	private GameLoop gameLoop;
	
	/*
	 * Metodusok
	 */
	
	GameFactory(GameLoop gameLoop) {
		setGameLoop(gameLoop);
	}
	
	/*
	 * Ott elterunk a specifikaciotol, hogy nem lesz se setWorld, se setWorldObjectFactory, hanem helyette setGameLoop.
	 */
	void setGameLoop(GameLoop gameLoop) {
		this.gameLoop	= gameLoop;
		this.world		= gameLoop.getWorld();
		
		this.worldObjectFactory = this.world.getWorldObjectFactory();
	}
	
	void createWall(double posX,double posY,double width,double height) {
		IWorldObject wallObject = worldObjectFactory.createObject(width, height); 
		wallObject.setPosX(posX);
		wallObject.setPosY(posY);
		
		/*
		 * Mivel ez a resz kikerul a vegso programbol, ezert itt nyugodtan castolhatunk.
		 */
		ProtoGodObject.getInstance().walls.add((WorldObject)wallObject);
	}
	
	void createSpecWall(double posX,double posY,double width,double height) {
		IWorldObject wallObject = worldObjectFactory.createObject(width, height); 
		wallObject.setPosX(posX);
		wallObject.setPosY(posY);
		
		SpecWall specWall = new SpecWall(wallObject);
		
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		ProtoGodObject.getInstance().specWalls.add(specWall);
	}
}