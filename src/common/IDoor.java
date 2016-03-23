package common;

/**
 * Ezen Interface felel az ajtók nyithatóságáért.
 */
public interface IDoor {
	/**
	 * Ez a függvény nyitja ki az ajtót.
	 * @return void
	 */
	public void open();
	
	
	/**
	 * Ez a függvény zárja be az ajtót.
	 * @return void
	 */
	public void close();
}
