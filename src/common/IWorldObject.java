package common;

import proto.Depth;

/**
 * Ezt az interface-t implementalja minden olyan objektum, akinek van pozicioja,
 * van elmozdulas vektora, amivel elorelep minden iteracioban,
 * es kepes utkozni mas vilagbeli objektummal.
 */
public interface IWorldObject {
	/**
	 * @brief Ezzel a fuggvennyel lehet beallitani a megvalosito objektum allapotot, hogy elmozdithato legyen,
	 * mozdithatatlan legyen vagy atereszto (azaz mas objektumok keresztol tudjanak rajta menni).
	 * 
	 * @param colResp enum valtozo, MOVABLE(mozgathato), IMMOVABLE(mozdithatatlan) vagy PASS(atereszto)
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp);
	
	
	/**
	 * @brief A vilagbeli objektum  X koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param x Az x koordinata.
	 * @return void
	 */
	public void setPosX(double x);
	
	
	/**
	 * @brief A vilagbeli objektum Y koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void setPosY(double y);
	
	
	/**
	 * @brief Az objektum poziciojahoz hozzaadja a (dx,dy) vektort.
	 * 
	 * @param dx Az objektum poziciojahoz hozzaadando vektor x koordinataja.
	 * @param dy Az objektum poziciojahoz hozzoadando vektor y koordinataja.
	 * @return void
	 */
	public void displace(double dx, double dy);
	
	
	/**
	 * @brief A vilagbeli objektum X tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosX();
	
	
	/**
	 * @brief A vilagbeli objektum Y tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosY();

	/*
	 * Itt eltertunk a specifikaciotol, getWidth es getHeight nem volt benne.
	 */

	/**
	 * A vilagbeli objektum  szelesseget (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth();
	
	/**
	 * A vilagbeli objektum  magassagat (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight();
	
	/**
	 * @brief Az elmozdulas vektor X komponensenek beallitasa.
	 * 
	 * @param x Az x komponens beellatando erteke.
	 * @return void
	 */
	public void setDisplacementX(double x);
	
	
	/**
	 * @brief Az elmozdulas vektor Y komponensenek beallitasa.
	 * 
	 * @param y Az y komponens beallatando erteke.
	 * @return void
	 */
	public void setDisplacementY(double y);
	
	
	/**
	 * @brief A (dx,dy) vektor hozzaadasa az elmozdulas vektorhoz.
	 * 
	 * @param dx A vektor x koordinataja.
	 * @param dy A vektor y koordinataja.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy);
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor X iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementX();
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor Y iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementY();
	
	
	/**
	 * @brief Beallitja a megvalosito objektumra feliratkozo observert.
	 * 
	 * @param observer A feliratkozo observer.
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer);
	
	
	/**
	 * @brief Visszaadja a vilagbeli objektum felso retegbeli reprezentaciojanak az IVisitable interfeszet,
	 * ha van felso retegbeli reprezentacioja, ha nincs, akkor null-t ad.
	 * 
	 * @warning Vigyazat! Lehet null, nem szabad csak ugy lehivni a fuggvenyet! Nullpointerseg ellenorzese KELL!
	 * 
	 * @return IVisitable
	 */
	public IVisitable getVisitable();
	
	public void setDirection(Direction direction) ;
	
	//TODO: kommentelni kéne
	public void setVisitable(IVisitable visitable);

	//TODO kommentelni kéne
	public void markRemovable();
	
	
}
