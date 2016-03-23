package upper_layer.wormhole;

import common.ISpecWall;
import common.ITeleportable;

/**
 * � felel�s az�rt, hogy a k�t csillagkapu k�z�tt teleport�lni lehessen.
 */
public class WormHole {
	/**
	 * Be�ll�tja a k�k kaput egy falra.
	 * @param wall ??????????
	 * @return void
	 */
	public void setBlue(ISpecWall wall) {}
	
	
	/**
	 * Be�ll�tja a s�rga kaput egy falra.
	 * @param wall ?????????
	 * @return void
	 */
	public void setYellow(ISpecWall wall) {}
	
	
	/**
	 * Player oszt�lyt teleport�lja a s�rga kapuhoz.
	 * @param t ???????
	 * @return void
	 */
	public void teleportToYellow(ITeleportable t) {}
	
	
	/**
	 * Player oszt�lyt teleport�lja a k�k kapuhoz.
	 * @param t ?????????
	 * @return void
	 */
	public void teleportToBlue(ITeleportable t) {}
}
