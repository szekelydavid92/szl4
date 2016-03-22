package interfaces;

/**
 * Ez az Interface felel�s az�rt, hogy a fels� r�tegbeli objektumok �rtes�ljenek afel�l,
 * hogy az als� r�tegbeli reprezent�ci�juk �tk�z�tt egy m�sik objektummal.
 */
public interface ICollisionObserver {
	/**
	 * Ebben a f�ggv�nyben val�sul meg a fels� r�tegbeli objektum �rtes�t�se az �tk�z�s bek�vetkezt�r�l.
	 * Az obj param�ter az a m�sik objektum, akivel a feliratkoz� WorldObject-je �tk�z�tt.
	 * @return void
	 */
	public void notify(IWorldObject obj);
}
