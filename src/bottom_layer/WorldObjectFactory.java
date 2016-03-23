package bottom_layer;

import common.IWorldObject;
import common.IWorldObjectFactory;

/**
 * Õ hozza létre a WorldObject-et.
 */
public class WorldObjectFactory implements IWorldObjectFactory {

	/**
	 * IWorldObject interfészt megvalósító osztály példányt hoz létre.
	 * @param width Létrehozandó objektum szélessége.
	 * @param height Létrehozandó objektum magassága.
	 * @return IWorldObject
	 */
	@Override
	public WorldObject createObject(double width, double height) {return null;}

}
