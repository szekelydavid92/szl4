package upper_layer.wormhole;

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
 * Lovedek. Amennyiben SpecWall-al utkozik, ott nyit egy WormHole-t.
 */
public class Projectile implements ICollisionObserver, IVisitor {
	
	public String name;
	
	@Override
	public void visit(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
		
		//TODO
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
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
		//Nem hívódik meg.
	}
	

	@Override
	public void notify(IWorldObject obj) {
		
		//TODO
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		//obj.getVisitable().accept((IVisitor)this);
		IVisitable sw; //importot is kivenni
		
		sw = obj.getVisitable();
		sw.accept(this);
		
		
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()");
		
	}
}
