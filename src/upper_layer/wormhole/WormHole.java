package upper_layer.wormhole;

import common.ISpecWall;
import common.ITeleportable;
import common.IZPM;
import skeleton.Depth;

/**
 * O felelos azert, hogy a ket csillagkapu kozott teleportalni lehessen.
 */
public class WormHole {
	
	ISpecWall yellowWall;
	ISpecWall blueWall;
	public String name;
	
	public WormHole(ISpecWall yelloW , ISpecWall blueW ){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".WormHole()");
		Depth.getInstance().enterFunction();
		
		setYellow(yelloW);
		setBlue(blueW);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".WormHole()");
		
	}
	
	/**
	 * Beallitja a kek kaput egy falra.
	 * @param wall ??????????
	 * @return void
	 */
	public void setBlue(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".setBlue()");
		Depth.getInstance().enterFunction();
		
		blueWall = wall;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setBlue()");
		
	}
	
	
	/**
	 * Beallitja a sarga kaput egy falra.
	 * @param wall ?????????
	 * @return void
	 */
	public void setYellow(ISpecWall wall) {

		Depth.getInstance().printTabs();
		System.out.print(name + ".setYellow()");
		Depth.getInstance().enterFunction();
		
		yellowWall = wall;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setYellow()");

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
