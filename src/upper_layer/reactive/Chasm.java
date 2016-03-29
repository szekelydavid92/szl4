package upper_layer.reactive;

import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import skeleton.Depth;

/**
 * @brief Ez a szakadek. Ha utkozott egy IKillable-t megvalosito objektummal, akkor megoli.
 */
public class Chasm implements ICollisionObserver, IVisitor {	
	
	public String name = "chasm";
	
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
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
		*/
		
		/*
		 * Ez nem hivodik le soha, vagy ha igen, nem vagyunk ra kivancsiak.
		 * Lorant
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
		//TODO Lorant
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
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
		*/

		/*
		 * Ez lehivodik, de nem vagyunk ra kivancsiak, mert ures a fuggvenytorzs
		 * Lorant
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
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
		*/
		
		/*
		 * Ez nem hivodik le soha, vagy ha igen, nem vagyunk ra kivancsiak.
		 * Lorant
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
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
		*/
		
		/*
		 * Ez nem hivodik le soha, vagy ha igen, nem vagyunk ra kivancsiak.
		 * Lorant
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
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
		*/
		
		/*
		 * Ez lehivodik, de nem vagyunk ra kivancsiak, mert ures a fuggvenytorzs
		 * Lorant
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
		
		//TODO LORANT
		Depth.getInstance().printTabs();
		System.out.println(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		IVisitable visitable = obj.getVisitable();
		
		//obj.getVisitable().accept(this); EZT NEM SZABAD CSAK UGY LEHIVNI, MERT LEHET NULLPOINTER!
		if(visitable != null)
		{
			visitable.accept(this);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".notify()");
	}
}
