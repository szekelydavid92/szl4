package common;

/**
 * Ez az Interface felel a lovedek letrehozasaert.
 */
public interface IProjectileFactory {
	/**
	 * Megadott szinu lovedeket hoz letre.
	 * @param colour Az adott szinu enum.
	 * @return void
	 */
	public void createProjectile(Colour colour, double pX, double pY, double mX, double mY); //p: player, m: mouse
}
