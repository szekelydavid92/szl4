package common;

/**
 * Ez az interface felel a teleportalhatosagert.
 */
public interface ITeleportable extends IVisitable {
	/**
	 * Ezzel a fuggvennyel lehet az implementalo osztaly peldanyat atteleportalni egy masik helyre.
	 * @param x A cel koordinatajanak x tagja.
	 * @param y A cel koordinatajanak y tagja.
	 * @return void
	 */
	public void teleport(double x, double y);
}
