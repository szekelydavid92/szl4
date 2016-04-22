package proto;

import bottom_layer.*;

import common.IWorldObject;
import common.IWorldObjectFactory;
import upper_layer.wormhole.SpecWall;
import upper_layer.entity.*;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.Scale;

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
	
	/*public void setWorld(World world){
		this.world = world;
	}*/
	
	
	
	
	
	
	
	public void setWorldObjectFactory(IWorldObjectFactory factory){
		this.worldObjectFactory = factory;
	}
	
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
	
	public void createPlayer(String name,double x,double y,double width,double height,double mass){
		IWorldObject playerObject = worldObjectFactory.createObject(width, height); 
		playerObject.setPosX(x);
		playerObject.setPosY(y);
		
		Player player = new Player(playerObject,mass);
		//player.name = new String(name);
		gameLoop.addEntity(player);
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		//ProtoGodObject.getInstance().specWalls.add(specWall);
	}
	
	public void createChasm(double x, double y,double width,double height){
		IWorldObject chasmObject = worldObjectFactory.createObject(width, height); 
		chasmObject.setPosX(x);
		chasmObject.setPosY(y);
		
		
		chasmObject.setVisitable(Chasm.getInstance());
		Chasm.getInstance().getChasms().add(chasmObject);
		//ProtoGodObject.getInstance().specWalls.add(specWall);
	}
	
	public void createBox(double x, double y, double width, double height,double mass){
		IWorldObject boxObj = worldObjectFactory.createObject(width, height); 
		boxObj.setPosX(x);
		boxObj.setPosY(y);
		
		Box box = new Box(boxObj, mass);
		gameLoop.addEntity(box);
		//ProtoGodObject.getInstance().specWalls.add(specWall);
	}
	
	public void createScale(double x, double y, double width, double height, double mass, int id){
		IWorldObject scaleObject = worldObjectFactory.createObject(width, height); 
		scaleObject.setPosX(x);
		scaleObject.setPosY(y);
		

		Scale scl = new Scale(scaleObject, mass);
		Chasm.getInstance().getChasms().add(scaleObject);
		gameLoop.addEntity(scl);
		
		//ProtoGodObject.getInstance().specWalls.add(specWall);
	}
	
	 public void createDoor(double x, double y, double width, double height, int id){
		 IWorldObject doorObject = worldObjectFactory.createObject(width, height); 
		 doorObject.setPosX(x);
		 doorObject.setPosY(y);
		 
		 Door door = new Door(doorObject);
		 gameLoop.addEntity(door);
		//ProtoGodObject.getInstance().specWalls.add(specWall);
	 }
}