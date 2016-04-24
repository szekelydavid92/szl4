package bottom_layer;

import common.CollisionResponse;
import common.Direction;
import common.ICollisionObserver;
import common.IVisitable;
import common.IWorldObject;

/**
 * @brief Ez az osztaly egy AABB-t modellez, ami egy
 * olyan tegla, amelynek az oldalai parhuzamosak a
 * koordinatatengelyekkel.
 * 
 * Minden olyan jatekobjektum, aki tud utkozni
 * vilagbeli objektumokkal, asszociacioban van egy ilyennel.
 */
public class WorldObject implements IWorldObject {
	

	public String name = "worldObj"; //O kell az objektum nevenek a kiprintelesehez!
	
	/*
	 * Attributumok
	 */
	
	double posX;
	double posY;
	double displacementX;
	double displacementY;
	double width;
	double height;
	CollisionResponse colResp;
	
	/* Ez az objektum felelos azert, hogy
	 * a felso retegbeli reprezentacio
	 * ertesuljon arrol, hogy az objektum
	 * utkozott. (Observer tervezesi minta)
	 */
	public ICollisionObserver observer = null;
	
	/* Ez az objektum felelos azert, hogy utkozes
	 * soran a masik objektum el tudja erni ennek
	 * az objektumank a felso retegbeli
	 * reprezentaciojat. (Visitor tervezesi minta)
	 */
	public IVisitable visitable = null;

	private boolean removable;
	
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief A pozicio X es Y koordinatajahoz hozzaadja az elmozdulas X es Y koordinatajat,
	 * eloreleptetve az objektumot az ido fuggvenyeben.
	 * @return void
	 */
	public void step() {
		double dx = getDisplacementX();
		double dy = getDisplacementY();
		displace(dx, dy);
	}
	
	/*
	 * Itt eltertunk a specifikaciotol, a setWidth es setHeight nem volt benne.
	 */

	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * A vilagbeli objektum  szelesseget (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * A vilagbeli objektum  magassagat (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {
		return height;
	}
	
		
	/**
	 * @brief Ezzel a fuggvennyel lehet beallitani a megvalosito objektum allapotot, hogy elmozdithato legyen,
	 * mozdithatatlan legyen vagy atereszto (azaz mas objektumok keresztol tudjanak rajta menni).
	 * 
	 * @param colResp enum valtozo, MOVABLE(mozgathato), IMMOVABLE(mozdithatatlan) vagy PASS(atereszto)
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp) {
		this.colResp = colResp;
	}
	
	/**
	 * @brief A vilagbeli objektum  X koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param x Az x koordinata.
	 * @return void
	 */
	public void setPosX(double x) {
		posX = x;
	}
	
	/**
	 * @brief A vilagbeli objektum Y koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void setPosY(double y) {
		posY = y;
	}
	
	/**
	 * @brief A (dx,dy) vektor hozzaadasa az elmozdulas vektorhoz.
	 * 
	 * @param dx A vektor x koordinataja.
	 * @param dy A vektor y koordinataja.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy) {
		displacementX += dx;
		displacementY += dy;
	}
	
	/*
	 * Itt eltertunk a specifikaciotol, ez a fuggveny nincs benne eredetileg.
	 */
	
	public void push(WorldObject other,double dx, double dy) {
		if(colResp == CollisionResponse.IMMOVABLE) {
			return;
		}
		else if(other.colResp == CollisionResponse.PASS || colResp == CollisionResponse.PASS) {
			return;
		}
		
		displacementX += dx;
		displacementY += dy;
	}
	
	/**
	 * @brief A vilagbeli objektum X tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosX() {
		return posX;
	}
	
	
	/**
	 * @brief A vilagbeli objektum Y tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosY() {
		return posY;
	}
	
	
	/**
	 * @brief Ez a metodus felelos azert, hogy leellenirizze, hogy ket WorldObject utkozott-e.
	 * 
	 * @param o A masik WorldObject.
	 * @return boolean
	 */
	public boolean checkCollision(WorldObject o){
		boolean collides = false;
		
		double oX = o.getPosX();
		double oY = o.getPosY();
		double oWidth = o.getWidth();
		double oHeight = o.getHeight();

		if((posX+width) < oX){
			return false;
		}
		else if(posX > (oX + oWidth)){
			return false;
		}
		else if((posY + height) < oY){
			return false;
		}
		else if(posY > (oY + oHeight)){
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * @brief Az objektum poziciojahoz hozzaadja a (dx,dy) vektort.
	 * 
	 * @param dx Az objektum poziciojahoz hozzaadando vektor x koordinataja.
	 * @param dy Az objektum poziciojahoz hozzoadando vektor y koordinataja.
	 * @return void
	 */
	public void displace(double dx, double dy) {
		posX += dx;
		posY += dy;
	}
	
	
	/**
	 * @brief Az elmozdulas vektor X komponensenek beallitasa.
	 * 
	 * @param x Az x komponens beellatando erteke.
	 * @return void
	 */
	public void setDisplacementX(double x) {
		displacementX = x;
	}
	
	
	/**
	 * @brief Az elmozdulas vektor Y komponensenek beallitasa.
	 * 
	 * @param y Az y komponens beallatando erteke.
	 * @return void
	 */
	public void setDisplacementY(double y) {
		displacementY = y;
	}
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor X iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementX() {
		return displacementX;
	}
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor Y iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementY() {
		return displacementY;
	}
	
	/**
	 * @brief Beallitja a megvalosito objektumra feliratkozo observert.
	 * 
	 * @param observer A feliratkozo observer.
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer) {
		this.observer=observer;
	}
	
	public void setVisitable(IVisitable visitable) {
		this.visitable=visitable;
	}
	
	/**
	 * @brief Ez a fuggveny hivodik meg a World checkCollision() fuggvenyeben,
	 * ha ez az objektum utkozott a parameterben megadott objektummal.
	 * 
	 * @param obj Parameterben megadott WorldObject objektum.
	 * @return void
	 */
	public void notify(WorldObject obj) {
		if(this.observer != null)
		{
			this.observer.notify(obj);
		}
	}

	/**
	 * @brief Visszaadja a vilagbeli objektum felso retegbeli reprezentaciojanak az IVisitable interfeszet,
	 * ha van felso retegbeli reprezentacioja, ha nincs, akkor null-t ad.
	 * 
	 * @warning Vigyazat! Lehet null, nem szabad csak ugy lehivni a fuggvenyet! Nullpointerseg ellenorzese KELL!
	 * 
	 * @return IVisitable
	 */
	public IVisitable getVisitable() {
		return visitable;
	}
	
	boolean isRemovable() {
		return removable;
	}
	
	@Override
	public void setDirection(Direction direction) {
		if(this.observer != null) {
			this.observer.setDirection(direction);
		}
	}
	
	@Override
	public void markRemovable() {
		removable = true;
	}

}
