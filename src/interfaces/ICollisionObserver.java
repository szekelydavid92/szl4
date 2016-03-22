package interfaces;

/**
 * Ez az Interface felelõs azért, hogy a felsõ rétegbeli objektumok értesüljenek afelõl,
 * hogy az alsó rétegbeli reprezentációjuk ütközött egy másik objektummal.
 */
public interface ICollisionObserver {
	/**
	 * Ebben a függvényben valósul meg a felsõ rétegbeli objektum értesítése az ütközés bekövetkeztérõl.
	 * Az obj paraméter az a másik objektum, akivel a feliratkozó WorldObject-je ütközött.
	 * @return void
	 */
	public void notify(IWorldObject obj);
}
