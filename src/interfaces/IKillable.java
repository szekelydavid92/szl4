package interfaces;

/**
 * Ez az Interface felel a megsemissíthetőségért.
 */
public interface IKillable {
	/**
	 * Ezzel a függvénnyel lehet az interfészt implementáló osztály példányát megsemmisíteni.
	 * @return void
	 */
	public void kill();
}
