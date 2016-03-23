package common;

/**
 * Box tartalmaz róla referenciát. Ez felel azért h eldobható legyen a box objektum.
 */
public interface ICarrier {
	/**
	 * Törli a róla levõ referenciát a Box objektumból.
	 * @return void
	 */
	public void forcedRelease();
}
