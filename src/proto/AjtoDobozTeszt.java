package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bottom_layer.GameLoop;
import bottom_layer.World;
import bottom_layer.WorldObject;
import upper_layer.entity.Box;
import upper_layer.entity.Door;
import upper_layer.entity.Player;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.Scale;

public class AjtoDobozTeszt {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static String line = null;
	public static String name = "AjtoDobozTeszt";
	
	static void ajtoNyitasZaras() {
		System.out.print("Teszteset inicializalasa\n");
		
		WorldObject o1 = new WorldObject();
		Box box = new Box(o1,1.0);
		box.name="box";
		
		o1.setCollisionObserver(box);
		o1.name="boxObject";
		
		Scale scale = new Scale();
		scale.name="scale";
		WorldObject o2 = new WorldObject();
		o2.setCollisionObserver(scale);
		o2.setVisitable(scale);
		o2.name="scaleObject";
		
		World probaWorld = new World();
		probaWorld.addWorldObject(o1);
		probaWorld.addWorldObject(o2);
		

		WorldObject doorObject=new WorldObject();
		Door door = new Door(doorObject);
		scale.door=door;
		door.name="door";
		//door.worldObject=doorObject;
		doorObject.name="doorObject";
		
		//World probaWorld=new World(); 
		
		GameLoop gameLoop=new GameLoop(probaWorld);
		gameLoop.name="gameLoop";
		gameLoop.addEntity(door);
		
		System.out.print("Initialization finished.\n");
		System.out.print("Ajto nyitasanak es zarasanak tesztelese.\n");
		String line="i"; // menj�nk-e egy ciklust
		while (line.equals("i")) {
		
			//w.checkCollision();
		
	
			gameLoop.run();
		
			System.out.println("Menjunk meg egy GameLoop ciklust? [i/n]\n");
			try {
				line = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static void boxMeghal() {
		System.out.print("Teszteset inicializalasa\n");
		WorldObject o1 = new WorldObject();
		o1.name="boxObject";
		Box b = new Box(o1,1.0);
		//b.worldObject=o1;
		b.name="box";
		o1.setCollisionObserver(b);
		o1.setVisitable(b);
		WorldObject playerObject = new WorldObject();
		b.regCarrier(new Player(playerObject,1.0));
		
		WorldObject o2 = new WorldObject();
		o2.name="chasmObject";
		Chasm c = new Chasm();
		c.name="chasm";
		o2.setCollisionObserver(c);
		
		World w = new World();
		w.addWorldObject(o2);
		w.addWorldObject(o1);

		System.out.print("Initialization finished.\n");
		System.out.print("Chasm es Box utkozesenek vizsgalata.\n");
		w.checkCollision();
	}
}
