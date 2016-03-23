package common;

/**
 * Ez az Interface felel a lövedék létrehozásáért.
 */
public interface IProjectileFactory {
	/**
	 * Megadott színû lõvedéket hoz létre.
	 * @param colour Az adott színû enum.
	 * @return void
	 */
	public void createProjectile(Colour colour);
}
