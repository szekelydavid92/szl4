package upper_layer.entity;

import common.IEntity;

/**
 * Az Entity interf�szt implement�l� absztrakt oszt�ly, van referenci�ja egy IWorldObjectre,
 * bel�le �r�k�l minden olyan Entity, akinek van als� r�tegbeli reprezent�ci�ja.
 */
public abstract class ColEntity implements IEntity {
	/**
	 * A ColEntity-b�l �r�kl� objektumok ebben a f�ggv�nyben l�ptetik el�re az �llapotukat az id�ben.
	 * @return void
	 */
	public abstract void step();
}
