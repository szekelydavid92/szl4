package proto;

import java.util.Scanner;

import bottom_layer.GameLoop;
import bottom_layer.World;

class ProtoGodObject {
	private World world;
	private GameLoop gameLoop;
	
	private static ProtoGodObject instance = null;
	
	public static ProtoGodObject getInstance() {
		if(instance == null) {
			instance = new ProtoGodObject();
		}
		
		return instance;
	}

	public void run(int iterations) {
		
		for(int i=0;i < iterations;i++) {
			gameLoop.run();
		}
	}
	
	public boolean loadMap(String map)
	{
		
		
		return true;
	}
	
	public static class ProtoLoadMap implements IProtoCommand {
		
		/*
		 * VIGYAZAT! A palyanevbe implementacios okokbol NE keruljon szokoz!
		 */
		@Override
		public boolean Execute(Scanner in) {
			String mapName = in.next();
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
			
			ProtoGodObject.getInstance().run(iterations);
			return true;
		}
		
		ProtoRun() {
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
