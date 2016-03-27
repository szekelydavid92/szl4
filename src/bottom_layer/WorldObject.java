package bottom_layer;

import common.CollisionResponse;
import common.ICollisionObserver;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import skeleton.Depth;

/**
 * @brief Ez az osztaly egy AABB-t modellez, ami egy
 * olyan tegla, amelynek az oldalai parhuzamosak a
 * koordinatatengelyekkel.
 * 
 * Minden olyan jatekobjektum, aki tud utkozni
 * vilagbeli objektumokkal, asszociacioban van egy ilyennel.
 */
public class WorldObject implements IWorldObject {
	
	public String name; //O kell az objektum nevenek a kiprintelesehez!
	
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
	
	/**
	 * @brief A pozicio X es Y koordinatajahoz hozzaadja az elmozdulas X es Y koordinatajat,
	 * eloreleptetve az objektumot az ido fuggvenyeben.
	 * @return void
	 */
	public void step() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".step()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".step()");
	}
	
	
	/**
	 * A vilagbeli objektum  szelesseget (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getWidth()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getWidth()");
		
		return 0;
	}
	
	/**
	 * A vilagbeli objektum  magassagat (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getHeight()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getHeight()");
		
		return 0;
	}
	
		
	/**
	 * @brief Ezzel a fuggvennyel lehet beallitani a megvalosito objektum allapotot, hogy elmozdithato legyen,
	 * mozdithatatlan legyen vagy atereszto (azaz mas objektumok keresztol tudjanak rajta menni).
	 * 
	 * @param colResp enum valtozo, MOVABLE(mozgathato), IMMOVABLE(mozdithatatlan) vagy PASS(atereszto)
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setCollisionResponse(" + colResp + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setCollisionResponse()");
	}
	
	static String xName = "x";
	static String yName = "y";
	
	/**
	 * @brief A vilagbeli objektum  X koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param x Az x koordinata.
	 * @return void
	 */
	public void setPosX(double x) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setPosX(" + xName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setPosX()");
	}
	
	/**
	 * @brief A vilagbeli objektum Y koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void setPosY(double y) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setPosY(" + yName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setPosY()");
	}
	
	/**
	 * @brief A (dx,dy) vektor hozzaadasa az elmozdulas vektorhoz.
	 * 
	 * @param dx A vektor x koordinataja.
	 * @param dy A vektor y koordinataja.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".addDisplacement(" + xName + "," + yName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".addDisplacement()");
	}
	
	
	/**
	 * @brief A vilagbeli objektum X tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosX() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getPosX()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getPosX()");
		
		return 0;
	}
	
	
	/**
	 * @brief A vilagbeli objektum Y tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosY() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getPosY()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getPosY()");
		
		return 0;
	}
	
	
	/**
	 * @brief Visszaadja a vilagbeli objektum felso retegbeli reprezentaciojanak az IVisitable interfeszet,
	 * ha van felso retegbeli reprezentacioja, ha nincs, akkor null-t ad.
	 * 
	 * @return IVisitable
	 */
	public IVisitable getIVisitable() {

		Depth.getInstance().printTabs();
		System.out.print(name + ".getIVisitable()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getIVisitable()");
		
		return visitable;
	}
	
	
	/**
	 * @brief Ez a metodus felelos azert, hogy leellenirizze, hogy ket WorldObject utkozott-e.
	 * 
	 * @param o A masik WorldObject.
	 * @return boolean
	 */
	public boolean checkCollision(WorldObject o){
		boolean collides = false;
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".checkCollision(" + o.name + ")");
		Depth.getInstance().enterFunction();
		
		System.out.println("Kerem, adja meg, hogy " + name + " es " + o.name + " utkoztek-e! [i/n]");
		//TODO: Meg kell kerdezni a tesztelotol, hogy milyen bemenetet adjunk a collides-nak.
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".checkCollision()");
		
		return collides;
	}
	
	
	/**
	 * @brief Az objektum poziciojahoz hozzaadja a (dx,dy) vektort.
	 * 
	 * @param dx Az objektum poziciojahoz hozzaadando vektor x koordinataja.
	 * @param dy Az objektum poziciojahoz hozzoadando vektor y koordinataja.
	 * @return void
	 */
	public void displace(double dx, double dy) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".displace(" + xName + "," + yName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".displace()");
	}
	
	
	/**
	 * @brief Az elmozdulas vektor X komponensenek beallitasa.
	 * 
	 * @param x Az x komponens beellatando erteke.
	 * @return void
	 */
	public void setDisplacementX(double x) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setDisplacementX(" + xName + "," + yName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setDisplacementX()");
	}
	
	
	/**
	 * @brief Az elmozdulas vektor Y komponensenek beallitasa.
	 * 
	 * @param y Az y komponens beallatando erteke.
	 * @return void
	 */
	public void setDisplacementY(double y) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setDisplacementY(" + yName + "," + yName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setDisplacementY()");
	}
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor X iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementX() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getDisplacementX()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getDisplacementX()");
		
		return 0;
	}
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor Y iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementY() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getDisplacementY()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getDisplacementY()");
		
		return 0;
	}
	
	static String observerName;
	
	/**
	 * @brief Beallitja a megvalosito objektumra feliratkozo observert.
	 * 
	 * @param observer A feliratkozo observer.
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer) {

		Depth.getInstance().printTabs();
		System.out.print(name + ".setCollisionObserver(" + observerName + ")");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setCollisionObserver()");
		
		this.observer=observer;
	}
	
	
	/**
	 * @brief Ez a fuggveny hivodik meg a World checkCollision() fuggvenyeben,
	 * ha ez az objektum utkozott a parameterben megadott objektummal.
	 * 
	 * @param obj Parameterben megadott WorldObject objektum.
	 * @return void
	 */
	public void notify(WorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify(" + obj.name + ")");
		Depth.getInstance().enterFunction();
		
		if(this.observer != null)
		{
			this.observer.notify(obj);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()");
	}


	@Override
	public IVisitable getVisitable() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
