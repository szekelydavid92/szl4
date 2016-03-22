package interfaces;

/**
 * Ez az interface felel a teleport�lhat�s�g�rt.
 */
public interface ITeleportable {
	/**
	 * Ezzel a f�ggv�nnyel lehet az implement�l� oszt�ly p�ld�ny�t �tteleport�lni egy m�sik helyre.
	 * @param x A c�l koordin�t�j�nak x tagja.
	 * @param y A c�l koordin�t�j�nak y tagja.
	 * @return void
	 */
	public void teleport(double x, double y);
}
