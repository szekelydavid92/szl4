package upper_layer.wormhole;

import common.ISpecWall;
import common.ITeleportable;

/**
 * Õ felelõs azért, hogy a két csillagkapu között teleportálni lehessen.
 */
public class WormHole {
	/**
	 * Beállítja a kék kaput egy falra.
	 * @param wall ??????????
	 * @return void
	 */
	public void setBlue(ISpecWall wall) {}
	
	
	/**
	 * Beállítja a sárga kaput egy falra.
	 * @param wall ?????????
	 * @return void
	 */
	public void setYellow(ISpecWall wall) {}
	
	
	/**
	 * Player osztályt teleportálja a sárga kapuhoz.
	 * @param t ???????
	 * @return void
	 */
	public void teleportToYellow(ITeleportable t) {}
	
	
	/**
	 * Player osztályt teleportálja a kék kapuhoz.
	 * @param t ?????????
	 * @return void
	 */
	public void teleportToBlue(ITeleportable t) {}
}
