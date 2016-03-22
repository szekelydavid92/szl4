package common;

/**
 * Ezt az interface-t implement�lja a csillagkapu.
 */
public interface IStargate {
	/**
	 * Ezzel a f�ggv�nnyel ny�lik meg a csillagkapu egy speci�lis falon.
	 * @param wall Egy ISpecWall interf�szt implement�l� objektum.
	 * @return void
	 */
	public void mask(ISpecWall wall);
}
