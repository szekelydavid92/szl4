package common;

/**
 * Box tartalmaz r�la referenci�t. Ez felel az�rt h eldobhat� legyen a box objektum.
 */
public interface ICarrier {
	/**
	 * T�rli a r�la lev� referenci�t a Box objektumb�l.
	 * @return void
	 */
	public void forcedRelease();
}
