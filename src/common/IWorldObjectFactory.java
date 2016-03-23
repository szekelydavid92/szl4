package common;

import bottom_layer.WorldObject;

/**
 * Az �t megval�s�t� oszt�lyoknak l�tre kell tudniuk hozni WorldObjecteket, adott sz�less�ggel, �s hossz�s�ggal.
 */
public interface IWorldObjectFactory {
	/**
	 * WorldObject objektum l�trehoz�s��rt felel.
	 * @param width Objektum sz�less�ge.
	 * @param height Objektum magass�ga.
	 * @return void
	 */
	public WorldObject createObject(double width, double height);

}
