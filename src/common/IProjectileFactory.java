package common;

/**
 * Ez az Interface felel a l�ved�k l�trehoz�s��rt.
 */
public interface IProjectileFactory {
	/**
	 * Megadott sz�n� l�ved�ket hoz l�tre.
	 * @param colour Az adott sz�n� enum.
	 * @return void
	 */
	public void createProjectile(Colour colour);
}
