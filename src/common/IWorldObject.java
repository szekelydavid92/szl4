package common;

/**
 * Ezt az interface-t implementálja minden olyan objektum, akinek van pozíciója,
 * van elmozdulás vektora, amivel elõrelép minden iterációban,
 * és képes ütközni más világbeli objektummal.
 */
public interface IWorldObject {
	/**
	 * Ezzel a függvénnyel lehet beállítani a megvalósító objektum állapotát, hogy elmozdítható legyen,
	 * mozdíthatatlan legyen vagy áteresztõ (azaz más objektumok keresztül tudjanak rajta menni).
	 * @param colResp ???????????
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp);
	
	
	/**
	 * A világbeli objektum  X koordinátáját állítja be a világ koordináta rendszerében.
	 * @param x ???????????????????????
	 * @return void
	 */
	public void setPosX(double x);
	
	
	/**
	 * A világbeli objektum Y koordinátáját állítja be a világ koordináta rendszerében.
	 * @param y ????????????????????
	 * @return void
	 */
	public void setPosY(double y);
	
	
	/**
	 * Az objektum pozíciójához hozzáadja a (dx,dy) vektort.
	 * @param dx ??????????????????
	 * @param dy ???????????????????
	 * @return void
	 */
	public void displace(double dx, double dy);
	
	
	/**
	 * A világbeli objektum X tengely menti pozícióját adja vissza eredményül.
	 * @return double
	 */
	public double getPosX();
	
	
	/**
	 * A világbeli objektum Y tengely menti pozícióját adja vissza eredményül.
	 * @return double
	 */
	public double getPosY();
	
	
	/**
	 * Az elmozdulás vektor X komponensének beállítása.
	 * @param x ?????????????????
	 * @return void
	 */
	public void setDisplacementX(double x);
	
	
	/**
	 * Az elmozdulás vektor Y komponensének beállítása.
	 * @param y ??????????????
	 * @return void
	 */
	public void setDisplacementY(double y);
	
	
	/**
	 * A (dx,dy) vektor hozzáadása az elmozdulás vektorhoz.
	 * @param dx ???????????????
	 * @param dy ???????????????
	 * @return void
	 */
	public void addDisplacement(double dx, double dy);
	
	
	/**
	 * Eredményül adja az elmozdulás vektor X irányú értékét.
	 * @return double
	 */
	public double getDisplacementX();
	
	
	/**
	 * Eredményül adja az elmozdulás vektor Y irányú értékét.
	 * @return double
	 */
	public double getDisplacementY();
	
	
	/**
	 * Beállítja a megvalósító objektumra feliratkozó observert.
	 * @param observer ??????????????????
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer);
	
	
	/**
	 * Visszaadja a világbeli objektum felsõ rétegbeli reprezentációjának az IVisitable interfészét,
	 * ha van felsõ rétegbeli reprezentációja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable();
}
