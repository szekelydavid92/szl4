package proto;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import bottom_layer.GameLoop;
import bottom_layer.World;
import bottom_layer.WorldObject;
import common.IWorldObject;
import upper_layer.wormhole.SpecWall;

class ProtoGodObject {
	private World world;
	private GameLoop gameLoop;
	
	private static ProtoGodObject instance = null;
	
	/*
	 * Ott elterunk a specifikaciotol, hogy ezek az attributumok publicok,
	 * mivel ez ugyis kikerul a vegso programbol, ez nem tragedia.
	 */
	public List<WorldObject> walls = new LinkedList<WorldObject>();
	public List<SpecWall> specWalls = new LinkedList<SpecWall>();
	
	public static ProtoGodObject getInstance() {
		if(instance == null) {
			instance = new ProtoGodObject();
		}
		
		return instance;
	}

	private void run(int iterations) {
		for(int i=0;i < iterations;i++) {
			gameLoop.run();
		}
	}
	
	private boolean loadMap(String map)
	{
		world = new World();
		gameLoop = new GameLoop(world);

		walls.clear();
		specWalls.clear();
		
		GameFactory gameFactory = new GameFactory(gameLoop);
		
		gameFactory.createWall(0, 0, 10, 10);
		gameFactory.createWall(0, 10, 10, 20);
		gameFactory.createSpecWall(10, 10, 10, 20);
		
		return true;
	}
	
	private void listWalls() {
		
		for(WorldObject o : walls) {
			System.out.println("Pozíció: [" + o.getPosX() + "," + o.getPosY() + "]");
			System.out.println("Fal szélessége: [" + o.getWidth() + "],Magassága: [" + o.getHeight() + "]");
			System.out.println("Fal típusa: általános");
			System.out.println("Falhoz tartozó csillagkapu:");
			System.out.println("");
		}
		
		for(SpecWall s : specWalls) {
			IWorldObject o = s.getWorldObject();
			System.out.println("Pozíció: [" + o.getPosX() + "," + o.getPosY() + "]");
			System.out.println("Fal szélessége: [" + o.getWidth() + "],Magassága: [" + o.getHeight() + "]");
			System.out.println("Fal típusa: speciális");
			System.out.println("Falhoz tartozó csillagkapu:"); //TODO ezt meg kell csinalni
			System.out.println("");
		}
	}
	
	public static class ProtoLoadMap implements IProtoCommand {
		
		/*
		 * VIGYAZAT! A palyanevbe implementacios okokbol NE keruljon szokoz!
		 */
		@Override
		public boolean Execute(Scanner in) {
			String mapName = in.next();
			
			System.out.println("loadMap");
			ProtoGodObject.getInstance().loadMap(mapName);
			return true;
		}
		
		ProtoLoadMap() {
			/*
			 * Ures fuggvenytorzs
			 */
		}
		
	}
	
	public static class ProtoRun implements IProtoCommand {

		@Override
		public boolean Execute(Scanner in) {
			int iterations = in.nextInt();
			
			System.out.println("run");
			ProtoGodObject.getInstance().run(iterations);
			return true;
		}
		
		ProtoRun() {
			/*
			 * Ures fuggvenytorzs
			 */
		}
		
	}
	

	
	public static class ProtoListWalls implements IProtoCommand {

		@Override
		public boolean Execute(Scanner in) {
			
			System.out.println("listWalls");
			ProtoGodObject.getInstance().listWalls();
			return true;
		}
		
		ProtoListWalls() {
			/*
			 * Ures fuggvenytorzs
			 */
		}
		
	}
	
	public static class ProtoCommandInterpreter extends CommandInterpreter {

		ProtoCommandInterpreter(Scanner in) {
			super(in);
			
			commands.put("loadMap", new ProtoGodObject.ProtoLoadMap());
			commands.put("run", new ProtoGodObject.ProtoRun());
			commands.put("listWalls", new ProtoGodObject.ProtoListWalls());
		}
	}
	
	public ProtoGodObject() {
		/*
		 * A biztonsag kedveert, hogy hulye bemenet eseten ne szalljon el a program.
		 */
		world = new World();
		gameLoop = new GameLoop(world);
	}
}
