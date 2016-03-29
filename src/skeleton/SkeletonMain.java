package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

import bottom_layer.World;
import bottom_layer.WorldObject;
import bottom_layer.WorldObjectFactory;
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
				//else if(line.equals("5")) 	case_5();
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
	static void case_1() {
		
		//System.out.println("Creating objects");
		Player p = new Player();
		WorldObject pwo = new WorldObject();
		World w = new World();
		
		p.worldObject = pwo;
		//pwo.setCollisionObserver(p); 
		//w.addWorldObject(pwo);
		w.objects.add(pwo);	
	
		System.out.println("O Neill vezerlofuggvenyeinek tesztelese");
		//FEL
		System.out.println("Kerem, adja meg, hogy O Neill felfele mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveUp(true);
		if(line.equals("n")) p.moveUp(false);
		//LE
		System.out.println("Kerem, adja meg, hogy O Neill lefele mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveDown(true);
		if(line.equals("n")) p.moveDown(false);
		//JOBBRA
		System.out.println("Kerem, adja meg, hogy O Neill jobbra mozogjon-e![i/n]\n");
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
		System.out.println("Kerem, adja meg, hogy O Neill balra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveLeft(true);
		if(line.equals("n")) p.moveLeft(false);
		
		System.out.println("\nO Neill jateklogikabeli tesztelese:");
		p.step();
		
		System.out.println("\nO Neill WordlObjectjenek tesztelese:");
		w.step();
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
		

		Projectile projectile = new Projectile();
		
		WorldObject obj = new WorldObject();
		WormHole wormHole = new WormHole();
		SpecWall specWall = new SpecWall();
		SpecWall masked = new SpecWall();
		
		projectile.wormHole = wormHole;
		
		obj.visitable = specWall;
		
		//projectile.
		
		projectile.notify(obj);
				
	}
	//Kek csillagkapu nyitasa
	/*static void case_5(){
				
		WorldObject projectileWO = new WorldObject();
		Projectile projectile = new Projectile();
		projectileWO.setCollisionObserver(projectile);
		
		WorldObject obj = new WorldObject();
		SpecWall wall = new SpecWall();
		obj.setCollisionObserver(wall);
		
		projectileWO.notify(obj); //innen indul
		
		WormHole wh = new WormHole();
		wh.setBlue(wall);
		
		//blue.mask(wall);
		
	}*/
	//Csillagkapu atjaras
	static void case_6(){
				
		WorldObject obj = new WorldObject();
		Player pl = new Player();
		obj.setCollisionObserver(pl);
		
		WorldObject wallObject = new WorldObject();
		//wallObject.setCollisionObserver(s);
		
		wallObject.notify(obj);
		
		WormHole wh = new WormHole();
				
	}
	
	//Doboz felvetele
	static void case_7(){
		
		World w = new World();
		WorldObject wo1 = new WorldObject();
		WorldObject wo2 = new WorldObject();
		Player p = new Player();
		Box b = new Box();
		
		p.worldObject = wo1;
		b.worldObject = wo2;
		w.objects.add(wo1);
		w.objects.add(wo2);
		
		System.out.println("O Neill dobozfelemelesenek lehivasa");
		p.pickUp(true);
		
		System.out.println("O Neill es a doboz utkozesenek a tesztelese");
		w.checkCollision();
		
					
	}
	//Doboz lerakasa
	static void case_8(){
				
		/*WorldObject o1 = new WorldObject();
		Player p =	new Player();
		o1.setCollisionObserver(p);
		
		WorldObject boxWorldObjectt = new WorldObject();
		Box b =	new Box();
		boxWorldObjectt.setCollisionObserver(b);
		
		p.carryBox();*/
		
		Player p = new Player();
		Box b = new Box();
		WorldObject wo = new WorldObject();
		
		b.worldObject = wo;
		
		p.carryBox();
				
	}
	//ZPM felvetele
	static void case_9(){
						
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
				
	}
	//Ajto nyitasa
	static void case_10(){
				
		WorldObject o1 = new WorldObject();
		Box b = new Box();
		o1.setCollisionObserver(b);
		
		WorldObject o2 = new WorldObject();
		Scale s = new Scale();
		o2.setCollisionObserver(s);
		
		Door d = new Door();
		s.door=d;
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();
		
	}
	// Ajti zarasa
	static void case_11(){
				
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
		
	}
	//Objektum megsemmiselese /player
	static void case_12(){
		
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
				
	}
	//Objektum megsemmiselese /box
	static void case_13(){
		
		//LoCI!!!
		//A Chasm-nak nincs IVisitable-je igy amikor le akarjuk kerni a GetVisitable()-t akkor hib�t dob
		//valahogy lek�ne tiltan mar a wolrd checkCollison-jeben h nem visitelje ha a masik worldobject chasm		
		
		WorldObject o1 = new WorldObject();
		Box b = new Box();
		o1.setCollisionObserver(b);
		o1.setVisitable(b);
		
		WorldObject o2 = new WorldObject();
		Chasm c = new Chasm();
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