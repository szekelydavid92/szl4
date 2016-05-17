package upper_layer;

import java.util.Map;
import java.util.TreeMap;

import bottom_layer.*;
import common.CollisionResponse;
import common.IController;
import common.IDrawableFactory;
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
import view.*;

public class GameFactory {
	
	/*
	 * Attributumok
	 */
	private World world;
	private IWorldObjectFactory worldObjectFactory;
	private ZPMObserver zpmObserver;
	//Itt elterunk a specifikaciotol, de ez kell ide.
	private GameLoop gameLoop;
	
	private IDrawableFactory drawableFactory;
	private IController controller;
	
	/*
	 * Itt is, es ez nem biztos, hogy a legszebb megoldas
	 */
	Map<Integer,Scale> scales = new TreeMap<Integer,Scale>();
	Map<Integer,Door> doors = new TreeMap<Integer,Door>();
	
	/*
	 * Metodusok
	 */
	
	public GameFactory(GameLoop gameLoop, IDrawableFactory drawableFactory,IController controller) {
		setGameLoop(gameLoop);
		zpmObserver = new ZPMObserver(this);
		this.drawableFactory = drawableFactory;
		this.controller = controller;
	}
	
	/*
	 * Ott elterunk a specifikaciotol, hogy nem lesz se setWorld, se setWorldObjectFactory, hanem helyette setGameLoop.
	 */
	
	void setGameLoop(GameLoop gameLoop) {
		this.gameLoop	= gameLoop;
		this.world		= gameLoop.getWorld();
		
		this.worldObjectFactory = this.world.getWorldObjectFactory();
		this.zpmObserver = new ZPMObserver(this);
	}
	
	/**
	 * @brief Uj fal letrehozasaert felelos fuggveny
	 * 
	 * @param posX a fal X koordinataja
	 * @param posY a fal Y koordinataja
	 * @param width a fal szelessege
	 * @param height a fal magassaga
	 * 
	 * @return void
	 */
	public void createWall(double posX,double posY,double width,double height) {
		IWorldObject wallObject = worldObjectFactory.createObject(width, height); 
		wallObject.setPosX(posX);
		wallObject.setPosY(posY);
		wallObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		
		/*
		 * Mivel ez a resz kikerul a vegso programbol, ezert itt nyugodtan castolhatunk.
		 */
		//ProtoGodObject.getInstance().walls.add((WorldObject)wallObject);
		drawableFactory.createObjectDrawable(wallObject, new DrawableColor(0, 0, 0));
	}
	
	/**
	 * @brief Uj specialis fal letrehozasaert felelos fuggveny
	 * 
	 * @param posX a fal X koordinataja
	 * @param posY a fal Y koordinataja
	 * @param width a fal szelessege
	 * @param height a fal magassaga
	 * 
	 * @return void
	 */
	public void createSpecWall(double posX,double posY,double width,double height) {
		IWorldObject wallObject = worldObjectFactory.createObject(width, height); 
		wallObject.setPosX(posX);
		wallObject.setPosY(posY);
		wallObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		
		SpecWall specWall = new SpecWall(wallObject);
		
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		//ProtoGodObject.getInstance().specWalls.add(specWall);
		drawableFactory.createObjectDrawable(wallObject, new DrawableColor(128, 128, 128));
		//TODO
	}
	
	/**
	 * @brief Uj jatekos letrehozasaert felelos fuggveny
	 * 
	 * @param name a jatekos neve
	 * @param posX a jatekos X koordinataja
	 * @param posY a jatekos Y koordinataja
	 * @param width a jatekos szelessege
	 * @param height a jatekos magassaga
	 * @param mass a jatekos tomege
	 * 
	 * @return void
	 */
	public void createPlayer(String name,double x,double y,double width,double height,double mass){
		IWorldObject playerObject = worldObjectFactory.createObject(width, height); 
		playerObject.setPosX(x);
		playerObject.setPosY(y);
		
		/*
		 * Itt esetszetvalasztas jon, ha valamelyik jatekost hoztuk letre, akkor
		 * Playert peldanyositunk, ha nem, akkor replikatort.
		 */
		if (name.equals("oneill") || name.equals("jaffa")) {
			//if(ProtoGodObject.getInstance().players.get(name) == null) {
				/*
				 * Minden uj jatekosnak letrehozunk egy uj WormHole-t.
				 */
				//WormHole wormHole = new WormHole(); //Tobbe mar nem.
			
				DrawableColor blueColor = new DrawableColor(0,0,255);
				DrawableColor yellowColor = new DrawableColor(255,255,0);
				
				if(name.equals("jaffa")) {
					blueColor.r = 255;
					blueColor.b = 0;
					
					yellowColor.r = 0;
				}
				/*
				 * Minden uj wormholenak letrehozunk egy uj ProjectileFactoryt.
				 */
				IProjectileFactory projFactory = new ProjectileFactory(worldObjectFactory,drawableFactory,blueColor,yellowColor/*wormHole*/);
				
				/*
				 * A jatekost tarsitjuk a neki megfelelo ProjectileFactoryvel.
				 */
				Player player = new Player(playerObject,projFactory,mass);
				
				/*
				 * Majd hozzaadjuk a vilaghoz, hogy elorelephessen az idoben.
				 */
				gameLoop.addEntity(player);
				
				if(name.equals("oneill")) { //marad [még]
					/*
					 * A modositas csak az ezredes altal felszedett 2 ZPM utan
					 * keri az uj ZPM lepakolasat.
					 */
					player.registerZPMObserver(zpmObserver);
					
					/*
					 * Ez a resz kikerul a vegso programbol.
					 */
					//ProtoGodObject.getInstance().oneillController.setPlayer(player);
					drawableFactory.createObjectDrawable(playerObject, new DrawableColor(255, 20, 147));
					controller.setOneill(player);
				}
				if(name.equals("jaffa")) { //controllers marad [még]
					/*
					 * Ez a resz kikerul a vegso programbol.
					 */
					//ProtoGodObject.getInstance().jaffaController.setPlayer(player);
					drawableFactory.createObjectDrawable(playerObject, new DrawableColor(255, 168, 255));
					controller.setJaffa(player);
				}
				
				/*
				 * Ez a resz kikerul a vegso programbol.
				 */
				//ProtoGodObject.getInstance().wormholes.put(name,wormHole); //TODO
				//ProtoGodObject.getInstance().players.put(name,player);
				
			//}
				//drawableFactory.createObjectDrawable(playerObject, new DrawableColor(255, 0, 0));
		}
		else /*if (name.equals("replikator"))*/ {
			playerObject.setCollisionResponse(CollisionResponse.REPLICATOR);
			
			/*
			 * Letrehozzuk az uj replikatort.
			 */
			Replicator replikator = new Replicator(playerObject,mass);
			
			/*
			 * A replikatorhoz a neki megfelelo controllert.
			 */
			ReplicatorController replicatorController = new ReplicatorController(replikator);
			
			/*
			 * A replicator controller elobb kerul a vilagba, mert igy a replikator mar
			 * ugyanabban a ciklusban megkapja a vezerlest.
			 * (forditott esetben csak egy frame-et kesne, ami nem jelentos)
			 */
			gameLoop.addEntity(replicatorController);
			
			/*
			 * Majd a replikatort is, hasonloan a jatekoshoz.
			 */
			gameLoop.addEntity(replikator);
			
			/*
			 * Ez a resz kikerul a vegso programbol.
			 */
			/*
			ProtoGodObject.getInstance().replicator=replikator;
			ProtoGodObject.getInstance().replicatorController=replicatorController;
			ProtoGodObject.getInstance().players.put(name,replikator);
			*/
			
			drawableFactory.createObjectDrawable(playerObject, new DrawableColor(255, 0, 0));
		}
	}
	
	/**
	 * @brief Uj szakadek letrehozasaert felelos fuggveny
	 * 
	 * @param posX a szakadek X koordinataja
	 * @param posY a szakadek Y koordinataja
	 * @param width a szakadek szelessege
	 * @param height a szakadek magassaga
	 * 
	 * @return void
	 */
	public void createChasm(double x, double y,double width,double height){
		IWorldObject chasmObject = worldObjectFactory.createObject(width, height); 
		chasmObject.setPosX(x);
		chasmObject.setPosY(y);
		
		chasmObject.setCollisionResponse(CollisionResponse.PASS);
		chasmObject.setVisitable(Chasm.getInstance());
		chasmObject.setCollisionObserver(Chasm.getInstance());
		Chasm.getInstance().getChasms().add(chasmObject);
		drawableFactory.createObjectDrawable(chasmObject, new DrawableColor(100, 50, 0));
	}
	
	/**
	 * @brief Uj doboz letrehozasaert felelos fuggveny
	 * 
	 * @param posX a doboz X koordinataja
	 * @param posY a doboz Y koordinataja
	 * @param width a doboz szelessege
	 * @param height a doboz magassaga
	 * @param mass a doboz tomege
	 * 
	 * @return void
	 */
	public void createBox(double x, double y, double width, double height,double mass){
		IWorldObject boxObj = worldObjectFactory.createObject(width, height); 
		boxObj.setPosX(x);
		boxObj.setPosY(y);
		boxObj.setCollisionResponse(CollisionResponse.PASS);
		
		Box box = new Box(boxObj, mass);
		gameLoop.addEntity(box);
		
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		//ProtoGodObject.getInstance().boxes.add(box);
		drawableFactory.createObjectDrawable(boxObj, new DrawableColor(255, 128, 0));
	}


	/**
	 * @brief Uj merleg letrehozasaert felelos fuggveny
	 * 
	 * @param posX a merleg X koordinataja
	 * @param posY a merleg Y koordinataja
	 * @param width a merleg szelessege
	 * @param height a merleg magassaga
	 * @param mass a merleg tomeghatara
	 * @param id a merleg id-ja
	 * 
	 * @return void
	 */
	public void createScale(double x, double y, double width, double height, double mass, int id){
		IWorldObject scaleObject = worldObjectFactory.createObject(width, height); 
		scaleObject.setPosX(x);
		scaleObject.setPosY(y);
		scaleObject.setCollisionResponse(CollisionResponse.PASS);
		
		Scale scale = new Scale(scaleObject, mass);
		gameLoop.addEntity(scale);
		
		Door door = doors.get(id);
		if(door != null) {
			doors.remove(id);
			scale.setDoor(door);
		} else {
			scales.put(id, scale);
		}
		
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		//ProtoGodObject.getInstance().scales.add(scale);
		drawableFactory.createObjectDrawable(scaleObject, new DrawableColor(0, 255, 255));
	}

	/**
	 * @brief Uj ajto letrehozasaert felelos fuggveny
	 * 
	 * @param posX az ajto X koordinataja
	 * @param posY az ajto Y koordinataja
	 * @param width az ajto szelessege
	 * @param height az ajto magassaga
	 * @param id az ajto id-ja
	 * 
	 * @return void
	 */
	public void createDoor(double x, double y, double width, double height, int id) {
		IWorldObject doorObject = worldObjectFactory.createObject(width, height); 
		doorObject.setPosX(x);
		doorObject.setPosY(y);
		 
		Door door = new Door(doorObject);
		gameLoop.addEntity(door);
		
		Scale scale = scales.get(id);
		if(scale != null) {
			scales.remove(id);
			scale.setDoor(door);
		} else {
			doors.put(id, door);
		}
		
		/*
		 * Ez a resz kikerul a vegso programbol.
		 */
		//ProtoGodObject.getInstance().doors.add(door);
		drawableFactory.createDoorDrawable(doorObject, door, new DrawableColor(0, 255, 255));
	}
	
	/**
	 * @brief Uj zpm letrehozasaert felelos fuggveny
	 * 
	 * @param posX a zpm X koordinataja
	 * @param posY a zpm Y koordinataja
	 * @param width a zpm szelessege
	 * @param height a zpm magassaga
	 * 
	 * @return void
	 */
	public void createZpm(double x, double y,double width, double height){
		IWorldObject zpmObj = worldObjectFactory.createObject(width, height); 
		zpmObj.setPosX(x);
		zpmObj.setPosY(y);
		zpmObj.setCollisionResponse(CollisionResponse.PASS);
		
		ZPM zpm = new ZPM(zpmObj);
		drawableFactory.createObjectDrawable(zpmObj, new DrawableColor(0, 100, 0));
		
	}
	
	/*
	 * Itt elterunk a specifikaciotol, ez a fuggveny kifelejtodott
	 */

	/**
	 * @brief Uj zpm random pozicio letrehozasaert felelos fuggveny
	 * 
	 * @param posX a zpm X koordinataja
	 * @param posY a zpm Y koordinataja
	 * @param width a zpm szelessege
	 * @param height a zpm magassaga
	 * 
	 * @return void
	 */
	public void createZpmRandPos(double x, double y,double width, double height) {
		zpmObserver.add(x, y, width, height);
	}
}