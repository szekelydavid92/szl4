package upper_layer.reactive;

import java.util.LinkedList;
import java.util.List;

import common.ICarriable;
import common.IChasm;
import common.ICollisionObserver;
import common.IKillable;
import common.IProjectile;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;

/**
 * @brief Ez a szakadek. Ha utkozott egy IKillable-t megvalosito objektummal, akkor megoli.
 */
public class Chasm implements ICollisionObserver, IVisitor, IVisitable, IChasm {	
	
	public String name = "chasm";
	
	/*
	 * Attributumok
	 */
	List<IWorldObject> chasms = new LinkedList<IWorldObject>(); 			//Azon WorldObjectek listája, akik szakadékok.	
	private static Chasm chasm = null;
	
	/*
	 * Metodusok
	 */
	public static Chasm getInstance() {
		if(chasm == null){
			chasm = new Chasm();
		}
		return chasm;
	}
	
	/**
	 * Ezen keresztül lehet elkérni azon WorldObjectek kollekcióját, akikhez be 
	 * van regisztrálva a Chasm. Elsősorban a pálya kiírásánál kell.
	 * @return List<IWorldObject>
	 */
	public List<IWorldObject> getChasms() {
		return chasms;
	}
	
	public void remove(IWorldObject obj) {
		chasms.remove(obj);
	}
	
	/**
	 * @brief Itt valosul meg az ISpecWall-al valo utkozes soran tanusutott viselkedes.
	 * Ez a fuggvenytorzs URES, nem csinal semmit.
	 * 
	 * @param wall Az ISpecWall interfeszt implementalo objektum.
	 * @return void
	 */
	@Override
	public void visit(ISpecWall wall) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	@Override
	public void visit(IProjectile projectile) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	/**
	 * @brief Itt valosul meg az IKillable-el valo utkozes soran tanusitott viselkedes.
	 * A Chasm megoli az IKillablet.
	 * 
	 * @param killable Az IKillable interfeszt implementalo objektum.
	 * @return void
	 */
	@Override
	public void visit(IKillable killable) {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".visit()");
		Depth.getInstance().enterFunction();
		
		killable.kill();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".visit()");
	}

	/**
	 * @brief Itt valosul meg az ICarriable-el valo utkozes soran tanusitott viselkedes.
	 * Ez a fuggvenytorzs URES, nem csinal semmit.
	 * 
	 * @param carriable Az ICarriable interfeszt implementalo objektum.
	 * @return void
	 */
	@Override
	public void visit(ICarriable carriable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	/**
	 * @brief Itt valosul meg az IZPM-el valo utkozos soran tanusitott viselkedes.
	 * Ez a fuggvenytorzs URES, nem csinal semmit.
	 * 
	 * @param zpm Az IZPM interfeszt implementalo objektum.
	 * @return void
	 */
	@Override
	public void visit(IZPM zpm) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	/**
	 * @brief Itt valosul meg az IScale-el valo utkozes soran tanusitott viselkedes.
	 * Ez a fuggvenytorzs URES, nem csinal semmit.
	 * 
	 * @param scale Az IScale interfeszt implementalo objektum.
	 * @return void
	 */
	@Override
	public void visit(IScale scale) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	/**
	 * @brief Itt valosul meg az ITeleportable-al valo utkozes soran tanusitott viselkedes.
	 * Ez a fuggvenytorzs URES, nem csinal semmit.
	 * 
	 * @param teleportable Az ITeleportable interfeszt implementalo objektum.
	 * @return void
	 */
	@Override
	public void visit(ITeleportable teleportable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	/**
	 * @brief Ezen a fuggvenyen keresztul ertesul a Chasm arrol, hogy utkozott
	 * egy masik objektummal. Ha Killable-el utkozik, megoli.
	 * 
	 * @param obj a masik objektum, akivel utkozott
	 * @return void
	 */
	@Override
	public void notify(IWorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.println(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		IVisitable visitable = obj.getVisitable();
		
		if(visitable != null)
		{
			visitable.accept(this);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".notify()");
	}


	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}


	@Override
	public void visit(IChasm chasm) {
		/*
		 * Nem torodunk az esettel.
		 */
	}
}
