package common;

/**
 * Ezt az interface-t implementálja a csillagkapu.
 */
public interface IStargate {
	/**
	 * Ezzel a függvénnyel nyílik meg a csillagkapu egy speciális falon.
	 * @param wall Egy ISpecWall interfészt implementáló objektum.
	 * @return void
	 */
	public void mask(ISpecWall wall);
}
