package skeleton;

import java.io.IOException;


import bottom_layer.World;
import bottom_layer.WorldObject;
import common.ICarriable;
import upper_layer.entity.Box;
import upper_layer.entity.Player;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.ZPM;

class ONeillTeszt {
	//O Neill mozgatasa
		static void ONeillMozgatas() {
			System.out.print("Teszteset inicializalasa\n");
			//System.out.println("Creating objects");
			Player player = new Player();
			WorldObject playerWorldObject = new WorldObject();
			World w = new World();
			
			player.worldObject = playerWorldObject;
			//pwo.setCollisionObserver(p); 
			//w.addWorldObject(pwo);
			w.objects.add(playerWorldObject);	
			
			String line = "n";

			System.out.print("Initialization finished.\n");
			System.out.println("O Neill vezerlofuggvenyeinek tesztelese");
			//FEL
			System.out.println("Kerem, adja meg, hogy O Neill felfele mozogjon-e![i/n]\n");
			try {
				line = SkeletonMain.in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(line.equals("i")) player.moveUp(true);
			if(line.equals("n")) player.moveUp(false);
			//LE
			System.out.println("Kerem, adja meg, hogy O Neill lefele mozogjon-e![i/n]\n");
			try {
				line = SkeletonMain.in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(line.equals("i")) player.moveDown(true);
			if(line.equals("n")) player.moveDown(false);
			//JOBBRA
			System.out.println("Kerem, adja meg, hogy O Neill jobbra mozogjon-e![i/n]\n");
			try {
				line = SkeletonMain.in.readLine();
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
				line = SkeletonMain.in.readLine();
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
		}
		
		static void zpmFelvetel() {
			System.out.print("Teszteset inicializalasa\n");
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

			System.out.print("Initialization finished.\n");
			System.out.print("ZPM és O'Neill utkozesenek tesztelese");
			w.checkCollision();
		
		}
		
		static void oNeillMeghal() {
			System.out.print("Teszteset inicializalasa\n");
			
			WorldObject o1 = new WorldObject();
			Player player = new Player();
			o1.setCollisionObserver(player);
			o1.setVisitable(player);
			o1.name="playerWorldOBject";
			Box box=new Box();
			player.box=box;
			
			WorldObject o2 = new WorldObject();
			Chasm chasm = new Chasm();
			o2.setCollisionObserver(chasm);
			o2.name="chasmWorldObject";
			
			World world = new World();
			world.addWorldObject(o2);
			world.addWorldObject(o1);

			System.out.print("Initialization finished.\n");
			System.out.print("Chasm es O'Neill utkozesenek vizsgalata.\n");
			world.checkCollision();
		}
		
		static void dobozFelvetel() {
			System.out.print("Teszteset inicializalasa\n");
			World world = new World();
			WorldObject wo1 = new WorldObject();
			wo1.name="playerObject";
			WorldObject wo2 = new WorldObject();
			wo2.name="boxObject";
			Player player = new Player();
			Box box = new Box();

			wo1.visitable = player;
			player.worldObject = wo1;
			box.worldObject = wo2;
			world.objects.add(wo1);
			world.objects.add(wo2);
			wo1.setCollisionObserver(player);
			wo2.setCollisionObserver(box);
			wo2.setVisitable(box);

			System.out.print("Initialization finished.\n");
			System.out.println("O Neill dobozfelemelesenek lehivasa");
			player.pickUp(true);
			
			System.out.println("O Neill es a doboz utkozesenek a tesztelese");
			world.checkCollision();
			
		}
		
		static void dobozLerakas() {
			System.out.print("Teszteset inicializalasa\n");
			Player player = new Player();
			Box box = new Box();
			WorldObject wo = new WorldObject();
			wo.name="boxObject";
			
			box.worldObject = wo;
			player.box = box;

			System.out.print("Initialization finished.\n");
			player.carryBox();
		}
		
		
}