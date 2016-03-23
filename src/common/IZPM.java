package common;

/**
 * Ez az interface felel az�rt, hogy a ZPM-et fel lehessen venni.
 */
public interface IZPM extends IVisitable {
	/**
	 * Ezzel a f�ggv�nnyel lek�rdezhetj�k, hogy a ZPM-et f�lvett�k-e.
	 * @return bool
	 */
	public boolean isPicked();
	
	
	/**
	 * Ezzel a f�ggv�nnyel jelezz�k, hogy f�lvett�k a ZPM-et.
	 * @return void
	 */
	public void pickUp();
}
