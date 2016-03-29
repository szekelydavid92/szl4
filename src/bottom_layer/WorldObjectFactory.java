package bottom_layer;

import common.IWorldObjectFactory;

/**
 * O hozza letre a WorldObject-et.
 */
public class WorldObjectFactory implements IWorldObjectFactory {

	/**
	 * IWorldObject interfeszt megvalosito osztaly peldanyt hoz letre.
	 * @param width Letrehozando objektum szelessege.
	 * @param height Letrehozando objektum magassaga.
	 * @return IWorldObject
	 */
	@Override
	public WorldObject createObject(double width, double height) {return null;}

}
