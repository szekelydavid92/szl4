package upper_layer.wormhole;

import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.ISpecWall;
import common.IStargate;
import common.ITeleportable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import skeleton.Depth;

/**
 * O a csillagkapu. Ha egy jatekos utkozik vele, atteleportalja a masik csillagkapuhoz.
 */
public class Stargate implements IStargate, ICollisionObserver {

	public String name;
	
	@Override
	public void visit(ISpecWall wall) {
		//Nem hívódik meg.
	}

	
	@Override
	public void visit(IKillable killable) {
		//Nem hívódik meg.
	}

	
	@Override
	public void visit(ICarriable carriable) {
		//Nem hívódik meg.
	}

	
	@Override
	public void visit(IZPM zpm) {
		//Nem hívódik meg.
	}

	
	@Override
	public void visit(IScale scale) {
		//Nem hívódik meg.
	}

	
	@Override
	public void visit(ITeleportable teleportable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
		
		//!!!!!!!!!!!!!!!
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
		
	}

	
	@Override
	public void mask(ISpecWall wall) {
		//TODO Lorant
		Depth.getInstance().printTabs();
		System.out.print(name + ".mask()");
		Depth.getInstance().enterFunction();
		
		//!!!!!!!!!!!!!!!!!!!!!!
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".mask()");
	}

	
	@Override
	public void notify(IWorldObject obj) {
		//TODO Lorant
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		obj.getVisitable().accept((IVisitor)this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()");
	}

}
