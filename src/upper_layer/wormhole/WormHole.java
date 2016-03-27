package upper_layer.wormhole;

import common.ISpecWall;
import common.ITeleportable;

/**
 * O felelos azert, hogy a ket csillagkapu kozott teleportalni lehessen.
 */
public class WormHole {
	
	ISpecWall yellowWall;
	ISpecWall blueWall;
	
	public WormHole(ISpecWall yelloW , ISpecWall blueW ){
		setYellow(yelloW);
		setBlue(blueW);
	}
	
	/**
	 * Beallitja a kek kaput egy falra.
	 * @param wall ??????????
	 * @return void
	 */
	public void setBlue(ISpecWall wall) {
		blueWall = wall;
	}
	
	
	/**
	 * Beallitja a sarga kaput egy falra.
	 * @param wall ?????????
	 * @return void
	 */
	public void setYellow(ISpecWall wall) {
		yellowWall = wall;
	}
	
	
	/**
	 * Player osztalyt teleportalja a sarga kapuhoz.
	 * @param t ???????
	 * @return void
	 */
	public void teleportToYellow(ITeleportable t) {}
	
	
	/**
	 * Player osztalyt teleportalja a kek kapuhoz.
	 * @param t ?????????
	 * @return void
	 */
	public void teleportToBlue(ITeleportable t) {}
}
