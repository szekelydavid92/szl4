package upper_layer.wormhole;

import common.Colour;
import common.Direction;
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
	//private Direction blueGateDirection;
	//private Direction yellowGateDirection;
	
	private double yellowX = 0.0;
	private double yellowY = 0.0;

	private double blueX = 0.0;
	private double blueY = 0.0;
	
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
	public void setBlue(ISpecWall wall,Direction direction) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".setBlue()\n");
		Depth.getInstance().enterFunction();
		
		blueGate.mask(wall);
		blueGate.setTeleportDirection(direction);
		
		switch(direction) {
		case UP:
			blueX = wall.getWorldObject().getPosX();
			blueY = wall.getWorldObject().getPosY() - wall.getWorldObject().getHeight();
			break;
		case DOWN:
			blueX = wall.getWorldObject().getPosX();
			blueY = wall.getWorldObject().getPosY() + wall.getWorldObject().getHeight();
			break;
		case LEFT:
			blueX = wall.getWorldObject().getPosX() - wall.getWorldObject().getWidth();
			blueY = wall.getWorldObject().getPosY();
			break;
		case RIGHT:
			blueX = wall.getWorldObject().getPosX() + wall.getWorldObject().getWidth();
			blueY = wall.getWorldObject().getPosY();
			break;
		}
		
		//System.out.println(direction+" "+blueX+";"+blueY);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setBlue()\n");
		
	}
	
	/*public void setBlueGateDirection(Direction dir) {
		blueGateDirection=dir;
	}
	
	public void setYellowGateDirection(Direction dir) {
		yellowGateDirection=dir;
	}*/
	/**
	 * @brief Kinyitja a sarga kaput egy specialis falon.
	 * 
	 * @param wall a specialis fal, amin kaput nyitunk.
	 * @return void
	 */
	public void setYellow(ISpecWall wall,Direction direction) {

		Depth.getInstance().printTabs();
		System.out.print(name + ".setYellow()\n");
		Depth.getInstance().enterFunction();
		
		yellowGate.mask(wall);
		yellowGate.setTeleportDirection(direction);
		
		switch(direction) {
		case UP:
			yellowX = wall.getWorldObject().getPosX();
			yellowY = wall.getWorldObject().getPosY() - wall.getWorldObject().getHeight();
			break;
		case DOWN:
			yellowX = wall.getWorldObject().getPosX();
			yellowY = wall.getWorldObject().getPosY() + wall.getWorldObject().getHeight();
			break;
		case LEFT:
			yellowX = wall.getWorldObject().getPosX() - wall.getWorldObject().getWidth();
			yellowY = wall.getWorldObject().getPosY();
			break;
		case RIGHT:
			yellowX = wall.getWorldObject().getPosX() + wall.getWorldObject().getWidth();
			yellowY = wall.getWorldObject().getPosY();
			break;
		}

		//System.out.println(direction+" "+yellowX+";"+yellowY);
		
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

		//System.out.print("SÁRGÁHOZ");
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

		//System.out.print("KÉKHEZ");
		teleportable.teleport(blueX,blueY);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToBlue()\n");
	}
}
