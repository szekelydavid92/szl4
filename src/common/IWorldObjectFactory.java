package common;

/**
 * Az õt megvalósító osztályoknak létre kell tudniuk hozniuk WorldObjecteket, adott szélességgel, és hosszúsággal.
 */
public interface IWorldObjectFactory {
	/**
	 * Objektum létrehozásáért felel.
	 * @param width Objektum szélessége.
	 * @param height Objektum magassága.
	 * @return void
	 */
	public void createObject(double width, double height);

}
