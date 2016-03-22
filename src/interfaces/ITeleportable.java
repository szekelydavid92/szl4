package interfaces;

/**
 * Ez az interface felel a teleportálhatóságért.
 */
public interface ITeleportable {
	/**
	 * Ezzel a függvénnyel lehet az implementáló osztály példányát átteleportálni egy másik helyre.
	 * @param x A cél koordinátájának x tagja.
	 * @param y A cél koordinátájának y tagja.
	 * @return void
	 */
	public void teleport(double x, double y);
}
