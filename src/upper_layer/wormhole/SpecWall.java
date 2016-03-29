package upper_layer.wormhole;

import common.ISpecWall;
import common.IStargate;
import common.IVisitor;
import common.IWorldObject;
import skeleton.Depth;

/**
 * Ez az, akire portalt lehet loni. Ha egy teleportalhato valakivel utkozik,
 * szol a WormHole-nak, hogy ot kene pakolni ot a masik SpecWall elo.
 */
public class SpecWall implements ISpecWall {
	
	public String name;
	
	@Override
	public void notify(IWorldObject obj) {
		//TODO
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		obj.getVisitable().accept((IVisitor)this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()");
		
	}

	
	@Override
	public void accept(IVisitor visitor) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit((ISpecWall)this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()");
		
	}

	
	@Override
	public void replace(IStargate o) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".replace()");
		Depth.getInstance().enterFunction();
		
		//TODO Lorant
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".replace()");
		
	}

	
	@Override
	public void restore() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".restore()");
		Depth.getInstance().enterFunction();
		
		//TODO Lorant
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".restore()");
		
	}

}
