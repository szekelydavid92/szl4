package common;

/**
 * Az ot megvalosito osztalyoknak letre kell tudniuk hozni WorldObjecteket, adott szelesseggel, es hosszusaggal.
 */
public interface IWorldObjectFactory {
	
	/**
	 * @brief IWorldObject interfeszt megvalosito osztaly peldanyt hoz letre.
	 * 
	 * @param width Letrehozando objektum szelessege.
	 * @param height Letrehozando objektum magassaga.
	 * @return IWorldObject - a letrehozott peldanyra mutato referencia
	 */
	public IWorldObject createObject(double width, double height);

}
