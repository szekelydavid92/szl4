package bottom_layer;

import common.CollisionResponse;
import common.ICollisionObserver;
import common.IVisitable;
import common.IWorldObject;

/**
 * Minden egyes osztály, amelynek az idõ függvényében változhat az állapota, leszármazik ebbõl az osztályból.
 */
public class WorldObject implements IWorldObject {
	
	double posX;			//Az objectum X tengely menti pozíció.
	double posY; 			//Az objectum  Y tengely menti pozíció.
	double displacementX;	//Az objectum elmozdulás vektorának X komponense.
	double displacementY;	//Az objectum elmozdulás vektorának Y komponense.
	double width; 			//Az objektum szélessége.
	double height; 			//Az objektum magassága.
	CollisionResponse colResp;	//a WorldObject belsõ állapota: ha 
								//MOVABLE, akkor ütközés esetén 
								//elmozdul, ha IMMOVABLE, akkor 
								//ütközés esetén nem mozdul el, ha pedig PASS, 
								//akkor keresztül engedi magán a másik objektumot.
	ICollisionObserver observer; // Az objektum ütközésérõl értesülõ observer.
	
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
	public double getWidth() {return width;}
	
	/**
	 * A világbeli objektum  magasságát (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {return height;}
	
		
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
	public void setPosX(double x) {posX=x;}
	
	
	/**
	 * A világbeli objektum Y koordinátáját állítja be a világ koordináta rendszerében.
	 * @param y Az y koordináta.
	 * @return void
	 */
	public void setPosY(double y) {posY=y;}
	
	
	/**
	 * A (dx,dy) vektor hozzáadása az elmozdulás vektorhoz.
	 * @param dx A vektor x koordinátája.
	 * @param dy A vektor y koordinátája.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy) 
	{displacementX+=dx; displacementY+=dy;}
	
	
	/**
	 * A világbeli objektum X tengely menti pozícióját adja vissza eredményül.
	 * @return double
	 */
	public double getPosX() {return posX;}
	
	
	/**
	 * A világbeli objektum Y tengely menti pozícióját adja vissza eredményül.
	 * @return double
	 */
	public double getPosY() {return posY;}
	
	
	/**
	 * Visszaadja a világbeli objektum felsõ rétegbeli reprezentációjának az IVisitable interfészét,
	 * ha van felsõ rétegbeli reprezentációja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable() {return null;}
	
	
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
	public void displace(double dx, double dy) {posX+=dx; posY+=dy;}
	
	
	/**
	 * Az elmozdulás vektor X komponensének beállítása.
	 * @param x Az x komponens beállítandó értéke.
	 * @return void
	 */
	public void setDisplacementX(double x) {displacementX=x;}
	
	
	/**
	 * Az elmozdulás vektor Y komponensének beállítása.
	 * @param y Az y komponens beállítandó értéke.
	 * @return void
	 */
	public void setDisplacementY(double y) {displacementY=y;}
	
	
	/**
	 * Eredményül adja az elmozdulás vektor X irányú értékét.
	 * @return double
	 */
	public double getDisplacementX() {return displacementX;}
	
	
	/**
	 * Eredményül adja az elmozdulás vektor Y irányú értékét.
	 * @return double
	 */
	public double getDisplacementY() {return displacementY;}
	
	
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
	public void notify(WorldObject obj) {}

}
