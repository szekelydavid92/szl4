package common;

/**
 * Ezen Interface felel az ajtok nyithatosagaert.
 */
public interface IDoor {
	/**
	 * Ez a fuggveny nyitja ki az ajtot.
	 * @return void
	 */
	public void open();
	
	
	/**
	 * Ez a fuggveny zarja be az ajtot.
	 * @return void
	 */
	public void close();
}
