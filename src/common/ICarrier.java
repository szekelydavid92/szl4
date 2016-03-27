package common;

/**
 * Box tartalmaz rola referenciat. Ez felel azert h eldobhato legyen a box objektum.
 */
public interface ICarrier {
	/**
	 * Torli a rola levo referenciat a Box objektumbol.
	 * @return void
	 */
	public void forcedRelease();
}
