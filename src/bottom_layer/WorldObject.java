package bottom_layer;

import common.CollisionResponse;
import common.ICollisionObserver;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * Minden egyes osztaly, amelynek az ido fuggvenyeben valtozhat az allapota, leszarmazik ebbol az osztalybol.
 */
public class WorldObject implements IWorldObject {
	
	ICollisionObserver observer; // Az objektum �tk�z�s�r�l �rtes�l� observer.
	IVisitable visitable; //�J!!!fels� r�tegbeli objektuma ami megval�s�tja az IVisitable-t
	
	/**
	 * A pozicio X es Y koordinatajahoz hozzaadja az elmozdulas X es Y koordinatajat,
	 * eloreleptetve az objektumot az ido fuggvenyeben.
	 * @return void
	 */
	public void step() {}
	
	
	/**
	 * A vilagbeli objektum  szelesseget (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth() {return 0;}
	
	/**
	 * A vilagbeli objektum  magassagat (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {return 0;}
	
		
	/**
	 * Ezzel a fuggvennyel lehet beallitani a megvalosito objektum allapotot, hogy elmozdithato legyen,
	 * mozdithatatlan legyen vagy atereszto (azaz mas objektumok keresztol tudjanak rajta menni).
	 * @param colResp ??????????????
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp) {}
	
	
	/**
	 * A vilagbeli objektum  X koordinatajat allitja be a vilag koordinata rendszereben.
	 * @param x Az x koordinata.
	 * @return void
	 */
	public void setPosX(double x) {}
	
	
	/**
	 * A vilagbeli objektum Y koordinatajat allitja be a vilag koordinata rendszereben.
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void setPosY(double y) {}
	
	
	/**
	 * A (dx,dy) vektor hozzaadasa az elmozdulas vektorhoz.
	 * @param dx A vektor x koordinataja.
	 * @param dy A vektor y koordinataja.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy) {}
	
	
	/**
	 * A vilagbeli objektum X tengely menti poziciojat adja vissza eredmenyul.
	 * @return double
	 */
	public double getPosX() {return 0;}
	
	
	/**
	 * A vilagbeli objektum Y tengely menti poziciojat adja vissza eredmenyul.
	 * @return double
	 */
	public double getPosY() {return 0;}
	
	
	/**
	 * Visszaadja a vilagbeli objektum felso retegbeli reprezentaciojanak az IVisitable interfeszet,
	 * ha van felso retegbeli reprezentacioja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable() {return visitable;}
	
	
	/**
	 * Ez a metodus felelos azert, hogy leellenirizze, hogy ket WorldObject utkozott-e.
	 * @param o A masik WorldObject.
	 * @return boolean
	 */
	public boolean checkCollision(WorldObject o) {return true;}
	
	
	/**
	 * Az objektum poziciojahoz hozzaadja a (dx,dy) vektort.
	 * @param dx Az objektum poziciojahoz hozzaadando vektor x koordinataja.
	 * @param dy Az objektum poziciojahoz hozzoadando vektor y koordinataja.
	 * @return void
	 */
	public void displace(double dx, double dy) {}
	
	
	/**
	 * Az elmozdulas vektor X komponensenek beallitasa.
	 * @param x Az x komponens beellatando erteke.
	 * @return void
	 */
	public void setDisplacementX(double x) {}
	
	
	/**
	 * Az elmozdulas vektor Y komponensenek beallitasa.
	 * @param y Az y komponens beallatando erteke.
	 * @return void
	 */
	public void setDisplacementY(double y) {}
	
	
	/**
	 * Eredmenyul adja az elmozdulas vektor X iranyu erteket.
	 * @return double
	 */
	public double getDisplacementX() {return 0;}
	
	
	/**
	 * Eredmenyul adja az elmozdulas vektor Y iranyu erteket.
	 * @return double
	 */
	public double getDisplacementY() {return 0;}
	
	
	/**
	 * Beallitja a megvalosoto objektumra feliratkozo observert.
	 * @param observer A feliratkozo observer.
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer) {this.observer=observer;}
	
	
	/**
	 * Ez a fuggveny hivodik meg a World checkCollision() fuggvenyeben,
	 * ha ez az objektum utkozott a parameterben megadott objektummal.
	 * @param obj Parameterben megadott WorldObject objektum.
	 * @return void
	 */
	public void notify(WorldObject obj) {
		this.observer.notify(obj);
	}

}
