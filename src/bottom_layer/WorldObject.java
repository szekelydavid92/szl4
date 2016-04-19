package bottom_layer;

import java.io.IOException;

import common.CollisionResponse;
import common.ICollisionObserver;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import proto.Depth;

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
		System.out.print(name + ".step()\n");
		Depth.getInstance().enterFunction();
		
		double x = getDisplacementX();
		double y = getDisplacementY();
		displace(x, y);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".step()\n");
	}
	
	
	/**
	 * A vilagbeli objektum  szelesseget (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getWidth()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getWidth()\n");
		
		return 0;
	}
	
	/**
	 * A vilagbeli objektum  magassagat (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getHeight()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getHeight()\n");
		
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
		System.out.print(name + ".setCollisionResponse(" + colResp + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setCollisionResponse()\n");
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
		System.out.print(name + ".setPosX(" + xName + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setPosX()\n");
	}
	
	/**
	 * @brief A vilagbeli objektum Y koordinatajat allitja be a vilag koordinata rendszereben.
	 * 
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void setPosY(double y) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setPosY(" + yName + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setPosY()\n");
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
		System.out.print(name + ".addDisplacement(" + xName + "," + yName + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".addDisplacement()\n");
	}
	
	
	/**
	 * @brief A vilagbeli objektum X tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosX() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getPosX()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getPosX()\n");
		
		return 0;
	}
	
	
	/**
	 * @brief A vilagbeli objektum Y tengely menti poziciojat adja vissza eredmenyul.
	 * 
	 * @return double
	 */
	public double getPosY() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getPosY()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getPosY()\n");
		
		return 0;
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
		System.out.print(name + ".checkCollision(" + o.name + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().printTabs();
		System.out.println("Kerem, adja meg, hogy " + name + " es " + o.name + " utkoztek-e! [i/n]");
		
		try {
			proto.ProtoMain.line = proto.ProtoMain.in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(proto.ProtoMain.line.equals("i")) {collides = true;}
		else if(proto.ProtoMain.line.equals("n")) {collides = false;}
		else {System.out.println("ERROR: Ervenytelen bemenet");}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".checkCollision()\n");
		
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
		System.out.print(name + ".displace(" + xName + "," + yName + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".displace()\n");
	}
	
	
	/**
	 * @brief Az elmozdulas vektor X komponensenek beallitasa.
	 * 
	 * @param x Az x komponens beellatando erteke.
	 * @return void
	 */
	public void setDisplacementX(double x) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setDisplacementX(" + xName + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setDisplacementX()\n");
	}
	
	
	/**
	 * @brief Az elmozdulas vektor Y komponensenek beallitasa.
	 * 
	 * @param y Az y komponens beallatando erteke.
	 * @return void
	 */
	public void setDisplacementY(double y) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".setDisplacementY(" + yName + ")\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setDisplacementY()\n");
	}
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor X iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementX() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getDisplacementX()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getDisplacementX()\n");
		
		return 0;
	}
	
	
	/**
	 * @brief Eredmenyul adja az elmozdulas vektor Y iranyu erteket.
	 * 
	 * @return double
	 */
	public double getDisplacementY() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".getDisplacementY()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getDisplacementY()\n");
		
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
		System.out.print(name + ".setCollisionObserver()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setCollisionObserver()\n");
		
		this.observer=observer;
	}
	//�j!!!!!!!!!!!!!!!!!!!!!!!!!
	public void setVisitable(IVisitable visitable) {

		Depth.getInstance().printTabs();
		System.out.print(name + ".setVisitable()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setVisitable()\n");

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
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify(" + obj.name + ")\n");
		Depth.getInstance().enterFunction();
		
		if(this.observer != null)
		{
			this.observer.notify(obj);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
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

		Depth.getInstance().printTabs();
		System.out.print(name + ".getVisitable()\n");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getVisitable()\n");
		

		
		return visitable;
		//return iv;

	}

}
