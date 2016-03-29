package skeleton;

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
		Box box = new Box();
		box.name="box";
		WorldObject o1 = new WorldObject();
		o1.setCollisionObserver(box);
		o1.name="boxObject";
		
		Scale scale = new Scale();
		scale.name="scale";
		WorldObject o2 = new WorldObject();
		o2.setCollisionObserver(scale);
		o2.setVisitable(scale);
		o2.name="scaleObject";
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		
		Door door = new Door();
		scale.door=door;
		door.name="door";
		WorldObject doorObject=new WorldObject();
		door.worldObject=doorObject;
		doorObject.name="doorObject";
		
		World probaWorld=new World(); 
		
		GameLoop gameLoop=new GameLoop();
		gameLoop.world=probaWorld;
		gameLoop.name="gameLoop";
		gameLoop.Entites.add(door);
		
		
		String line="i"; // menjünk-e egy ciklust
		while (line.equals("i")) {
		
			w.checkCollision();
		
	
			gameLoop.run();
		
		System.out.println("Menjünk még egy GameLoop ciklust? [i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	static void boxMeghal() {
		WorldObject o1 = new WorldObject();
		o1.name="boxObject";
		Box b = new Box();
		b.worldObject=o1;
		b.name="box";
		o1.setCollisionObserver(b);
		o1.setVisitable(b);
		b.regCarrier(new Player());
		
		WorldObject o2 = new WorldObject();
		o2.name="chasmObject";
		Chasm c = new Chasm();
		c.name="chasm";
		o2.setCollisionObserver(c);
		
		World w = new World();
		w.addWorldObject(o2);
		w.addWorldObject(o1);
		
		System.out.println(w.objects.size());
		
		w.checkCollision();
		{
	}
	}
}
