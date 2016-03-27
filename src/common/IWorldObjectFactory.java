package common;

import bottom_layer.WorldObject;

/**
 * Az ot megvalosito osztalyoknak letre kell tudniuk hozni WorldObjecteket, adott szelesseggel, es hosszusaggal.
 */
public interface IWorldObjectFactory {
	/**
	 * WorldObject objektum letrehozasaert felel.
	 * @param width Objektum szelessege.
	 * @param height Objektum magassaga.
	 * @return void
	 */
	public WorldObject createObject(double width, double height);

}
