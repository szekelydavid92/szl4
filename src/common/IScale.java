package common;

/**
 * Ez az interfész felelõs azért, hogy az õt megvalósító objektum lenyomható legyen.
 */
public interface IScale {
	/**
	 * Ez a függvény jelzi a mérleg számára, hogy súly van rajta.
	 * @return void
	 */
	public void push();
}
