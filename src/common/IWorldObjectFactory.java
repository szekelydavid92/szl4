package common;

import bottom_layer.WorldObject;

/**
 * Az õt megvalósító osztályoknak létre kell tudniuk hozni WorldObjecteket, adott szélességgel, és hosszúsággal.
 */
public interface IWorldObjectFactory {
	/**
	 * WorldObject objektum létrehozásáért felel.
	 * @param width Objektum szélessége.
	 * @param height Objektum magassága.
	 * @return void
	 */
	public WorldObject createObject(double width, double height);

}
