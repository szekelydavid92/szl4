package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

import bottom_layer.GameLoop;
import bottom_layer.World;
import bottom_layer.WorldObject;
import bottom_layer.WorldObjectFactory;
import common.ICarriable;
import common.IWorldObject;
import upper_layer.entity.Box;
import upper_layer.entity.Door;
import upper_layer.entity.Player;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.Scale;
import upper_layer.reactive.ZPM;
import upper_layer.wormhole.Projectile;
import upper_layer.wormhole.ProjectileFactory;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

public class MarkoMain {	
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static String line = null;
	public static String name = "SkeletonMain";
	public static void main(String[] args) {
		
		while (true) {	
	        try {
	        	writeCases();
				line = in.readLine();
				if(line.equals("1")) 		case_1();
				else if(line.equals("2")) 	case_2();
				else if(line.equals("3")) 	case_3();
				else if(line.equals("4")) 	case_4();
				//else if(line.equals("5")) 	case_5();
				else if(line.equals("6")) 	case_6();
				else if(line.equals("7")) 	case_7();
				else if(line.equals("8")) 	case_8();
				else if(line.equals("9")) 	case_9();
				else if(line.equals("10")) 	case_10();
				else if(line.equals("12")) 	case_12();
				else if(line.equals("13")) 	case_13();
				else System.out.println("ERROR: Ervenytelen bemenet!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	//O Neill mozgatasa
	static void case_1() {
		
		ONeillTeszt.ONeillMozgatas();
	}
	
	
	static void case_2() { //Sarga lovedek lovese
				
		//System.out.println("Creating objects");
		Player p = new Player();
		WorldObject pwo = new WorldObject();
		ProjectileFactory pf = new ProjectileFactory();
		WorldObjectFactory wof = new WorldObjectFactory();
		
		p.worldObject = pwo;
		p.projFactory = pf;
		pf.iwof = wof;
		
		//pwo.setCollisionObserver(p);//elvileg nem kell ide
		
		System.out.println("\nO Neill lovesenek lehivasa");
		p.shootYellow(true);
		
		System.out.println("O Neill viselkedese");
		p.shoot();
				
	}
	
	static void case_3() { //Kek lovedek lovese
		
		Player p = new Player();
		WorldObject pwo = new WorldObject();
		ProjectileFactory pf = new ProjectileFactory();
		WorldObjectFactory wof = new WorldObjectFactory();
		
		p.worldObject = pwo;
		p.projFactory = pf;
		pf.iwof = wof;
		
		System.out.println("\nO Neill lovesenek lehivasa");
		p.shootBlue(true);
		
		System.out.println("O Neill viselkedese");
		p.shoot();
			
	}
	//Sarga csillagkapu nyitasa
	static void case_4(){
		
		/*WorldObject projectileWO = new WorldObject();
		Projectile projectile = new Projectile();
		projectileWO.setCollisionObserver(projectile);
		
		WorldObject obj = new WorldObject();
		SpecWall wall = new SpecWall();
		obj.setCollisionObserver(wall);
		
		projectileWO.notify(obj); //innen indul
		
		WormHole wh1 = new WormHole(null,null);
		wh1.setYellow(wall);
		
		Stargate yellow = new Stargate();
		yellow.mask(wall);	*/	
		
		System.out.print("Initializing test case 4\n");
		Projectile projectile = new Projectile();
		
		WorldObject wallObj = new WorldObject();
		WorldObject maskedWallObj = new WorldObject();
		
		WormHole wormHole = new WormHole();
		SpecWall specWall = new SpecWall();
		SpecWall maskedWall = new SpecWall();
		
		projectile.wormHole = wormHole;
		
		wallObj.visitable = specWall;
		maskedWallObj.visitable = maskedWall;
		
		specWall.iwo = wallObj;
		maskedWall.iwo = maskedWallObj;
		
		wormHole.yellowGate.mask(maskedWall);
		
		System.out.print("Initialization finished.\n");
		//projectile.
		
		System.out.print("Test case 4");
		projectile.notify(wallObj);
				
	}
	//Kek csillagkapu nyitasa
	/*static void case_5(){
				
	//	WorldObject projectileWO = new WorldObject();
		//Projectile projectile = new Projectile();
		//projectileWO.setCollisionObserver(projectile);
		
		//WorldObject obj = new WorldObject();
		//SpecWall wall = new SpecWall();
		//obj.setCollisionObserver(wall);
		
	//	projectileWO.notify(obj); //innen indul
		
<<<<<<< HEAD
	//	WormHole wh = new WormHole(null,null);
	//	wh.setBlue(wall);
=======
		WormHole wh = new WormHole();
		wh.setBlue(wall);
>>>>>>> branch 'master' of https://github.com/szekelydavid92/szl4
		
<<<<<<< HEAD
//		Stargate blue = new Stargate();
=======
>>>>>>> branch 'master' of https://github.com/szekelydavid92/szl4
		//blue.mask(wall);
		
	}*/
	//Csillagkapu atjaras
	static void case_6(){
		System.out.print("Initializing test case 5\n");
		WorldObject obj = new WorldObject();
		Player player = new Player();
		obj.visitable = player;
		obj.setCollisionObserver(player);
				
		//WorldObject obj = new WorldObject();
		//Player pl = new Player();
		//obj.setCollisionObserver(pl);
		
		WorldObject yellowWallObject = new WorldObject();
		WorldObject blueWallObject = new WorldObject();
		
		WormHole wormHole = new WormHole();
		
		wormHole.yellowGate.name = "stargate";
		wormHole.blueGate.name = "stargate";
		
		yellowWallObject.setCollisionObserver(wormHole.yellowGate);
		blueWallObject.setCollisionObserver(wormHole.blueGate);
		//wallObject.setCollisionObserver(s);

		System.out.print("Initialization finished.\n");
//		wallObject.notify(obj);
		
		/*
		 * Ebben elter a specifikacotol! Elore kell megadni, hogy a
		 * sÃ¡rga vagy a kÃ©k kapun megyunk be
		 */
		boolean isYellow = true;
		System.out.println("Kerem, adja meg, hogy melyik (sarga vagy kek) portalba lepett![s/k]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("s")) 		{isYellow = true;}
		else if(line.equals("k")) 	{isYellow = false;}
		else {
			System.out.println("ERROR: Ervenytelen bemenet!/n");
		}
		if(isYellow){
			yellowWallObject.notify(obj);
		} else {
			blueWallObject.notify(obj);
		}
				
	}
	
	//Doboz felvetele
	static void case_7(){
		
	ONeillTeszt.dobozFelvetel();
					
	}
	//Doboz lerakasa
	static void case_8(){
		
		ONeillTeszt.dobozLerakas();
				
	}
	//ZPM felvetele
	static void case_9(){
						
		ONeillTeszt.zpmFelvetel();
				
	}
	//Ajto nyitasa
	static void case_10(){

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
	// Ajti zarasa
	
	//Objektum megsemmiselese /player
	static void case_12() {
		
		ONeillTeszt.oNeillMeghal();
				
	}
	//Objektum megsemmiselese /box
	static void case_13(){
		
		//LoCI!!! 
		//A Chasm-nak nincs IVisitable-je igy amikor le akarjuk kerni a GetVisitable()-t akkor hibï¿½t dob
		//valahogy lekï¿½ne tiltan mar a wolrd checkCollison-jeben h nem visitelje ha a masik worldobject chasm		
		
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
				
	}
	static void writeCases(){
		System.out.println("\nO Neill mozgatasa[1]");
		System.out.println("Sarga lovedek lovese[2]");
		System.out.println("Kek lovedek lovese[3]");
		System.out.println("Sarga csillagkapu nyitasa[4]");
		System.out.println("Kek csillagkapu nyitasa[5]");
		System.out.println("Csillagkapu atjarasa[6]");
		System.out.println("Doboz felvetele[7]");
		System.out.println("Doboz lerakasa[8]");
		System.out.println("ZPM felvetele[9]");
		System.out.println("Ajto nyitasa[10]");
		System.out.println("Ajto zarasa[11]");
		System.out.println("Player Objektum megsemmisulese[12]");
		System.out.println("Box Objektum megsemmisulese[13]");
	}
}
		