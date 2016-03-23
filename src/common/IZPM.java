package common;

/**
 * Ez az interface felel azért, hogy a ZPM-et fel lehessen venni.
 */
public interface IZPM extends IVisitable {
	/**
	 * Ezzel a függvénnyel lekérdezhetjük, hogy a ZPM-et fölvettük-e.
	 * @return bool
	 */
	public boolean isPicked();
	
	
	/**
	 * Ezzel a függvénnyel jelezzük, hogy fölvettük a ZPM-et.
	 * @return void
	 */
	public void pickUp();
}
