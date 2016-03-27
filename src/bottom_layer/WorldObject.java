package bottom_layer;

import common.CollisionResponse;
import common.ICollisionObserver;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * Minden egyes osztály, amelynek az idõ függvényében változhat az állapota, leszármazik ebbõl az osztályból.
 */
public class WorldObject implements IWorldObject {
	
	ICollisionObserver observer; // Az objektum ütközésérõl értesülõ observer.
	IVisitable visitable; //ÚJ!!!felsõ rétegbeli objektuma ami megvalósítja az IVisitable-t
	
	/**
	 * A pozíció X és Y koordinátájához hozzáadja az elmozdulás X és Y koordinátáját,
	 * elõreléptetve az objektumot az idõ függvényében.
	 * @return void
	 */
	public void step() {}
	
	
	/**
	 * A világbeli objektum  szélességét (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth() {return 0;}
	
	/**
	 * A világbeli objektum  magasságát (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {return 0;}
	
		
	/**
	 * Ezzel a függvénnyel lehet beállítani a megvalósító objektum állapotát, hogy elmozdítható legyen,
	 * mozdíthatatlan legyen vagy áteresztõ (azaz más objektumok keresztül tudjanak rajta menni).
	 * @param colResp ??????????????
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp) {}
	
	
	/**
	 * A világbeli objektum  X koordinátáját állítja be a világ koordináta rendszerében.
	 * @param x Az x koordináta.
	 * @return void
	 */
	public void setPosX(double x) {}
	
	
	/**
	 * A világbeli objektum Y koordinátáját állítja be a világ koordináta rendszerében.
	 * @param y Az y koordináta.
	 * @return void
	 */
	public void setPosY(double y) {}
	
	
	/**
	 * A (dx,dy) vektor hozzáadása az elmozdulás vektorhoz.
	 * @param dx A vektor x koordinátája.
	 * @param dy A vektor y koordinátája.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy) {}
	
	
	/**
	 * A világbeli objektum X tengely menti pozícióját adja vissza eredményül.
	 * @return double
	 */
	public double getPosX() {return 0;}
	
	
	/**
	 * A világbeli objektum Y tengely menti pozícióját adja vissza eredményül.
	 * @return double
	 */
	public double getPosY() {return 0;}
	
	
	/**
	 * Visszaadja a világbeli objektum felsõ rétegbeli reprezentációjának az IVisitable interfészét,
	 * ha van felsõ rétegbeli reprezentációja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable() {return visitable;}
	
	
	/**
	 * Ez a metódus felelõs azért, hogy leellenõrizze, hogy két WorldObject ütközött-e.
	 * @param o A másik WorldObject.
	 * @return boolean
	 */
	public boolean checkCollision(WorldObject o) {return true;}
	
	
	/**
	 * Az objektum pozíciójához hozzáadja a (dx,dy) vektort.
	 * @param dx Az objektum pozíciójához hozzáadandó vektor x koordinátája.
	 * @param dy Az objektum pozíciójához hozzáadandó vektor y koordinátája.
	 * @return void
	 */
	public void displace(double dx, double dy) {}
	
	
	/**
	 * Az elmozdulás vektor X komponensének beállítása.
	 * @param x Az x komponens beállítandó értéke.
	 * @return void
	 */
	public void setDisplacementX(double x) {}
	
	
	/**
	 * Az elmozdulás vektor Y komponensének beállítása.
	 * @param y Az y komponens beállítandó értéke.
	 * @return void
	 */
	public void setDisplacementY(double y) {}
	
	
	/**
	 * Eredményül adja az elmozdulás vektor X irányú értékét.
	 * @return double
	 */
	public double getDisplacementX() {return 0;}
	
	
	/**
	 * Eredményül adja az elmozdulás vektor Y irányú értékét.
	 * @return double
	 */
	public double getDisplacementY() {return 0;}
	
	
	/**
	 * Beállítja a megvalósító objektumra feliratkozó observert.
	 * @param observer A feliratkozó observer.
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer) {this.observer=observer;}
	
	
	/**
	 * Ez a függvény hívódik meg a World checkCollision() függvényében,
	 * ha ez az objektum ütközött a paraméterben megadott objektummal.
	 * @param obj Paraméterben megadott WorldObject objektum.
	 * @return void
	 */
	public void notify(WorldObject obj) {
		this.observer.notify(obj);
	}

}
