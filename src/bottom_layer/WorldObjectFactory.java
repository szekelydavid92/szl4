package bottom_layer;

import common.IWorldObject;
import common.IWorldObjectFactory;

/**
 * � hozza l�tre a WorldObject-et.
 */
public class WorldObjectFactory implements IWorldObjectFactory {

	/**
	 * IWorldObject interf�szt megval�s�t� oszt�ly p�ld�nyt hoz l�tre.
	 * @param width L�trehozand� objektum sz�less�ge.
	 * @param height L�trehozand� objektum magass�ga.
	 * @return IWorldObject
	 */
	@Override
	public WorldObject createObject(double width, double height) {return null;}

}
