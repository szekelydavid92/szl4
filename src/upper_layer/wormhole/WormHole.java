package upper_layer.wormhole;

import common.Colour;
import common.ISpecWall;
import common.ITeleportable;
import common.IZPM;
import proto.Depth;

/**
 * @brief O felelos azert, hogy a ket csillagkapu kozott teleportalni lehessen.
 */
public class WormHole {
	public String name = "wormHole";
	
	/*
	 * Attributumok
	 */
	public Stargate blueGate = new Stargate(Colour.BLUE,this);
	public Stargate yellowGate = new Stargate(Colour.YELLOW,this);
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	public WormHole() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".WormHole()\n");
		Depth.getInstance().enterFunction();
		
		blueGate.name = "blue";
		yellowGate.name = "yellow";
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".WormHole()\n");
		
	}
	
	/**
	 * @brief Kinyitja a kek kaput egy specialis falon.
	 * 
	 * @param wall a specialis fal, amin kaput nyitunk.
	 * @return void
	 */
	public void setBlue(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".setBlue()\n");
		Depth.getInstance().enterFunction();
		
		blueGate.mask(wall);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setBlue()\n");
		
	}
	
	
	/**
	 * @brief Kinyitja a sarga kaput egy specialis falon.
	 * 
	 * @param wall a specialis fal, amin kaput nyitunk.
	 * @return void
	 */
	public void setYellow(ISpecWall wall) {

		Depth.getInstance().printTabs();
		System.out.print(name + ".setYellow()\n");
		Depth.getInstance().enterFunction();
		
		yellowGate.mask(wall);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setYellow()\n");
	}
	
	
	/**
	 * @brief Atteleportal egy teleportalhato objektumot a sarga kapuhoz.
	 * 
	 * @param teleportable a teleportalhato objektum
	 * @return void
	 */
	public void teleportToYellow(ITeleportable teleportable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".teleportToYellow()\n");
		Depth.getInstance().enterFunction();
		
		double yellowX=0.0,yellowY=0.0;
		teleportable.teleport(yellowX,yellowY);
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToYellow()\n");
	}
	
	
	/**
	 * @brief Atteleportal egy teleportalhato objektumot a kek kapuhoz.
	 * 
	 * @param teleportable a teleportalhato objektum
	 * @return void
	 */
	public void teleportToBlue(ITeleportable teleportable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".teleportToBlue()\n");
		Depth.getInstance().enterFunction();

		double blueX=0.0,blueY=0.0;
		teleportable.teleport(blueX,blueY);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToBlue()\n");
	}
}
