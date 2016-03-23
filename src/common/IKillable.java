package common;

/**
 * Ez az Interface felel a megsemissíthetõségért.
 */
public interface IKillable extends IVisitable {
	/**
	 * Ezzel a függvénnyel lehet az interfészt implementáló osztály példányát megsemmisíteni.
	 * @return void
	 */
	public void kill();
}
