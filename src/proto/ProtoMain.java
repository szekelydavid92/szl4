package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
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

/*
 * Aprilis 19 21:00 Seres kommentezte a kodot, megirta a WorldObjectFactory, a ColEntity,
 * a Killable, a Player, a Box, a Projectile, a ProjectileFactory, a SpecWall, a Stargate,
 * a WormHole, konstruktorat.
 * 3 óra
 * 
 * Aprilis 20 16:00 1 óra Seres belekezdett a ProtoGodObject osztályba.
 * 
 * Aprilis 22 14:00 [] óra Seres belekezdett a GameFactory osztályba, es folytatta a ProtoGodObject
 * boviteset.
 * 
 */

public class ProtoMain {
	
	/*
	 * A Scanner azert kell, mert azzal lehet konnyen parsolni szamokat meg stringeket.
	 */
	public static Scanner in = new Scanner(System.in);
	
	public static String line = null;
	public static String name = "SkeletonMain";
	
	static CommandInterpreter commandInterpreter = new ProtoGodObject.ProtoCommandInterpreter(in);
	
	
	public static void main(String[] args) {
		
		while (true) {
	        	writeCases();
				line = in.next();
				if(line.equals("0")) 		{ONeillTeszt.ONeillMozgatas();}
				else if(line.equals("1")) 	{ONeillTeszt.zpmFelvetel();}
				else if(line.equals("2")) 	{WormholeTest.KekLovedekLovese();}
				else if(line.equals("3")) 	{WormholeTest.SargaLovedekLovese();}
				else if(line.equals("4")) 	{WormholeTest.CsillagkapuNyitas();}
				else if(line.equals("5")) 	{WormholeTest.CsillagkapuAtjaras();}
				else if(line.equals("6")) 	{ONeillTeszt.dobozFelvetel();}
				else if(line.equals("7")) 	{ONeillTeszt.dobozLerakas();}
				else if(line.equals("8")) 	{AjtoDobozTeszt.ajtoNyitasZaras();}
				else if(line.equals("9")) 	{ONeillTeszt.oNeillMeghal();}
				else if(line.equals("10")) 	{AjtoDobozTeszt.boxMeghal();}
				else if(line.equals("11")) 	{commandInterpreter.Menu();}
				else {break;}
	    }
	}
	/*
	//O Neill mozgatasa
	static void case_1() {
		/ *
		//System.out.println("Creating objects");
		Player player = new Player();
		WorldObject pwo = new WorldObject();
		World w = new World();
		
		player.worldObject = pwo;
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
		if(line.equals("i")) player.moveUp(true);
		if(line.equals("n")) player.moveUp(false);
		//LE
		System.out.println("Kerem, adja meg, hogy O Neill lefele mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) player.moveDown(true);
		if(line.equals("n")) player.moveDown(false);
		//JOBBRA
		System.out.println("Kerem, adja meg, hogy O Neill jobbra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) 		{player.moveRight(true);}
		else if(line.equals("n")) 	{player.moveRight(false);}
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
		if(line.equals("i")) player.moveLeft(true);
		if(line.equals("n")) player.moveLeft(false);
		
		System.out.println("\nO Neill jateklogikabeli tesztelese:");
		player.step();
		
		System.out.println("\nO Neill WordlObjectjenek tesztelese:");
		w.step();
		* /
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
		yellow.mask(wall);	*/	/*
		
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
		* /
		WormholeTest.CsillagkapuNyitas();	
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
		
	}* /
	//Csillagkapu atjaras
	static void case_6(){/*
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
		 * sárga vagy a kék kapun megyunk be
		 * /
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
		}* /
		
		WormholeTest.CsillagkapuAtjaras();
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
		
		p.carryBox();* /
		
		Player p = new Player();
		Box b = new Box();
		WorldObject wo = new WorldObject();
		
		b.worldObject = wo;
		p.box = b;
		
		p.carryBox();
				
	}
	//ZPM felvetele
	static void case_9(){
						/*
		WorldObject o1 = new WorldObject();
		Player p = new Player();
		o1.name="playerObject";
		o1.setCollisionObserver(p);
		
		WorldObject o2 = new WorldObject();
		ZPM	z = new ZPM();
		o2.setCollisionObserver(z);
		o2.setVisitable(z);
		o2.name="zpmObject";
		
		World w	= new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();* /
		ONeillTeszt.zpmFelvetel();
				
	}
	//Ajto nyitasa
	/*
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
		
	}* /
	// Ajti zarasa
	static void case_11(){
				/*
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
		
		w.checkCollision();* /
		AjtoDobozTeszt.ajtoNyitasZaras();
		
	}
	//Objektum megsemmiselese /player
	static void case_12(){/*
		
		WorldObject o1 = new WorldObject();
		Player p = new Player();
		o1.setCollisionObserver(p);
		
		WorldObject o2 = new WorldObject();
		Chasm c = new Chasm();
		o2.setCollisionObserver(c);
		
		World w = new World();
		w.addWorldObject(o1);
		w.addWorldObject(o2);
		
		w.checkCollision();* /
		ONeillTeszt.oNeillMeghal();
				
	}
	//Objektum megsemmiselese /box
	static void case_13(){
		
		//LoCI!!!
		//A Chasm-nak nincs IVisitable-je igy amikor le akarjuk kerni a GetVisitable()-t akkor hib�t dob
		//valahogy lek�ne tiltan mar a wolrd checkCollison-jeben h nem visitelje ha a masik worldobject chasm		
		/*
		WorldObject o1 = new WorldObject();
		Box b = new Box();
		o1.setCollisionObserver(b);
		o1.setVisitable(b);
		
		b.name = "box";
		o1.name = "boxObject";
		
		WorldObject o2 = new WorldObject();
		Chasm c = new Chasm();
		o2.setCollisionObserver(c);
		
		c.name = "chasm";
		o2.name = "chasmObj";
		
		World w = new World();
		w.addWorldObject(o2);
		w.addWorldObject(o1);
		
		System.out.println(w.objects.size());
		
		w.checkCollision();* /
		AjtoDobozTeszt.boxMeghal();
	}*/
	static void writeCases(){
		System.out.println("\nO Neill mozgatasa[0]");
		System.out.println("ZPM felvetele[1]");
		System.out.println("Kek lovedek lovese[2]");
		System.out.println("Sarga lovedek lovese[3]");
		System.out.println("Csillagkapu nyitasa[4]");
		System.out.println("Csillagkapu atjarasa[5]");
		System.out.println("Doboz felvetele[6]");
		System.out.println("Doboz lerakasa[7]");
		System.out.println("Ajto nyitasa es zarasa[8]");
		System.out.println("Player Objektum megsemmisulese[9]");
		System.out.println("Box Objektum megsemmisulese[10]");
		System.out.println("Command line interpreter kiprobalasa[11]");
		System.out.println("Barmi mas: kilepes");
	}
}