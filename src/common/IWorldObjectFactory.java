package common;

/**
 * Az �t megval�s�t� oszt�lyoknak l�tre kell tudniuk hozniuk WorldObjecteket, adott sz�less�ggel, �s hossz�s�ggal.
 */
public interface IWorldObjectFactory {
	/**
	 * Objektum l�trehoz�s��rt felel.
	 * @param width Objektum sz�less�ge.
	 * @param height Objektum magass�ga.
	 * @return void
	 */
	public void createObject(double width, double height);

}
