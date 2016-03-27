package common;

/**
 * Ez az Interface felelos azert, hogy a felso retegbeli objektumok ertesuljenek arrol,
 * hogy az also retegbeli reprezentaciojuk utkozott egy masik objektummal.
 */
public interface ICollisionObserver {
	/**
	 * Ebben a fuggvenyben valosul meg a felso retegbeli objektum ertesitese az utkozes bekovetkezterol.
	 * Az obj parameter az a masik objektum, akivel a feliratkozo WorldObject-je utkozott.
	 * @return void
	 */
	public void notify(IWorldObject obj);
}
