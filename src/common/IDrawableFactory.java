package common;

import java.awt.Color;

import view.DrawableColor;

/**
 * Definiálja a View megjeleníthető objektumokat létrehozó komponensének a Modell által 
 * elvárt funkcionális követelményeit.
 */
public interface IDrawableFactory {
	/**
	 *  Létrehoz egy grafikus primitívet az adott pozícióval, szélességgel és magassággal.
	 * @param door
	 * @param color
	 */
	void createDoorDrawable(IWorldObject worldObject,IDoor door,Color color);
	/**
	 * Létrehoz egy grafikus primitívet az adott pozícióval, szélességgel és magassággal.
	 * @param worldObject
	 * @param color
	 */
	void createObjectDrawable(IWorldObject worldObject,Color color);
	/**
	 * Létrehoz egy grafikus primitívet a csillagkapunak az adott pozícióval, szélességgel, magassággal és színnel.
	 * @param stargate
	 * @param color
	 */
	void createStargateDrawable(IStargate stargate,Color color);
}
