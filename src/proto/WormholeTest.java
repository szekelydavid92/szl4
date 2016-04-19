package proto;

import java.io.IOException;

import bottom_layer.World;
import bottom_layer.WorldObject;
import bottom_layer.WorldObjectFactory;
import upper_layer.entity.Player;
import upper_layer.wormhole.Projectile;
import upper_layer.wormhole.ProjectileFactory;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.WormHole;

class WormholeTest {
	static void SargaLovedekLovese() { //Sarga lovedek lovese
		System.out.print("Teszteset inicializalasa\n");
		
		World w = new World();
				
		//System.out.println("Creating objects");
		WorldObject pwo = new WorldObject();
		Player p = new Player(pwo);
		ProjectileFactory pf = new ProjectileFactory();
		WorldObjectFactory wof = new WorldObjectFactory(w);
		
		
		p.projFactory = pf;
		pf.iwof = wof;
		
		//pwo.setCollisionObserver(p);//elvileg nem kell ide

		System.out.print("Initialization finished.\n");
		System.out.println("\nO Neill lovesenek lehivasa");
		p.shootYellow(true);
		
		System.out.println("O Neill viselkedese");
		p.shoot();
				
	}
	
	static void KekLovedekLovese() { //Kek lovedek lovese
		System.out.print("Teszteset inicializalasa\n");

		World w = new World();
		
		WorldObject pwo = new WorldObject();
		Player p = new Player(pwo);
		
		ProjectileFactory pf = new ProjectileFactory();
		WorldObjectFactory wof = new WorldObjectFactory(w);
		
		p.projFactory = pf;
		pf.iwof = wof;

		System.out.print("Initialization finished.\n");
		System.out.println("\nO Neill lovesenek lehivasa");
		p.shootBlue(true);
		
		System.out.println("O Neill viselkedese");
		p.shoot();
			
	}
	
	static void CsillagkapuNyitas(){
		System.out.print("Teszteset inicializalasa\n");
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
		
		System.out.print("Kek vagy sarga csillagkapu nyitasa\n");
		projectile.notify(wallObj);
				
	}
	
	static void CsillagkapuAtjaras(){
		System.out.print("Teszteset inicializalasa\n");
		WorldObject obj = new WorldObject();
		Player player = new Player(obj);
		obj.visitable = player;
		obj.setCollisionObserver(player);
		
		obj.name = "playerObject";
				
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
		
		yellowWallObject.name = "wallObject";
		blueWallObject.name = "wallObject";

		System.out.print("Initialization finished.\n");
//		wallObject.notify(obj);
		
		/*
		 * Ebben elter a specifikacotol! Elore kell megadni, hogy a
		 * sárga vagy a kék kapun megyunk be
		 */
		String line = "";
		boolean isYellow = true;
		System.out.println("Kerem, adja meg, hogy melyik (sarga vagy kek) portalba lepett![s/k]\n");
		
		line = ProtoMain.in.next();
		
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
	
}