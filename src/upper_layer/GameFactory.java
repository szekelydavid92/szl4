package upper_layer;

import java.util.Map;
import java.util.TreeMap;

import bottom_layer.*;
import common.CollisionResponse;
import common.IProjectileFactory;
import common.IWorldObject;
import common.IWorldObjectFactory;
import proto.ProtoGodObject;
import upper_layer.wormhole.ProjectileFactory;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.WormHole;
import upper_layer.entity.*;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.Scale;
import upper_layer.reactive.ZPM;

public class GameFactory {
	
	/*
	 * Attributumok
	 */
	private World world;
	private IWorldObjectFactory worldObjectFactory;
	private ZPMObserver zpmObserver;
	//Itt elterunk a specifikaciotol, de ez kell ide.
	private GameLoop gameLoop;
	
	/*
	 * Itt is, es ez nem a legszebb megoldas
	 */
	Map<Integer,Scale> scales = new TreeMap<Integer,Scale>();
	Map<Integer,Door> doors = new TreeMap<Integer,Door>();
	
	/*
	 * Metodusok
	 */
	
	public GameFactory(GameLoop gameLoop) {
		setGameLoop(gameLoop);
		zpmObserver = new ZPMObserver(this);
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
	
	public void createWall(double posX,double posY,double width,double height) {
		IWorldObject wallObject = worldObjectFactory.createObject(width, height); 
		wallObject.setPosX(posX);
		wallObject.setPosY(posY);
		wallObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		
		/*
		 * Mivel ez a resz kikerul a vegso programbol, ezert itt nyugodtan castolhatunk.
		 */
		ProtoGodObject.getInstance().walls.add((WorldObject)wallObject);
	}
	
	public void createSpecWall(double posX,double posY,double width,double height) {
		IWorldObject wallObject = worldObjectFactory.createObject(width, height); 
		wallObject.setPosX(posX);
		wallObject.setPosY(posY);
		wallObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		
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
		
		if (name.equals("oneill") || name.equals("jaffa")) {
			if(ProtoGodObject.getInstance().players.get(name) == null) {
				
				WormHole wormHole = new WormHole();
				IProjectileFactory projFactory = new ProjectileFactory(worldObjectFactory,wormHole);
				Player player = new Player(playerObject,projFactory,mass);
				gameLoop.addEntity(player);
				
				if(name.equals("oneill")) {
					ProtoGodObject.getInstance().oneillController.setPlayer(player);
				}
				if(name.equals("jaffa")) {
					ProtoGodObject.getInstance().jaffaController.setPlayer(player);
				}
				/*
				 * Ez a resz kikerul a vegso programbol.
				 */
				ProtoGodObject.getInstance().wormholes.put(name,wormHole);
				ProtoGodObject.getInstance().players.put(name,player);
			}
		}
		else if (name.equals("replikator")) {
			Replicator replikator = new Replicator(playerObject,mass);
			ReplicatorController replicatorController = new ReplicatorController(replikator);
			gameLoop.addEntity(replicatorController);
			gameLoop.addEntity(replikator);
			/*
			 * Ez a resz kikerul a vegso programbol.
			 */
			ProtoGodObject.getInstance().replicator=replikator;
			ProtoGodObject.getInstance().replicatorController=replicatorController;
			ProtoGodObject.getInstance().players.put(name,replikator);
		}
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		//ProtoGodObject.getInstance().players.put(name,player);
	}
	
	public void createChasm(double x, double y,double width,double height){
		IWorldObject chasmObject = worldObjectFactory.createObject(width, height); 
		chasmObject.setPosX(x);
		chasmObject.setPosY(y);
		
		chasmObject.setVisitable(Chasm.getInstance());
		Chasm.getInstance().getChasms().add(chasmObject);
	}
	
	public void createBox(double x, double y, double width, double height,double mass){
		IWorldObject boxObj = worldObjectFactory.createObject(width, height); 
		boxObj.setPosX(x);
		boxObj.setPosY(y);
		boxObj.setCollisionResponse(CollisionResponse.PASS);
		
		Box box = new Box(boxObj, mass);
		gameLoop.addEntity(box);
		ProtoGodObject.getInstance().boxes.add(box);
	}
	
	public void createScale(double x, double y, double width, double height, double mass, int id){
		IWorldObject scaleObject = worldObjectFactory.createObject(width, height); 
		scaleObject.setPosX(x);
		scaleObject.setPosY(y);
		scaleObject.setCollisionResponse(CollisionResponse.PASS);
		

		Scale scl = new Scale(scaleObject, mass);
		Chasm.getInstance().getChasms().add(scaleObject);
		gameLoop.addEntity(scl);
		
		Door door = doors.get(id);
		if(door != null) {
			doors.remove(id);
			scl.setDoor(door);
		}
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		ProtoGodObject.getInstance().scales.add(scl);
	}
	
	public void createDoor(double x, double y, double width, double height, int id){
		IWorldObject doorObject = worldObjectFactory.createObject(width, height); 
		doorObject.setPosX(x);
		doorObject.setPosY(y);
		 
		Door door = new Door(doorObject);
		gameLoop.addEntity(door);
		
		Scale scale = scales.get(id);
		if(scale != null) {
			scales.remove(id);
			scale.setDoor(door);
		}
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		ProtoGodObject.getInstance().doors.add(door);
	}
	 
	public void createZpm(double x, double y,double width, double height){
		IWorldObject zpmObj = worldObjectFactory.createObject(width, height); 
		zpmObj.setPosX(x);
		zpmObj.setPosY(y);
		zpmObj.setCollisionResponse(CollisionResponse.PASS);
		
		ZPM zpm = new ZPM(zpmObj);
	}
	
	/*
	 * Itt elterunk a specifikaciotol, ez a fuggveny kifelejtodott
	 */
	
	public void createZpmRandPos(double x, double y,double width, double height) {
		zpmObserver.add(x, y, width, height);
	}
}