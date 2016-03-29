package upper_layer.wormhole;

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
	public Stargate blueGate;
	public Stargate yellowGate;
	public String name;
	
	public WormHole(ISpecWall yelloW , ISpecWall blueW ) { //ezek miért nem alapból null-ok?
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".WormHole()\n");
		Depth.getInstance().enterFunction();
		
		setYellow(yelloW);
		setBlue(blueW);
		
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
		
		//blueWall = wall;
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
		
		//yellowWall = wall;
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
		System.out.print(name + ".teleportToYellow()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToYellow()");
		//TODO Lorant
	}
	
	
	/**
	 * Player osztalyt teleportalja a kek kapuhoz.
	 * @param t ?????????
	 * @return void
	 */
	public void teleportToBlue(ITeleportable t) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".teleportToBlue()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleportToBlue()");
		//TODO Lorant
	}
}
