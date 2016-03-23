package common;

/**
 * Ezen Interface felel az ajt�k nyithat�s�g��rt.
 */
public interface IDoor {
	/**
	 * Ez a f�ggv�ny nyitja ki az ajt�t.
	 * @return void
	 */
	public void open();
	
	
	/**
	 * Ez a f�ggv�ny z�rja be az ajt�t.
	 * @return void
	 */
	public void close();
}
