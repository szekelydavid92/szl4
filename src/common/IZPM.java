package common;

/**
 * @brief Ez az interface felel azert, hogy a ZPM-et fel lehessen venni.
 */
public interface IZPM extends IVisitable {
	
	/**
	 * @brief Ezzel a fuggvennyel lekerdezhetjuk, hogy a ZPM-et felvettek-e.
	 * 
	 * @return bool
	 */
	public boolean isPicked();
	
	
	/**
	 * @brief Ezzel a fuggvennyel jelezzuk, hogy felvettuk a ZPM-et.
	 * 
	 * @return void
	 */
	public void pickUp();
}
