package common;

/**
 * Ezen interface-t azon osztalyok implementaljak, akik ertesulni akarnak arrol, hogy az ido telik,
 * azaz elore akarjak leptetni az allapotukat minden ciklusban.
 */
public interface IEntity {
	/**
	 * @brief Ez az a fuggveny, amelyet a GameLoop minden ciklusban lehiv.
	 * Ebben a metodusban leptetik elore az objektumok az allapotukat az ido fuggvenyeben.
	 * @return void
	 */
	public void step();
}
