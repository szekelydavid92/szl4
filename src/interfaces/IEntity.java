package interfaces;

/**
 * Ezen interface-t azon osztályok implementálják, akik értesülni akarnak arról, hogy az idõ telik,
 * azaz elõre akarják léptetni az állapotukat minden ciklusban.
 */
public interface IEntity {
	/**
	 * Ez az a függvény, amelyet a GameLoop minden ciklusban lehív.
	 * Ebben a metódusban léptetik elõre az objektumok az állapotukat az idõ függvényében.
	 * @return void
	 */
	public void step();
}
