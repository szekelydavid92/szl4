package upper_layer.wormhole;

import common.Colour;
import common.ISpecWall;
import common.ITeleportable;
import common.IZPM;
import skeleton.Depth;

/**
 * O felelos azert, hogy a ket csillagkapu kozott teleportalni lehessen.
 */
public class WormHole {
	
	//ISpecWall yellowWall;	//nem tudom h kellenek-e ezek ide - topi
	//ISpecWall blueWall;	//nem tudom h kellenek-e ezek ide - topi
	public Stargate blueGate = new Stargate(this,Colour.BLUE);
	public Stargate yellowGate = new Stargate(this,Colour.YELLOW);
	public String name = "wormHole";
	
	public WormHole(/*ISpecWall yelloW , ISpecWall blueW*/) { //ezek mi�rt nem alapb�l null-ok?
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".WormHole()\n");
		Depth.getInstance().enterFunction();
		
		blueGate.name = "blue";
		yellowGate.name = "yellow";
		//setYellow(yelloW);
		//setBlue(blueW);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".WormHole()\n");
		
	}
	
	/**
	 * Beallitja a kek kaput egy falra.
	 * @param wall ??????????
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
	 * Beallitja a sarga kaput egy falra.
	 * @param wall ?????????
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
	 * Player osztalyt teleportalja a sarga kapuhoz.
	 * @param t ???????
	 * @return void
	 */
	public void teleportToYellow(ITeleportable t) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".teleportToYellow()\n");
		Depth.getInstance().enterFunction();
		
		double yellowX=0.0,yellowY=0.0;
		t.teleport(yellowX,yellowY);
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToYellow()\n");
		//TODO Lorant
	}
	
	
	/**
	 * Player osztalyt teleportalja a kek kapuhoz.
	 * @param t ?????????
	 * @return void
	 */
	public void teleportToBlue(ITeleportable t) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".teleportToBlue()\n");
		Depth.getInstance().enterFunction();

		double blueX=0.0,blueY=0.0;
		t.teleport(blueX,blueY);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToBlue()\n");
		//TODO Lorant
	}
}
