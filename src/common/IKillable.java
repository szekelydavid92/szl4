package common;

/**
 * Ez az Interface felel a megsemissithetosegert.
 */
public interface IKillable extends IVisitable {
	/**
	 * Ezzel a fuggvennyel lehet az interfeszt implementalo osztaly peldanyat megsemmisiteni.
	 * @return void
	 */
	public void kill();
}
