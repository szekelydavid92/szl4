package skeleton;

import java.io.IOException;

import bottom_layer.World;
import bottom_layer.WorldObject;
import upper_layer.entity.Player;

class ONeillTeszt {
	//O Neill mozgatasa
		static void ONeillMozgatas() {
			
			//System.out.println("Creating objects");
			Player player = new Player();
			WorldObject playerWorldObject = new WorldObject();
			World w = new World();
			
			player.worldObject = playerWorldObject;
			//pwo.setCollisionObserver(p); 
			//w.addWorldObject(pwo);
			w.objects.add(playerWorldObject);	
			
			String line = "n";
			
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
}