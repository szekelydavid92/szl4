package common;

/**
 * Ez az Interface felel a megsemiss�thet�s�g�rt.
 */
public interface IKillable extends IVisitable {
	/**
	 * Ezzel a f�ggv�nnyel lehet az interf�szt implement�l� oszt�ly p�ld�ny�t megsemmis�teni.
	 * @return void
	 */
	public void kill();
}