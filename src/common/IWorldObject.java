package common;

/**
 * Ezt az interface-t implementalja minden olyan objektum, akinek van pozicioja,
 * van elmozdulas vektora, amivel elorelep minden iteracioban,
 * es kepes utkozni mas vilagbeli objektummal.
 */
public interface IWorldObject {
	/**
	 * Ezzel a fuggvennyel lehet beallitani a megvalosito objektum allapotot, hogy elmozdithato legyen,
	 * mozdithatatlan legyen vagy atereszto (azaz mas objektumok keresztul tudjanak rajta menni).
	 * @param colResp ???????????
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp);
	
	
	/**
	 * A vilagbeli objektum  X koordinitajat allitja be a vilag koordinata rendszereben.
	 * @param x ???????????????????????
	 * @return void
	 */
	public void setPosX(double x);
	
	
	/**
	 * A vilagbeli objektum Y koordinatajat allitja be a vilag koordinata rendszereben.
	 * @param y ????????????????????
	 * @return void
	 */
	public void setPosY(double y);
	
	
	/**
	 * Az objektum poziciojahoz hozzaadja a (dx,dy) vektort.
	 * @param dx ??????????????????
	 * @param dy ???????????????????
	 * @return void
	 */
	public void displace(double dx, double dy);
	
	
	/**
	 * A vilagbeli objektum X tengely menti poziciojat adja vissza eredmenyul.
	 * @return double
	 */
	public double getPosX();
	
	
	/**
	 * A vilagbeli objektum Y tengely menti poziciojat adja vissza eredmenyul.
	 * @return double
	 */
	public double getPosY();
	
	
	/**
	 * Az elmozdulas vektor X komponensenek beallitasa.
	 * @param x ?????????????????
	 * @return void
	 */
	public void setDisplacementX(double x);
	
	
	/**
	 * Az elmozdulas vektor Y komponensenek beallitasa.
	 * @param y ??????????????
	 * @return void
	 */
	public void setDisplacementY(double y);
	
	
	/**
	 * A (dx,dy) vektor hozzaadasa az elmozdulas vektorhoz.
	 * @param dx ???????????????
	 * @param dy ???????????????
	 * @return void
	 */
	public void addDisplacement(double dx, double dy);
	
	
	/**
	 * Eredmenyul adja az elmozdulas vektor X iranyu erteket.
	 * @return double
	 */
	public double getDisplacementX();
	
	
	/**
	 * Eredmenyul adja az elmozdulas vektor Y iranyu erteket.
	 * @return double
	 */
	public double getDisplacementY();
	
	
	/**
	 * Beallitja a megvalosito objektumra feliratkozo observert.
	 * @param observer ??????????????????
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer);
	
	
	/**
	 * Visszaadja a vilagbeli objektum felso retegbeli reprezentaciojanak az IVisitable interfeszet,
	 * ha van felso retegbeli reprezentacioja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable();
}
