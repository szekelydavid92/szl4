package proto;

import java.util.Scanner;

import bottom_layer.GameLoop;

class ProtoGodObject {
	
	private GameLoop gameLoop;
	
	private static ProtoGodObject instance = null;
	
	public static ProtoGodObject getInstance() {
		if(instance == null) {
			instance = new ProtoGodObject();
		}
		
		return instance;
	}
	
	public static class ProtoLoadLevel implements IProtoCommand {

		@Override
		public boolean Execute(Scanner in) {
			ProtoGodObject.getInstance().gameLoop = new GameLoop();
			return true;
		}
		
		ProtoLoadLevel() {
			
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
			
		}
		
	}
	
	public ProtoGodObject() {
		gameLoop = new GameLoop();
	}

	public void run(int iterations) {
		
		for(int i=0;i < iterations;i++) {
			gameLoop.run();
		}
	}
}
