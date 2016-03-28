package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

import bottom_layer.World;
import bottom_layer.WorldObject;
import upper_layer.entity.Box;
import upper_layer.entity.Door;
import upper_layer.entity.Player;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.Scale;
import upper_layer.reactive.ZPM;
import upper_layer.wormhole.Projectile;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

public class SkeletonMain {	
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
				else if(line.equals("5")) 	case_5();
				else if(line.equals("6")) 	case_6();
				else if(line.equals("7")) 	case_7();
				else if(line.equals("8")) 	case_8();
				else if(line.equals("9")) 	case_9();
				else if(line.equals("10")) 	case_10();
				else if(line.equals("11")) 	case_11();
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
	static void case_1(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_1()");
		Depth.getInstance().enterFunction();
		
		Player p = new Player();
		
		System.out.println("O Neill vezerlofuggvenyeinek tesztelese\n");
		//FEL
		System.out.println("Kerem, adja meg, hogy O �Neill felfele mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveUp(true);
		if(line.equals("n")) p.moveUp(false);
		//LE
		System.out.println("Kerem, adja meg, hogy O �Neill lefele mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveDown(true);
		if(line.equals("n")) p.moveDown(false);
		//JOBBRA
		System.out.println("Kerem, adja meg, hogy O �Neill jobbra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) 		{p.moveRight(true);}
		else if(line.equals("n")) 	{p.moveRight(false);}
		else {
			System.out.println("ERROR: Ervenytelen bemenet!/n");
		}
		//BALRA
		System.out.println("Kerem, adja meg, hogy O �Neill balra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveLeft(true);
		if(line.equals("n")) p.moveLeft(false);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_1()");
		
	}
	
	
	static void case_2(){ //Sarga loved�k lovese
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_2()");
		Depth.getInstance().enterFunction();
		
		WorldObject p_worldObject = new WorldObject();
		Player pl = new Player();
		p_worldObject.setCollisionObserver(pl);
		
		pl.shoot();
		//TODO LORANT
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_2()");
		
	}
	//Kek lovedek lovese
	static void case_3(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_3()");
		Depth.getInstance().enterFunction();
		
		WorldObject p_worldObject = new WorldObject();
		Player pl = new Player();
		p_worldObject.setCollisionObserver(pl);
		
		pl.shoot();
		//TODO LORANT
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_3()");
		
	}
	//Sarga csillagkapu nyitasa
	static void case_4(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_4()");
		Depth.getInstance().enterFunction();
		
		WorldObject projectileWO = new WorldObject();
		Projectile projectile = new Projectile();
		projectileWO.setCollisionObserver(projectile);
		
		WorldObject obj = new WorldObject();
		SpecWall wall = new SpecWall();
		obj.setCollisionObserver(wall);
		
		projectileWO.notify(obj); //innen indul
		
		WormHole wh = new WormHole(null,null);
		wh.setYellow(wall);
		
		Stargate yellow = new Stargate();
		yellow.mask(wall);		
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_4()");
		
	}
	//Kek csillagkapu nyitasa
	static void case_5(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_5()");
		Depth.getInstance().enterFunction();
		
		WorldObject projectileWO = new WorldObject();
		Projectile projectile = new Projectile();
		projectileWO.setCollisionObserver(projectile);
		
		WorldObject obj = new WorldObject();
		SpecWall wall = new SpecWall();
		obj.setCollisionObserver(wall);
		
		projectileWO.notify(obj); //innen indul
		
		WormHole wh = new WormHole(null,null);
		wh.setBlue(wall);
		
		Stargate blue = new Stargate();
		blue.mask(wall);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_5()");
		
	}
	//Csillagkapu atjaras
	static void case_6(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_6()");
		Depth.getInstance().enterFunction();
		
		WorldObject obj = new WorldObject();
		Player pl = new Player();
		obj.setCollisionObserver(pl);
		
		WorldObject wallObject = new WorldObject();
		Stargate s = new Stargate();
		wallObject.setCollisionObserver(s);
		
		wallObject.notify(obj);
		
		WormHole wh = new WormHole(null,null);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_6()");
		
	}
	
	//Doboz felvétele
	static void case_7(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_7()");
		Depth.getInstance().enterFunction();
			
		Player p = new Player();
		WorldObject o1 = new WorldObject();
		o1.setCollisionObserver(p);
		
		WorldObject o2 = new WorldObject();
		Box b =	new Box();
		o2.setCollisionObserver(b);
		
		World world = new World();
		world.addWorldObject(o1);
		world.addWorldObject(o2);
		
		world.checkCollision();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_7()");
			
	}
	//Doboz lerakasa
	static void case_8(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_8()");
		Depth.getInstance().enterFunction();
		
		WorldObject o1 = new WorldObject();
		Player p =	new Player();
		o1.setCollisionObserver(p);
		
		WorldObject boxWorldObjectt = new WorldObject();
		Box b =	new Box();
		boxWorldObjectt.setCollisionObserver(b);
		
		p.carryBox();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_8()");
		
	}
	//ZPM felvétele
	static void case_9(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_9()");
		Depth.getInstance().enterFunction();
				
		WorldObject o1 = new WorldObject();
		Player p = new Player();
		o1.setCollisionObserver(p);
		
		WorldObject o2 = new WorldObject();
		ZPM	z = new ZPM();
		o2.setCollisionObserver(z);
		
		World w	= new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_9()");
		
	}
	//Ajto nyitasa
	static void case_10(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_10()");
		Depth.getInstance().enterFunction();
		
		WorldObject o1 = new WorldObject();
		Box b = new Box();
		o1.setCollisionObserver(b);
		
		WorldObject o2 = new WorldObject();
		Scale s = new Scale();
		o2.setCollisionObserver(s);
		
		Door d = new Door();
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_10()");
		
	}
	// Ajti zarasa
	static void case_11(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_11()");
		Depth.getInstance().enterFunction();
		
		WorldObject o1 = new WorldObject();
		Box b = new Box();
		o1.setCollisionObserver(b);
		
		WorldObject o2 = new WorldObject();
		Scale s = new Scale();
		o2.setCollisionObserver(s);
		
		Door d = new Door();
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_11()");
		
	}
	//Objektum megsemmiselese /player
	static void case_12(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_12()");
		Depth.getInstance().enterFunction();
		
		WorldObject o1 = new WorldObject();
		Player p = new Player();
		o1.setCollisionObserver(p);
		
		WorldObject o2 = new WorldObject();
		Chasm c = new Chasm();
		o2.setCollisionObserver(c);
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_12()");
		
	}
	//Objektum megsemmiselese /box
	static void case_13(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".case_13()");
		Depth.getInstance().enterFunction();
		
		WorldObject o1 = new WorldObject();
		Box b = new Box();
		o1.setCollisionObserver(b);
		
		WorldObject o2 = new WorldObject();
		Chasm c = new Chasm();
		o2.setCollisionObserver(c);
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".case_13()");
		
	}
	static void writeCases(){
		System.out.println("O Neill mozgatasa[1]");
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
		System.out.println("Objektum megsemmisulese[12]");
	}
}