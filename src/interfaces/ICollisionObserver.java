package interfaces;

/**
 * Ez az Interface felelős azért, hogy a felső rétegbeli objektumok értesüljenek afelől,
 * hogy az alsó rétegbeli reprezentációjuk ütközött egy másik objektummal.
 */
public interface ICollisionObserver {
	/**
	 * Ebben a függvényben valósul meg a felső rétegbeli objektum értesítése az ütközés bekövetkeztéről.
	 * Az obj paraméter az a másik objektum, akivel a feliratkozó WorldObject-je ütközött.
	 * @return void
	 */
	public void notify(IWorldObject obj);
}
