package common;

/**
 * Ez az interface felel azert, hogy a ZPM-et fel lehessen venni.
 */
public interface IZPM extends IVisitable {
	/**
	 * Ezzel a fuggvennyel lekerdezhetjuk, hogy a ZPM-et felvettek-e.
	 * @return bool
	 */
	public boolean isPicked();
	
	
	/**
	 * Ezzel a fuggvennyel jelezzuk, hogy felvettek a ZPM-et.
	 * @return void
	 */
	public void pickUp();
}
